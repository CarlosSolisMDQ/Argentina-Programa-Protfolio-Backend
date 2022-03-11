package ar.com.carlosPorfolio.Portfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long id;

    private String escuela = "";
    private String carrera = "";
    private Integer fechaInicio = 0;
    private Integer fechaFin = 0;



}
