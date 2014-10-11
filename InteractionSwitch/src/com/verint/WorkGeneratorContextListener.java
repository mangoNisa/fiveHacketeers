package com.verint;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.verint.implementation.CustomerDataManager;


public class WorkGeneratorContextListener implements ServletContextListener{

    private static final int REAL_TICK_TIME = 50;
	private static final int DIFFICULTY = 70;

	public void contextInitialized(ServletContextEvent sce) {
    	CustomerDataManager customerDataManager = createCustomerManager(sce);
    	
    	TelephonySwitch telephonySwitch = new TelephonySwitch(new CallGenerator(customerDataManager), new InteractionManager(), DIFFICULTY, REAL_TICK_TIME);
        ApplicationStatus appStatus = new ApplicationStatus(telephonySwitch);
        WorkGenerator  workGenerator = new WorkGenerator(appStatus);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(workGenerator);
        ServletContext ctx=sce.getServletContext();  
        ctx.setAttribute("appStatus", appStatus);  
    }

	private CustomerDataManager createCustomerManager(ServletContextEvent sce) {
		 URL customerDataFileUrl = null;
    	 CustomerDataManager customerDataManager = new CustomerDataManager();
         try {
             customerDataFileUrl = sce.getServletContext().getResource("/WEB-INF/resources/customerData.json");
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
         customerDataManager.loadCustomerData(new File(customerDataFileUrl.getPath()));
		return customerDataManager;
	}

    public void contextDestroyed(ServletContextEvent sce){
        
    }
}

