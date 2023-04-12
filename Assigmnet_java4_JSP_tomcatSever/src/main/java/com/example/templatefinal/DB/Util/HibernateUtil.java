package com.example.templatefinal.DB.Util;


import com.example.templatefinal.DB.entyti.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;


public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA23_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(chitietsanpham.class);
        conf.addAnnotatedClass(sanpham.class);
        conf.addAnnotatedClass(chucvu.class);
        conf.addAnnotatedClass(cuahang.class);
        conf.addAnnotatedClass(dongsp.class);
        conf.addAnnotatedClass(giohang.class);
        conf.addAnnotatedClass(giohangchitiet.class);
        conf.addAnnotatedClass(hoadon.class);
        conf.addAnnotatedClass(hoadonchitiet.class);
        conf.addAnnotatedClass(khachhang.class);
        conf.addAnnotatedClass(mausac.class);
        conf.addAnnotatedClass(nhanvien.class);
        conf.addAnnotatedClass(nsx.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("Connected");
    }
}
