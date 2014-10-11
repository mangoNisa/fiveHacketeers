package com.verint.api;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.ObjectMapper;

import com.verint.ApplicationStatus;
import com.verint.InteractionManager;

// The Java class will be hosted at the URI path "/dashboardinformation"
@Path("/getalldroppedcalls")
public class GetAllDroppedCalls {
	
	@javax.ws.rs.core.Context 
	private ServletContext  ctx;
	
    @GET
    @Produces("application/json")
    public String getAllDropped() {
    	 try {
         	ApplicationStatus appStatus = (ApplicationStatus) ctx.getAttribute("appStatus");  
             InteractionManager contactManager = appStatus.getInteractionManager();
             ObjectMapper mapper = new ObjectMapper();

             return mapper.writeValueAsString(contactManager.getInteractionsDropped());
         } catch (Exception e) {
             e.printStackTrace();
         }
         return null;
        
    }
}
