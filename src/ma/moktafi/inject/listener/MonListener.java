package ma.moktafi.inject.listener;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ma.moktafi.inject.annotations.Injection;
import ma.moktafi.inject.dao.IUserDAO;

public class MonListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try
		{
			
			//Reflexivité
			Scanner scanner = new Scanner(new File("C:\\Users\\ELMOUKTAFI\\Desktop\\expIOCspring1\\config.txt"));
			String name = scanner.next();
			Class udao = Class.forName(name);		
			Constructor daoconst = (Constructor) udao.getConstructor();
			IUserDAO daoInstaance = (IUserDAO) daoconst.newInstance();
			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("mydao",daoInstaance);
			
			//Xml
			//ApplicationContext appctx1 = new ClassPathXmlApplicationContext("springconf.xml");
			//event.getServletContext().setAttribute("appctx1",appctx1);
			
			//Annotations
			//ApplicationContext appctx2 = new AnnotationConfigApplicationContext(Injection.class);
			//event.getServletContext().setAttribute("appctx2",appctx2);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
