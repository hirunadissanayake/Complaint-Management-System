package lk.ijse.gdse.main.cms.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.ijse.gdse.main.cms.dto.UserDTO;
import lk.ijse.gdse.main.cms.model.UserModel;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");

        boolean isValidUser = UserModel.findUser(new UserDTO(username, password,role),dataSource);
        System.out.println(isValidUser);

        if (isValidUser) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            // Redirect based on role
            if ("admin".equalsIgnoreCase(role)) {
                resp.sendRedirect("admindashboard.jsp");
            } else if ("employee".equalsIgnoreCase(role)) {
                resp.sendRedirect("employeedashboard.jsp");
            }
        } else {
            req.setAttribute("error", "Invalid credentials or role.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
