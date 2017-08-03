package controleGastos;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
	
}
