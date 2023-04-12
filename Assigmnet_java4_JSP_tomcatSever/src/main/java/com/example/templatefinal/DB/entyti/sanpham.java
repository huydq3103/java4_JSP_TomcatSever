package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class sanpham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "Id",insertable = false,updatable = false)
    private String idSP;
    @Column
    private String Ma;

    @Column
    private String Ten;
    @OneToMany(mappedBy = "sanpham", cascade = CascadeType.PERSIST)
    public List<chitietsanpham> chitietsanphams ;//= new ArrayList<>() co the dung lazy

    public sanpham(String ma, String ten) {
        Ma = ma;
        Ten = ten;
    }
}
