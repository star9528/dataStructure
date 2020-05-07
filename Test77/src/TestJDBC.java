import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class TestJDBC {
    public static void main(String[] args) {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL();
        ((MysqlDataSource)dataSource).setUser();
        ((MysqlDataSource)dataSource).setPassword();
    }
}
