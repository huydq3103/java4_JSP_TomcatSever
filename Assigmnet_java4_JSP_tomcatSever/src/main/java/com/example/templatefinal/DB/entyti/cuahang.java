package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Data
@ToString
@NoArgsConstructor
public class cuahang implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;

    @Column
    private String Ma ;

    @Column
    private String Ten ;

    @Column
    private String DiaChi ;
    @Column
    private String ThanhPho;

    @Column
    private String QuocGia;

    @Column(name = "Id",insertable = false,updatable = false)
    private String idCH;
    public cuahang(String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        Ma = ma;
        Ten = ten;
        DiaChi = diaChi;
        ThanhPho = thanhPho;
        QuocGia = quocGia;
    }


}
