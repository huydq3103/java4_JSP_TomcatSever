package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.khachhang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class KhachHangResponsitory {

    public ArrayList<khachhang> getAll() {
        ArrayList<khachhang> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select kh from khachhang kh ";
            Query query = session.createQuery(sql);
            list = (ArrayList<khachhang>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(khachhang kh) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(kh);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    public khachhang FindKH(String user , String pass) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            String sql = "select kh from khachhang kh where kh.Ma =:newMa and kh.MatKhau =:NewMatKhau";
            Query query = session.createQuery(sql);
            query.setParameter("newMa",user);
            query.setParameter("NewMatKhau",pass);
            khachhang kh = (khachhang) query.getSingleResult();
            session.close();
            return kh;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public khachhang GetKH(String ma) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            String sql = "select kh from khachhang kh where kh.Ma =:newMa ";
            Query query = session.createQuery(sql);
            query.setParameter("newMa",ma);
            khachhang kh = (khachhang) query.getSingleResult();
            session.close();
            return kh;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean udpate(String id, khachhang kh) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("update khachhang kh set Ma = :newMa , " +
                    "Ten = :newTen ,TenDem = :newTenDem,Ho = :newHo," +
                    "NgaySinh = :newNgaySinh,DiaChi = :newDiaChi," +
                    " Sdt = :newSdt ,ThanhPho = :newThanhPho ," +
                    "QuocGia = :newQuocGia , MatKhau = :newMatKhau where Id like '%"+id+"'");


            Query query = session.createQuery(sql);
            query.setParameter("newMa", kh.getMa());
            query.setParameter("newTen", kh.getTen());
            query.setParameter("newTenDem", kh.getTenDem());
            query.setParameter("newNgaySinh", kh.getNgaySinh());
            query.setParameter("newDiaChi", kh.getDiaChi());
            query.setParameter("newSdt", kh.getSdt());
            query.setParameter("newThanhPho", kh.getThanhPho());
            query.setParameter("newQuocGia", kh.getQuocGia());
            query.setParameter("newMatKhau", kh.getMatKhau());
            query.setParameter("newHo",kh.getHo());
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }
    public boolean delete(String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("delete khachhang where Id like '%"+id+"'");
            Query query = session.createQuery(sql);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

}
