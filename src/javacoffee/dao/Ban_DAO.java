/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.Ban_pojo;
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
public class Ban_DAO {

    public Ban_DAO() {
    }

    public static ArrayList<Ban_pojo> getList() {
        ArrayList<Ban_pojo> lstBan = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_Ban WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                int maBan = Integer.parseInt(result.getString("MaBan"));
                String tenBan = result.getNString("TenBan");
                int maKV = Integer.parseInt(result.getString("MaKV"));
                boolean trangThai = result.getBoolean("TrangThai");
                boolean daXoa = result.getBoolean("DaXoa");
                lstBan.add(new Ban_pojo(maBan, maKV, tenBan, trangThai, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstBan;
    }

    public static ArrayList<Ban_pojo> getList(int maKV) {
        ArrayList<Ban_pojo> lstResult = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "SELECT * FROM tb_Ban WHERE MaKV=? AND DaXoa=0 ORDER BY MaBan";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maKV);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int maBan = Integer.parseInt(result.getString("MaBan"));
                String tenBan = result.getNString("TenBan");
                int maKV2 = Integer.parseInt(result.getString("MaKV"));
                boolean trangThai = result.getBoolean("TrangThai");
                boolean daXoa = result.getBoolean("DaXoa");
                lstResult.add(new Ban_pojo(maBan, maKV2, tenBan, trangThai, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstResult;
    }

    public static int updateStatus(int maBan, boolean trangThai) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "UPDATE tb_Ban SET TrangThai=? WHERE MaBan=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setBoolean(1, trangThai);
            preparedStatement.setInt(2, maBan);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int insert(String tenBan, int maKV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_Ban(TenBan, MaKV) VALUES(?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenBan);
            preparedStatement.setInt(2, maKV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maBan, String tenBan, int maKV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_Ban SET TenBan=?, MaKV=? WHERE MaBan=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenBan);
            preparedStatement.setInt(2, maKV);
            preparedStatement.setInt(3, maBan);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maBan) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_Ban SET DaXoa=1 WHERE MaBan=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maBan);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int deleteList(int maKV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_Ban SET DaXoa=1 WHERE MaKV=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maKV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Ban_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
