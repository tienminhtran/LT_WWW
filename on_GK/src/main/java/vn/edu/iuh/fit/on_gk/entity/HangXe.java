package vn.edu.iuh.fit.on_gk.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
/*@AllArgsConstructor
@NoArgsConstructor*/
@Table(name = "hang_xe")
public class HangXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maHangXe;
    private String tenHangXe;
    private String quocGia;
    private String moTa;

    public HangXe(int maHangXe, String tenHangXe, String quocGia, String moTa) {
        this.maHangXe = maHangXe;
        this.tenHangXe = tenHangXe;
        this.quocGia = quocGia;
        this.moTa = moTa;
    }

    public HangXe() {
    }

    public int getMaHangXe() {

        return maHangXe;
    }

    public void setMaHangXe(int maHangXe) {
        this.maHangXe = maHangXe;
    }

    public String getTenHangXe() {
        return tenHangXe;
    }

    public void setTenHangXe(String tenHangXe) {
        this.tenHangXe = tenHangXe;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}