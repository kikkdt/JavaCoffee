/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import javacoffee.sqlprovider.SqlServerProvider;
import javacoffee.pojo.KhuVuc_pojo;
import javacoffee.pojo.HoaDon_pojo;
import javacoffee.pojo.Ban_pojo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.ThanhToan_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThanhToan_DAO {

    public static ThanhToan_pojo getThanhToan(int maBan) {
        ThanhToan_pojo thanhtoan = null;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            CallableStatement callableStatement = sql.open().prepareCall("{call up_GetBill(?)}");
            callableStatement.setInt(1, maBan);
            ResultSet result = callableStatement.executeQuery();

            HoaDon_pojo hd = null;
            KhuVuc_pojo kv = null;
            Ban_pojo b = null;
            int maHD = 0;
            while (result.next()) {
                //Create HoaDon
                maHD = result.getInt("MaHD");
                int maNV = result.getInt("MaNV");
                int maKH = result.getInt("MaKH");
                Timestamp ngayXuatHD = result.getTimestamp("NgayXuatHD");
                double tongTien = result.getDouble("TongTien");
                Double giamGia = result.getDouble("GiamGia");
                double thanhTien = result.getDouble("ThanhTien");
                boolean trangThai = result.getBoolean("TrangThai");
                hd = new HoaDon_pojo(maHD, maNV, maKH, maBan, ngayXuatHD, tongTien, giamGia, thanhTien, trangThai);

                //Create KhuVuc
                int maKV = result.getInt("MaKV");
                String tenKV = result.getString("TenKV");
                kv = new KhuVuc_pojo(maKV, tenKV, false);

                //Create Ban
                String tenBan = result.getString("TenBan");
                boolean trangThaiBan = result.getBoolean("TrangThaiBan");
                b = new Ban_pojo(maBan, maKV, tenBan, trangThaiBan, false);
            }
            thanhtoan = new ThanhToan_pojo(hd, b, kv, CTHoaDon_DAO.getList(maHD));
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return thanhtoan;
    }

    public static int completeThanhToan(int maHD, int maBan) {
        int res = 0;
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "{call up_CompletePayment(?,?)}";
            CallableStatement callableStatement = sql.open().prepareCall(sqlCmd);
            callableStatement.setInt(1, maHD);
            callableStatement.setInt(2, maBan);

            res = callableStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ThanhToan_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return res;
    }
}
