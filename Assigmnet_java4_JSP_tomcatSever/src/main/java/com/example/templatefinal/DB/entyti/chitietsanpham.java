package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class chitietsanpham implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "Id")
    private sanpham sanpham;
    @ManyToOne
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id")
    private nsx nsx;
    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private mausac mausac;
    @ManyToOne
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id")
    private dongsp dongsp;

    @Column
    private Integer NamBH;

    @Column
    private String MoTa;

    @Column
    private Integer SoLuongTon;

    @Column
    private BigDecimal GiaNhap;

    @Column
    private BigDecimal GiaBan;

    @Column(name = "Id",updatable = false,insertable = false)
    private String idCTSP;

    public chitietsanpham(com.example.templatefinal.DB.entyti.sanpham sanpham, com.example.templatefinal.DB.entyti.nsx nsx, com.example.templatefinal.DB.entyti.mausac mausac, com.example.templatefinal.DB.entyti.dongsp dongsp, Integer namBH, String moTa, Integer soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.sanpham = sanpham;
        this.nsx = nsx;
        this.mausac = mausac;
        this.dongsp = dongsp;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
    }
}
