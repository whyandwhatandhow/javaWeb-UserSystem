package crud.service.impl;

import crud.dao.UserDao;
import crud.dao.impl.UserDaoImpl;
import crud.domain.User;
import crud.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return  dao.findAll();
    }

    public User loginUser(User user){
        return dao.findUserByUsernameAndPassword(user.getIdenty(), user.getPassword());
    }

    @Override
    public void registerUser(User user) {
        dao.registerUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public User findUserById(int id) {
        return dao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
         dao.updateUser(user);
    }


}
