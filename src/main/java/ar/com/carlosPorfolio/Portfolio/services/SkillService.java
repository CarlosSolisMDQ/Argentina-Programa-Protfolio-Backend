package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Skill;
import ar.com.carlosPorfolio.Portfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService implements ISkillService{

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> getSkill() {
        List<Skill> listaSkill = skillRepository.findAll();
        return listaSkill;
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = skillRepository.findById(id).orElse(null);
        return skill;
    }
}
