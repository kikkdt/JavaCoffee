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
import javacoffee.pojo.NhaCungCap_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NhaCungCap_DAO {

    public NhaCungCap_DAO() {
    }

    public static ArrayList<NhaCungCap_pojo> getList() {
        ArrayList<NhaCungCap_pojo> LstNCC = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_NhaCungCap WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                LstNCC.add(new NhaCungCap_pojo(result.getInt("MaNCC"), result.getNString("TenNCC"), result.getString("SDT"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return LstNCC;
    }

    public static int insert(String tenNCC, String sdt) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_NhaCungCap(TenNCC, SDT) VALUES(?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNCC);
            preparedStatement.setString(2, sdt);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maNCC, String tenNCC, String sdt) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NhaCungCap SET TenNCC=?, SDT=? WHERE MaNCC=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNCC);
            preparedStatement.setString(2, sdt);
            preparedStatement.setInt(3, maNCC);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maNCC) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NhaCungCap SET DaXoa=1 WHERE MaNCC=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNCC);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCap_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
