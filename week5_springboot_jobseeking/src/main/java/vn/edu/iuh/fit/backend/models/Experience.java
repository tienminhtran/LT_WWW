package vn.edu.iuh.fit.backend.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "experience")
public class Experience implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("exp_id")
    private long id;

    @Column(name = "company_name",nullable = false, length = 120)
    @JsonProperty("company")
    private String companyName;

    @Column(name = "from_date",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("fromDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @Column(name = "to_date",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("toDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    @Column(name = "role",nullable = false, length = 100)
    @JsonProperty("role")
    private String role;

    @Column(name = "work_desc",nullable = false, length = 400)
    @JsonProperty("work_desc")
    private String workDescription;

    //=============================RELATIONSHIPS====================
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "can_id")
    @JsonIgnore
    private Candidate candidate;
}
