package com.example.templatefinal.DB.responsitory;

import com.example.templatefinal.DB.Util.HibernateUtil;
import com.example.templatefinal.DB.entyti.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class SanPhamresponsitory {
    public ArrayList<chitietsanpham> getAll() {
        ArrayList<chitietsanpham> list = new ArrayList<>();

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from chitietsanpham  ";
            Query query = session.createQuery(sql);
            list = (ArrayList<chitietsanpham>) query.getResultList();
            session.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Add(sanpham sp) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            session.persist(sp);
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }


    public nsx getOneNSX(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from nsx nsx where nsx.Ma = :Newma";
            Query query = session.createQuery(sql);
            query.setParameter("Newma", ma);
            nsx nsx = (nsx) query.getSingleResult();
            session.close();
            return nsx;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public sanpham getOneSP(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from sanpham  sp where sp.Ma = :Newma";
            Query query = session.createQuery(sql);
            query.setParameter("Newma", ma);
            sanpham sp = (sanpham) query.getSingleResult();
            session.close();
            return sp;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public mausac getOneMauSac(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from mausac mausac where mausac.Ma = :NewMa";
            Query query = session.createQuery(sql);
            query.setParameter("NewMa", ma);
            mausac mausac = (mausac) query.getSingleResult();
            session.close();
            return mausac;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    public chitietsanpham getOneCTSP(String idCtsp) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = "select ctsp from chitietsanpham ctsp where ctsp.idCTSP like '%"+idCtsp+"'";
            Query query = session.createQuery(sql);
            chitietsanpham ctsp = (chitietsanpham) query.getSingleResult();
            session.close();
            return ctsp;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public dongsp getOneDSP(String ma) {

        try (Session session = HibernateUtil.getFACTORY().openSession();) {

            String sql = " from dongsp dongsp where dongsp.Ma = :Newma";
            Query query = session.createQuery(sql);
            query.setParameter("Newma", ma);
            dongsp dongsp = (dongsp) query.getSingleResult();
            session.close();
            return dongsp;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public boolean Update(sanpham sp, String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql = "update sanpham set Ten = :newTen , Ma = :NewMa where idSP = :newID";
            Query query = session.createQuery(sql);
            query.setParameter("newTen", sp.getTen());
            query.setParameter("NewMa", sp.getMa());
            query.setParameter("newID", id);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }

    public boolean UpdateChitietSP(chitietsanpham ctsp, nsx nsx, mausac ms, dongsp dsp, String id) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            String sql = "update chitietsanpham ctsp set " +
                    "ctsp.nsx = :NewNSX,ctsp.mausac = :newMauSac ,ctsp.dongsp = :newDongsp," +
                    "ctsp.NamBH =: newNamBH, ctsp.MoTa =:NewMoTa , ctsp.SoLuongTon =:newSoLuongTon," +
                    "ctsp.GiaNhap = :newGiaNhap,ctsp.GiaBan =:newGiaBan  where idCTSP = :newID ";
            Query query = session.createQuery(sql);
            query.setParameter("NewNSX", nsx);
            query.setParameter("newMauSac", ms);
            query.setParameter("newDongsp", dsp);
            query.setParameter("newNamBH", ctsp.getNamBH());
            query.setParameter("NewMoTa", ctsp.getMoTa());
            query.setParameter("newSoLuongTon", ctsp.getSoLuongTon());
            query.setParameter("newGiaNhap", ctsp.getGiaNhap());
            query.setParameter("newGiaBan", ctsp.getGiaBan());
            query.setParameter("newID", id);
            query.executeUpdate();
            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }


    public boolean Remove(String ma) {
        try (Session session = HibernateUtil.getFACTORY().openSession();) {
            Transaction tran = session.beginTransaction();
            // Tìm đối tượng SanPham cần xóa
            sanpham sp = getOneSP(ma);
            String id = String.valueOf(sp.getId());
            String newID = id.substring(id.length() - 12);
            session.createQuery("delete chitietsanpham ctsp where ctsp.sanpham.Id like '%" + newID + "'")
                    .executeUpdate();
            session.createQuery("delete from sanpham sp where sp.Id like '%" + newID + "'")
                    .executeUpdate();

            tran.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return false;
    }


    public static void main(String[] args) {
        SanPhamresponsitory sp = new SanPhamresponsitory();
        NhaSanXuatResponsitory nsx1 = new NhaSanXuatResponsitory();
        String id = "2698da2a-a700-46c4-b51d-984b18b147d0";
        String idctsp = id.substring(id.length()-12);
        chitietsanpham ctsp = sp.getOneCTSP(idctsp);

        System.out.println(ctsp.getSanpham().getTen());

//            nsx.Add(new nsx("2","t"));
//           String idSql = "4AF0BDFC-8500-9E4E-86D1-5F11F3D8EA11";
//           String idJAVA = String.valueOf(sp.getOne("2").getId2());
//           String idJAVA2 = String.valueOf(sp.getOne("2").getId());

//        System.out.println((idJAVA));
//        System.out.println((idJAVA2));
//         sanpham sp2 = new sanpham("oke2","1222");
//        nsx nsx = sp.getOneNSX("2");
//        mausac ms = sp.getOneMauSac("1");
//
//        dongsp dsp = sp.getOneDSP("1");
//
//        chitietsanpham ctsp = new chitietsanpham();
//        ctsp.setDongsp(dsp);
//        ctsp.setMausac(ms);
//        ctsp.setNsx(nsx);
//
//        sp2.setChitietsanphams(Arrays.asList(ctsp));
//
//         String id =("6A530817-D6AD-024D-AB2E-7323E057FEE1");
//        sp.UpdateChitietSP(ctsp,nsx,ms,dsp,id);
// banr chất là nó add thàng cha trước khi nó chứa tồn tại
// còn nếu tồn tại rồi thì nó lấy và add vào thg con
// cứ thế nếu mấy thằng cha kia cũng chưa tồn tại thì nó sẽ thêm vào và lấy ra
    }


}
