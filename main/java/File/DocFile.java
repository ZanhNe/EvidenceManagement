package File;

import BoKiemDinh.BoKiemDinh;
import CapPhep.CapPhep;
import MinhChung.MinhChung;
import NguoiDung.NguoiDung;
import PhongBan.PhongBan;
import ThongTin.ThongTin;
import TieuChi.TieuChi;
import TieuChuan.TieuChuan;
import NguoiDung.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocFile {
    public static void docDuLieu(String tenTep, TruongPhong nd,List<NguoiDung> tt) {

        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = br.readLine())!=null) {
                String []layout = line.split(",");
                String ten = layout[0];
                String mk = layout[1];
                NguoiDung nguoiDung = new TruongPhong(ten,mk);
                tt.add(nguoiDung);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void docDuLieu(String tenTep, GiangVien nd,List<NguoiDung> tt){
        try (BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String line;
            while ((line = br.readLine())!=null) {
                String []layout = line.split(",");
                String ten = layout[0];
                String mk = layout[1];
                NguoiDung nguoiDung = new GiangVien(ten,mk);
                tt.add(nguoiDung);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void docDuLieu(String tenTep, CapPhep capPhep,List<CapPhep> ds) {
        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = br.readLine())!=null) {
                String []layout = line.split(",");
                String ngayCungCap = layout[0];
                String ngayKhoiTao = layout[1];
                CapPhep cp = new CapPhep(ngayCungCap,ngayKhoiTao);
                ds.add(cp);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void docDuLieu(String tenTep,List<ThongTin> tt) {

        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String line ;
            while ((line = br.readLine())!=null) {
                    String []layout = line.split(",");
                    String ten = layout[0];
                    String noiDung = layout[1];
                if(tenTep.equals("Data/DataTieuChuan.txt")) {
                    ThongTin thongTin = new TieuChuan(ten, noiDung);
                    tt.add(thongTin);
                }
                else if (tenTep.equals("Data/DataTieuChi.txt")) {
                    ThongTin thongTin = new TieuChi(ten,noiDung);
                    tt.add(thongTin);
                }


            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void docDuLieu(String tenTep,BoKiemDinh boKiemDinh){

        try(BufferedReader br = new BufferedReader(new FileReader(tenTep))) {
            String line;

            while ((line = br.readLine())!=null) {
                String ten = line;
                boKiemDinh = new BoKiemDinh(ten);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void docDuLieu(String tenTep,MinhChung mc,List<MinhChung> tt) {

        try (BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String line;
            while ((line = br.readLine())!=null) {
                String []layout = line.split(",");
                String ten = layout[0];
                String place = layout[1];
                String date = layout[2];
                MinhChung minhChung = new MinhChung(ten,place,date);
                tt.add(minhChung);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void docDuLieu(String tenTep,PhongBan pb,List<PhongBan> tt) {

        try (BufferedReader br = new BufferedReader(new FileReader(tenTep))){
            String line;
            while ((line = br.readLine())!=null) {
                String []layout = line.split(",");
                String ten = layout[0];
                String place = layout[1];
                PhongBan pBan = new PhongBan(ten,place);
                tt.add(pBan);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }




}
