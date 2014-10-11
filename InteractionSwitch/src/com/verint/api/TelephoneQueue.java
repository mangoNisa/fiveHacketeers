package com.verint.api;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.map.ObjectMapper;

import com.verint.ApplicationStatus;
import com.verint.InteractionManager;


@Path("/activequeue")
public class TelephoneQueue {
    // The Java method will process HTTP GET requests
	@javax.ws.rs.core.Context 
	private ServletContext  ctx;
	
    @GET
    @Produces("application/json")
    public String getPendingCalls() {
        try {
        	ApplicationStatus appStatus = (ApplicationStatus) ctx.getAttribute("appStatus");  
            InteractionManager contactManager = appStatus.getInteractionManager();
            ObjectMapper mapper = new ObjectMapper();

            return mapper.writeValueAsString(contactManager.getAllInteractions());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
