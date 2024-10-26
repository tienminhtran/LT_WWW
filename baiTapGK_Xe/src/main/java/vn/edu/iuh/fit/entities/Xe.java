package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maxe", nullable = false)
    private Integer id;

    @Column(name = "tenxe", length = 50)
    private String tenxe;

    @ColumnDefault("0")
    @Column(name = "namsanxuat")
    private Integer namsanxuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("0")
    @JoinColumn(name = "mahangxe")
    private HangXe mahangxe;

    @Column(name = "giaxe")
    private Double giaxe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Integer getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(Integer namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public HangXe getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(HangXe mahangxe) {
        this.mahangxe = mahangxe;
    }

    public Double getGiaxe() {
        return giaxe;
    }

    public void setGiaxe(Double giaxe) {
        this.giaxe = giaxe;
    }

}