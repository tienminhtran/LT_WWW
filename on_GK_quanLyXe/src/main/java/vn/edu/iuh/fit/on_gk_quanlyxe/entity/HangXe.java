package vn.edu.iuh.fit.on_gk_quanlyxe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hang_xe")
public class HangXe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHangXe", nullable = false)
    private String maHangXe;

    @Size(max = 50)
    @NotNull
    @Column(name = "tenHangXe", nullable = false, length = 50)
    private String tenHangXe;

    @Lob
    @Column(name = "moTa")
    private String moTa;

    @Size(max = 50)
    @Column(name = "quocGia", length = 50)
    private String quocGia;

}