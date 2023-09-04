package crud.web.servlet;

import crud.domain.User;
import crud.service.UserService;
import crud.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String sex = req.getParameter("Sex");
        String identy = req.getParameter("identy");
        String title = req.getParameter("title");
        String password = req.getParameter("password");

        int i = Integer.parseInt(id);
        int identify=Integer.parseInt(identy);
        UserService service=new UserServiceImpl();
        User user = service.findUserById(i);
        //将user存入request
        user.setName(name);
        user.setSex(sex);
        user.setIdenty(identify);
        user.setTitle(title);
        user.setPassword(password);
        service.loginUser(user);
        req.setAttribute("user",user);
        //转发
        req.getRequestDispatcher("/update.jsp").forward(req,resp);



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
