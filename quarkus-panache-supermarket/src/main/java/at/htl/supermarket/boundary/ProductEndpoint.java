package at.htl.supermarket.boundary;

import at.htl.supermarket.business.ActivityRepository;
import at.htl.supermarket.model.Activity;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("product")
public class ProductEndpoint {

    @Inject
    ActivityRepository activityRepository;

    @GET
    @Path("soldProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSoldProductsSorted() {
        List<Activity> responseList;
        responseList = activityRepository.getSoldProductsSortedByDate();

        return Response.ok().entity(responseList).build();
    }

    @GET
    @Path("soldProducts/{cashier_lastname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSoldProductsByCashierLastname(@PathParam("cashier_lastname") String cashier_lastname){
        List<Activity> responseList;
        responseList = activityRepository.getSoldProductsByCashier(cashier_lastname);
        if(responseList.size() > 0){
            return Response.ok().entity(responseList).build();
        } else {
            return Response.noContent().build();
        }
    }
}
