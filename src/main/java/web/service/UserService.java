package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    public List<User> index();

    public User show(long id);

    public void save(User user);

    public void update(long id, User updateUser);

    public void delete(long id);
}
