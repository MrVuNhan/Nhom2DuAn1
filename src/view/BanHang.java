/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChatLieuService;
import service.HoaDonBHSer;
import service.HoaDonCTBHSer;
import service.KhachHangService;
import service.LoaiSPService;
import service.MauSacService;
import service.NhaCungCapService;
import service.SanPhamCTService;
import service.SizeService;
import service.impl.ChatLieuIml;
import service.impl.HoaDonBHCTSerimpl;
import service.impl.HoaDonBHSerimpl;
import service.impl.KhachHangServiceimpl;
import service.impl.LoaiSPImpl;
import service.impl.MauSacimpl;
import service.impl.NhaCungCapIMPL;
import service.impl.SanPhamCTServiceimpl;
import service.impl.SizeServiceimpl;
import viewmodel.HoaDonBHViewModel;
import viewmodel.HoaDonCTBHViewModel;
import viewmodel.KhachHangViewModel;
import viewmodel.SanPhamChiTietViewModel;

/**
 *
 * @author FPTSHOP
 */
public class BanHang extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<SanPhamChiTietViewModel> listSPCT = new ArrayList<>();
    private List<SanPhamChiTietViewModel> listDSMH = new ArrayList<>();
    private SanPhamCTService serSPCT = new SanPhamCTServiceimpl();

    private DefaultTableModel dtm1 = new DefaultTableModel();
    private List<HoaDonBHViewModel> lisHDBH = new ArrayList<>();

    private HoaDonBHSer serHDBH = new HoaDonBHSerimpl();

    // cbb khach hang
    private DefaultTableModel dtm2 = new DefaultTableModel();
    private List<HoaDonCTBHViewModel> lisHDCTBH = new ArrayList<>();
    private HoaDonCTBHSer serHDCTBH = new HoaDonBHCTSerimpl();
    private String ma;
    private DefaultComboBoxModel cbb = new DefaultComboBoxModel();

    private KhachHangService serKH = new KhachHangServiceimpl();
    private List<KhachHangViewModel> listKH = new ArrayList<>();
    private List<String> listCBBKH = new ArrayList<>();

    // lọc 
    //Sản phẩm
    private DefaultComboBoxModel dcbm1 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbSP = new ArrayList<>();
    private HoaDonCTBHSer serSp = new HoaDonBHCTSerimpl();

    //Loại sản phẩm
    private DefaultComboBoxModel dcbm2 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbLoai = new ArrayList<>();
    private LoaiSPService serLoai = new LoaiSPImpl();
    //Màu sắc
    private DefaultComboBoxModel dcbm3 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbMs = new ArrayList<>();
    private MauSacService serMs = new MauSacimpl();

    //Chất liệu
    private DefaultComboBoxModel dcbm4 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbCl = new ArrayList<>();
    private ChatLieuService serCl = new ChatLieuIml();
    //Size
    private DefaultComboBoxModel dcbm5 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbSz = new ArrayList<>();
    private SizeService serSz = new SizeServiceimpl();
    //Nhà cung cấp
    private DefaultComboBoxModel dcbm6 = new DefaultComboBoxModel();
    private List<SanPhamChiTietViewModel> listCbbNcc = new ArrayList<>();
    private NhaCungCapService serNcc = new NhaCungCapIMPL();

    /**
     * Creates new form BanHang
     */
    public BanHang() {
        initComponents();
        setLocationRelativeTo(null);
        //Tb sản phẩm

    }

    public BanHang(String maNV) {
        initComponents();
        ma = maNV;
        tbSanPham.setModel(dtm);
        String[] a = {"Tên SP", "Loại", "Màu", "Chất", "Size", "Nhà cc", "SLT", "Giá B", "Mô tả", "Trạng thái"};
        dtm.setColumnIdentifiers(a);
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);

        //Tb hóa đơn
        tbHoaDon.setModel(dtm1);
        String[] b = {"Mã HD", "Tên NV", "Ngày Tạo", "Trạng Thái"};
        dtm1.setColumnIdentifiers(b);
        lisHDBH = serHDBH.getAll();
        loadTable1(lisHDBH);

        //Tb hóa đơn ct
        tbMuaHang.setModel(dtm2);
        String[] c = {"Tên SP", "Loại SP", "Màu Sắc", "Chất Liệu", "Size", "NSX", "Số Lượng", "Đơn Giá"};
        dtm2.setColumnIdentifiers(c);

        cbbKH.setModel(cbb);
        loadCBB();

        loadCacCbb();

    }

    private void loadCBB() {
        listKH = serKH.getAll();
        for (KhachHangViewModel kh : listKH) {
            listCBBKH.add(kh.getTen());
        }
        cbb.addAll(listCBBKH);
        cbb.setSelectedItem("My");

    }

    public void loclsp(ArrayList<String> listloclsp) {
        cbbTenSp.removeAllItems();
        cbbTenSp.addItem("tất cả");
        for (String lsp : listloclsp) {
            cbbTenSp.addItem(lsp);
        }
    }

    private void loadCacCbb() {
        //Sản phẩm
        listCbbSP = serSPCT.getAll();
        loadCbbSp(listCbbSP);
        //LoaiSP
        listCbbLoai = serSPCT.getAll();
        loadCbbLoai(listCbbLoai);
        //Màu sắc
        listCbbMs = serSPCT.getAll();
        loadCbbMs(listCbbMs);
        //Chất liệu
        listCbbCl = serSPCT.getAll();
        loadCbbCl(listCbbCl);
        //Size
        listCbbSz = serSPCT.getAll();
        loadCbbSz(listCbbSz);
        //Nhasx
        listCbbNcc = serSPCT.getAll();
        loadCbbNcc(listCbbNcc);
    }

    public void loadCbbSp(List<SanPhamChiTietViewModel> listSp) {
        cbbTenSp.setModel(dcbm1);
        listCbbLoai = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listSp) {
            dcbm1.addElement(x.getTenSP());
        }
    }

    public void loadCbbLoai(List<SanPhamChiTietViewModel> listLoai) {
        cbbLoaiSp.setModel(dcbm2);
        listCbbLoai = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listLoai) {
            dcbm2.addElement(x.getLoaiSP());
        }
    }

    public void loadCbbMs(List<SanPhamChiTietViewModel> listMs) {
        cbbMauSac.setModel(dcbm3);
        listCbbLoai = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listMs) {
            dcbm3.addElement(x.getMauSac());
        }
    }

    public void loadCbbCl(List<SanPhamChiTietViewModel> listCl) {
        cbbChatLieu.setModel(dcbm4);
        listCbbLoai = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listCl) {
            dcbm4.addElement(x.getChatLieu());
        }
    }

    public void loadCbbSz(List<SanPhamChiTietViewModel> listSz) {
        cbbsize.setModel(dcbm5);
        listCbbLoai = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listSz) {
            dcbm5.addElement(x.getSize());
        }
    }

    public void loadCbbNcc(List<SanPhamChiTietViewModel> listLoai) {
        cbbNhaSX.setModel(dcbm6);
        listCbbNcc = serSPCT.getAll();
        for (SanPhamChiTietViewModel x : listLoai) {
            dcbm6.addElement(x.getNsx());
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        radioDa = new javax.swing.JRadioButton();
        radioChua = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtMa = new javax.swing.JTextField();
        txtNgTao = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtKhachDua = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JLabel();
        lbTienThua = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttk = new javax.swing.JTextField();
        btttk = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bttthemkhachhang = new javax.swing.JButton();
        cbbKH = new javax.swing.JComboBox<>();
        lbCheck = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSanPham = new javax.swing.JTable();
        cbbTenSp = new javax.swing.JComboBox<>();
        cbbLoaiSp = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        cbbTatCa = new javax.swing.JButton();
        cbbsize = new javax.swing.JComboBox<>();
        cbbNhaSX = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMuaHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Quầy Thanh Toán");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Hóa Đơn");

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioDa);
        radioDa.setText("Đã thanh toán");
        radioDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioChua);
        radioChua.setText("Chưa thanh toán");
        radioChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioChuaActionPerformed(evt);
            }
        });

        jLabel4.setText("Danh sách hóa đơn:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Tất Cả");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioDa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(radioChua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTaoHoaDon))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioChua)
                    .addComponent(radioDa)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(jRadioButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("Mã HD:");

        jLabel8.setText("Ngày Tạo:");

        jLabel9.setText("Tên NV:");

        jLabel10.setText("Tên KH:");

        jLabel11.setText("Thành Tiền:");

        jLabel12.setText("Tiền Khách Đưa:");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel14.setText("Trả Lại:");

        txtThanhTien.setText("----------------------------------");

        lbTienThua.setText("-----------------------------------");

        jLabel15.setText("Tìm Kiếm Theo Tên SP");

        btttk.setText("Tìm Kiếm");
        btttk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btttkActionPerformed(evt);
            }
        });

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bttthemkhachhang.setText("Thêm Khách Hàng");
        bttthemkhachhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttthemkhachhangActionPerformed(evt);
            }
        });

        cbbKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbCheck.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCheck.setForeground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bttthemkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCheck)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNgTao)
                                        .addComponent(txtMa)
                                        .addComponent(txtTenNV)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtKhachDua)
                                        .addComponent(cbbKH, 0, 182, Short.MAX_VALUE)))))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btttk)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttthemkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btttk)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtThanhTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(lbCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(lbTienThua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Sản phẩm");

        jLabel5.setText("Danh sách sản phẩm:");

        tbSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSanPham.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tbSanPhamComponentAdded(evt);
            }
        });
        tbSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSanPham);

        cbbTenSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item", "Item 2", "Item 3", "Item 4" }));
        cbbTenSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTenSpActionPerformed(evt);
            }
        });

        cbbLoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSpActionPerformed(evt);
            }
        });

        cbbMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauSacActionPerformed(evt);
            }
        });

        cbbChatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChatLieuActionPerformed(evt);
            }
        });

        cbbTatCa.setText("Tất Cả SP");
        cbbTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTatCaActionPerformed(evt);
            }
        });

        cbbsize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbsizeActionPerformed(evt);
            }
        });

        cbbNhaSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhaSX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhaSXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbbTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(cbbTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cbbTatCa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbTenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbNhaSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Danh sách mua hàng");

        tbMuaHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMuaHangMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbMuaHangMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(tbMuaHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbSanPhamComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tbSanPhamComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbSanPhamComponentAdded

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = tbHoaDon.getSelectedRow();
        HoaDonBHViewModel hd = lisHDBH.get(row);
        if (hd.getTrangThai() == 1) {
            JOptionPane.showMessageDialog(this, "Đã Thanh Toán");
        } else {
            fillData(row);
        }
    }//GEN-LAST:event_tbHoaDonMouseClicked
    private void checkLB() {
        lbCheck.setText("Không được để trông");
    }

    private void checkLB1() {
        lbCheck.setText("Không đúng định dạng");
    }

    private void checkLB2() {
        lbCheck.setText("Không đủ tiền để thanh toán");
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int row = tbMuaHang.getSelectedRow();
//        fillData1(row);
//        lisHDBH = serHDBH.getAll();
        int row1 = tbHoaDon.getSelectedRow();
        SanPhamChiTietViewModel sp = listDSMH.get(row);
        HoaDonBHViewModel hds = lisHDBH.get(row1);
        SanPhamChiTietViewModel sp1 = listSPCT.get(row);
//        double tienKD = Double.valueOf(txtKhachDua.getText());
        String tienKD = txtKhachDua.getText();
        if (tienKD.isEmpty()) {
            checkLB();
        } else if (!tienKD.matches("[0-9]+")) {
            checkLB1();
        } else if (Double.valueOf(tienKD) < sp.getSlt() * sp.getGiaBan()) {
            checkLB2();
        } else {
            double tt = Double.valueOf(tienKD) - sp.getSlt() * sp.getGiaBan();
//            String tienThua = String.valueOf(tt);
//            lbTienThua.setText(tienThua);
//            double tienThua = Double.valueOf(tt);
            lbTienThua.setText(String.valueOf(tt));
            System.out.println(hds.getMa());
            String idHD = serHDBH.getIDHD(hds.getMa());
            String idKH = serHDBH.getIDKH((String) cbbKH.getSelectedItem());
            KhachHangViewModel kh = serKH.getOneKH(idKH);
            System.out.println(idHD);
            JOptionPane.showMessageDialog(this, serHDBH.addCTHD(idHD, sp.getId(),
                    sp.getSlt(), sp.getGiaBan()));
            serHDBH.updateCTSP(sp.getId(), sp.getSlt());
            if (serHDBH.updateTTHD(idHD, idKH, kh.getTen(), kh.getDiaChi(), kh.getSdt())) {
                System.out.println("cn tk");
            } else {
                System.out.println("cn khong tk");
            }
            loadTableDSMH(listDSMH);
            lisHDBH = serHDBH.getAll();
            loadTable1(lisHDBH);
            txtKhachDua.setText("");
            txtNgTao.setText("");
            txtTenNV.setText("");
            txtMa.setText("");
           

        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        String idNV = serHDBH.getIDNV(ma);
        System.out.println(idNV);
        String maHD = null;
        for (int i = lisHDBH.size() + 1; i < lisHDBH.size() + 2; i++) {
            maHD = "HD" + i;
        }
        JOptionPane.showMessageDialog(this, serHDBH.add(maHD, idNV));
        lisHDBH = serHDBH.getAll();
        loadTable1(lisHDBH);
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tbSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamMouseClicked
        int row = tbSanPham.getSelectedRow();
        SanPhamChiTietViewModel sp = listSPCT.get(row);
        int SoLuong = Integer.valueOf(JOptionPane.showInputDialog("Nhập số lượng"));
        if (SoLuong > sp.getSlt()) {
            JOptionPane.showMessageDialog(this, "Nhập lại số lượng");

        } else if (SoLuong < 0) {
            JOptionPane.showMessageDialog(this, "Nhập lại số lượng");
        } else {
            int SLT = sp.getSlt() - SoLuong;
            SanPhamChiTietViewModel sp1 = new SanPhamChiTietViewModel(sp.getId(), sp.getTenSP(),
                    sp.getLoaiSP(), sp.getMauSac(), sp.getChatLieu(), sp.getSize(),
                    sp.getNsx(), SLT, sp.getGiaNhap(), sp.getGiaBan(),
                    sp.getMoTa(), sp.getTrangThai());
            SanPhamChiTietViewModel sp2 = new SanPhamChiTietViewModel(sp.getId(), sp.getTenSP(),
                    sp.getLoaiSP(), sp.getMauSac(), sp.getChatLieu(), sp.getSize(),
                    sp.getNsx(), SoLuong, sp.getGiaNhap(), sp.getGiaBan(),
                    sp.getMoTa(), sp.getTrangThai());
            listSPCT.add(sp1);
            listSPCT.remove(sp);
            loadTable(listSPCT);
            serSPCT.getOneSP(sp, SoLuong, sp.getId());
            listDSMH.add(sp2);
            loadTableDSMH(listDSMH);
        }

    }//GEN-LAST:event_tbSanPhamMouseClicked
  private void loadTT(List<HoaDonBHViewModel> lists){
      
  }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Menu login = new Menu(ma);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bttthemkhachhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttthemkhachhangActionPerformed
        KhachHang login = new KhachHang(ma);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_bttthemkhachhangActionPerformed

    private void cbbTenSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTenSpActionPerformed

        String tenSP = (String) cbbTenSp.getSelectedItem();
        listSPCT = serSPCT.searchTenSP(tenSP);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbTenSpActionPerformed

    private void cbbLoaiSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSpActionPerformed
        String loaiSP = (String) cbbLoaiSp.getSelectedItem();
        listSPCT = serSPCT.searchLoaiSP(loaiSP);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbLoaiSpActionPerformed

    private void cbbMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauSacActionPerformed
        String mau = (String) cbbMauSac.getSelectedItem();
        listSPCT = serSPCT.searchMau(mau);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbMauSacActionPerformed

    private void cbbChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChatLieuActionPerformed
        String chatlieu = (String) cbbChatLieu.getSelectedItem();
        listSPCT = serSPCT.searchCL(chatlieu);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbChatLieuActionPerformed

    private void tbMuaHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMuaHangMouseEntered

    }//GEN-LAST:event_tbMuaHangMouseEntered

    private void tbMuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMuaHangMouseClicked
        int row = tbMuaHang.getSelectedRow();
        fillData1(row);
        loadTableDSMH(listDSMH);
       
    }//GEN-LAST:event_tbMuaHangMouseClicked

    private void cbbsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbsizeActionPerformed
        String size = (String) cbbsize.getSelectedItem();
        listSPCT = serSPCT.searchSz(size);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbsizeActionPerformed

    private void cbbNhaSXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhaSXActionPerformed
        // TODO add your handling code here:
        String mau = (String) cbbNhaSX.getSelectedItem();
        listSPCT = serSPCT.searchNsx(mau);
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbNhaSXActionPerformed

    private void btttkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btttkActionPerformed
        String tenSP = txttk.getText();
        listSPCT = serSPCT.searchTenSP(tenSP);
        loadTable(listSPCT);
    }//GEN-LAST:event_btttkActionPerformed

    private void cbbTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTatCaActionPerformed
        listSPCT = serSPCT.getAll();
        loadTable(listSPCT);
    }//GEN-LAST:event_cbbTatCaActionPerformed

    private void radioDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDaActionPerformed
        lisHDBH = serHDBH.getTT(1);
        loadTable1(lisHDBH);
    }//GEN-LAST:event_radioDaActionPerformed

    private void radioChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioChuaActionPerformed
        lisHDBH = serHDBH.getTT(0);
        loadTable1(lisHDBH);
    }//GEN-LAST:event_radioChuaActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
         lisHDBH = serHDBH.getAll();
        loadTable1(lisHDBH);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    public void loadTable(List<SanPhamChiTietViewModel> list) {
        dtm.setRowCount(0);
        for (SanPhamChiTietViewModel x : listSPCT) {
            dtm.addRow(x.toDataRow1());
        }
    }

    public void loadTableDSMH(List<SanPhamChiTietViewModel> list) {
        dtm2.setRowCount(0);
        for (SanPhamChiTietViewModel x : listDSMH) {
            dtm2.addRow(new Object[]{x.getTenSP(), x.getLoaiSP(), x.getMauSac(),
                x.getChatLieu(), x.getSize(), x.getNsx(), x.getSlt(), x.getGiaBan()});
        }
    }

