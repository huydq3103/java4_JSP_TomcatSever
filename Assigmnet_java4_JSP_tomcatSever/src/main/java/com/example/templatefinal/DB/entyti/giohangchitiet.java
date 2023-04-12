package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "GioHangChiTiet")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class giohangchitiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private giohang giohang;

    @Id
    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private chitietsanpham chitietsanpham;
    @Column
    private Integer SoLuong;
    @Column
    private BigDecimal DonGia;
    @Column
    private BigDecimal DonGiaKhiGiam;

    public giohangchitiet(com.example.templatefinal.DB.entyti.giohang giohang,
                          com.example.templatefinal.DB.entyti.chitietsanpham chitietsanpham,
                          Integer soLuong, BigDecimal donGia) {
        this.giohang = giohang;
        this.chitietsanpham = chitietsanpham;
        SoLuong = soLuong;
        DonGia = donGia;
    }




}
