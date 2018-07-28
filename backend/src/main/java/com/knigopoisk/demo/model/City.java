package com.knigopoisk.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties(value = {"airports"})
@Entity
@Table(name = "cities")
//@Table(name = "cities", schema = "public", catalog = "airports")
public class City {
    private Long id;
    private String name;
    //private List<AirportEntity> airports;

    public City() {}
    public City(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(
//            initialValue = 1,
//            allocationSize = 1,
//            name = "CityIdGenerator",
//            sequenceName = "cities_id_seq"
//    )
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 46)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City that = (City) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "city", cascade = {CascadeType.ALL})
//    public List<AirportEntity> getAirports() {
//        return airports;
//    }
//
//    public void setAirports(List<AirportEntity> airportsById) {
//        this.airports = airportsById;
//    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}