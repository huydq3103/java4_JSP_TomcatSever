package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.cuahang;
import com.example.templatefinal.DB.entyti.nhanvien;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class NhanVienResponitory {

    public ArrayList<nhanvien> getAll() {
        ArrayList<nhanvien> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select nv from nhanvien nv ";
            Query query = session.createQuery(sql);
            list = (ArrayList<nhanvien>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(nhanvien nv) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(nv);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }



    public boolean Update(nhanvien nv) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.merge(nv);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public nhanvien getOneNv(UUID id) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            nhanvien nhanvien = new nhanvien();
            nhanvien = session.get(nhanvien.class, id);
            return nhanvien;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public chucvu getOneCV(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from chucvu cv where cv.Ma = :Newma";
            Query query = session.createQuery(sql);
            query.setParameter("Newma",ma);
            chucvu chucvu = (chucvu) query.getSingleResult();
            session.close();
            return chucvu;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public cuahang getOneCH(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from cuahang ch where ch.Ma = :Newma";
            Query query = session.createQuery(sql);
            query.setParameter("Newma",ma);
            cuahang cuahang = (cuahang) query.getSingleResult();
            session.close();
            return cuahang;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }




    public boolean delete(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("delete nhanvien nv where nv.Id = :newID");
            Query query = session.createQuery(sql);
            query.setParameter("newID",id);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    public nhanvien FindNV(String ma,String pass) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from nhanvien nv where nv.Ma = :Newma and nv.MatKhau =: newPass";
            Query query = session.createQuery(sql);
            query.setParameter("Newma",ma);
            query.setParameter("newPass",pass);
            nhanvien nhanvien = (nhanvien) query.getSingleResult();
            session.close();
            return nhanvien;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static void main(String[] args) {
         NhanVienResponitory nv = new NhanVienResponitory();
        System.out.println(nv.getAll());
        String ma = "2";
        nv.getOneCV(ma);
        System.out.println( nv.getOneCV(ma));
//        String Ma = "non2";
//        String ten ="oke";
//        String tendem = "oke";
//        String ho = "oke";
//        Date ngaySinh = new Date();
//        String diachi = "oke";
//        String sdt = "oke";
//        String Gioitinh = "oke";
//        cuahang ch = nv.getOneCH("02");
//        chucvu cv =  nv.getOneCV("2");
//        System.out.println(ch);
//        System.out.println(cv);
//        Integer trangthai = 1;
//        String matkhau = "ch01";
//        nhanvien nv2 = new nhanvien(id,cv,ch,Ma,ten,tendem,ho,Gioitinh,ngaySinh,diachi,sdt,matkhau,trangthai);
//        nv.Update(nv2);

    }
}
