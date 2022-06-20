package pl.coderslab.users;

import pl.coderslab.utils.User;
import pl.coderslab.utils.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDelete", value = "/user/delete")
public class UserDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        User user = userDao.read(id);

        if (user == null) {
            request.setAttribute("message", "Użytkownik o podanym ID nie istnieje");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        } else {
            userDao.delete(id);
            request.setAttribute("message", "Użytkownik został usunięty");
            getServletContext().getRequestDispatcher("/user/list").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
