import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

public class Keys {
    @Bean
    @Primary
    @ConfigurationProperties("mysql.connection1")
    public DataSourceProperties connectionProp1() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("mysql.connection1")
    public DataSource connection1() {
        return connectionProp1().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    @ConfigurationProperties("mysql.connection2")
    public DataSourceProperties connectionProp2() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("mysql.connection2")
    public DataSource connection2() {
        return connectionProp2().initializeDataSourceBuilder().build();
    }
}
