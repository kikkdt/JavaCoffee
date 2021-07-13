/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.HoaDon_pojo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kikkdt (KietDt)
 */
public class HoaDon_DAO {

    public HoaDon_DAO() {
    }

    public static ArrayList<HoaDon_pojo> getList() {
        ArrayList<HoaDon_pojo> lstHoaDon = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_HoaDon ORDER BY NgayXuatHD DESC";
            ResultSet result = sql.executeQuery(sqlCmd);

            while (result.next()) {
                int maHD = result.getInt("MaHD");
                int maNV = result.getInt("MaNV");
                int maKH = result.getInt("MaKH");
                int maBan = result.getInt("MaBan");
                Timestamp ngayXuatHD = result.getTimestamp("NgayXuatHD");
                double tongTien = result.getDouble("TongTien");
                double giamGia = result.getDouble("GiamGia");
                double thanhTien = result.getDouble("ThanhTien");
                boolean trangThai = result.getBoolean("TrangThai");

                lstHoaDon.add(new HoaDon_pojo(maHD, maNV, maKH, maBan, ngayXuatHD, tongTien, giamGia, thanhTien, trangThai));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstHoaDon;
    }

    public static ArrayList<HoaDon_pojo> getList(int ngay, int thang, int nam) {
        ArrayList<HoaDon_pojo> lstHoaDon = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();

        try {
            sql.open();

            String sqlCmd = "SELECT * FROM tb_HoaDon WHERE DAY(NgayXuatHD)=? AND MONTH(NGAYXUATHD)=? AND YEAR(NgayXuatHD)=? ORDER BY NgayXuatHD DESC";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, ngay);
            preparedStatement.setInt(2, thang);
            preparedStatement.setInt(3, nam);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int maHD = result.getInt("MaHD");
                int maNV = result.getInt("MaNV");
                int maKH = result.getInt("MaKH");
                int maBan = result.getInt("MaBan");
                Timestamp ngayXuatHD = result.getTimestamp("NgayXuatHD");
                double tongTien = result.getDouble("TongTien");
                double giamGia = result.getDouble("GiamGia");
                double thanhTien = result.getDouble("ThanhTien");
                boolean trangThai = result.getBoolean("TrangThai");

                lstHoaDon.add(new HoaDon_pojo(maHD, maNV, maKH, maBan, ngayXuatHD, tongTien, giamGia, thanhTien, trangThai));
            }

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstHoaDon;
    }

    public static int insert(int maNV, int maBan) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "INSERT INTO tb_HoaDon(MaNV, MaBan) VALUES (?,?)";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maNV);
            preparedStatement.setInt(2, maBan);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }

    public static int update(int maHD, int maKH) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();

        try {
            String sqlCmd = "UPDATE tb_HoaDon SET MaKH=? WHERE MaHD=?";
            PreparedStatement preparedStatement = sql.open().prepareStatement(sqlCmd);
            preparedStatement.setInt(1, maKH);
            preparedStatement.setInt(2, maHD);

            res = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
