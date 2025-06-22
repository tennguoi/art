package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "giao_dich")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tranh_id")
    private Tranh tranh;

    @ManyToOne
    @JoinColumn(name = "khach_hang_id")
    private KhachHang khachHang;

    @Enumerated(EnumType.STRING)
    @Column(name = "loai_giao_dich", nullable = false, columnDefinition = "ENUM('mua_vao', 'ban_ra')")
    private LoaiGiaoDich loaiGiaoDich;

    @Column(name = "gia", nullable = false, precision = 12, scale = 2)
    private BigDecimal gia;

    @Column(name = "so_luong")
    private Integer soLuong = 1;

    @Column(name = "ngay_giao_dich", nullable = false)
    private LocalDate ngayGiaoDich;

    @Enumerated(EnumType.STRING)
    @Column(name = "phuong_thuc_thanh_toan", columnDefinition = "ENUM('tien_mat', 'chuyen_khoan', 'the_tin_dung', 'khac') default 'tien_mat'")
    private PhuongThucThanhToan phuongThucThanhToan = PhuongThucThanhToan.tien_mat;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai_thanh_toan", columnDefinition = "ENUM('cho_xu_ly', 'hoan_thanh', 'da_huy') default 'hoan_thanh'")
    private TrangThaiThanhToan trangThaiThanhToan = TrangThaiThanhToan.hoan_thanh;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "nhan_vien_id")
    private NguoiDung nhanVien;

    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;

    public enum LoaiGiaoDich {
        mua_vao, ban_ra
    }

    public enum PhuongThucThanhToan {
        tien_mat, chuyen_khoan, the_tin_dung, khac
    }

    public enum TrangThaiThanhToan {
        cho_xu_ly, hoan_thanh, da_huy
    }

    @PrePersist
    protected void onCreate() {
        ngayTao = LocalDateTime.now();
        ngayCapNhat = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        ngayCapNhat = LocalDateTime.now();
    }
} 