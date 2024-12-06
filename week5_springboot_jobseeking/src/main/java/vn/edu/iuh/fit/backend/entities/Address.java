package vn.edu.iuh.fit.backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import vn.edu.iuh.fit.backend.converters.CountryCodeConverter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private Long id;

    @Column(name = "street", length = 150)
    @JsonProperty("street")
    private String street;

    @Column(name = "city", length = 50)
    @JsonProperty("city")
    private String city;

    @Convert(converter = CountryCodeConverter.class)
    @JsonProperty("country")
    @Column(name = "country")
    private CountryCode country;

    @Column(name = "number", length = 20)
    @JsonProperty("number")
    private String number;

    @Column(name = "zipcode", length = 7)
    @JsonProperty("zipcode")
    private String zipcode;


    public Address() {
    }
    public Address(Long id, String street, String city, String number, String zipcode, CountryCode country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }


    public Address(String number, String street, String city, String zipcode, CountryCode countryCode) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = countryCode;
    }

    @Override
    public String toString() {
        return number + ", " + street + ", " + city + ", " + zipcode + ", " + country.getName();
    }

}