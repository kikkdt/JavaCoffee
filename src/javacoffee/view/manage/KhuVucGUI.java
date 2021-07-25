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
import javacoffee.bus.Ban_BUS;
import javacoffee.bus.KhuVuc_BUS;
import javacoffee.pojo.Ban_pojo;
import javacoffee.pojo.KhuVuc_pojo;
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
public class KhuVucGUI extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private ArrayList<KhuVuc_pojo> lstKhuVuc = new KhuVuc_BUS().getList();
    private static KhuVuc_BUS khuvuc = new KhuVuc_BUS();

    public KhuVucGUI() {
        initComponents();
        loadTabKhuVuc();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogKhuVuc = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        lblKhuVuc = new javax.swing.JLabel();
        txtKhuVuc = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlKhuVuc = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuVuc = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtTongSo = new javax.swing.JLabel();

        dialogKhuVuc.setTitle("Quản lý Khu vực");
        dialogKhuVuc.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo-icon.png"))
        );
        dialogKhuVuc.setMinimumSize(new java.awt.Dimension(400, 250));
        dialogKhuVuc.setResizable(false);
        dialogKhuVuc.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogKhuVucWindowClosing(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 87, 29), 2, true));

        lblKhuVuc.setBackground(new java.awt.Color(149, 87, 29));
        lblKhuVuc.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblKhuVuc.setForeground(new java.awt.Color(255, 255, 255));
        lblKhuVuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKhuVuc.setText("Thêm Khu vực");
        lblKhuVuc.setOpaque(true);

        txtKhuVuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtKhuVuc.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(96, 56, 19));
        jLabel12.setText("Tên Khu vực:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKhuVuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(lblKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
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

        javax.swing.GroupLayout dialogKhuVucLayout = new javax.swing.GroupLayout(dialogKhuVuc.getContentPane());
        dialogKhuVuc.getContentPane().setLayout(dialogKhuVucLayout);
        dialogKhuVucLayout.setHorizontalGroup(
            dialogKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogKhuVucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dialogKhuVucLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        dialogKhuVucLayout.setVerticalGroup(
            dialogKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogKhuVucLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setMinimumSize(new java.awt.Dimension(1024, 500));
        setPreferredSize(new java.awt.Dimension(1024, 500));

        pnlKhuVuc.setPreferredSize(new java.awt.Dimension(800, 500));

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

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(txtSearch);
        jLabel1.setText("Tìm Khu vực:");
        jLabel1.setToolTipText("Tìm Khu vực");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-24.png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jScrollPane1.setBorder(null);

        tblKhuVuc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhuVuc.setOpaque(false);
        jScrollPane1.setViewportView(tblKhuVuc);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tổng số Khu vực:");

        txtTongSo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongSo.setText("...");
        txtTongSo.setMaximumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setMinimumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
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
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout pnlKhuVucLayout = new javax.swing.GroupLayout(pnlKhuVuc);
        pnlKhuVuc.setLayout(pnlKhuVucLayout);
        pnlKhuVucLayout.setHorizontalGroup(
            pnlKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlKhuVucLayout.setVerticalGroup(
            pnlKhuVucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhuVucLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlKhuVuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || txtKhuVuc.getText().isBlank()) {
            dialogKhuVuc.dispose();
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Khu vực chưa được lưu. Bạn có muốn lưu không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chosen == JOptionPane.NO_OPTION) {
                dialogKhuVuc.dispose();
            } else if (chosen == JOptionPane.YES_OPTION) {
                btnSave.doClick();
                if ("performed".equalsIgnoreCase(btnSave.getActionCommand())) {
                    dialogKhuVuc.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void dialogKhuVucWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogKhuVucWindowClosing
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || txtKhuVuc.getText().isBlank()) {
            dialogKhuVuc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Khu vực chưa được lưu. Bạn có muốn lưu không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            switch (chosen) {
                case JOptionPane.NO_OPTION:
                    dialogKhuVuc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    break;
                case JOptionPane.CANCEL_OPTION:
                    dialogKhuVuc.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    break;
                case JOptionPane.YES_OPTION:
                    btnSave.doClick();
                    if ("performed".equalsIgnoreCase(btnSave.getActionCommand())) {
                        dialogKhuVuc.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_dialogKhuVucWindowClosing

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        lblKhuVuc.setText("Thêm Khu vực");
        txtKhuVuc.setText("");
        if (btnSave.getActionListeners().length != 0) {
            for (ActionListener item : btnSave.getActionListeners()) {
                btnSave.removeActionListener(item);
            }
        }
        btnSave.addActionListener((ActionEvent e) -> {
            if (new KhuVuc_BUS().insert(txtKhuVuc.getText().trim()) > 0) {
                JOptionPane.showMessageDialog(null, "Thêm khu vực thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dialogKhuVuc.dispose();
                btnSave.setActionCommand("performed");
                loadTabKhuVuc();
            }
        });
        dialogKhuVuc.getRootPane().setDefaultButton(btnSave);
        dialogKhuVuc.setLocationRelativeTo(null);
        dialogKhuVuc.setModal(true);
        dialogKhuVuc.setVisible(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (tblKhuVuc.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 khu vực để sửa thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else {
            int index = tblKhuVuc.getSelectedRow();
            lblKhuVuc.setText("Cập nhật Khu vực");
            dtm = (DefaultTableModel) tblKhuVuc.getModel();
            int maKV = Integer.parseInt(dtm.getValueAt(index, 0).toString());
            String tenKV = dtm.getValueAt(index, 1).toString();
            txtKhuVuc.setText(tenKV);

            if (btnSave.getActionListeners().length != 0) {
                for (ActionListener item : btnSave.getActionListeners()) {
                    btnSave.removeActionListener(item);
                }
            }
            btnSave.addActionListener((ActionEvent e) -> {
                if (new KhuVuc_BUS().update(maKV, txtKhuVuc.getText().trim()) > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật khu vực thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dialogKhuVuc.dispose();
                    btnSave.setActionCommand("performed");
                    loadTabKhuVuc();
                }
            });
            dialogKhuVuc.getRootPane().setDefaultButton(btnSave);
            dialogKhuVuc.setLocationRelativeTo(null);
            dialogKhuVuc.setModal(true);
            dialogKhuVuc.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int[] rowSelected = tblKhuVuc.getSelectedRows();
        if (rowSelected.length == 0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 khu vực để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        else {
            dtm = (DefaultTableModel) tblKhuVuc.getModel();
            int chosen = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá " + rowSelected.length + " khu vực không?", "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (chosen == JOptionPane.YES_OPTION) {
                int rowAffected = 0;
                khuvuc = new KhuVuc_BUS();
                Ban_BUS ban = new Ban_BUS();
                for (int i = 0; i < rowSelected.length; i++) {
                    String tenKV = dtm.getValueAt(rowSelected[i], 1).toString();
                    int maKV = Integer.parseInt(dtm.getValueAt(rowSelected[i], 0).toString());

                    ArrayList<Ban_pojo> lstBan_KV = new Ban_BUS().getList(maKV);
                    // If there exists tables in this area
                    if (!lstBan_KV.isEmpty()) {
                        int comfirmDel = JOptionPane.showConfirmDialog(null, "Xóa khu vực [" + tenKV + "] sẽ xóa " + lstBan_KV.size() + " bàn hiện có trong đó, bạn có chắc muốn xóa?", "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
                        if (comfirmDel == JOptionPane.YES_OPTION) {
                            boolean chkTrangThai = false;
                            for (Ban_pojo b : lstBan_KV) {
                                if (b.isTrangThai()) {
                                    chkTrangThai = true;
                                    break;
                                }
                            }
                            // If there exist a table is serving, don't delete it
                            if (!chkTrangThai) {
                                if (ban.deleteList(maKV) > 0) {
                                    rowAffected = khuvuc.delete(maKV) > 0 ? rowAffected++ : rowAffected;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Xóa thất bại vì có bàn hiện đang phục vụ.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
                            }
                        }
                    } else {
                        rowAffected = khuvuc.delete(maKV) > 0 ? rowAffected++ : rowAffected;
                    }
                }
                if (rowAffected == rowSelected.length) {
                    JOptionPane.showMessageDialog(null, "Xoá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                loadTabKhuVuc();
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String strSearch = "^.*" + txtSearch.getText().toLowerCase() + ".*$";
        dtm = (DefaultTableModel) tblKhuVuc.getModel();
        dtm.setRowCount(0);
        lstKhuVuc.stream().filter(kv -> (String.valueOf(kv.getMaKhuVuc()).matches(strSearch) || kv.getTenKhuVuc().toLowerCase().matches(strSearch))).forEachOrdered(kv -> {
            dtm.addRow(new Object[]{
                kv.getMaKhuVuc(),
                kv.getTenKhuVuc()
            });
        });
    }//GEN-LAST:event_txtSearchKeyReleased

    private void loadTabKhuVuc() {
        lstKhuVuc = new KhuVuc_BUS().getList();
        if (lstKhuVuc.isEmpty()) {
            return;
        }

        tblKhuVuc.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblKhuVuc.getTableHeader().setReorderingAllowed(false);
        tblKhuVuc.setRowHeight(24);
        tblKhuVuc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblKhuVuc.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Set DefaultTableModel & add header table
        tblKhuVuc.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        tblKhuVuc.getModel().addTableModelListener((TableModelEvent e) -> {
            txtTongSo.setText(tblKhuVuc.getRowCount() + "");
        });

        dtm = (DefaultTableModel) tblKhuVuc.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Mã Khu vực");
        dtm.addColumn("Tên Khu vực");

        //Setting column width & turn off resizable
        tblKhuVuc.getColumnModel().getColumn(0).setMinWidth(150);
        tblKhuVuc.getColumnModel().getColumn(0).setMaxWidth(150);
        for (int i = 0; i < 2; i++) {
            tblKhuVuc.getColumnModel().getColumn(i).setResizable(false);
        }
        tblKhuVuc.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        for (KhuVuc_pojo kv : lstKhuVuc) {
            dtm.addRow(new Object[]{
                kv.getMaKhuVuc(),
                kv.getTenKhuVuc()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    protected javax.swing.JButton btnSave;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JDialog dialogKhuVuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKhuVuc;
    private javax.swing.JPanel pnlKhuVuc;
    private javax.swing.JTable tblKhuVuc;
    protected javax.swing.JTextField txtKhuVuc;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtTongSo;
    // End of variables declaration//GEN-END:variables
}
