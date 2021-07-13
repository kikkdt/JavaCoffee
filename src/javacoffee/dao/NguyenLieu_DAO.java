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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.NguyenLieu_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NguyenLieu_DAO {

    public NguyenLieu_DAO() {
    }

    public static ArrayList<NguyenLieu_pojo> getList() {
        ArrayList<NguyenLieu_pojo> lstNgLieu = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_NguyenLieu WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstNgLieu.add(new NguyenLieu_pojo(result.getInt("MaNL"), result.getNString("TenNL"), result.getInt("MaNCC"), result.getNString("DonViTinh"), result.getDouble("DonGia"), result.getNString("MoTa"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstNgLieu;
    }

    public static int insert(String tenNL, int maNCC, String donViTinh, double donGia, String moTa) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_NguyenLieu(TenNL, MaNCC, DonViTinh, DonGia, MoTa) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNL);
            preparedStatement.setInt(2, maNCC);
            preparedStatement.setNString(3, donViTinh);
            preparedStatement.setDouble(4, donGia);
            preparedStatement.setObject(5, moTa);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maNL, String tenNL, int maNCC, String donViTinh, double donGia, String moTa) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NguyenLieu SET TenNL=?, MaNCC=?, DonViTinh=?, DonGia=?, MoTa=? WHERE MaNL=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNL);
            preparedStatement.setInt(2, maNCC);
            preparedStatement.setNString(3, donViTinh);
            preparedStatement.setDouble(4, donGia);
            preparedStatement.setObject(5, moTa);
            preparedStatement.setInt(6, maNL);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maNL) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NguyenLieu SET DaXoa=1 WHERE MaNL=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNL);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int deleteList(int maNCC) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NguyenLieu SET DaXoa=1 WHERE MaNCC=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNCC);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NguyenLieu_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
