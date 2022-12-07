/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.TraHangServisert;
import service.impl.Trahangimpl;
import viewmodel.HoaDonModel;

/**
 *
 * @author vungo
 */
public class FromTraHang extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();

    private DefaultTableModel dtmhdct = new DefaultTableModel();

    private List<HoaDonModel> listhoadon = new ArrayList<>();

    private List<HoaDonModel> listhdct = new ArrayList<>();

    private TraHangServisert ser = new Trahangimpl();

    private int row;
    private String ma;

    public FromTraHang() {
        initComponents();
    }

    /**
     * Creates new form FromTraHang
     */
    public FromTraHang(String user) {
        initComponents();
        ma = user;
        tbhthoadon.setModel(dtm);
        String[] a = {"Ma KH", "Ma HD", "Ten KH", "Ngay Tao", "Ngay Thu", "Dia Chi ", "SDT", "Trang Thai"};
        String[] b = {"Ma HD", "Ten KH", "So Luong", "Don Gia", "Tong Tien"};
        dtm.setColumnIdentifiers(a);
        tbhthoadonduoi.setModel(dtmhdct);
        dtmhdct.setColumnIdentifiers(b);
        listhoadon = ser.getall();
        showdata(listhoadon);

    }

    private void showdata(List<HoaDonModel> list) {
        dtm.setRowCount(0);
        for (HoaDonModel hoaDon1 : list) {
            dtm.addRow(hoaDon1.todata());
        }
    }

    private void showdatahdct(List<HoaDonModel> lists) {
        dtmhdct.setRowCount(0);
        for (HoaDonModel hoaDon2 : lists) {
            dtmhdct.addRow(hoaDon2.todatarow());
        }
    }

    private void fiildata(int index) {
        HoaDonModel hd1 = listhoadon.get(index);
        txtmahd.setText(hd1.getMahd());
        txttenkh.setText(hd1.getTenkh());

//        txtsltl.setText(String.valueOf(hd1.getSoluong()));
//        txttienth.setText(hd1.tongtien(hd1.getSoluong(), hd1.getDongia())+" ");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbhthoadon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btthoantra = new javax.swing.JButton();
        txttenkh = new javax.swing.JTextField();
        txtmahd = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbhthoadonduoi = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtsltl = new javax.swing.JTextField();
        lbThanhToan = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("QUAN LY TRA HANG");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa don"));

        tbhthoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma HD", "Ten NV", "Ngay Tao", "Ngay Thu", "So Luong", "Don Gia", "Tong Tien", "Trang thai"
            }
        ));
        tbhthoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhthoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbhthoadon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoan tra"));

        jLabel2.setText("Ten khách hàng");

        jLabel3.setText("Ma hóa don");

        jLabel4.setText("Đơn Giá");

        jLabel6.setText("Tong tien hoan tra");

        btthoantra.setBackground(new java.awt.Color(231, 154, 22));
        btthoantra.setText("Hoàn tra");
        btthoantra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btthoantraActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa Don CT"));

        tbhthoadonduoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ten KH", "Ma HD", "Ngay Tra", "Tong tien hoan tra"
            }
        ));
        tbhthoadonduoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbhthoadonduoiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbhthoadonduoi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setText("Số lượng trả");

        lbThanhToan.setText("------------");

        lbDonGia.setText("------------");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtmahd, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                            .addComponent(txttenkh, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                            .addComponent(txtsltl)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(lbDonGia))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btthoantra, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(36, 37, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtsltl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDonGia)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbThanhToan))
                .addGap(33, 33, 33)
                .addComponent(btthoantra)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(jLabel1)
                                .addGap(162, 162, 162)
                                .addComponent(jButton2)))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbhthoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhthoadonMouseClicked
        row = tbhthoadon.getSelectedRow();
        HoaDonModel hd = listhoadon.get(row);
        String idHD = ser.getOneIDHD(hd.getMahd());
        ser.getallbymahoadon(hd, idHD);
        listhdct.add(hd);
        showdatahdct(listhdct);


    }//GEN-LAST:event_tbhthoadonMouseClicked

    private void tbhthoadonduoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbhthoadonduoiMouseClicked

        fiildata(row);
    }//GEN-LAST:event_tbhthoadonduoiMouseClicked

    private double setText(int soLuong, double donGia) {
        return soLuong * donGia;
    }

    private double setDonGia(double donGia) {
        return donGia;
    }


    private void btthoantraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btthoantraActionPerformed

        row = tbhthoadonduoi.getSelectedRow();
        HoaDonModel hd = listhoadon.get(row);
        showdatahdct(listhdct);
        String idKH = ser.getoneIDKH(hd.getMaKH());
        String idHD = ser.getOneIDHD(hd.getMahd());
        String idCTSP = ser.getIDCTHD(idHD);
        int soluongHD = ser.getSoLuong(idHD);
        int soLuong = Integer.parseInt(txtsltl.getText());
        double tongTienTL = soLuong * hd.getDongia();
        double tienThua = hd.tongtien(hd.getSoluong(), hd.getDongia()) - tongTienTL;
        HoaDonModel hd1 = new HoaDonModel(soLuong);

        if (soLuong < 0) {
            JOptionPane.showMessageDialog(this, "So Luong phai > 0");
            txtsltl.setText("");

        } else if (soLuong > soluongHD) {
            JOptionPane.showMessageDialog(this, "Nhập sai ! vui lòng nhập lại");
            txtsltl.setText("");
            lbThanhToan.setText("");
        } else {
            lbThanhToan.setText(setText(soLuong, hd.getDongia()) + " ");
            lbDonGia.setText(setDonGia(hd.getDongia()) + " ");
            JOptionPane.showMessageDialog(this, ser.update(idKH, idHD, 
                    hd.getTenkh(), soLuong, tienThua));
            JOptionPane.showMessageDialog(this, ser.updateCTHD(idHD, soLuong));
            listhoadon.add(hd1);
            listhdct.remove(hd);
            txtmahd.setText("");
            txttenkh.setText("");
            txtsltl.setText("");
            showdatahdct(listhdct);
//            showdata(listhoadon);
        }

    }//GEN-LAST:event_btthoantraActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu login = new Menu(ma);
        login.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FromTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromTraHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btthoantra;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbThanhToan;
    private javax.swing.JTable tbhthoadon;
    private javax.swing.JTable tbhthoadonduoi;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtsltl;
    private javax.swing.JTextField txttenkh;
    // End of variables declaration//GEN-END:variables

}
