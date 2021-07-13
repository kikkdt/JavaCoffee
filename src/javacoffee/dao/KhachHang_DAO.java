/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.PreparedStatement;
import javacoffee.pojo.KhachHang_pojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class KhachHang_DAO {

    public KhachHang_DAO() {
    }

    public static ArrayList<KhachHang_pojo> getList() {
        ArrayList<KhachHang_pojo> lstKH = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();
        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_KhachHang WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                int maKH = result.getInt("MaKH");
                String tenKH = result.getNString("TenKH");
                int maLoaiKH = result.getInt("MaLoaiKH");
                int diemTichLuy = result.getInt("DiemTichLuy");
                String sdt = result.getString("SDT");
                boolean daXoa = result.getBoolean("DaXoa");
                lstKH.add(new KhachHang_pojo(maKH, tenKH, maLoaiKH, diemTichLuy, sdt, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstKH;
    }

    public static int insert(String tenKH, String sdt, int loaiKH) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_KhachHang(TenKH, SDT, MaLoaiKH) VALUES(?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenKH);
            preparedStatement.setString(2, sdt);
            preparedStatement.setInt(3, loaiKH);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maKH, String tenKH, String sdt, int loaiKH) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_KhachHang SET TenKH=?, SDT=?, MaLoaiKH=? WHERE MaKH=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenKH);
            preparedStatement.setString(2, sdt);
            preparedStatement.setInt(3, loaiKH);
            preparedStatement.setInt(4, maKH);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maKH) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_KhachHang SET DaXoa=1 WHERE MaKH=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maKH);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
