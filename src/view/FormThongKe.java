/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
import service.impl.ThongKeImpl;
import viewmodel.ThongKeViewModle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author ADMIN
 */
public class FormThongKe extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<ThongKeViewModle> listCl = new ArrayList<>();
    private ThongKeImpl thongKe = new ThongKeImpl();
    private List<ThongKeViewModle> listSearch = new ArrayList<>();
    private String ma;
    
    public FormThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Thống kê");
        use.setModel(dtm);
        String[] fillter = {"Mã Nhân Viên", "Tên Nhân Viên", "Mã Sản Phẩm", "Tên Sản Phẩm", "Ngày Tạo", "Số lượng Bán", "Giá Nhập", "Giá Bán", "Tiền Lời"};
        dtm.setColumnIdentifiers(fillter);
        listCl = thongKe.getAll();
        showDaTaHD(listCl);
        DecimalFormat ds = new DecimalFormat("###,###,###,###");
        thanhTien(listCl);
        txtDoanhThu.setText(ds.format(thanhTien(listCl)) + " " + "VNĐ");
        txtSoLuong.setText(ds.format(soLuong(listCl)));
    }

    public void showDaTaHD(List<ThongKeViewModle> list) {
        dtm.setRowCount(0);
        for (ThongKeViewModle chatLieu : list) {
            dtm.addRow(chatLieu.toDataRow());
        }
    }

    private double thanhTien(List<ThongKeViewModle> x) {
        double tien = 0;
        for (ThongKeViewModle thke : x) {
            tien += thke.getIdCTSP().getGiaBan();
        }
        return tien;
    }

    private int soLuong(List<ThongKeViewModle> x) {
        int tien = 0;
        for (ThongKeViewModle thke : x) {
            tien += thke.getSoLuong();
        }
        return tien;
    }

    private void tongDoan() {
        DecimalFormat ds = new DecimalFormat("###,###,###,###");
        showDaTaHD(listSearch);
        txtDoanhThu.setText(ds.format(thanhTien(listSearch)) + " " + "VNĐ");
        txtSoLuong.setText(ds.format(soLuong(listSearch)));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        use = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtThang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtDoanhThu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thống Kê Doanh Thu");

        use.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(use);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tổng Số Doanh Thu : ");

        jLabel5.setText("Ngày :");

        jLabel6.setText("Tháng :");

        jLabel7.setText("Năm :");

        jButton1.setText("Tìm Kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tổng Số lượng đã bán :");

        jButton2.setText("Tất cả");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("excel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)
                        .addGap(98, 98, 98))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(38, 38, 38)
                        .addComponent(jButton3)
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(338, 338, 338))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThoat)
                        .addGap(34, 34, 34))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ngay = txtNgay.getText();
        String thang = txtThang.getText();
        String nam = txtNam.getText();
        String all = nam + "-" + thang + "-" + ngay;
        if (ngay.isEmpty() && thang.isEmpty() && nam.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mời điền ngày tháng năm muốn tìm kiếm");
        } else if (!ngay.isBlank() && thang.isEmpty() && nam.isEmpty()) {
            if (!ngay.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Ngày không hợp lệ ");
            } else if (Integer.valueOf(ngay) > 31) {
                JOptionPane.showMessageDialog(this, "Ngày dưới ngày 31");
            } else {
                listSearch = thongKe.listNgay(ngay);
                tongDoan();
            }
        } else if (!thang.isEmpty() && ngay.isEmpty() && nam.isEmpty()) {
            if (!thang.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Tháng không hơp lệ");
            } else if (Integer.valueOf(thang) > 12) {
                JOptionPane.showMessageDialog(this, "Tháng chỉ có 12 tháng");
            } else {
                listSearch = thongKe.listThang(thang);
                tongDoan();
            }
        } else if (!nam.isEmpty() && ngay.isEmpty() && thang.isEmpty()) {
            if (!nam.matches("\\d+") || nam.length() != 4) {
                JOptionPane.showMessageDialog(this, "Năm là số và gồm 4 số");
            } else {
                listSearch = thongKe.listNam(nam);
                tongDoan();
            }
        } else if (!ngay.isEmpty() && !thang.isEmpty() && nam.isEmpty()) {
            if (!ngay.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
            } else if (Integer.valueOf(ngay) > 31) {
                JOptionPane.showMessageDialog(this, "Ngày từ 1 - 31");
            } else if (!thang.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Tháng không hợp lệ");
            } else if (Integer.valueOf(thang) > 12) {
                JOptionPane.showMessageDialog(this, "Tháng chỉ có 12 tháng");
            } else {
                if (Integer.valueOf(thang) == 2 && Integer.valueOf(ngay) > 29) {
                    JOptionPane.showMessageDialog(this, "Tháng 2 không có quá ngày 29");
                } else {
                    listSearch = thongKe.listNgayThang(ngay, thang);
                    tongDoan();
                }
            }
        } else if (ngay.isEmpty() && !thang.isEmpty() && !nam.isEmpty()) {
            if (!thang.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Tháng không hợp lệ");
            } else if (Integer.valueOf(thang) > 12) {
                JOptionPane.showMessageDialog(this, "Tháng chỉ có 12 tháng");
            } else if (!nam.matches("\\d+") || nam.length() != 4) {
                JOptionPane.showMessageDialog(this, "Năm là số và gồm 4 số");
            } else {
                listSearch = thongKe.listNamThang(thang, nam);
                tongDoan();
            }
        } else if (!ngay.isEmpty() && thang.isEmpty() && !nam.isEmpty()) {
            if (!ngay.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
            } else if (Integer.valueOf(ngay) > 31) {
                JOptionPane.showMessageDialog(this, "Ngày dưới ngày 31");
            } else if (!nam.matches("\\d+") || nam.length() != 4) {
                JOptionPane.showMessageDialog(this, "Năm là số và gồm 4 số");
            } else {
                listSearch = thongKe.listNamNgay(ngay, nam);
                tongDoan();
            }
        } else {
            if (Integer.valueOf(ngay) == 29 && Integer.valueOf(thang) == 2 && Integer.valueOf(nam) % 4 != 0) {
                JOptionPane.showMessageDialog(this, "Năm " + nam + " không là năm nhuận nên không có ngày 29");
            } else {
                if (!ngay.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
                } else if (Integer.valueOf(ngay) > 31) {
                    JOptionPane.showMessageDialog(this, "Ngày từ 1 - 31");
                } else if (!thang.matches("\\d+")) {
                    JOptionPane.showMessageDialog(this, "Tháng không hợp lệ");
                } else if (Integer.valueOf(thang) > 12) {
                    JOptionPane.showMessageDialog(this, "Tháng chỉ có 12 tháng");
                } else if (!nam.matches("\\d+") || nam.length() != 4) {
                    JOptionPane.showMessageDialog(this, "Năm là số và gồm 4 số");
                } else {
                    listSearch = thongKe.listAll(all);
                    tongDoan();
                }

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        Menu fnv = new Menu();
        fnv.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        listCl = thongKe.getAll();
        showDaTaHD(listCl);
        DecimalFormat ds = new DecimalFormat("###,###,###,###");
        thanhTien(listCl);
        txtDoanhThu.setText(ds.format(thanhTien(listCl)) + " " + "VNĐ");
        txtSoLuong.setText(ds.format(soLuong(listCl)));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try {
            XSSFWorkbook xssw = new XSSFWorkbook();
            XSSFSheet xsss = xssw.createSheet("dsD");
            XSSFRow xssr = null;
            Cell cell = null;

            xssr = xsss.createRow(2);
            cell = xssr.createCell(0, CellType.STRING);
            cell.setCellValue("listThongKe");

            xssr = xsss.createRow(3);
            cell = xssr.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = xssr.createCell(1, CellType.STRING);
            cell.setCellValue("Mã NV");

            cell = xssr.createCell(2, CellType.STRING);
            cell.setCellValue("Tên NV");

            cell = xssr.createCell(3, CellType.STRING);
            cell.setCellValue("Mã SP");

            cell = xssr.createCell(4, CellType.STRING);
            cell.setCellValue("Tên SP");

            cell = xssr.createCell(5, CellType.STRING);
            cell.setCellValue("Ngày Tạo");

            cell = xssr.createCell(6, CellType.NUMERIC);
            cell.setCellValue("Số lượng bán");

            cell = xssr.createCell(7, CellType.NUMERIC);
            cell.setCellValue("Giá Nhập");

            cell = xssr.createCell(8, CellType.NUMERIC);
            cell.setCellValue("Giá Bán");
            
            cell = xssr.createCell(9, CellType.NUMERIC);
            cell.setCellValue("Tiền lời");

            for (int i = 0; i < listCl.size(); i++) {
                //Modelbook book =arr.get(i);
                xssr = xsss.createRow(4 + i);

                cell = xssr.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = xssr.createCell(1, CellType.STRING);
                cell.setCellValue(listCl.get(i).getIdHD().getIdNV().getMa());

                cell = xssr.createCell(2, CellType.STRING);
                cell.setCellValue(listCl.get(i).getIdHD().getIdNV().getTen());

                cell = xssr.createCell(4, CellType.STRING);
                cell.setCellValue(listCl.get(i).getIdCTSP().getIdSp().getMaSP());

                cell = xssr.createCell(5, CellType.STRING);
                cell.setCellValue(listCl.get(i).getIdCTSP().getIdSp().getTenSP());

                cell = xssr.createCell(3, CellType.STRING);
                cell.setCellValue(listCl.get(i).getIdHD().getNgayTao());

                cell = xssr.createCell(6, CellType.NUMERIC);
                cell.setCellValue(listCl.get(i).getSoLuong());

                cell = xssr.createCell(7, CellType.NUMERIC);
                cell.setCellValue(listCl.get(i).getIdCTSP().getGiaNhap());

                cell = xssr.createCell(8, CellType.NUMERIC);
                cell.setCellValue(listCl.get(i).getIdCTSP().getGiaBan());
                
                cell = xssr.createCell(9, CellType.NUMERIC);
                cell.setCellValue((listCl.get(i).getIdCTSP().getGiaBan()) - (listCl.get(i).getIdCTSP().getGiaNhap()));
                
            }

            File f = new File("D:\\thongKe.xlsx");
            try {
                FileOutputStream fis = new FileOutputStream(f);
                xssw.write(fis);
                fis.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "in thanh cong");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");

        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtNgay;
    private javax.swing.JLabel txtSoLuong;
    private javax.swing.JTextField txtThang;
    private javax.swing.JTable use;
    // End of variables declaration//GEN-END:variables
}
