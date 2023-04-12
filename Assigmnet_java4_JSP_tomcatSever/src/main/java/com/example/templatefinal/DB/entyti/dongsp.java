package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class dongsp implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID Id;

        @Column
        private String Ma;

        @Column
        private String Ten;

        @Column(name = "Id",insertable = false,updatable = false)
        private String idDongsp;

        public dongsp(String ma, String ten) {
                Ma = ma;
                Ten = ten;
        }
}
