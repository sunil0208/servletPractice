package service;

import model.Users;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sunil on 5/25/16.
 */
public class UserService {
    Connection connection;
    PreparedStatement statement;
    String query;
    ResultSet resultSet;

    public UserService(){
        try {
            connection = new DbConnection().getDbConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(Users users) throws SQLException {

        String insertUser = "INSERT INTO user1 (userName, password) VALUES (?,?)";

        try {
           statement = connection.prepareStatement(insertUser);
            statement.setString(1, users.getUserName());
            statement.setString(2, users.getPassword());
            statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


    public boolean searchUserId(Users users){


        query="select * from user1 where userName = ? && password = ?";
        boolean     success=false;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, users.getUserName());
            statement.setString(2, users.getPassword());
            resultSet=statement.executeQuery();
            while (resultSet.next()){
                success=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;

    }




}
