package crud.service;


import crud.domain.User;

import java.util.List;

/*用户管理的业务接口*/
public interface UserService {
    List<User> findAll();

    User loginUser(User user);

    void registerUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    void updateUser(User user);
}
