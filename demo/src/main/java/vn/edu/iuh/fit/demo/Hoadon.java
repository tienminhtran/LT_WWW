package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "hoadon")
public class Hoadon {
    @Id
    @Column(name = "idhoadon", nullable = false)
    private Integer id;

    @Column(name = "idUser", nullable = false)
    private Integer idUser;

    @Column(name = "idSP", nullable = false)
    private Integer idSP;

    @Column(name = "tongtien", nullable = false)
    private Integer tongtien;

    @Column(name = "trangthai", nullable = false)
    private Integer trangthai;

    @Column(name = "soluongmua", nullable = false)
    private Integer soluongmua;

    @Column(name = "ngaymua", nullable = false)
    private LocalDate ngaymua;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public Integer getTongtien() {
        return tongtien;
    }

    public void setTongtien(Integer tongtien) {
        this.tongtien = tongtien;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public Integer getSoluongmua() {
        return soluongmua;
    }

    public void setSoluongmua(Integer soluongmua) {
        this.soluongmua = soluongmua;
    }

    public LocalDate getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(LocalDate ngaymua) {
        this.ngaymua = ngaymua;
    }

}