package lk.ijse.gdse.main.cms.db;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class DBCP implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cms");
        dataSource.setUsername("root");
        dataSource.setPassword("Ijse@1234");
        dataSource.setInitialSize(50);
        dataSource.setMaxTotal(100);

        sce.getServletContext().setAttribute("dataSource", dataSource);

    }
    public void contextDestroyed(ServletContextEvent sce) {
        BasicDataSource dataSource = (BasicDataSource) sce.getServletContext().getAttribute("dataSource");
        try {
            dataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
