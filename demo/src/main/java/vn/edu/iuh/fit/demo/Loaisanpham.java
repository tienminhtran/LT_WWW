package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loaisanpham")
public class Loaisanpham {
    @Id
    @Column(name = "idLoaiSP", nullable = false)
    private Integer id;

    @Column(name = "tenLSP", nullable = false)
    private String tenLSP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLSP() {
        return tenLSP;
    }

    public void setTenLSP(String tenLSP) {
        this.tenLSP = tenLSP;
    }

}