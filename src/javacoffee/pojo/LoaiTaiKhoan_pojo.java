/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.pojo;

/**
 *
 * @author doant
 */
public class LoaiTaiKhoan_pojo {
    private int id;
    private String tenLoaiTK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiTK() {
        return tenLoaiTK;
    }

    public void setTenLoaiTK(String tenLoaiTK) {
        this.tenLoaiTK = tenLoaiTK;
    }

    public LoaiTaiKhoan_pojo(int id, String tenLoaiTK) {
        this.id = id;
        this.tenLoaiTK = tenLoaiTK;
    }
}
