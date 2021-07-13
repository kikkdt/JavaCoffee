/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacoffee.pojo.ThongKe_pojo;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import javacoffee.sqlprovider.SqlServerProvider;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThongKe_DAO {

    public static ArrayList<ThongKe_pojo> getThongKe(Date from, Date to) {
        ArrayList<ThongKe_pojo> lstDoanhThu = new ArrayList<>();
        SqlServerProvider sql = new SqlServerProvider();
        try {
            String sqlCmd = "{call up_RevenueStatistics(?,?)}";
            CallableStatement callableStatement = sql.open().prepareCall(sqlCmd);
            callableStatement.setDate(1, from);
            callableStatement.setDate(2, to);

            ResultSet result = callableStatement.executeQuery();
            while (result.next()) {
                lstDoanhThu.add(new ThongKe_pojo(result.getDate("NgayXuatHD"), result.getDouble("ThanhTien")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sql.close();
        }
        return lstDoanhThu;
    }
}
