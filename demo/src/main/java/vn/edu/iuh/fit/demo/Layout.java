package vn.edu.iuh.fit.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "layout")
public class Layout {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "diachi", nullable = false)
    private String diachi;

    @Column(name = "phone", nullable = false)
    private Double phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Double getPhone() {
        return phone;
    }

    public void setPhone(Double phone) {
        this.phone = phone;
    }

}