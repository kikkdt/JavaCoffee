/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.sqlprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class SqlServerProvider {

    private Connection conn;

    public Connection open() {
        String server = "KIKKDT";
        String database = "dbJavaCoffee";
        String username = "sa";
        String password = "123";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://" + server + ";database=" + database + ";integratedSecurity=true;user=" + username + ";password=" + password;
            conn = DriverManager.getConnection(connectionUrl);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SqlServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public void close() {
        if (conn != null) {
            try {
                if (!conn.isClosed()) {
                    this.conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SqlServerProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        conn = null;
    }

    public ResultSet executeQuery(String sqlCmd) {
        ResultSet rs = null;
        try {
            Statement sm = conn.createStatement();
            rs = sm.executeQuery(sqlCmd);

        } catch (SQLException ex) {
            Logger.getLogger(SqlServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public int executeUpdateQuery(String sqlCmd) {
        int rowAffected = -1;
        try {
            Statement sm = conn.createStatement();
            rowAffected = sm.executeUpdate(sqlCmd);

        } catch (SQLException ex) {
            Logger.getLogger(SqlServerProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowAffected;
    }
}
