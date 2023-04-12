package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "MauSac")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class mausac implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID Id;

        @Column
        private String Ma;

        @Column
        private String Ten;
        @Column(name = "id",insertable = false,updatable = false)
        private String idMauSac;
        public mausac(String ma, String ten) {
                Ma = ma;
                Ten = ten;
        }
}
