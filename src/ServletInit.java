 
//import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
//import org.apache.log4j.PropertyConfigurator;
 
//@WebListener("application context listener")
public class ServletInit implements ServletContextListener {
 

    @Override
    public void contextInitialized(ServletContextEvent event) 
    {
    	System.out.println("Inicializando parametros del sitema CEBT-Struts....");
        // initialize log4j here
    	
    	System.out.println("Carga de parametros finalizada CEBT-Struts inciando...");
        
         
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }  
}