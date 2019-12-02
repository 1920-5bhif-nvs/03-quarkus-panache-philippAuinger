package at.htl.supermarket.boundary;

import at.htl.supermarket.business.CashierRepository;
import at.htl.supermarket.model.Cashier;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cashier")
public class CashierEndpoint {

    @Inject
    CashierRepository cashierRepository;

    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCashiers(){
        List<Cashier> responseList;
        responseList = cashierRepository.getAll();
        return Response.ok().entity(responseList).build();
    }
}
