/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class KetNoiCSDL {
    public static Connection ketNoiCSDL(){
        Connection con = null;
        try 
        {
             
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);         
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_CuaHangVLXD;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
//            String user = "sa";
//            String password = "123";
            con = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
        
    }
}
