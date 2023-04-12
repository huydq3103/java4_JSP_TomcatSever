package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class nhanvien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "Id")
    private chucvu chucvu;
    @ManyToOne
    @JoinColumn(name = "IdCH", referencedColumnName = "Id")
    private cuahang cuahang;
    @Column
    private String Ma;
    @Column
    private String Ten;
    @Column
    private String TenDem;
    @Column
    private String Ho;
    @Column

    private String GioiTinh;
    @Column
    private Date NgaySinh;
    @Column
    private String DiaChi;
    @Column
    private String Sdt;
    @Column
    private String MatKhau;
    @Column
    private Integer TrangThai;


    public nhanvien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh,
                    String diaChi, String sdt, String matKhau, Integer trangThai,
                    com.example.templatefinal.DB.entyti.cuahang cuahang, com.example.templatefinal.DB.entyti.chucvu chucvu) {
        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        GioiTinh = gioiTinh;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Sdt = sdt;
        MatKhau = matKhau;
        TrangThai = trangThai;
        this.chucvu = chucvu;
        this.cuahang = cuahang;
    }



}
