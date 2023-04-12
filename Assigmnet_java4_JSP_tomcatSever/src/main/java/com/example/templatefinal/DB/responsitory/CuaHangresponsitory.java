package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.cuahang;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;

public class CuaHangresponsitory {
    public ArrayList<cuahang> getAll() {
        ArrayList<cuahang> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select cuahang from cuahang cuahang ";
            Query query = session.createQuery(sql);
            list = (ArrayList<cuahang>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(cuahang cuahang) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.save(cuahang);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean udpate(String id, cuahang cuahang) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql = ("update cuahang cuahang set cuahang.Ma = :newMa , cuahang.Ten = :newTen," +
                    " cuahang.DiaChi =:newDiaChi,cuahang.QuocGia =:newQuocGia," +
                    "cuahang.ThanhPho =:newThanhPho   where Id like '%" + id + "'");
            Query query = session.createQuery(sql);
            query.setParameter("newMa", cuahang.getMa());
            query.setParameter("newTen", cuahang.getTen());
            query.setParameter("newQuocGia", cuahang.getQuocGia());
            query.setParameter("newThanhPho", cuahang.getThanhPho());
            query.setParameter("newDiaChi", cuahang.getDiaChi());
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
            String sql = ("delete cuahang where Id like '%" + id + "'");
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
