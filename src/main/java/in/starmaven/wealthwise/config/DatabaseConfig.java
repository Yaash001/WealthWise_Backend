/*package in.starmaven.wealthwise.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import javax.sql.DataSource;
import liquibase.integration.spring.SpringLiquibase;
// import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "in.starmaven.wealthwise.repository")
@EntityScan(basePackages = "in.starmaven.wealthwise.model")
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String databaseUsername;
    @Value("${spring.datasource.password}")
    private String databasePassword;
    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;
    @Value("${spring.datasource.default.schema}")
    private String databaseDefaultSchema;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    @Bean("dataSource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .url(databaseUrl)
                .username(databaseUsername)
                .password(databasePassword)
                .driverClassName(databaseDriver)
                .build();
    }

    @Bean("wealthwiseLiquibase")
    public SpringLiquibase springCoreLiquibase(@Qualifier("dataSource") DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/master-liquibase-changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
        Properties jpaProps = new Properties();
        jpaProps.setProperty("hibernate.show_sql", "false");
        jpaProps.setProperty("hibernate.default_schema", databaseDefaultSchema);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform(hibernateDialect);
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("in.starmaven.wealthwise.entity");
        em.setJpaProperties(jpaProps);
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean("transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
*/