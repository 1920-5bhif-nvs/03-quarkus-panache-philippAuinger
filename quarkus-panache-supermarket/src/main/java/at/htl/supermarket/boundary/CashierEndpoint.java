package at.htl.supermarket.boundary;

import at.htl.supermarket.business.CashierRepository;
import at.htl.supermarket.model.Cashier;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCashier(Cashier cashier){
        Cashier newCashier = cashierRepository.save(cashier);
        return Response.ok().entity(newCashier).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putCashier(Cashier cashier){
        Cashier updatedCashier = cashierRepository.update(cashier);
        return Response.ok().entity(updatedCashier).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCashier(Cashier cashier){
        cashierRepository.delete(cashier);
        return Response.ok().build();
    }
}
