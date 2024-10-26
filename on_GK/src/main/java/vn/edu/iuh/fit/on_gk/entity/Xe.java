package vn.edu.iuh.fit.on_gk.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maXe;
    private String tenXe;
    private double giaXe;
    private String namSX;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maHangXe")
    private HangXe maHangXe;

    public Xe() {
    }

    public Xe(String tenXe, double giaXe, String namSX) {
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
    }

    public Xe(int maXe, String tenXe, double giaXe, String namSX) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
    }

    public Xe(int maXe, String tenXe, double giaXe, String namSX, HangXe maHangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.maHangXe = maHangXe;
    }

    public Xe(String tenXe, double giaXe, String namSX, HangXe maHangXe) {
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.maHangXe = maHangXe;
    }

    public int getMaXe() {
        return maXe;
    }

    public void setMaXe(int maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }

    public String getNamSX() {
        return namSX;
    }

    public void setNamSX(String namSX) {
        this.namSX = namSX;
    }

    public HangXe getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(HangXe maHangXe) {
        this.maHangXe = maHangXe;
    }

}