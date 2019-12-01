package at.htl.supermarket.boundary;

import at.htl.supermarket.business.CustomerRepository;
import at.htl.supermarket.model.Customer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customer")
public class CustomerEndpoint {

    @Inject
    CustomerRepository customerRepository;

    @GET
    @Path("loyality")
    public Response getAllSortedByLoyality(){
        List<Customer> responseList = customerRepository.getAllSortedByLoyalityPoints();
        if(responseList!=null) {
            return Response.ok().entity(responseList).build();
        } else {
            return Response.noContent().build();
        }
    }
}
