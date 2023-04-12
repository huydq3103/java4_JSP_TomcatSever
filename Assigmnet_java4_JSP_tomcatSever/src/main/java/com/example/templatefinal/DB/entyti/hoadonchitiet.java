package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "HoaDonChiTiet")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class hoadonchitiet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private hoadon hoadon;

    @Id
    @ManyToOne()
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private chitietsanpham chitietsanpham;
    @Column
    private Integer SoLuong;
    @Column
    private BigDecimal DonGia;
}