//    public void loadTable3(List<HoaDonCTBHViewModel> list) {
//        dtm2.setRowCount(0);
//        for (HoaDonCTBHViewModel x : list) {
//            dtm2.addRow(x.toDataRow());
//        }
//    }
    public void loadTable1(List<HoaDonBHViewModel> list) {
        dtm1.setRowCount(0);
        for (HoaDonBHViewModel c : list) {
            dtm1.addRow(new Object[]{c.getMa(), c.getTenNV(), c.getNgayTao(), c.trangThaiHD(c.getTrangThai())});
        }
    }

    public void fillData(int index) {
        HoaDonBHViewModel hd = lisHDBH.get(index);
        txtMa.setText(hd.getMa());
        txtTenNV.setText(hd.getTenNV());
        txtNgTao.setText(String.valueOf(hd.getNgayTao()));
        cbbKH.setSelectedItem(hd.getTenKH());
        int trangThai = hd.getTrangThai();
        if (trangThai == 0) {
            radioChua.setSelected(true);
        } else {
            radioDa.setSelected(true);
        }
    }

    public void fillData1(int index) {
        SanPhamChiTietViewModel hd = listDSMH.get(index);
        txtThanhTien.setText(hd.getGiaBan() * hd.getSlt() + "");

    }

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
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton bttthemkhachhang;
    private javax.swing.JButton btttk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKH;
    private javax.swing.JComboBox<String> cbbLoaiSp;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNhaSX;
    private javax.swing.JButton cbbTatCa;
    private javax.swing.JComboBox<String> cbbTenSp;
    private javax.swing.JComboBox<String> cbbsize;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbCheck;
    private javax.swing.JLabel lbTienThua;
    private javax.swing.JRadioButton radioChua;
    private javax.swing.JRadioButton radioDa;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbMuaHang;
    private javax.swing.JTable tbSanPham;
    private javax.swing.JTextField txtKhachDua;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgTao;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JLabel txtThanhTien;
    private javax.swing.JTextField txttk;
    // End of variables declaration//GEN-END:variables

}
