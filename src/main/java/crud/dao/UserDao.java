package crud.dao;

import crud.domain.User;

import java.util.List;

//用户操作的Dao
public interface UserDao {
    List<User> findAll();

    User findUserByUsernameAndPassword(int username ,String password);

    void registerUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    void updateUser(User user);

}
