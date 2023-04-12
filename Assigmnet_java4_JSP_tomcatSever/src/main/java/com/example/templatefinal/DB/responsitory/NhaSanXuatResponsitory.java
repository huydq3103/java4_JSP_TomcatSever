package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.nsx;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class NhaSanXuatResponsitory {

    public ArrayList<nsx> getAll() {
        ArrayList<nsx> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select nsx from nsx nsx";
            Query query = session.createQuery(sql);
            list = (ArrayList<nsx>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(nsx nsx) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(nsx);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean udpate(String id, nsx nsx) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("update nsx nsx set nsx.Ma = :newMa , nsx.Ten = :newTen   where Id like '%"+id+"'");
            Query query = session.createQuery(sql);
            query.setParameter("newMa", nsx.getMa());
            query.setParameter("newTen", nsx.getTen());
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
            String sql =("delete nsx where Id like '%"+id+"'");
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
