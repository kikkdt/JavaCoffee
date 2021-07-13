/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.bus;

import java.sql.Date;
import java.util.ArrayList;
import javacoffee.dao.ThongKe_DAO;
import javacoffee.pojo.ThongKe_pojo;

/**
 *
 * @author kikkdt (KietDt)
 */
public class ThongKe_BUS {

    public ArrayList<ThongKe_pojo> getThongKe(Date from, Date to) {
        return ThongKe_DAO.getThongKe(from, to);
    }
}
