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
public class BanGUI extends javax.swing.JPanel {

    private DefaultTableModel dtm;
    private ArrayList<KhuVuc_pojo> lstKhuVuc = new KhuVuc_BUS().getList();
    private ArrayList<Ban_pojo> lstBan = new Ban_BUS().getList();
    private static KhuVuc_BUS khuvuc = new KhuVuc_BUS();

    public BanGUI() {
        initComponents();
        loadTableBan();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogBan = new javax.swing.JDialog();
        jPanel7 = new javax.swing.JPanel();
        lblBan = new javax.swing.JLabel();
        txtBan = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbKhuVuc = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        pnlBan = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnThemBan = new javax.swing.JButton();
        btnSuaBan = new javax.swing.JButton();
        btnXoaBan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTongSo = new javax.swing.JLabel();

        dialogBan.setTitle("Quản lý Bàn");
        dialogBan.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/logo-icon.png"))
        );
        dialogBan.setMinimumSize(new java.awt.Dimension(400, 300));
        dialogBan.setResizable(false);
        dialogBan.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                dialogBanWindowClosing(evt);
            }
        });

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(149, 87, 29), 2, true));

        lblBan.setBackground(new java.awt.Color(149, 87, 29));
        lblBan.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBan.setForeground(new java.awt.Color(255, 255, 255));
        lblBan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBan.setText("Thêm Bàn");
        lblBan.setOpaque(true);

        txtBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBan.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtBan.setToolTipText("Nhập tên bàn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 56, 19));
        jLabel13.setText("Tên bàn:");

        cbKhuVuc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhuVuc.setToolTipText("Chọn khu vực");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(96, 56, 19));
        jLabel14.setText("Khu vực:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbKhuVuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(lblBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
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

        javax.swing.GroupLayout dialogBanLayout = new javax.swing.GroupLayout(dialogBan.getContentPane());
        dialogBan.getContentPane().setLayout(dialogBanLayout);
        dialogBanLayout.setHorizontalGroup(
            dialogBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogBanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dialogBanLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave)))
                .addContainerGap())
        );
        dialogBanLayout.setVerticalGroup(
            dialogBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogBanLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(dialogBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        setMinimumSize(new java.awt.Dimension(1024, 500));
        setPreferredSize(new java.awt.Dimension(1024, 500));

        pnlBan.setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel3.setBackground(new java.awt.Color(149, 87, 29));
        jPanel3.setMinimumSize(new java.awt.Dimension(793, 45));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnThemBan.setBackground(new java.awt.Color(149, 87, 29));
        btnThemBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemBan.setForeground(new java.awt.Color(255, 255, 255));
        btnThemBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-24.png"))); // NOI18N
        btnThemBan.setToolTipText("Thêm");
        btnThemBan.setBorderPainted(false);
        btnThemBan.setFocusable(false);
        btnThemBan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThemBan.setLabel("Thêm");
        btnThemBan.setMaximumSize(new java.awt.Dimension(100, 35));
        btnThemBan.setMinimumSize(new java.awt.Dimension(100, 35));
        btnThemBan.setPreferredSize(new java.awt.Dimension(100, 35));
        btnThemBan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThemBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemBanActionPerformed(evt);
            }
        });
        jPanel3.add(btnThemBan);

        btnSuaBan.setBackground(new java.awt.Color(149, 87, 29));
        btnSuaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaBan.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-pencil-drawing-24.png"))); // NOI18N
        btnSuaBan.setText("Sửa");
        btnSuaBan.setToolTipText("Sửa");
        btnSuaBan.setBorderPainted(false);
        btnSuaBan.setFocusable(false);
        btnSuaBan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSuaBan.setMaximumSize(new java.awt.Dimension(100, 35));
        btnSuaBan.setMinimumSize(new java.awt.Dimension(100, 35));
        btnSuaBan.setPreferredSize(new java.awt.Dimension(100, 35));
        btnSuaBan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSuaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaBanActionPerformed(evt);
            }
        });
        jPanel3.add(btnSuaBan);

        btnXoaBan.setBackground(new java.awt.Color(149, 87, 29));
        btnXoaBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaBan.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-minus-24.png"))); // NOI18N
        btnXoaBan.setText("Xoá");
        btnXoaBan.setToolTipText("Xóa");
        btnXoaBan.setBorderPainted(false);
        btnXoaBan.setFocusable(false);
        btnXoaBan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnXoaBan.setMaximumSize(new java.awt.Dimension(100, 35));
        btnXoaBan.setMinimumSize(new java.awt.Dimension(100, 35));
        btnXoaBan.setPreferredSize(new java.awt.Dimension(100, 35));
        btnXoaBan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoaBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBanActionPerformed(evt);
            }
        });
        jPanel3.add(btnXoaBan);

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(149, 87, 29)));

        jScrollPane2.setBorder(null);

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBan.setOpaque(false);
        jScrollPane2.setViewportView(tblBan);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-24.png"))); // NOI18N
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setLabelFor(txtSearch);
        jLabel3.setText("Tìm Bàn:");
        jLabel3.setToolTipText("Tìm Bàn");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng số bàn:");

        txtTongSo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongSo.setText("...");
        txtTongSo.setMaximumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setMinimumSize(new java.awt.Dimension(100, 20));
        txtTongSo.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(247, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTongSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1024, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(pnlBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || txtBan.getText().isBlank()) {
            dialogBan.dispose();
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Bàn chưa được lưu. Bạn có muốn lưu không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if (chosen == JOptionPane.NO_OPTION) {
                dialogBan.dispose();
            } else if (chosen == JOptionPane.YES_OPTION) {
                btnSave.doClick();
                if ("performed".equalsIgnoreCase(btnSave.getActionCommand())) {
                    dialogBan.dispose();
                }
            }
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void dialogBanWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_dialogBanWindowClosing
        if ("performed".equalsIgnoreCase(btnSave.getActionCommand()) || txtBan.getText().isBlank()) {
            dialogBan.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        } else {
            int chosen = JOptionPane.showConfirmDialog(null, "Bàn chưa được lưu. Bạn có muốn lưu không?", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            switch (chosen) {
                case JOptionPane.NO_OPTION:
                    dialogBan.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    break;
                case JOptionPane.CANCEL_OPTION:
                    dialogBan.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    break;
                case JOptionPane.YES_OPTION:
                    btnSave.doClick();
                    if ("performed".equals(btnSave.getActionCommand())) {
                        dialogBan.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    }
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_dialogBanWindowClosing

    private void loadCbKhuVuc() {
        lstKhuVuc = new KhuVuc_BUS().getList();
        if (lstKhuVuc.isEmpty()) {
            return;
        }
        cbKhuVuc.removeAllItems();
        lstKhuVuc.forEach(kv -> cbKhuVuc.addItem(kv.getTenKhuVuc()));
    }

    private void btnThemBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemBanActionPerformed
        khuvuc = new KhuVuc_BUS();
        lblBan.setText("Thêm Bàn");
        txtBan.setText("");
        loadCbKhuVuc();
        if (btnSave.getActionListeners().length != 0) {
            for (ActionListener item : btnSave.getActionListeners()) {
                btnSave.removeActionListener(item);
            }
        }
        btnSave.addActionListener((ActionEvent e) -> {
            int maKV = khuvuc.getMaKhuVuc(cbKhuVuc.getSelectedItem().toString());
            if (new Ban_BUS().insert(txtBan.getText().trim(), maKV) > 0) {
                JOptionPane.showMessageDialog(null, "Thêm bàn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dialogBan.dispose();
                btnSave.setActionCommand("performed");
                loadTableBan();
            }
        });
        dialogBan.getRootPane().setDefaultButton(btnSave);
        dialogBan.setLocationRelativeTo(null);
        dialogBan.setModal(true);
        dialogBan.setVisible(true);
    }//GEN-LAST:event_btnThemBanActionPerformed

    private void btnSuaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaBanActionPerformed
        if (tblBan.getSelectedRowCount() != 1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 bàn để sửa thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        } else {
            khuvuc = new KhuVuc_BUS();
            loadCbKhuVuc();
            int index = tblBan.getSelectedRow();
            lblBan.setText("Cập nhật Bàn");
            dtm = (DefaultTableModel) tblBan.getModel();
            int maBan = Integer.parseInt(dtm.getValueAt(index, 0).toString());
            txtBan.setText(dtm.getValueAt(index, 1).toString());
            cbKhuVuc.setSelectedItem(dtm.getValueAt(index, 2).toString());

            if (btnSave.getActionListeners().length != 0) {
                for (ActionListener item : btnSave.getActionListeners()) {
                    btnSave.removeActionListener(item);
                }
            }
            btnSave.addActionListener((ActionEvent e) -> {
                int maKV = khuvuc.getMaKhuVuc(cbKhuVuc.getSelectedItem().toString());
                if (new Ban_BUS().update(maBan, txtBan.getText().trim(), maKV) > 0) {
                    JOptionPane.showMessageDialog(null, "Cập nhật bàn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dialogBan.dispose();
                    btnSave.setActionCommand("performed");
                    loadTableBan();
                }
            });
            dialogBan.getRootPane().setDefaultButton(btnSave);
            dialogBan.setLocationRelativeTo(null);
            dialogBan.setModal(true);
            dialogBan.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaBanActionPerformed

    private void btnXoaBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBanActionPerformed
        int[] rowSelected = tblBan.getSelectedRows();
        if (rowSelected.length == 0)
            JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất 1 bàn để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE, new ImageIcon(getClass().getResource("/error.png")));
        else {
            dtm = (DefaultTableModel) tblBan.getModel();
            int chosen = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá " + rowSelected.length + " bàn không?", "Thông báo", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
            if (chosen == JOptionPane.YES_OPTION) {
                int rowAffected = 0;
                for (int i = 0; i < rowSelected.length; i++) {
                    if (new Ban_BUS().delete(Integer.parseInt(dtm.getValueAt(rowSelected[i], 0).toString())) > 0) {
                        rowAffected++;
                    }
                }
                if (rowAffected == rowSelected.length) {
                    JOptionPane.showMessageDialog(null, "Xoá thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
                loadTableBan();
            }
        }
    }//GEN-LAST:event_btnXoaBanActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String strSearch = "^.*" + txtSearch.getText().toLowerCase() + ".*$";
        dtm = (DefaultTableModel) tblBan.getModel();
        dtm.setRowCount(0);
        lstBan.forEach(b -> {
            String tenKhuVuc = khuvuc.getTenKhuVuc(b.getMaKhuVuc());
            String trangThai = b.isTrangThai() == true ? "Đang phục vụ" : "Bàn trống";
            if (String.valueOf(b.getMaBan()).matches(strSearch) || b.getTenBan().toLowerCase().matches(strSearch) || tenKhuVuc.toLowerCase().matches(strSearch) || trangThai.toLowerCase().matches(strSearch)) {
                dtm.addRow(new Object[]{
                    b.getMaBan(),
                    b.getTenBan(),
                    tenKhuVuc,
                    trangThai
                });
            }
        });
    }//GEN-LAST:event_txtSearchKeyReleased

    private void loadTableBan() {
        lstBan = new Ban_BUS().getList();
        if (lstBan.isEmpty()) {
            return;
        }

        tblBan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblBan.getTableHeader().setReorderingAllowed(false);
        tblBan.setRowHeight(24);
        tblBan.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblBan.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Set DefaultTableModel & add header table
        tblBan.setModel(new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        });
        tblBan.getModel().addTableModelListener((TableModelEvent e) -> {
            txtTongSo.setText(tblBan.getRowCount() + "");
        });

        dtm = (DefaultTableModel) tblBan.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Mã Bàn");
        dtm.addColumn("Tên Bàn");
        dtm.addColumn("Khu vực");
        dtm.addColumn("Trạng thái");

        //Setting column width & turn off resizable
        tblBan.getColumnModel().getColumn(0).setMinWidth(150);
        tblBan.getColumnModel().getColumn(0).setMaxWidth(150);
        for (int i = 0; i < 4; i++) {
            tblBan.getColumnModel().getColumn(i).setResizable(false);
        }
        tblBan.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        khuvuc = new KhuVuc_BUS();
        if (khuvuc.getList().isEmpty()) {
            return;
        }
        lstBan.forEach(b -> {
            dtm.addRow(new Object[]{
                b.getMaBan(),
                b.getTenBan(),
                khuvuc.getTenKhuVuc(b.getMaKhuVuc()),
                b.isTrangThai() == true ? "Đang phục vụ" : "Bàn trống"
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    protected javax.swing.JButton btnSave;
    private javax.swing.JButton btnSuaBan;
    private javax.swing.JButton btnThemBan;
    private javax.swing.JButton btnXoaBan;
    private javax.swing.JComboBox<String> cbKhuVuc;
    private javax.swing.JDialog dialogBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBan;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JTable tblBan;
    protected javax.swing.JTextField txtBan;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel txtTongSo;
    // End of variables declaration//GEN-END:variables
}
