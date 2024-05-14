package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(long id);

    void save(User user);

    void update(long id, User updateUser);

    void delete(long id);
}
