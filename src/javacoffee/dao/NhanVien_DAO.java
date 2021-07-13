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
import javacoffee.pojo.NhanVien_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NhanVien_DAO {

    public NhanVien_DAO() {
    }

    public static ArrayList<NhanVien_pojo> getList() {
        ArrayList<NhanVien_pojo> lstNV = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * from tb_NhanVien WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                int maNV = result.getInt("MaNV");
                String tenNV = result.getNString("TenNV");
                String gioiTinh = result.getNString("GioiTinh");
                String chucVu = result.getNString("ChucVu");
                Timestamp ngayVaoLam = result.getTimestamp("NgayVaoLam");
                String diaChi = result.getNString("DiaChi");
                String sdt = result.getString("SDT");
                boolean daXoa = result.getBoolean("DaXoa");
                lstNV.add(new NhanVien_pojo(maNV, tenNV, gioiTinh, chucVu, ngayVaoLam, diaChi, sdt, daXoa));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstNV;
    }

    public static int insert(String tenNV, String gioiTinh, String chucVu, Timestamp ngayVaoLam, String diaChi, String sdt) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_NhanVien(TenNV, GioiTinh, ChucVu, NgayVaoLam, DiaChi, SDT) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNV);
            preparedStatement.setNString(2, gioiTinh);
            preparedStatement.setNString(3, chucVu);
            preparedStatement.setTimestamp(4, ngayVaoLam);
            preparedStatement.setNString(5, diaChi);
            preparedStatement.setString(6, sdt);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maNV, String tenNV, String gioiTinh, String chucVu, Timestamp ngayVaoLam, String diaChi, String sdt) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NhanVien SET TenNV=?, GioiTinh=?, ChucVu=?, NgayVaoLam=?, DiaChi=?, SDT=? WHERE MaNV=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setNString(1, tenNV);
            preparedStatement.setNString(2, gioiTinh);
            preparedStatement.setNString(3, chucVu);
            preparedStatement.setTimestamp(4, ngayVaoLam);
            preparedStatement.setNString(5, diaChi);
            preparedStatement.setString(6, sdt);
            preparedStatement.setInt(7, maNV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(int maNV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_NhanVien SET DaXoa=1 WHERE MaNV=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNV);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
