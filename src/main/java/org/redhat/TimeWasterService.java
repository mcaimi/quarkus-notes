package org.redhat;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@RequestScoped
public class TimeWasterService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String wasteTime(long milliseconds) throws InterruptedException {
        String response = "";
        try {
            Thread.sleep(milliseconds);
            response = "Wasted a little time: " + milliseconds + "ms.";
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return response;
    }
}