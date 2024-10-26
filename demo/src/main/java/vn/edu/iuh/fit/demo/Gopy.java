package vn.edu.iuh.fit.demo;

import jakarta.persistence.*;

@Entity
@Table(name = "gopy")
public class Gopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idgopy", nullable = false)
    private Integer id;

    @Column(name = "idSP", nullable = false)
    private Integer idSP;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "noidung", nullable = false)
    private String noidung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdSP() {
        return idSP;
    }

    public void setIdSP(Integer idSP) {
        this.idSP = idSP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

}