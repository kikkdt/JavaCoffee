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
import javacoffee.pojo.LoaiKhachHang_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class LoaiKhachHang_DAO {

    public LoaiKhachHang_DAO() {
    }

    public static ArrayList<LoaiKhachHang_pojo> getList() {
        ArrayList<LoaiKhachHang_pojo> lstLoaiKH = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_LoaiKhachHang WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstLoaiKH.add(new LoaiKhachHang_pojo(result.getInt("MaLoaiKH"), result.getNString("TenLoaiKH"), result.getInt("PhanTramGiam"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoaiKhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstLoaiKH;
    }
}
