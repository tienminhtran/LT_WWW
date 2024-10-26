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
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maXe", nullable = false)
    private String maXe;

    @Size(max = 50)
    @NotNull
    @Column(name = "tenXe", nullable = false, length = 50)
    private String tenXe;

    @Column(name = "giaXe")
    private Long giaXe;

    @Column(name = "namSX")
    private String namSX;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maHangXe")
    private HangXe maHangXe;

}