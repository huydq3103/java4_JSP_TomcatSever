package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.dongsp;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import java.util.ArrayList;

public class DongspReposity {

    public ArrayList<dongsp> getAll() {
        ArrayList<dongsp> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select dsp from dongsp dsp ";
            Query query = session.createQuery(sql);
            list = (ArrayList<dongsp>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(dongsp dsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(dsp);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean udpate(String id, dongsp dsp) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql =("update dongsp dsp set dsp.Ma = :newMa , dsp.Ten = :newTen   where Id like '%"+id+"'");
            Query query = session.createQuery(sql);
            query.setParameter("newMa", dsp.getMa());
            query.setParameter("newTen", dsp.getTen());
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
            String sql =("delete dongsp where Id like '%"+id+"'");
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
