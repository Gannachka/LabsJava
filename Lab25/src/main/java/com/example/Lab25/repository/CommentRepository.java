package com.example.Lab25.repository;

import com.example.Lab25.JdbcConnection;
import com.example.Lab25.model.Comment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class CommentRepository {

    public static String sessionId = "user";
    public static String userName = "user";

    public static void insert(Comment comment) {
        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(String.format("insert into Comments(linkId, stamp, text, author, sessionId) values('%d',GETDATE(),'%s','%s','%s')",
                    comment.getLinkId(), comment.getText(), comment.getAuthor(), comment.getSessionId()));
            connection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Comments WHERE id = " + id);
        connection.close();
        statement.close();
    }

    public static void update(Comment comment) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();

        statement.execute(String.format("UPDATE Comments SET text = '" +
                comment.getText() + "' WHERE id = " + comment.getId()));
        statement.close();
        connection.close();

    }

    public static List<Comment> selectAll(String id) throws SQLException, ClassNotFoundException {
        List<Comment> comments = new LinkedList<Comment>();
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM Comments WHERE linkId = " + id);

        Comment comment = null;

        while (result.next()) {
            comment = new Comment(result.getInt(1),
                    result.getInt(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6));
            comments.add(comment);
        }

        return comments;
    }

}
