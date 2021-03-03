package com.example.multi.connectToTwo;

import java.sql.*;

public class MySqlConnection {

    public static void main(String [] args){

        String url="jdbc:mysql://localhost:3306/datasource1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username="spring";
        String password="P@ssword1";

        try(  Connection conn= DriverManager.getConnection(url,username,password);
        Statement statement=conn.createStatement()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
             ResultSet rs=statement.executeQuery("select * from persons");

            System.out.println("connected");
        }
        catch(ClassNotFoundException e){
            System.out.println("isn't connected");;
        } catch (SQLSyntaxErrorException throwable) {
            System.out.println("qaws");
            System.out.println(throwable.getMessage());;
        } catch (SQLException throwables) {
            System.out.println("qwer");
        }
    }

}
