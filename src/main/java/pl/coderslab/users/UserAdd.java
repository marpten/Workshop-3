package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/add.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User user = new User();
        user.setUsername(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));

        UserDao userDao = new UserDao();

        if(userDao.create(user) != null) {
            request.setAttribute("message", "Użytkownik został utworzony");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        } else {
            request.setAttribute("message", "Wystąpił błąd podczas dodawania użytkownika");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        }

    }
}
