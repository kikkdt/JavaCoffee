/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.SanPham_pojo;
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
public class SanPham_DAO {

    public SanPham_DAO() {
    }

    public static ArrayList<SanPham_pojo> getList() {
        ArrayList<SanPham_pojo> list = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();
            String sqlCmd = "SELECT * FROM tb_SanPham WHERE DaXoa=0 ORDER BY MaSP";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                int maSanPham = result.getInt("MaSP");
                String tenSanPham = result.getNString("TenSP");
                int maDanhMuc = result.getInt("MaDanhMuc");
                String hinhAnh = result.getString("HinhAnh");
                double giaBan = result.getDouble("GiaBan");
                boolean daXoa = result.getBoolean("DaXoa");
                list.add(new SanPham_pojo(maSanPham, maDanhMuc, tenSanPham, hinhAnh, giaBan, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return list;
    }

    public static ArrayList<SanPham_pojo> getList(int maDanhMuc) {
        ArrayList<SanPham_pojo> lstResult = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "SELECT * FROM tb_SanPham WHERE MaDanhMuc=? AND DaXoa=0 ORDER BY MaSP";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maDanhMuc);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int maSanPham = result.getInt("MaSP");
                String tenSanPham = result.getNString("TenSP");
                String hinhAnh = result.getString("HinhAnh");
                double giaBan = result.getDouble("GiaBan");
                boolean daXoa = result.getBoolean("DaXoa");
                lstResult.add(new SanPham_pojo(maSanPham, maDanhMuc, tenSanPham, hinhAnh, giaBan, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstResult;
    }

    public static int insert(String tenSP, String hinhAnh, double giaBan, int maDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_SanPham(TenSP, HinhAnh, GiaBan, MaDanhMuc) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenSP);
            preparedStatement.setNString(2, hinhAnh);
            preparedStatement.setDouble(3, giaBan);
            preparedStatement.setInt(4, maDanhMuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maSP, String tenSP, String hinhAnh, double giaBan, int maDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_SanPham SET TenSP=?, HinhAnh=?, GiaBan=?, MaDanhMuc=? WHERE MaSP=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenSP);
            preparedStatement.setNString(2, hinhAnh);
            preparedStatement.setDouble(3, giaBan);
            preparedStatement.setInt(4, maDanhMuc);
            preparedStatement.setInt(5, maSP);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maSP) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_SanPham SET DaXoa=1 WHERE MaSP=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maSP);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int deleteList(int maDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_SanPham SET DaXoa=1 WHERE MaDanhMuc=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maDanhMuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
