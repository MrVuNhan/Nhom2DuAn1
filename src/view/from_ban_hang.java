/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author vungo
 */
public class from_ban_hang extends javax.swing.JFrame {

    /**
     * Creates new form from_ban_hang
     */
    public from_ban_hang() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTrangthai = new javax.swing.JPanel();
        rdoChothanhtoan = new javax.swing.JRadioButton();
        rdoTatca = new javax.swing.JRadioButton();
        rdoDahuy = new javax.swing.JRadioButton();
        rdoDathanhtoan = new javax.swing.JRadioButton();
        btnTaohoadon = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTrangthaiHD = new javax.swing.JTable();
        pnlHoadon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMahoadon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNgaytaoHD = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMaNVHD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTongtienHD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTienthuaHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKhachduaHD = new javax.swing.JTextField();
        btnThanhtoanHD = new javax.swing.JButton();
        lblNgayTaoHD = new javax.swing.JLabel();
        lblMaHoaDonHD = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblkhachduaHD = new javax.swing.JLabel();
        pnlSanphamHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanphamHD = new javax.swing.JTable();
        pnlGiohangdangtao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGiohangdangtao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTrangthai.setBorder(javax.swing.BorderFactory.createTitledBorder("Trạng thái"));
        pnlTrangthai.setForeground(new java.awt.Color(204, 204, 255));

        rdoChothanhtoan.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdoChothanhtoan.setText("Chờ thanh toán");

        rdoTatca.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdoTatca.setText("Tất cả");

        rdoDahuy.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdoDahuy.setText("Đã hủy");

        rdoDathanhtoan.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        rdoDathanhtoan.setText("Đã thanh toan");

