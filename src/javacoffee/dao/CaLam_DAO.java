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
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.CaLam_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CaLam_DAO {

    public CaLam_DAO() {
    }

    public static ArrayList<CaLam_pojo> getList() {
        ArrayList<CaLam_pojo> lstCaLam = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_CaLam WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstCaLam.add(new CaLam_pojo(result.getInt("MaCaLam"), result.getNString("TenCaLam"), result.getTime("GioBatDau"), result.getTime("GioKetThuc"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstCaLam;
    }

    public static int insert(String tenCaLam, Time gioBatDau, Time gioKetThuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_CaLam(TenCaLam, GioBatDau, GioKetThuc) VALUES(?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenCaLam);
            preparedStatement.setTime(2, gioBatDau);
            preparedStatement.setTime(3, gioKetThuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maCaLam, String tenCaLam, Time gioBatDau, Time gioKetThuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_CaLam SET TenCaLam=?, GioBatDau=?, GioKetThuc=? WHERE MaCaLam=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenCaLam);
            preparedStatement.setTime(2, gioBatDau);
            preparedStatement.setTime(3, gioKetThuc);
            preparedStatement.setInt(4, maCaLam);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maCaLam) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_CaLam SET DaXoa=1 WHERE MaCaLam=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maCaLam);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
