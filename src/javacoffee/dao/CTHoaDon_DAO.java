/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.CTHoaDon_pojo;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CTHoaDon_DAO {

    public CTHoaDon_DAO() {
    }

    public static ArrayList<CTHoaDon_pojo> getList(int maHD) {
        ArrayList<CTHoaDon_pojo> lstCTHoaDon = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "SELECT * FROM tb_CTHoaDon WHERE MaHD=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maHD);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int maSP = result.getInt("MaSP");
                int soLuong = result.getInt("SoLuong");
                double thanhTien = result.getDouble("ThanhTien");

                lstCTHoaDon.add(new CTHoaDon_pojo(maHD, maSP, soLuong, thanhTien));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstCTHoaDon;
    }

    public static int insert(int maHD, int maSP) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "{call up_InsertInfoBill(?,?)}";
            CallableStatement callableStatement = sql.open().prepareCall(sqlCmd);
            callableStatement.setInt(1, maHD);
            callableStatement.setInt(2, maSP);

            res = callableStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maHD, int maSP, int soLuong) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {

            String sqlCmd = "UPDATE tb_CTHoaDon SET SoLuong=? WHERE MaHD=? AND MaSP=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, soLuong);
            preparedStatement.setInt(2, maHD);
            preparedStatement.setInt(3, maSP);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maHD, int maSP) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "DELETE tb_CTHoaDon WHERE MaHD=? AND MaSP=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maHD);
            preparedStatement.setInt(2, maSP);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
