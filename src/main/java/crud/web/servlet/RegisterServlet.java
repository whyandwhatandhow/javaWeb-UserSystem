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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String sex = req.getParameter("Sex");
        int identy = Integer.parseInt(req.getParameter("identy"));
        String title = req.getParameter("title");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("rePassword");


        UserService userService=new UserServiceImpl();

        if(password.equals(rePassword)) {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setSex(sex);
            user.setIdenty(identy);
            user.setTitle(title);
            user.setPassword(password);

            userService.registerUser(user);
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
            req.setAttribute("succeed","登陆成功");
        }else {
            req.setAttribute("password_error","前后密码不一致");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
