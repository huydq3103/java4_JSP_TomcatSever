package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.chucvu;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class ChucVuRepository {

    public ArrayList<chucvu> getAll() {
        ArrayList<chucvu> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select cv from chucvu  cv";
            Query query = session.createQuery(sql);
            list = (ArrayList<chucvu>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(chucvu cv) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(cv);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean udpate(String id, chucvu cv) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("update chucvu cv set cv.Ma = :newMa , cv.Ten = :newTen   where Id like '%"+id+"'");
            Query query = session.createQuery(sql);
            query.setParameter("newMa", cv.getMa());
            query.setParameter("newTen", cv.getTen());
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
            String sql =("delete chucvu where Id like '%"+id+"'");
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
