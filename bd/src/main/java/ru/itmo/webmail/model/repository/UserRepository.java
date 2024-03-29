package ru.itmo.webmail.model.repository;

import ru.itmo.webmail.model.domain.User;

import java.util.List;

public interface UserRepository {
    User find(long userId);
    User findByLogin(String login);
    User findByLoginAndPasswordSha(String login, String passwordSha);
    List<User> findAll();
    void save(User user, String passwordSha);
    public User findByEmail(String email, String passwordSha);
    public void confirmUser(long userId);
}
