/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import domainmodel.SanPhamCT;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbCon = new javax.swing.JCheckBox();
        cbHet = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        lbId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jLabel1.setText("Sản phẩm chi tiết");

        btnOut.setText("OUT");
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

        cbbLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Số Lượng Tồn:");

        jLabel10.setText("Giá Nhập:");

        jLabel11.setText("Giá Bán:");

        jLabel12.setText("Mô Tả:");

        teaMoTa.setColumns(20);
        teaMoTa.setRows(5);
        jScrollPane1.setViewportView(teaMoTa);

        jLabel13.setText("Trạng Thái:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTim2)))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim2))
                .addContainerGap(32, Short.MAX_VALUE))
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

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        cbCon.setText("Còn hàng");

        cbHet.setText("Hết hàng");

        jLabel18.setText("Id:");

        lbId.setText("jLabel19");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
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
                                    .addGap(67, 67, 67)
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
                                                    .addGap(40, 40, 40)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(txtGB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                        .addComponent(txtGN, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtSLT, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(jLabel17)
                                                            .addGap(18, 18, 18))))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbCon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(cbHet, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel1)))
                                .addComponent(jLabel16))
                            .addGap(58, 58, 58))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(47, 47, 47)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(114, 114, 114)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnOut)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbbTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtSLT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(21, 21, 21)
                                        .addComponent(txtGB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel12))
                                            .addComponent(jLabel6))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(cbbNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbCon)
                            .addComponent(cbHet)
                            .addComponent(jLabel18)
                            .addComponent(lbId))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOut)
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
        SanPhamCT sp = new SanPhamCT(tenSP, loaiSP, mau, chatLieu, size, nsx, Integer.valueOf(slt), Double.valueOf(gn), Double.valueOf(gb), mota, trangThai);
        JOptionPane.showMessageDialog(this, serSPCT.add(sp));
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
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
        SanPhamCT sp = new SanPhamCT(tenSP, loaiSP, mau, chatLieu, size, nsx, Integer.valueOf(slt), Double.valueOf(gn), Double.valueOf(gb), mota, trangThai);
        JOptionPane.showMessageDialog(this, serSPCT.update(sp, id));
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String id = lbId.getText();
        JOptionPane.showMessageDialog(this, serSPCT.deleta(id));
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTim2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTim2ActionPerformed
//        String id = lbId.getText();
//        List<SanPhamChiTietViewModel> listTim = serSPCT.search(listSPCT, id);
//        loadTable(listTim);
    }//GEN-LAST:event_btnTim2ActionPerformed

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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnOut;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbId;
    private javax.swing.JTable tbSanPhamCT;
    private javax.swing.JTextArea teaMoTa;
    private javax.swing.JTextField txtGB;
    private javax.swing.JTextField txtGN;
    private javax.swing.JTextField txtSLT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
