package ma.moktafi.inject.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ma.moktafi.inject.dao.IUserDAO;
import ma.moktafi.inject.dao.UserDAO;
@Configuration
@ComponentScan(basePackages = "ma.moktafi.inject.web")
public class Injection {
		@Bean
		public IUserDAO getmetier() {
			return new UserDAO();
		}

}
//<context:component-scan> analyse uniquement @Component 
//l�annotation @Configuration joue un r�le central. Les classes o� elle est appos�e 
//se substituent en effet aux traditionnels fichiers de configuration
//la configuration et l�initialisation d�un bean 
//Spring est r�alis� dans une m�thode annot�e par @Bean.