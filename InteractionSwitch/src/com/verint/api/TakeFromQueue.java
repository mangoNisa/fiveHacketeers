package com.verint.api;

import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jackson.map.ObjectMapper;

import com.verint.ApplicationStatus;
import com.verint.InteractionManager;
import com.verint.implementation.Interaction;

@Path("/takefromqueue")
public class TakeFromQueue {
	
	@javax.ws.rs.core.Context 
	private ServletContext  ctx;
    
    @GET
    @Produces("application/json")
    public String getById(@QueryParam("interactionId") int id) {
        try {
            
            ObjectMapper mapper = new ObjectMapper();
        	ApplicationStatus appStatus = (ApplicationStatus) ctx.getAttribute("appStatus");  
            InteractionManager interactionManager = appStatus.getInteractionManager();
            List<Interaction> allInteractions = interactionManager.getAllInteractions();
            Iterator<Interaction> it = allInteractions.iterator();
            while(it.hasNext()) {
            	Interaction interaction = it.next();
            	if(interaction.getId() == id){
            		it.remove();
            		return mapper.writeValueAsString(interaction);		
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
