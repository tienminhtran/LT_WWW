package vn.edu.iuh.fit.backend.repositories.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.sql.Timestamp;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product_price")
@NamedQueries({
        @NamedQuery(name = "ProductPrice.findAll", query = "select p from ProductPrice p"),
        @NamedQuery(name = "ProductPrice.findById", query = "select p from ProductPrice p where p.id = :id"),
        @NamedQuery(name = "ProductPrice.findActivePriceByProductId", query = "select p from ProductPrice p where p.productId = :productId and p.status = 1")
})
public class ProductPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "price_id", nullable = false)
    private Product product;

    @NotNull
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @NotNull
    @Column(name = "apply_date", nullable = false)
    private Timestamp applyDate;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "value", nullable = false)
    private Double value;

    @Lob
    @Column(name = "note")
    private String note;

    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;



}