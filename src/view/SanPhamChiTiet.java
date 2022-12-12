/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.SanPhamCT;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.ChatLieuService;
import service.LoaiSPService;
import service.MauSacService;
import service.NhaCungCapService;
import service.SanPhamCTService;
import service.SanPhamSer;
import service.SizeService;
import service.impl.ChatLieuIml;
import service.impl.LoaiSPImpl;
import service.impl.MauSacimpl;
import service.impl.NhaCungCapIMPL;
import service.impl.SanPhamCTServiceimpl;
import service.impl.SanPhamSerimpl;
import service.impl.SizeServiceimpl;
import viewmodel.ChatlieuViewModel;
import viewmodel.LoaiSPViewmodel;
import viewmodel.MauSacViewmodel;
import viewmodel.NhaCungCapviewmodel;
import viewmodel.SanPhamChiTietViewModel;
import viewmodel.SanPhamViewModel;
import viewmodel.SizeViewModel;

/**
 *
 * @author FPTSHOP
 */
public class SanPhamChiTiet extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<SanPhamChiTietViewModel> listSPCT = new ArrayList<>();
    private SanPhamCTService serSPCT = new SanPhamCTServiceimpl();

    //Sản phẩm
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private List<SanPhamViewModel> listCbbSP = new ArrayList<>();
    private SanPhamSer serSp = new SanPhamSerimpl();
    //Loại sản phẩm
    private DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel();
    private List<LoaiSPViewmodel> listCbbLoai = new ArrayList<>();
    private LoaiSPService serLoai = new LoaiSPImpl();
    //Màu sắc
    private DefaultComboBoxModel dcbm3 = new DefaultComboBoxModel();
    private List<MauSacViewmodel> listCbbMs = new ArrayList<>();
    private MauSacService serMs = new MauSacimpl();

    //Chất liệu
    private DefaultComboBoxModel dcbm4 = new DefaultComboBoxModel();
    private List<ChatlieuViewModel> listCbbCl = new ArrayList<>();
    private ChatLieuService serCl = new ChatLieuIml();
    //Size
    private DefaultComboBoxModel dcbm5 = new DefaultComboBoxModel();
    private List<SizeViewModel> listCbbSz = new ArrayList<>();
    private SizeService serSz = new SizeServiceimpl();
    //Nhà cung cấp
    private DefaultComboBoxModel dcbm6 = new DefaultComboBoxModel();
    private List<NhaCungCapviewmodel> listCbbNcc = new ArrayList<>();
    private NhaCungCapService serNcc = new NhaCungCapIMPL();

    /**
     * Creates new form NewJFrame
     */
    public SanPhamChiTiet() {
        initComponents();
        setLocationRelativeTo(null);
        tbSanPhamCT.setModel(dtm);
        String[] e = {"Id", "Tên SP", "Loại", "Màu", "Chất", "Size", "Nhà cc", "SLT", "Giá N", "Giá B", "Mô tả", "Trạng thái"};
        dtm.setColumnIdentifiers(e);

        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);

        loadCacCbb();
    }

    public void loadCacCbb() {
        //Sản phẩm
        listCbbSP = serSp.getAll();
        loadCbbSp(listCbbSP);
        //LoaiSP
        listCbbLoai = serLoai.getAll();
        loadCbbLoai(listCbbLoai);
        //Màu sắc
        listCbbMs = serMs.getAll();
        loadCbbMs(listCbbMs);
        //Chất liệu
        listCbbCl = serCl.getAll();
        loadCbbCl(listCbbCl);
        //Size
        listCbbSz = serSz.getAll();
        loadCbbSz(listCbbSz);
        //Nhasx
        listCbbNcc = serNcc.getAll();
        loadCbbNcc(listCbbNcc);
    }

    public void loadCbbSp(List<SanPhamViewModel> listSp) {
        cbbTenSp.setModel(dcbm1);

        listCbbLoai = serLoai.getAll();
        for (SanPhamViewModel x : listSp) {
            dcbm1.addElement(x.getTenSP());
        }
    }

    public void loadCbbLoai(List<LoaiSPViewmodel> listLoai) {
        cbbLoaiSp.setModel(dcbm2);
        listCbbLoai = serLoai.getAll();
        for (LoaiSPViewmodel x : listLoai) {
            dcbm2.addElement(x.getTenLoai());
        }
    }

    public void loadCbbMs(List<MauSacViewmodel> listMs) {
        cbbMauSac.setModel(dcbm3);
        listCbbLoai = serLoai.getAll();
        for (MauSacViewmodel x : listMs) {
            dcbm3.addElement(x.getTenMS());
        }
    }

    public void loadCbbCl(List<ChatlieuViewModel> listCl) {
        cbbChatLieu.setModel(dcbm4);
        listCbbLoai = serLoai.getAll();
        for (ChatlieuViewModel x : listCl) {
            dcbm4.addElement(x.getTen());
        }
    }

    public void loadCbbSz(List<SizeViewModel> listSz) {
        cbbSize.setModel(dcbm5);
        listCbbLoai = serLoai.getAll();
        for (SizeViewModel x : listSz) {
            dcbm5.addElement(x.getTen());
        }
    }

    public void loadCbbNcc(List<NhaCungCapviewmodel> listLoai) {
        cbbNhaSX.setModel(dcbm6);
        listCbbNcc = serNcc.getAll();
        for (NhaCungCapviewmodel x : listLoai) {
            dcbm6.addElement(x.getTenNhaCC());
        }

    }

    public void loadTable(List<SanPhamChiTietViewModel> list) {
        dtm.setRowCount(0);
        for (SanPhamChiTietViewModel x : listSPCT) {
            dtm.addRow(x.toDataRow());
        }
    }

    public void fillData(int index) {
        SanPhamChiTietViewModel sp = listSPCT.get(index);
        cbbTenSp.setSelectedItem(sp.getTenSP());
        cbbLoaiSp.setSelectedItem(sp.getLoaiSP());
        cbbMauSac.setSelectedItem(sp.getMauSac());
        cbbChatLieu.setSelectedItem(sp.getChatLieu());
        cbbSize.setSelectedItem(sp.getSize());
        cbbNhaSX.setSelectedItem(sp.getNsx());
        lbId.setText(sp.getId());
        txtSLT.setText(String.valueOf(sp.getSlt()));
        txtGN.setText(String.valueOf(sp.getGiaNhap()));
        txtGB.setText(String.valueOf(sp.getGiaBan()));
        teaMoTa.setText(sp.getMoTa());
        if (sp.getSlt() == 0) {
            cbCon.setSelected(false);
            cbHet.setSelected(true);
        } else {
            cbCon.setSelected(true);
            cbHet.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnOut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbbTenSp = new javax.swing.JComboBox<>();
        cbbLoaiSp = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbNhaSX = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teaMoTa = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        txtSLT = new javax.swing.JTextField();
        txtGN = new javax.swing.JTextField();
        txtGB = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTim2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPhamCT = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        cbCon = new javax.swing.JCheckBox();
        cbHet = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();
        btnSP = new javax.swing.JButton();
        btnLSP = new javax.swing.JButton();
        btnMS = new javax.swing.JButton();
        btnCL = new javax.swing.JButton();
        btnSz = new javax.swing.JButton();
        btnNSX = new javax.swing.JButton();
        btnLocSp = new javax.swing.JButton();
        btnLocLSP = new javax.swing.JButton();
        btnLocMs = new javax.swing.JButton();
        btnLocCL = new javax.swing.JButton();
        btnLocSize = new javax.swing.JButton();
        btnLocNss = new javax.swing.JButton();
        btnTatCa = new javax.swing.JButton();
        lbSLT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Sản phẩm chi tiết");

        btnOut.setText("Thoát");
        btnOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOutActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên SP:");

        jLabel2.setText("Loại SP:");

        jLabel5.setText("Màu Sắc:");

        jLabel6.setText("Chất Liệu:");

        jLabel7.setText("Size:");

        jLabel8.setText("Nhà SX:");

        cbbTenSp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTenSpMouseClicked(evt);
            }
        });

        cbbLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Số Lượng Tồn:");

        jLabel10.setText("Giá Nhập:");

        jLabel11.setText("Giá Bán:");

        jLabel12.setText("Mô Tả:");

        teaMoTa.setColumns(20);
        teaMoTa.setRows(5);
        jScrollPane1.setViewportView(teaMoTa);

        jLabel13.setText("Trạng Thái:");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tìm kiếm theo thông tin:");

        jLabel15.setText("Tìm Theo Tên:");

        btnTim2.setText("Tìm");
        btnTim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTim2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTim2))
                            .addComponent(jLabel15))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Danh Sách SPCT:");

        tbSanPhamCT.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSanPhamCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSanPhamCT);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Các chức năng:");

        cbCon.setText("Còn hàng");

        cbHet.setText("Hết hàng");

        jLabel18.setText("Id:");

        lbId.setText("jLabel19");

        btnSP.setText("+");
        btnSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPActionPerformed(evt);
            }
        });

        btnLSP.setText("+");
        btnLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLSPActionPerformed(evt);
            }
        });

        btnMS.setText("+");
        btnMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMSActionPerformed(evt);
            }
        });

        btnCL.setText("+");
        btnCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLActionPerformed(evt);
            }
        });

        btnSz.setText("+");
        btnSz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSzActionPerformed(evt);
            }
        });

        btnNSX.setText("+");
        btnNSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNSXActionPerformed(evt);
            }
        });

        btnLocSp.setText("Lọc");
        btnLocSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSpActionPerformed(evt);
            }
        });

        btnLocLSP.setText("Lọc");
        btnLocLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocLSPActionPerformed(evt);
            }
        });

        btnLocMs.setText("Lọc");
        btnLocMs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocMsActionPerformed(evt);
            }
        });

        btnLocCL.setText("Lọc");
        btnLocCL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocCLActionPerformed(evt);
            }
        });

        btnLocSize.setText("Lọc");
        btnLocSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocSizeActionPerformed(evt);
            }
        });

        btnLocNss.setText("Lọc");
        btnLocNss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocNssActionPerformed(evt);
            }
        });

        btnTatCa.setText("Tất cả");
        btnTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTatCaActionPerformed(evt);
            }
        });

        jButton1.setText("Excel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbbLoaiSp, 0, 155, Short.MAX_VALUE)
                                        .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbNhaSX, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbTenSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnSz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnMS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNSX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLocSp, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLocLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnLocMs, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnLocCL, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnLocSize, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(btnLocNss, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(cbCon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbHet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(220, 220, 220))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(txtGB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                    .addComponent(txtGN, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtSLT, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbSLT, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(jLabel17)
                                                        .addGap(25, 25, 25))))))
                                    .addComponent(jLabel1))))
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnTatCa))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOut)
                        .addGap(0, 23, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtSLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSP)
                            .addComponent(btnLocSp)
                            .addComponent(lbSLT)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(btnMS)
                                    .addComponent(btnLocMs)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(btnLSP)
                                        .addComponent(btnLocLSP)))
                                .addGap(21, 21, 21)
                                .addComponent(txtGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(btnCL)
                                        .addComponent(btnLocCL))
                                    .addComponent(jLabel6))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSz)
                                    .addComponent(btnLocSize))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbbNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnNSX)
                                    .addComponent(btnLocNss)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbCon)
                            .addComponent(cbHet)
                            .addComponent(jLabel18)
                            .addComponent(lbId))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTatCa, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOut)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOutActionPerformed
        Menu me = new Menu();
        this.dispose();
        me.setVisible(true);

    }//GEN-LAST:event_btnOutActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        cbbTenSp.setSelectedIndex(0);
        cbbLoaiSp.setSelectedIndex(0);
        cbbMauSac.setSelectedIndex(0);
        cbbChatLieu.setSelectedIndex(0);
        cbbSize.setSelectedIndex(0);
        cbbNhaSX.setSelectedIndex(0);
        txtSLT.setText("");
        txtGN.setText("");
        txtGB.setText("");
        teaMoTa.setText("");
        cbCon.setSelected(false);
        cbHet.setSelected(false);
        txtTimKiem.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void tbSanPhamCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamCTMouseClicked
        int row = tbSanPhamCT.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tbSanPhamCTMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String tenSP = (String) cbbTenSp.getSelectedItem();
        String loaiSP = (String) cbbLoaiSp.getSelectedItem();
        String mau = (String) cbbMauSac.getSelectedItem();
        String chatLieu = (String) cbbChatLieu.getSelectedItem();
        String size = (String) cbbSize.getSelectedItem();
        String nsx = (String) cbbNhaSX.getSelectedItem();
        String slt = txtSLT.getText();
        String gn = txtGN.getText();
        String gb = txtGB.getText();
        String mota = teaMoTa.getText();
        int trangThai = 0;
        if (cbCon.isSelected() == true) {
            trangThai += 0;
        } else {
            trangThai += 1;
        }
        if (slt.isEmpty()) {
            txtSLT.setBackground(Color.red);
        } else if (!slt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số lượng tồn phải là số");
        } else {
            txtSLT.setBackground(Color.white);
        }

        if (gn.isEmpty()) {
            txtGN.setBackground(Color.red);
        } else if (!gn.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Giá nhập phải là số");
        } else {
            txtGN.setBackground(Color.white);
        }
        if (gb.isEmpty()) {
            txtGB.setBackground(Color.red);
        } else if (!gb.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Giá bán phải là số");
        } else {
            txtGB.setBackground(Color.white);
        }
        if (mota.isEmpty()) {
            teaMoTa.setBackground(Color.red);
        } else {
            SanPhamCT sp = new SanPhamCT(tenSP, loaiSP, mau, chatLieu, size, nsx, Integer.valueOf(slt), Double.valueOf(gn), Double.valueOf(gb), mota, trangThai);
            JOptionPane.showMessageDialog(this, serSPCT.add(sp));
            listSPCT = serSPCT.getAll();
            loadTable(listSPCT);
            teaMoTa.setBackground(Color.white);
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id = lbId.getText();
        String tenSP = (String) cbbTenSp.getSelectedItem();
        String loaiSP = (String) cbbLoaiSp.getSelectedItem();
        String mau = (String) cbbMauSac.getSelectedItem();
        String chatLieu = (String) cbbChatLieu.getSelectedItem();
        String size = (String) cbbSize.getSelectedItem();
        String nsx = (String) cbbNhaSX.getSelectedItem();
        String slt = txtSLT.getText();
        String gn = txtGN.getText();
        String gb = txtGB.getText();
        String mota = teaMoTa.getText();
        int trangThai = 0;
        if (cbCon.isSelected() == true) {
            trangThai += 0;
        } else {
            trangThai += 1;
        }
        if (slt.isEmpty()) {
            txtSLT.setBackground(Color.red);
        } else {
            txtSLT.setBackground(Color.white);
        }
        if (gn.isEmpty()) {
            txtGN.setBackground(Color.red);
        } else {
            txtGN.setBackground(Color.white);
        }
        if (gb.isEmpty()) {
            txtGB.setBackground(Color.red);
        } else {
            txtGB.setBackground(Color.white);
        }
        if (mota.isEmpty()) {
            teaMoTa.setBackground(Color.red);
        } else {
            SanPhamCT sp = new SanPhamCT(tenSP, loaiSP, mau, chatLieu, size, nsx, Integer.valueOf(slt), Double.valueOf(gn), Double.valueOf(gb), mota, trangThai);
            JOptionPane.showMessageDialog(this, serSPCT.update(sp, id));
            listSPCT = serSPCT.getAll();
            loadTable(listSPCT);
            teaMoTa.setBackground(Color.white);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String id = lbId.getText();
        JOptionPane.showMessageDialog(this, serSPCT.deleta(id));
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTim2ActionPerformed
        String ten = txtTimKiem.getText();
        if (ten.isEmpty()) {
            txtTimKiem.setBackground(Color.red);
        } else {
            txtTimKiem.setBackground(Color.white);
            listSPCT = serSPCT.searchTenSP(ten);
            loadTable(listSPCT);
        }

    }//GEN-LAST:event_btnTim2ActionPerformed

    private void cbbTenSpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTenSpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTenSpMouseClicked

    private void btnMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMSActionPerformed
        MauSac ms = new MauSac();
        this.dispose();
        ms.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnMSActionPerformed

    private void btnSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPActionPerformed
        SanPham sp = new SanPham();
        this.dispose();
        sp.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnSPActionPerformed

    private void btnLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLSPActionPerformed
        LoaiSanPham lsp = new LoaiSanPham();
        this.dispose();
        lsp.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnLSPActionPerformed

    private void btnCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLActionPerformed
        ChatLieu cl = new ChatLieu();
        this.dispose();
        cl.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnCLActionPerformed

    private void btnSzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSzActionPerformed
        SizeView sz = new SizeView();
        this.dispose();
        sz.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnSzActionPerformed

    private void btnNSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNSXActionPerformed
        NhaCungCap ncc = new NhaCungCap();
        this.dispose();
        ncc.setVisible(true);
        SanPhamChiTiet spct = new SanPhamChiTiet();
        spct.setVisible(false);
    }//GEN-LAST:event_btnNSXActionPerformed

    private void btnLocSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSpActionPerformed
        String ten = cbbTenSp.getSelectedItem().toString();
        listSPCT = serSPCT.searchTenSP(ten);
        //listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocSpActionPerformed

    private void btnLocLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocLSPActionPerformed
        String ten = cbbLoaiSp.getSelectedItem().toString();
        listSPCT = serSPCT.searchLoaiSP(ten);
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocLSPActionPerformed

    private void btnLocMsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocMsActionPerformed
        String ten = cbbMauSac.getSelectedItem().toString();
        listSPCT = serSPCT.searchMau(ten);
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocMsActionPerformed

    private void btnLocCLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocCLActionPerformed
        String ten = cbbChatLieu.getSelectedItem().toString();
        listSPCT = serSPCT.searchCL(ten);
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocCLActionPerformed

    private void btnLocSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocSizeActionPerformed
        String ten = cbbSize.getSelectedItem().toString();
        listSPCT = serSPCT.searchSz(ten);
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocSizeActionPerformed

    private void btnLocNssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocNssActionPerformed
        String ten = cbbNhaSX.getSelectedItem().toString();
        listSPCT = serSPCT.searchNsx(ten);
        loadTable(listSPCT);
    }//GEN-LAST:event_btnLocNssActionPerformed

    private void btnTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTatCaActionPerformed
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_btnTatCaActionPerformed

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
            java.util.logging.Logger.getLogger(SanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCL;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLSP;
    private javax.swing.JButton btnLocCL;
    private javax.swing.JButton btnLocLSP;
    private javax.swing.JButton btnLocMs;
    private javax.swing.JButton btnLocNss;
    private javax.swing.JButton btnLocSize;
    private javax.swing.JButton btnLocSp;
    private javax.swing.JButton btnMS;
    private javax.swing.JButton btnNSX;
    private javax.swing.JButton btnOut;
    private javax.swing.JButton btnSP;
    private javax.swing.JButton btnSz;
    private javax.swing.JButton btnTatCa;
    private javax.swing.JButton btnTim2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbCon;
    private javax.swing.JCheckBox cbHet;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbLoaiSp;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNhaSX;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbTenSp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbSLT;
    private javax.swing.JTable tbSanPhamCT;
    private javax.swing.JTextArea teaMoTa;
    private javax.swing.JTextField txtGB;
    private javax.swing.JTextField txtGN;
    private javax.swing.JTextField txtSLT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
