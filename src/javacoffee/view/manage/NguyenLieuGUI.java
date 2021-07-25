/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacoffee.view.manage;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javacoffee.bus.NguyenLieu_BUS;
import javacoffee.bus.NhaCungCap_BUS;
import javacoffee.pojo.NguyenLieu_pojo;
import javacoffee.pojo.NhaCungCap_pojo;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kikkdt (KietDt)
 */
public class NguyenLieuGUI extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private ArrayList<NguyenLieu_pojo> lstNgLieu = new NguyenLieu_BUS().getList();
    private static NhaCungCap_BUS ncc = new NhaCungCap_BUS();

    public NguyenLieuGUI() {
        initComponents();
        loadTableNguyenLieu();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogNgLieu = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        lblNgLieu = new javax.swing.JLabel();
        txtTenNL = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbNCC = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlNhaCungCap = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNguyenLieu = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTongSo = new javax.swing.JLabel();

        dialogNgLieu.setTitle("Quản lý Nhà cung cấp");
        dialogNgLieu.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo-icon.png"))
        );
        dialogNgLieu.setMinimumSize(new java.awt.Dimension(500, 385));
        dialogNgLieu.setResizable(false);
        dialogNgLieu.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogNgLieuWindowClosing(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 87, 29), 2, true));

        lblNgLieu.setBackground(new java.awt.Color(149, 87, 29));
        lblNgLieu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblNgLieu.setForeground(new java.awt.Color(255, 255, 255));
        lblNgLieu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNgLieu.setText("Thêm Nguyên liệu");
        lblNgLieu.setOpaque(true);

        txtTenNL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNL.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTenNL.setToolTipText("Nhập tên Nhà cung cấp");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(96, 56, 19));
        jLabel12.setLabelFor(txtTenNL);
        jLabel12.setText("Tên NL:");
        jLabel12.setToolTipText("Tên Nhà cung cấp");

        txtDonViTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDonViTinh.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDonViTinh.setToolTipText("Nhập Số điện thoại");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 56, 19));
        jLabel13.setText("Đơn vị tính:");
        jLabel13.setToolTipText("Số điện thoại");

        txtDonGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDonGia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDonGia.setToolTipText("Nhập Số điện thoại");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(96, 56, 19));
        jLabel14.setText("Đơn giá:");
        jLabel14.setToolTipText("Số điện thoại");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(96, 56, 19));
        jLabel15.setText("Mô tả:");
        jLabel15.setToolTipText("Số điện thoại");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(96, 56, 19));
        jLabel16.setText("Nhà cung cấp:");
        jLabel16.setToolTipText("Số điện thoại");

        cbNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMoTa.setColumns(20);
        txtMoTa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMoTa.setRows(3);
        jScrollPane2.setViewportView(txtMoTa);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNgLieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel12))
                                    .addGap(23, 23, 23))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addGap(45, 45, 45)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(58, 58, 58)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDonViTinh)
                            .addComponent(txtTenNL)
                            .addComponent(txtDonGia)
                            .addComponent(jScrollPane2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblNgLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNL, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );

        btnSave.setBackground(new java.awt.Color(149, 87, 29));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-save-24.png"))); // NOI18N
        btnSave.setText("Lưu");
        btnSave.setBorderPainted(false);
        btnSave.setIconTextGap(10);

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(96, 56, 19));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-cancel-24.png"))); // NOI18N
        btnCancel.setText("Thoát");
        btnCancel.setIconTextGap(10);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogNgLieuLayout = new javax.swing.GroupLayout(dialogNgLieu.getContentPane());
        dialogNgLieu.getContentPane().setLayout(dialogNgLieuLayout);
        dialogNgLieuLayout.setHorizontalGroup(
            dialogNgLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogNgLieuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogNgLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dialogNgLieuLayout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        dialogNgLieuLayout.setVerticalGroup(
            dialogNgLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogNgLieuLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(dialogNgLieuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        setMinimumSize(new java.awt.Dimension(1024, 500));
        setPreferredSize(new java.awt.Dimension(1024, 500));

        pnlNhaCungCap.setMinimumSize(new java.awt.Dimension(1024, 500));
        pnlNhaCungCap.setPreferredSize(new java.awt.Dimension(1024, 500));

        jPanel2.setBackground(new java.awt.Color(149, 87, 29));
        jPanel2.setMinimumSize(new java.awt.Dimension(793, 45));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnThem.setBackground(new java.awt.Color(149, 87, 29));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-24.png"))); // NOI18N
        btnThem.setToolTipText("Thêm");
        btnThem.setBorderPainted(false);
        btnThem.setFocusable(false);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThem.setLabel("Thêm");
        btnThem.setMaximumSize(new java.awt.Dimension(100, 35));
        btnThem.setMinimumSize(new java.awt.Dimension(100, 35));
        btnThem.setPreferredSize(new java.awt.Dimension(100, 35));
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnSua.setBackground(new java.awt.Color(149, 87, 29));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-pencil-drawing-24.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setToolTipText("Sửa");
        btnSua.setBorderPainted(false);
        btnSua.setFocusable(false);
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSua.setMaximumSize(new java.awt.Dimension(100, 35));
        btnSua.setMinimumSize(new java.awt.Dimension(100, 35));
        btnSua.setPreferredSize(new java.awt.Dimension(100, 35));
        btnSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXoa.setBackground(new java.awt.Color(149, 87, 29));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-minus-24.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setToolTipText("Xóa");
        btnXoa.setBorderPainted(false);
        btnXoa.setFocusable(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnXoa.setMaximumSize(new java.awt.Dimension(100, 35));
        btnXoa.setMinimumSize(new java.awt.Dimension(100, 35));
        btnXoa.setPreferredSize(new java.awt.Dimension(100, 35));
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(149, 87, 29)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(txtSearch);
        jLabel1.setText("Tìm Nguyên liệu:");
        jLabel1.setToolTipText("Tìm Nguyên liệu");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-24.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane1.setBorder(null);

        tblNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNguyenLieu.setOpaque(false);
        jScrollPane1.setViewportView(tblNguyenLieu);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tổng số Nguyên liệu:");

        txtTongSo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongSo.setText("...");
        txtTongSo.setMaximumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setMinimumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(254, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout pnlNhaCungCapLayout = new javax.swing.GroupLayout(pnlNhaCungCap);
        pnlNhaCungCap.setLayout(pnlNhaCungCapLayout);
        pnlNhaCungCapLayout.setHorizontalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlNhaCungCapLayout.setVerticalGroup(
            pnlNhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNhaCungCapLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || (txtTenNL.getText().isBlank() && cbNCC.getSelectedItem() == null && txtDonViTinh.getText().isBlank() && txtDonGia.getText().isBlank())) {
            dialogNgLieu.dispose();
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Nguyên liệu chưa được lưu. Lưu?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chosen == JOptionPane.NO_OPTION) {
                dialogNgLieu.dispose();
            } else if (chosen == JOptionPane.YES_OPTION) {
                btnSave.doClick();
                if ("performed".equalsIgnoreCase(btnSave.getActionCommand())) {
                    dialogNgLieu.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void dialogNgLieuWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogNgLieuWindowClosing
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || (txtTenNL.getText().isBlank() && cbNCC.getSelectedItem() == null && txtDonViTinh.getText().isBlank() && txtDonGia.getText().isBlank())) {
            dialogNgLieu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Nguyên liệu chưa được lưu. Lưu?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            switch (chosen) {
                case JOptionPane.NO_OPTION:
                    dialogNgLieu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    break;
                case JOptionPane.CANCEL_OPTION:
                    dialogNgLieu.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    break;
                case JOptionPane.YES_OPTION:
                    btnSave.doClick();
                    if ("performed".equalsIgnoreCase(btnSave.getActionCommand())) {
                        dialogNgLieu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_dialogNgLieuWindowClosing

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        lblNgLieu.setText("Thêm Nguyên liệu");
        txtTenNL.setText("");
        loadCbNhaCungCap();
        txtDonViTinh.setText("");
        txtDonGia.setText("");
        txtMoTa.setText("");

        if (btnSave.getActionListeners().length != 0) {
            for (ActionListener item : btnSave.getActionListeners()) {
                btnSave.removeActionListener(item);
            }
        }
        btnSave.addActionListener((ActionEvent e) -> {
            int maNCC = ncc.getMaNCC(cbNCC.getSelectedItem().toString());
            double donGia;
            if (txtDonGia.getText().matches("^\\d+$")) {
                donGia = Double.parseDouble(txtDonGia.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi, đơn giá không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
                return;
            }
            String moTa = txtMoTa.getText().isBlank() ? null : txtMoTa.getText();

            if (new NguyenLieu_BUS().insert(txtTenNL.getText().trim(), maNCC, txtDonViTinh.getText().trim(), donGia, moTa) > 0) {
                JOptionPane.showMessageDialog(null, "Thêm nguyên liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dialogNgLieu.dispose();
                btnSave.setActionCommand("performed");
                loadTableNguyenLieu();
            }
        });

        dialogNgLieu.getRootPane().setDefaultButton(btnSave);
        dialogNgLieu.setLocationRelativeTo(null);
        dialogNgLieu.setModal(true);
        dialogNgLieu.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tblNguyenLieu.getSelectedRowCount() == 1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 nhà cung cấp để sửa thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else {
            int index = tblNguyenLieu.getSelectedRow();
            lblNgLieu.setText("Cập nhật Nguyên liệu");
            dtm = (DefaultTableModel) tblNguyenLieu.getModel();
            int maNL = Integer.parseInt(dtm.getValueAt(index, 0).toString());
            txtTenNL.setText(dtm.getValueAt(index, 1).toString());
            loadCbNhaCungCap();
            int maNCC = ncc.getMaNCC(dtm.getValueAt(index, 2).toString());
            txtDonViTinh.setText(dtm.getValueAt(index, 3).toString());
            String tmpDonGia = dtm.getValueAt(index, 4).toString();
            txtDonGia.setText(new StringBuilder(tmpDonGia).deleteCharAt(tmpDonGia.indexOf(".")).toString());
            txtMoTa.setText(dtm.getValueAt(index, 5) == null ? "" : dtm.getValueAt(index, 5).toString());

            if (btnSave.getActionListeners().length != 0) {
                for (ActionListener item : btnSave.getActionListeners()) {
                    btnSave.removeActionListener(item);
                }
            }
            btnSave.addActionListener((ActionEvent e) -> {
                double donGia;
                if (txtDonGia.getText().matches("^\\d+$")) {
                    donGia = Double.parseDouble(txtDonGia.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi, đơn giá không đúng.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
                    return;
                }
                String moTa = txtMoTa.getText().isBlank() ? null : txtMoTa.getText();

                if (new NguyenLieu_BUS().update(maNL, txtTenNL.getText().trim(), maNCC, txtDonViTinh.getText().trim(), donGia, moTa) > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật nguyên liệu thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dialogNgLieu.dispose();
                    btnSave.setActionCommand("performed");
                    loadTableNguyenLieu();
                }
            });

            dialogNgLieu.getRootPane().setDefaultButton(btnSave);
            dialogNgLieu.setLocationRelativeTo(null);
            dialogNgLieu.setModal(true);
            dialogNgLieu.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int[] rowSelected = tblNguyenLieu.getSelectedRows();
        if (rowSelected.length == 0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 nguyên liệu để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        else {
            dtm = (DefaultTableModel) tblNguyenLieu.getModel();
            int chosen = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá " + rowSelected.length + " nguyên liệu không?", "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (chosen == JOptionPane.YES_OPTION) {
                int rowAffected = 0;
                for (int i = 0; i < rowSelected.length; i++) {
                    if (new NguyenLieu_BUS().delete(Integer.parseInt(dtm.getValueAt(rowSelected[i], 0).toString())) > 0) {
                        rowAffected++;
                    }
                }
                if (rowAffected == rowSelected.length) {
                    JOptionPane.showMessageDialog(null, "Xoá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                loadTableNguyenLieu();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String strSearch = "^.*" + txtSearch.getText().toLowerCase() + ".*$";
        dtm = (DefaultTableModel) tblNguyenLieu.getModel();
        dtm.setRowCount(0);
        lstNgLieu.stream().filter(nl -> (String.valueOf(nl.getMaNL()).matches(strSearch) || nl.getTenNL().toLowerCase().matches(strSearch) || ncc.getTenNCC(nl.getMaNCC()).toLowerCase().matches(strSearch) || nl.getDonViTinh().toLowerCase().matches(strSearch) || String.valueOf(nl.getDonGia()).matches(strSearch))).forEachOrdered(nl -> {
            dtm.addRow(new Object[]{
                nl.getMaNL(),
                nl.getTenNL(),
                ncc.getTenNCC(nl.getMaNCC()),
                nl.getDonViTinh(),
                String.format("%,.0f", nl.getDonGia()),
                nl.getMoTa()
            });
        });
    }//GEN-LAST:event_txtSearchKeyReleased

    private void loadCbNhaCungCap() {
        ArrayList<NhaCungCap_pojo> lstNCC = ncc.getList();
        if (lstNCC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lỗi, nhà cung cấp hiện đang trống.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else {
            lstNCC.forEach(item -> cbNCC.addItem(item.getTenNCC()));
        }
    }

    private void loadTableNguyenLieu() {
        lstNgLieu = new NguyenLieu_BUS().getList();
        if (lstNgLieu.isEmpty()) {
            return;
        }

        tblNguyenLieu.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblNguyenLieu.getTableHeader().setReorderingAllowed(false);
        tblNguyenLieu.setRowHeight(24);
        tblNguyenLieu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblNguyenLieu.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Set DefaultTableModel & add header table
        tblNguyenLieu.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        tblNguyenLieu.getModel().addTableModelListener((TableModelEvent e) -> {
            txtTongSo.setText(tblNguyenLieu.getRowCount() + "");
        });

        dtm = (DefaultTableModel) tblNguyenLieu.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Mã NL");
        dtm.addColumn("Tên NL");
        dtm.addColumn("Mã NCC");
        dtm.addColumn("ĐVT");
        dtm.addColumn("Đơn giá");
        dtm.addColumn("Mô tả");

        //Setting column width & turn off resizable
        tblNguyenLieu.getColumnModel().getColumn(0).setMinWidth(100);
        tblNguyenLieu.getColumnModel().getColumn(0).setMaxWidth(100);
        for (int i = 0; i < 3; i++) {
            tblNguyenLieu.getColumnModel().getColumn(i).setResizable(false);
        }
        tblNguyenLieu.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        lstNgLieu.forEach(nl -> {
            dtm.addRow(new Object[]{
                nl.getMaNL(),
                nl.getTenNL(),
                ncc.getTenNCC(nl.getMaNCC()),
                nl.getDonViTinh(),
                String.format("%,.0f", nl.getDonGia()),
                nl.getMoTa()
            });
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    protected javax.swing.JButton btnSave;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbNCC;
    private javax.swing.JDialog dialogNgLieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNgLieu;
    private javax.swing.JPanel pnlNhaCungCap;
    private javax.swing.JTable tblNguyenLieu;
    protected javax.swing.JTextField txtDonGia;
    protected javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSearch;
    protected javax.swing.JTextField txtTenNL;
    private javax.swing.JLabel txtTongSo;
    // End of variables declaration//GEN-END:variables
}
