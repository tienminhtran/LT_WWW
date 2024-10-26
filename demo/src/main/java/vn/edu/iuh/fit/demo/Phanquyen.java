package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phanquyen")
public class Phanquyen {
    @Id
    @Column(name = "idQuyen", nullable = false)
    private Integer id;

    @Column(name = "tenquyen", nullable = false)
    private String tenquyen;

    @Column(name = "chitietquyen", nullable = false)
    private String chitietquyen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenquyen() {
        return tenquyen;
    }

    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    public String getChitietquyen() {
        return chitietquyen;
    }

    public void setChitietquyen(String chitietquyen) {
        this.chitietquyen = chitietquyen;
    }

}