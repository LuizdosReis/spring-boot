package controleGastos;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class Configuracao {
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
		
		managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		managerDataSource.setUrl("jdbc:mysql://localhost:3306/controle_gastos");
		managerDataSource.setUsername("root");
		managerDataSource.setPassword("root");
		return managerDataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorApapter() {
	    return new HibernateJpaVendorAdapter();
	}
	
	private Properties jpaProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.hbm2ddl.auto", "update");
	    return properties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	    LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	    emf.setDataSource(dataSource());
	    emf.setPackagesToScan("controleGastos.model");
	    emf.setJpaVendorAdapter(jpaVendorApapter());
	    emf.setJpaProperties(jpaProperties());
	    return emf;
	}
	

	
	
	
}
