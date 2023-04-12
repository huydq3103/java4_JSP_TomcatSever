package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.dongsp;
import com.example.templatefinal.DB.entyti.mausac;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class MauSacResponsitory {
    public ArrayList<mausac> getAll() {
        ArrayList<mausac> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select ms from mausac ms ";
            Query query = session.createQuery(sql);
            list = (ArrayList<mausac>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(mausac ms) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(ms);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean udpate(String id, mausac ms) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("update mausac ms set ms.Ma = :newMa , ms.Ten = :newTen   where Id like '%"+id+"'");
            Query query = session.createQuery(sql);
            query.setParameter("newMa", ms.getMa());
            query.setParameter("newTen", ms.getTen());
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
            String sql =("delete mausac where Id like '%"+id+"'");
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
