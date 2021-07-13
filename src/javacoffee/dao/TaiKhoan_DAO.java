/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.TaiKhoan_pojo;
import java.sql.CallableStatement;
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
public class TaiKhoan_DAO {

    public TaiKhoan_DAO() {
    }

    public static TaiKhoan_pojo login(String tenDangNhap, String matKhau) {
        TaiKhoan_pojo taikhoan = null;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            CallableStatement callableStatement = sql.open().prepareCall("{call up_Login(?,?)}");
            callableStatement.setString(1, tenDangNhap);
            callableStatement.setString(2, matKhau);
            ResultSet result = callableStatement.executeQuery();

            if (result.next()) {
                taikhoan = new TaiKhoan_pojo(result.getString("TenDangNhap"), result.getString("MatKhau"), result.getNString("TenHienThi"), result.getInt("IDLoaiTK"), result.getInt("MaNV"), result.getBoolean("DaXoa"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return taikhoan;
    }

    public static ArrayList<TaiKhoan_pojo> getList() {
        ArrayList<TaiKhoan_pojo> lstTK = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();
        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_TaiKhoan WHERE DaXoa=0";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                lstTK.add(new TaiKhoan_pojo(result.getString("TenDangNhap"), result.getString("MatKhau"), result.getNString("TenHienThi"), result.getInt("IDLoaiTK"), result.getInt("MaNV"), result.getBoolean("DaXoa")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstTK;
    }

    public static int insert(String tenDangNhap, String matKhau, String tenHienThi, int idLoaiTK, int maNV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "INSERT INTO tb_TaiKhoan(TenDangNhap, MatKhau, TenHienThi, IDLoaiTK, MaNV) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setString(1, tenDangNhap);
            preparedStatement.setString(2, matKhau);
            preparedStatement.setNString(3, tenHienThi);
            preparedStatement.setInt(4, idLoaiTK);
            preparedStatement.setInt(5, maNV);

            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(String tenDangNhap, String matKhau, String tenHienThi, int idLoaiTK, int maNV) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "UPDATE tb_TaiKhoan SET MatKhau=?, TenHienThi=?, IDLoaiTK=?, MaNV=? WHERE TenDangNhap=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setString(1, matKhau);
            preparedStatement.setNString(2, tenHienThi);
            preparedStatement.setInt(3, idLoaiTK);
            preparedStatement.setInt(4, maNV);
            preparedStatement.setString(5, tenDangNhap);

            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int delete(String tenDangNhap) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "UPDATE tb_TaiKhoan SET DaXoa=1 WHERE TenDangNhap=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setString(1, tenDangNhap);

            res = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
