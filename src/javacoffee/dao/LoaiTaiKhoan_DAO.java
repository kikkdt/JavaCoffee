/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.LoaiTaiKhoan_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class LoaiTaiKhoan_DAO {

    public LoaiTaiKhoan_DAO() {
    }

    public static ArrayList<LoaiTaiKhoan_pojo> getList() {
        ArrayList<LoaiTaiKhoan_pojo> lstLoaiTK = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_LoaiTaiKhoan";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstLoaiTK.add(new LoaiTaiKhoan_pojo(result.getInt("ID"), result.getNString("TenLoaiTK")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoaiTaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstLoaiTK;
    }
}
