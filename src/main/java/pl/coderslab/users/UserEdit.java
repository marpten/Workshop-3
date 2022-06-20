package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);

        if (user == null) {
            request.setAttribute("message", "Użytkownik o podanym ID nie istnieje");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        } else {
            request.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);

        if (user == null) {
            request.setAttribute("message", "Użytkownik o podanym ID nie istnieje");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        } else {
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            userDao.update(user);

            request.setAttribute("message", "Dane użytkownika zostały zaktualizowane");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        }

    }
}
