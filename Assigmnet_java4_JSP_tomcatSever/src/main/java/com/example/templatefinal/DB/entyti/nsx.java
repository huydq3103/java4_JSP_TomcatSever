package com.example.templatefinal.DB.entyti;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "NSX")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class nsx implements Serializable{


        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(columnDefinition = "uniqueidentifier")
        private UUID id;


        @Column(name = "id",insertable = false,updatable = false)
        private String idNSX;
        @Column
        private String Ma;

        @Column
        private String Ten;

        public nsx(String ma, String ten) {
                Ma = ma;
                Ten = ten;
        }
}
