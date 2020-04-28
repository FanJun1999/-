package com.hdax.service;

import com.hdax.entity.SmbmsUser;

import java.sql.*;

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

    public SmbmsUser login(String usercode){
        SmbmsUser user = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smbms?useSSL=false&useUnicode=true&characterEncoding=UTF-8","root","123456");
            String sql = "SELECT ID,USERNAME,USERCODE,USERPASSWORD,SALT FROM SMBMS_USER WHERE USERCODE=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usercode);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                user = new SmbmsUser();
                user.setId(rs.getInt("ID"));
                user.setUsercode(rs.getString("USERCODE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setUserpassword(rs.getString("USERPASSWORD"));
                user.setSalt(rs.getString("SALT"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
