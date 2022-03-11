package ar.com.carlosPorfolio.Portfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class About {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String about = "";


}
