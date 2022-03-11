package ar.com.carlosPorfolio.Portfolio.services;

import ar.com.carlosPorfolio.Portfolio.models.Skill;
import ar.com.carlosPorfolio.Portfolio.models.User;

import java.util.List;

public interface IUserService {

    public List<User> getUser();
    public void saveUser(User user);
    public void deleteUser(Long id);

    public User findUser(Long id);

}
