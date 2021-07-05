package com.example.Lab25.repository;

import com.example.Lab25.JdbcConnection;
import com.example.Lab25.model.Link;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class LinkRepository {

    public static List<Link> filteredList = LinkRepository.selectAll();
    public static String filter = "";

    public static void insert(Link element) {
        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(String.format("insert into Links(url, description, plus_counter, minus_counter) values('%s','%s','%d','%d')",
                    element.getUrl(), element.getDescription(), 0, 0));
            connection.close();
            statement.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public static void delete(String id) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("DELETE FROM Links WHERE id = " + id);
        connection.close();
        statement.close();
    }


    public static void update(Link element) throws SQLException, ClassNotFoundException {

        Connection connection = JdbcConnection.getConnection();
        Statement statement = connection.createStatement();
//        PreparedStatement statement = connection.prepareStatement(String.format("UPDATE Links SET [url] = \"" +
//                element.getUrl() + "\" , [description]= \"" + element.getDescription()
//                + "\", [plus_counter] = " + element.getPlus()
//                + ", [minus_counter] = " + element.getMinus() + "  WHERE [id] = " + element.getId()));
        if (connection == null)
            System.out.println("Connection is null");


        System.out.println("Plus");
        statement.execute(String.format("UPDATE Links SET [url] = \'" +
                element.getUrl() + "\' , [description]= \'" + element.getDescription()
                + "\', [plus_counter] = " + element.getPlus()
                + ", [minus_counter] = " + element.getMinus() + "  WHERE [id] = " + element.getId()));

        statement.close();
        connection.close();
    }

    public static Link select(int id) {
        Link link = null;
        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Links WHERE id = " + id);


            while (result.next()) {
                link = new Link(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5));
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }

    public static List<Link> selectAll() {
        List<Link> links = new LinkedList<Link>();
        Link link = null;
        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Links");


            while (result.next()) {
                link = new Link(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5));
                links.add(link);
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return links;
    }

    public static List<Link> filterSelectAll(String filter) {
        List<Link> links = new LinkedList<Link>();
        Link link = null;
        try {
            Connection connection = JdbcConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Links WHERE description like \'%" + filter + "%\'");

            while (result.next()) {
                link = new Link(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5));
                links.add(link);
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return links;
    }
}
