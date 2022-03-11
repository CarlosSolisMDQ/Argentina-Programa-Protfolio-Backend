package ar.com.carlosPorfolio.Portfolio.security.service;

import ar.com.carlosPorfolio.Portfolio.security.entity.Rol;
import ar.com.carlosPorfolio.Portfolio.security.enums.RolNombre;
import ar.com.carlosPorfolio.Portfolio.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    }


}
