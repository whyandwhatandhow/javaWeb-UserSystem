package crud.web.servlet;

import crud.domain.User;
import crud.service.UserService;
import crud.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int username = Integer.parseInt(req.getParameter("username"));
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");

        HttpSession session=req.getSession();
        String checkCodeSession = (String) session.getAttribute("checkCode_session");
        session.removeAttribute("checkCode_session");
        //检验验证码有没有问题

        User user=new User(username,password);
        UserService service=new UserServiceImpl();
        User loginUser = service.loginUser(user);
        if(checkCodeSession.equalsIgnoreCase(captcha)){
            //检验登录
            if(loginUser!=null){
                //登陆成功
                session.setAttribute("user",loginUser);
                resp.sendRedirect(req.getContextPath()+"/index.jsp");
            }else {
                //登陆失败
                req.setAttribute("login_error","用户名密码错误");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

        }else {
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
