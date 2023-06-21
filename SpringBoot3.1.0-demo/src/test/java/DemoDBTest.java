import com.demo.config.MyDaoAutoConfiguration;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * @author 伍六七
 * @date 2023/6/19 15:30
 */
@SpringBootTest(classes = MyDaoAutoConfiguration.class)
public class DemoDBTest {
    @Resource(name = "mysqlConnection")
    private Connection connection;

    @Test
    void test() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("select * from favorites");
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (resultSet.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = resultSet.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
        resultSet.close();
    }
}
