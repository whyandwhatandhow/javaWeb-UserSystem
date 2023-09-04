package crud.dao.impl;

import crud.dao.UserDao;
import crud.domain.User;
import crud.util.ConnectionTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> findAll() {
        //操作数据库
        List<User> users = new ArrayList<>();
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = connectionTest.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from user";
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1)); // Assuming "id" is the column name
                user.setName(resultSet.getString(2));
                user.setSex(resultSet.getString(3));
                user.setIdenty(resultSet.getInt(4));
                user.setTitle(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        } finally {
            // Close resources like resultSet, statement, and connection
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(int username, String password) {
        String sql = "select * from user where identy=? and password=?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = null;

        try {
            connection = connectionTest.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, username);
            statement.setString(2, password);

            // 执行查询
            resultSet = statement.executeQuery();

            // 处理查询结果并返回User对象
            if (resultSet.next()) {
                User user = new User();
                user.setIdenty(resultSet.getInt("identy"));
                user.setPassword(resultSet.getString("password"));
                // 其他属性设置

                return user;
            }

            // 如果没有找到匹配的用户
            return null;

        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常，可能记录日志或者返回适当的错误信息
            return null;

        } finally {
            // 关闭资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void registerUser(User user) {
        int id = user.getId();
        String name = user.getName();
        int identy = user.getIdenty();
        String sex = user.getSex();
        String title = user.getTitle();
        String password = user.getPassword();

        String sql = "insert into user (id,name,Sex,identy,title,password) values(?,?,?,?,?,?) ";
        PreparedStatement statement = null;
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = null;


        try {
            connection = connectionTest.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, sex);
            statement.setInt(4, identy);
            statement.setString(5, title);
            statement.setString(6, password);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "delete from user where id = ?";
        PreparedStatement statement = null;
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = null;

        try {
            connection = connectionTest.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id= ?";
        PreparedStatement statement = null;
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = connectionTest.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSex(resultSet.getString("sex"));
                user.setIdenty(resultSet.getInt("identy"));
                user.setTitle(resultSet.getString("title"));
                user.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,Sex=?,identy=?,title=?,password=? where id=?";
        PreparedStatement statement = null;
        ConnectionTest connectionTest = new ConnectionTest();
        Connection connection = null;

        try {
            connection=connectionTest.getConnection();
            statement=connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getSex());
            statement.setInt(3,user.getIdenty());
            statement.setString(4, user.getTitle());
            statement.setString(5, user.getPassword());
            statement.setInt(6,user.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            e.getCause();
        }
    }


}


