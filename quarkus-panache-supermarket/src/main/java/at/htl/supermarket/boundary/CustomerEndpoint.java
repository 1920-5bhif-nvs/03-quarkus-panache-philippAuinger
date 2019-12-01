package at.htl.supermarket.boundary;

import at.htl.supermarket.business.CustomerRepository;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("customer")
public class CustomerEndpoint {

    @Inject
    CustomerRepository customerRepository;
    
}
