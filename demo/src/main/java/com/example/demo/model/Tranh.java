package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tranh")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tranh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten", nullable = false, length = 200)
    private String ten;

    @Column(name = "hoa_si", nullable = false, length = 100)
    private String hoaSi;

    @ManyToOne
    @JoinColumn(name = "the_loai_id")
    private TheLoai theLoai;

    @Column(name = "kich_thuoc", length = 50)
    private String kichThuoc;

    @Column(name = "gia_ban", nullable = false, precision = 12, scale = 2)
    private BigDecimal giaBan;

    @Column(name = "gia_mua", precision = 12, scale = 2)
    private BigDecimal giaMua;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "duong_dan_anh", length = 500)
    private String duongDanAnh;

    @Column(name = "ghi_chu_tinh_trang")
    private String ghiChuTinhTrang;

    @Enumerated(EnumType.STRING)
    @Column(name = "trang_thai", nullable = false, columnDefinition = "ENUM('co_san', 'da_ban', 'da_dat_coc', 'hong') default 'co_san'")
    private TrangThai trangThai = TrangThai.co_san;

    @ManyToOne
    @JoinColumn(name = "nguoi_tao_id")
    private NguoiDung nguoiTao;

    @Column(name = "ngay_tao", updatable = false)
    private LocalDateTime ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDateTime ngayCapNhat;

    public enum TrangThai {
        co_san, da_ban, da_dat_coc, hong
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