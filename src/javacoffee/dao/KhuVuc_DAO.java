/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import java.sql.PreparedStatement;
import javacoffee.pojo.KhuVuc_pojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class KhuVuc_DAO {

    public KhuVuc_DAO() {
    }

    public static ArrayList<KhuVuc_pojo> getList() {
        ArrayList<KhuVuc_pojo> lstKhuVuc = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_KhuVuc WHERE DaXoa=0 ORDER BY MaKV";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstKhuVuc.add(new KhuVuc_pojo(Integer.parseInt(result.getString("MaKV")), result.getString("TenKV"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(KhuVuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstKhuVuc;
    }

    public static int insert(String tenKhuVuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_KhuVuc(TenKV) VALUES(?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setString(1, tenKhuVuc);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhuVuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maKV, String tenKhuVuc) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_KhuVuc SET TenKV=? WHERE MaKV=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenKhuVuc);
            preparedStatement.setInt(2, maKV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhuVuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maKV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_KhuVuc SET DaXoa=1 WHERE MaKV=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maKV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(KhuVuc_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
