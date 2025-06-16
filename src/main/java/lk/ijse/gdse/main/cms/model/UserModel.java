package lk.ijse.gdse.main.cms.model;

import lk.ijse.gdse.main.cms.dto.UserDTO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
    public static boolean findUser(UserDTO userDTO,  BasicDataSource dataSource) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username=? AND password=? AND role=?");
            preparedStatement.setString(1, userDTO.getUsername());
            preparedStatement.setString(2, userDTO.getPassword());
            preparedStatement.setString(3, userDTO.getRole());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean saveUser(UserDTO userDTO, BasicDataSource dataSource) {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users(fullname,username,password,role) values(?,?,?,?)");
            preparedStatement.setString(1, userDTO.getFullName());
            preparedStatement.setString(2, userDTO.getUsername());
            preparedStatement.setString(3, userDTO.getPassword());
            preparedStatement.setString(4, userDTO.getPassword());
            int i = preparedStatement.executeUpdate();

            if (i > 0) {
                return true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
