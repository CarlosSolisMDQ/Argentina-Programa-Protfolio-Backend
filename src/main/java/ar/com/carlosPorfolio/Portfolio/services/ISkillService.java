package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Skill;

import java.util.List;

public interface ISkillService {
    public List<Skill> getSkill();
    public void saveSkill(Skill skill);
    public void deleteSkill(Long id);

    public Skill findSkill(Long id);
}
