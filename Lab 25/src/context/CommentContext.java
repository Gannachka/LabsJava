package context;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import model.CommentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentContext{
    private Connection connection;

    public CommentContext() throws SQLServerException {
        connection = ConnectionString.init();
    }

    public List<CommentModel> getComments(int refId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("select * from WSREFCOMMENT where wsref_id=" + refId);
        ResultSet result = statement.executeQuery();
        List<CommentModel> commentModels = new ArrayList<>();
        while (result.next()) {
            commentModels.add(new CommentModel(result.getInt(1),
                    result.getInt(2),
                    result.getString(3),
                    result.getDate(4),
                    result.getString(5)));
        }
        return commentModels;
    }

    public void addComment(CommentModel commentModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into WSREFCOMMENT(wsref_id,session_id,stamp,comtext) values(?,?,?,?)");
        statement.setInt(1, commentModel.getWsrefId());
        statement.setString(2, commentModel.getSessionId());
        statement.setDate(3, commentModel.getStamp());
        statement.setString(4, commentModel.getComtext());
        statement.executeUpdate();
    }

    public void updateComment(CommentModel commentModel) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update WSREFCOMMENT set comtext=? where id=?");
        statement.setString(1, commentModel.getComtext());
        statement.setInt(2, commentModel.getId());
        statement.executeUpdate();
    }

    public void deleteComment(CommentModel commentModel) throws SQLException {
        PreparedStatement statement=connection.prepareStatement("delete from WSREFCOMMENT where id=?");
        statement.setInt(1, commentModel.getId());
        statement.executeUpdate();
    }
}
