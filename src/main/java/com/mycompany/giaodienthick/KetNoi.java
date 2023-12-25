/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giaodienthick;

/**
 *
 * @author MINH QUAN
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class KetNoi {
    public static Connection layKetNoi() { 
        Connection ketNoi = null;
        String uRL = "jdbc:sqlserver://localhost:1433;databaseName=CK;encrypt=true;trustServerCertificate=true;";
        String userName = "sa";
        String password = "Mr.butthead02112003";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //com.microsoft.sqlserver.jdbc.SQLServerDriver
            ketNoi = DriverManager.getConnection(uRL, userName, password);
            System.out.println("Ket noi CSDL thanh cong");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Khong ket noi duoc voi CSDL");
        }
        return ketNoi;
    }
    
    public static void main(String[] args) {
        layKetNoi();
    }
}
