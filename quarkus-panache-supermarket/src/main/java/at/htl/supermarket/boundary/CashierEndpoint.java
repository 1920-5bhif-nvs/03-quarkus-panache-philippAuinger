package at.htl.supermarket.boundary;

import at.htl.supermarket.business.CashierRepository;
import at.htl.supermarket.model.Cashier;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cashier")
@Transactional
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
    /*
    {
        "firstname": "Philipp",
        "lastname": "Geld",
        "birthdate": [
            2000,
            12,
            13
        ],
        "mobilePhone": "+66 43242342",
        "email": "",
        "begin_date": [
            2019,
            2,
            12
        ],
        "salary": 2999.1
    }
    */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCashier(Cashier cashier){
        Cashier newCashier = cashierRepository.save(cashier);
        return Response.ok().entity(newCashier).build();
    }

    /*
    {
        "id": 12,
        "firstname": "Susanna",
        "lastname": "Moneten",
        "birthdate": [
            1999,
            7,
            5
        ],
        "mobilePhone": "+66 43242342",
        "email": "",
        "begin_date": [
            2000,
            1,
            1
        ],
        "salary": 2300.2
    }
     */

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putCashier(Cashier cashier){
        Cashier updatedCashier = cashierRepository.update(cashier);
        if(updatedCashier != null) {
            return Response.ok().entity(updatedCashier).build();
        } else {
            return Response.status(404).build();
        }
    }

    /*
    {
        "id": 21,
        "firstname": "Philipp",
        "lastname": "Geld",
        "birthdate": [
            2000,
            12,
            13
        ],
        "mobilePhone": "+66 43242342",
        "email": "",
        "begin_date": [
            2019,
            2,
            12
        ],
        "salary": 2999.1,
        "persistent": false
    }
    */

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCashier(Cashier cashier){
        Cashier deletedCashier = cashierRepository.deleteCashier(cashier);
        if(deletedCashier != null) {
            return Response.ok().build();
        } else {
            return Response.status(404).build();
        }
    }
}
