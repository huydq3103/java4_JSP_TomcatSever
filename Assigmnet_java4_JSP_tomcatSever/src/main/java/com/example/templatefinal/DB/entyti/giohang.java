package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class giohang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @ManyToOne
    @JoinColumn(name = "IdKH", referencedColumnName = "Id")
    private khachhang khachhang;

    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "Id")
    private nhanvien nhanvien;

    @Column
    private String Ma;
    @Column
    private Date NgayTao;

    @Column
    private Date NgayThanhToan;

    @Column
    private Integer TinhTrang;

    @Column
    private String TenNguoiNhan;

    @Column
    private String DiaChi;

    @Column
    private String Sdt;

    public giohang(com.example.templatefinal.DB.entyti.khachhang khachhang,
                   com.example.templatefinal.DB.entyti.nhanvien nhanvien,
                   String ma, Date ngayTao, Date ngayThanhToan, Integer tinhTrang,
                   String tenNguoiNhan, String diaChi, String sdt) {
        this.khachhang = khachhang;
        this.nhanvien = nhanvien;
        Ma = ma;
        NgayTao = ngayTao;
        NgayThanhToan = ngayThanhToan;
        TinhTrang = tinhTrang;
        TenNguoiNhan = tenNguoiNhan;
        DiaChi = diaChi;
        Sdt = sdt;
    }


}
