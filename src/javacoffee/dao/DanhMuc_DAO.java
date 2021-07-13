/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.PreparedStatement;
import javacoffee.pojo.DanhMuc_pojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class DanhMuc_DAO {

    public DanhMuc_DAO() {
    }

    public static ArrayList<DanhMuc_pojo> getList() {
        ArrayList<DanhMuc_pojo> lstDanhMuc = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_DanhMuc WHERE DaXoa=0 ORDER BY MaDanhMuc";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstDanhMuc.add(new DanhMuc_pojo(result.getInt("MaDanhMuc"), result.getNString("TenDanhMuc"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DanhMuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstDanhMuc;
    }

    public static int insert(String tenDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_DanhMuc(TenDanhMuc) VALUES(?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenDanhMuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maDanhMuc, String tenDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_DanhMuc SET TenDanhMuc=? WHERE MaDanhMuc=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenDanhMuc);
            preparedStatement.setInt(2, maDanhMuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maDanhMuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_DanhMuc SET DaXoa=1 WHERE MaDanhMuc=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maDanhMuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DanhMuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
