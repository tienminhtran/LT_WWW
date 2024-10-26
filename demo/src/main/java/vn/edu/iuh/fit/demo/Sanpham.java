package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "sanpham")
public class Sanpham {
    @Id
    @Column(name = "idSP", nullable = false)
    private Integer id;

    @Column(name = "idKM", nullable = false)
    private Integer idKM;

    @Column(name = "idLoaiSP", nullable = false)
    private Integer idLoaiSP;

    @Column(name = "idcolor", nullable = false)
    private Integer idcolor;

    @Column(name = "idsize", nullable = false)
    private Integer idsize;

    @Column(name = "tenSP", nullable = false)
    private String tenSP;

    @Column(name = "Dongia", nullable = false)
    private Integer dongia;

    @Column(name = "anh1", nullable = false)
    private String anh1;

    @Column(name = "anh2", nullable = false)
    private String anh2;

    @Column(name = "anh3", nullable = false)
    private String anh3;

    @Column(name = "ngaynhap", nullable = false)
    private LocalDate ngaynhap;

    @Column(name = "mota", nullable = false)
    private String mota;

    @Column(name = "soluong", nullable = false)
    private Integer soluong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKM() {
        return idKM;
    }

    public void setIdKM(Integer idKM) {
        this.idKM = idKM;
    }

    public Integer getIdLoaiSP() {
        return idLoaiSP;
    }

    public void setIdLoaiSP(Integer idLoaiSP) {
        this.idLoaiSP = idLoaiSP;
    }

    public Integer getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public Integer getIdsize() {
        return idsize;
    }

    public void setIdsize(Integer idsize) {
        this.idsize = idsize;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getDongia() {
        return dongia;
    }

    public void setDongia(Integer dongia) {
        this.dongia = dongia;
    }

    public String getAnh1() {
        return anh1;
    }

    public void setAnh1(String anh1) {
        this.anh1 = anh1;
    }

    public String getAnh2() {
        return anh2;
    }

    public void setAnh2(String anh2) {
        this.anh2 = anh2;
    }

    public String getAnh3() {
        return anh3;
    }

    public void setAnh3(String anh3) {
        this.anh3 = anh3;
    }

    public LocalDate getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(LocalDate ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

}