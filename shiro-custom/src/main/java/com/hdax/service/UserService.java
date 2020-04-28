package com.hdax.service;

import com.hdax.entity.SmbmsUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {
    public void user(SmbmsUser user){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smbms","root","123456");
            String sql = "insert into smbms_user(username,usercode,userpassword,salt)values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getUsercode());
            statement.setString(3,user.getUserpassword());
            statement.setString(4,user.getSalt());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
