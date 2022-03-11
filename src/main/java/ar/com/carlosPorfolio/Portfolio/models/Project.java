package ar.com.carlosPorfolio.Portfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String nombre = "";
    private String descripcion = "";
    private String imagen = "";


}
