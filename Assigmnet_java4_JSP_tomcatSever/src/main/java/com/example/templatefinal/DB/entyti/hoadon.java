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
@Table(name = "HoaDon")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class hoadon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @ManyToOne
            @JoinColumn(name = "IdKH",referencedColumnName = "Id")
     private khachhang khachhang;

    @ManyToOne
            @JoinColumn(name = "IdNV",referencedColumnName = "Id")
      private nhanvien nhanvien;

    @Column
    private String Ma;
    @Column
    private Date NgayTao;

    @Column
    private Date NgayThanhToan;

    @Column
    private Date NgayShip;

    @Column
    private Date NgayNhan;

    @Column
    private Integer TinhTrang;

    @Column
    private String TenNguoiNhan;

    @Column
    private String DiaChi;

    @Column
    private String Sdt;
}
