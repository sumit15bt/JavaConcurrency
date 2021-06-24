/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sumit
 */
public class UserDao {

    public int saveUser(User user) throws ClassNotFoundException, SQLException {
        int row = 0;
        try {
            Connection con = DbConnection.getConnection();
            PreparedStatement statement = con.prepareStatement("Insert into ct_user values (?,?,?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            row = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return row;
    }

}
