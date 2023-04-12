package com.example.templatefinal.DB.entyti;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class khachhang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column
    private String Ma;
    @Column
    private String Ten;
    @Column
    private String TenDem;
    @Column
    private String Ho;
    @Column
    private Date NgaySinh;
    @Column
    private String DiaChi;
    @Column
    private String Sdt;

    @Column
    private String ThanhPho;
    @Column
    private String QuocGia;
    @Column
    private String MatKhau;

    public khachhang(String ma, String ten, String tenDem, String ho, Date ngaySinh, String diaChi, String sdt, String thanhPho, String quocGia, String matKhau) {

        Ma = ma;
        Ten = ten;
        TenDem = tenDem;
        Ho = ho;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        Sdt = sdt;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
        MatKhau = matKhau;
    }


}
