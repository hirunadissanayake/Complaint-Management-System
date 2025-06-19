package lk.ijse.gdse.main.cms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.main.cms.dto.UserDTO;
import lk.ijse.gdse.main.cms.model.UserModel;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;

@WebServlet("/signup")
public class SignUpServelet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String fullname = req.getParameter("fullName");
        String email = req.getParameter("email");
        String role = req.getParameter("role");

        BasicDataSource dataSource = (BasicDataSource) req.getServletContext().getAttribute("dataSource");
        boolean isSave = UserModel.saveUser(new UserDTO( username,password,fullname,email,role), dataSource);
        if (isSave) {
            System.out.println("Save User...");
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("message", "Failed to register. Try again.");
            req.getRequestDispatcher("/pages/signup.jsp").forward(req, resp);
        }
    }

}
