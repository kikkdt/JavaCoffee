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
import javacoffee.pojo.CTCaLam_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class CTCaLam_DAO {

    public static ArrayList<CTCaLam_pojo> getList(Timestamp ngayLam) {
        ArrayList<CTCaLam_pojo> lstCTCaLam = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "SELECT * FROM tb_CTCaLam WHERE NgayLam=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setTimestamp(1, ngayLam);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                lstCTCaLam.add(new CTCaLam_pojo(result.getInt("MaNV"), result.getInt("MaCaLam"), result.getTimestamp("NgayLam")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CTCaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstCTCaLam;
    }

    public static int insert(int maNV, int maCaLam, Timestamp ngayLam) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_CTCaLam(MaNV, MaCaLam, NgayLam) VALUES(?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNV);
            preparedStatement.setInt(2, maCaLam);
            preparedStatement.setTimestamp(3, ngayLam);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTCaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maNV, int maCaLam, int maCaLam1, Timestamp ngayLam) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_CTCaLam SET MaCaLam=? WHERE MaNV=? AND MaCaLam=? AND NgayLam=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maCaLam1);
            preparedStatement.setInt(2, maNV);
            preparedStatement.setInt(3, maCaLam);
            preparedStatement.setTimestamp(4, ngayLam);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTCaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maNV, int maCaLam, Timestamp ngayLam) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "DELETE tb_CTCaLam WHERE MaNV=? AND MaCaLam=? AND NgayLam=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNV);
            preparedStatement.setInt(2, maCaLam);
            preparedStatement.setTimestamp(3, ngayLam);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(CTCaLam_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
