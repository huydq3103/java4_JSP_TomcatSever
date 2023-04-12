package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.cuahang;
import com.example.templatefinal.DB.entyti.giohang;
import com.example.templatefinal.DB.entyti.giohangchitiet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.UUID;

public class GioHangResponsitory {
    public giohang CheckGioHang(String maKH) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select gh from giohang  gh where gh.Ma =:newMaKH ";
            Query query = session.createQuery(sql);
            query.setParameter("newMaKH",maKH);
            giohang giohang = (giohang) query.getSingleResult();
            session.close();
            return giohang;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public ArrayList<giohangchitiet> getAll(String ma) {
        ArrayList<giohangchitiet> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select giohangchitiet from giohangchitiet giohangchitiet where giohang.khachhang.Ma =:NewMa ";
            Query query = session.createQuery(sql);
            query.setParameter("NewMa",ma);
            list = (ArrayList<giohangchitiet>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean CreateGioHang(giohang gh) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(gh);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean AddGioHang(giohangchitiet ghct) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(ghct);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean delete() {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
           Query query = session.createQuery("delete from giohangchitiet ");
           query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean deleteOneSP(UUID idCTSP) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            Query query = session.createQuery("delete from giohangchitiet ghct where ghct.chitietsanpham.id =: newID ");
            query.setParameter("newID",idCTSP);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }


//    public static void main(String[] args) {
//        GioHangResponsitory gh = new GioHangResponsitory();
//        for (giohangchitiet gh1: gh.getAll()
//             ) {
//            System.out.println(gh1.getChitietsanpham().getSanpham().getTen());
//            System.out.println(gh1.getChitietsanpham().getGiaBan());
//            System.out.println(gh1.getSoLuong());
//        }
//    }


}