        btnTaohoadon.setBackground(new java.awt.Color(102, 255, 255));
        btnTaohoadon.setText("Tạo hóa đơn");
        btnTaohoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaohoadonActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(204, 255, 51));

        tblTrangthaiHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Mã nhân viên", "Tình trạng"
            }
        ));
        jScrollPane4.setViewportView(tblTrangthaiHD);

        javax.swing.GroupLayout pnlTrangthaiLayout = new javax.swing.GroupLayout(pnlTrangthai);
        pnlTrangthai.setLayout(pnlTrangthaiLayout);
        pnlTrangthaiLayout.setHorizontalGroup(
            pnlTrangthaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTrangthaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTrangthaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaohoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlTrangthaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdoDahuy)
                    .addComponent(rdoDathanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoTatca)
                    .addComponent(rdoChothanhtoan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTrangthaiLayout.setVerticalGroup(
            pnlTrangthaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTrangthaiLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pnlTrangthaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTrangthaiLayout.createSequentialGroup()
                        .addComponent(rdoChothanhtoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoTatca)
                        .addGap(13, 13, 13)
                        .addComponent(rdoDahuy)
                        .addGap(18, 18, 18)
                        .addComponent(rdoDathanhtoan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlTrangthaiLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTaohoadon)))
                .addContainerGap())
        );

        pnlHoadon.setBackground(new java.awt.Color(204, 255, 204));
        pnlHoadon.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Ngày tạo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel4.setText("Mã NV");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setText("Tổng tiền");

        txtTongtienHD.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setText("Khách đưa");

        txtTienthuaHD.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel7.setText("Tiền thừa");

        btnThanhtoanHD.setBackground(new java.awt.Color(255, 204, 51));
        btnThanhtoanHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThanhtoanHD.setText("Thanh toán");
        btnThanhtoanHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhtoanHDActionPerformed(evt);
            }
        });

        lblNgayTaoHD.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblNgayTaoHD.setForeground(new java.awt.Color(255, 0, 0));
        lblNgayTaoHD.setText("-");

        lblMaHoaDonHD.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblMaHoaDonHD.setForeground(new java.awt.Color(255, 0, 0));
        lblMaHoaDonHD.setText("-");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setText("-");

        lblkhachduaHD.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lblkhachduaHD.setForeground(new java.awt.Color(255, 51, 0));
        lblkhachduaHD.setText("-");

        javax.swing.GroupLayout pnlHoadonLayout = new javax.swing.GroupLayout(pnlHoadon);
        pnlHoadon.setLayout(pnlHoadonLayout);
        pnlHoadonLayout.setHorizontalGroup(
            pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoadonLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnThanhtoanHD, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlHoadonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKhachduaHD)
                    .addComponent(txtTienthuaHD)
                    .addGroup(pnlHoadonLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMahoadon))
                    .addComponent(txtTongtienHD)
                    .addGroup(pnlHoadonLayout.createSequentialGroup()
                        .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21)
                        .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgaytaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txtMaNVHD)
                            .addComponent(lblMaHoaDonHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNgayTaoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblkhachduaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlHoadonLayout.createSequentialGroup()
                        .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHoadonLayout.createSequentialGroup()
                    .addContainerGap(90, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(85, 85, 85)))
        );
        pnlHoadonLayout.setVerticalGroup(
            pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHoadonLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMahoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMaHoaDonHD)
                .addGap(2, 2, 2)
                .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgaytaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblNgayTaoHD)
                .addGap(2, 2, 2)
                .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaNVHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongtienHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtKhachduaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblkhachduaHD)
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienthuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnThanhtoanHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(pnlHoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlHoadonLayout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addComponent(jLabel21)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );

        pnlSanphamHD.setBackground(new java.awt.Color(255, 255, 102));
        pnlSanphamHD.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản phẩm"));

        tblSanphamHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Năm", "Màu", "Mô tả", "Số lượng", "Giá nhập", "Giá bán"
            }
        ));
        tblSanphamHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanphamHD);

        javax.swing.GroupLayout pnlSanphamHDLayout = new javax.swing.GroupLayout(pnlSanphamHD);
        pnlSanphamHD.setLayout(pnlSanphamHDLayout);
        pnlSanphamHDLayout.setHorizontalGroup(
            pnlSanphamHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanphamHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlSanphamHDLayout.setVerticalGroup(
            pnlSanphamHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSanphamHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pnlGiohangdangtao.setBackground(new java.awt.Color(204, 255, 255));
        pnlGiohangdangtao.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng đang tạo"));

        tblGiohangdangtao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        jScrollPane5.setViewportView(tblGiohangdangtao);

        javax.swing.GroupLayout pnlGiohangdangtaoLayout = new javax.swing.GroupLayout(pnlGiohangdangtao);
        pnlGiohangdangtao.setLayout(pnlGiohangdangtaoLayout);
        pnlGiohangdangtaoLayout.setHorizontalGroup(
            pnlGiohangdangtaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiohangdangtaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        pnlGiohangdangtaoLayout.setVerticalGroup(
            pnlGiohangdangtaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGiohangdangtaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(pnlTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlGiohangdangtao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(pnlHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlSanphamHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlGiohangdangtao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(pnlSanphamHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaohoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaohoadonActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btnTaohoadonActionPerformed

    private void btnThanhtoanHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhtoanHDActionPerformed
        
    }//GEN-LAST:event_btnThanhtoanHDActionPerformed

    private void tblSanphamHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamHDMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblSanphamHDMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(from_ban_hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(from_ban_hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(from_ban_hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(from_ban_hang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new from_ban_hang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaohoadon;
    private javax.swing.JButton btnThanhtoanHD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblMaHoaDonHD;
    private javax.swing.JLabel lblNgayTaoHD;
    private javax.swing.JLabel lblkhachduaHD;
    private javax.swing.JPanel pnlGiohangdangtao;
    private javax.swing.JPanel pnlHoadon;
    private javax.swing.JPanel pnlSanphamHD;
    private javax.swing.JPanel pnlTrangthai;
    private javax.swing.JRadioButton rdoChothanhtoan;
    private javax.swing.JRadioButton rdoDahuy;
    private javax.swing.JRadioButton rdoDathanhtoan;
    private javax.swing.JRadioButton rdoTatca;
    private javax.swing.JTable tblGiohangdangtao;
    private javax.swing.JTable tblSanphamHD;
    private javax.swing.JTable tblTrangthaiHD;
    private javax.swing.JTextField txtKhachduaHD;
    private javax.swing.JTextField txtMaNVHD;
    private javax.swing.JTextField txtMahoadon;
    private javax.swing.JTextField txtNgaytaoHD;
    private javax.swing.JTextField txtTienthuaHD;
    private javax.swing.JTextField txtTongtienHD;
    // End of variables declaration//GEN-END:variables
}
