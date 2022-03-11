package ar.com.carlosPorfolio.Portfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private String empresa = "";
    private String puesto = "";
    private Integer fechaInicio = 0;
    private Integer fechaFin = 0;


}
