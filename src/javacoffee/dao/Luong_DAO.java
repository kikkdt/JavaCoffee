/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.Luong_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class Luong_DAO {

    public Luong_DAO() {
    }

    public static ArrayList<Luong_pojo> calcLuong(double luongCB, Timestamp from, Timestamp to) {
        ArrayList<Luong_pojo> lstLuong = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "SELECT * FROM uf_CalcSalary(?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setDouble(1, luongCB);
            preparedStatement.setTimestamp(2, from);
            preparedStatement.setTimestamp(3, to);

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                lstLuong.add(new Luong_pojo(result.getInt("MaNV"), result.getNString("TenNV"), result.getInt("TongCaLam"), result.getDouble("ThanhTien")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Luong_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstLuong;
    }
}
