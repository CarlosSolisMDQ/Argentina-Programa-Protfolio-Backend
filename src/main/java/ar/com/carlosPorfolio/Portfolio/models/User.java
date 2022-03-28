package ar.com.carlosPorfolio.Portfolio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class User {

    //queda obsoleto porque mudo a una carpeta de seguridad que va a manejar los usuarios y autenticaciones


    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String user = "";
    private String token = "";

}
