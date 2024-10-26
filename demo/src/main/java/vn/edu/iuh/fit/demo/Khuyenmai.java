package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "khuyenmai")
public class Khuyenmai {
    @Id
    @Column(name = "idKM", nullable = false)
    private Integer id;

    @Column(name = "loaiKM", nullable = false)
    private String loaiKM;

    @Column(name = "giatriKM", nullable = false)
    private Float giatriKM;

    @Column(name = "ngaybatdau", nullable = false)
    private LocalDate ngaybatdau;

    @Column(name = "ngayketthuc", nullable = false)
    private LocalDate ngayketthuc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiKM() {
        return loaiKM;
    }

    public void setLoaiKM(String loaiKM) {
        this.loaiKM = loaiKM;
    }

    public Float getGiatriKM() {
        return giatriKM;
    }

    public void setGiatriKM(Float giatriKM) {
        this.giatriKM = giatriKM;
    }

    public LocalDate getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(LocalDate ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public LocalDate getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(LocalDate ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

}