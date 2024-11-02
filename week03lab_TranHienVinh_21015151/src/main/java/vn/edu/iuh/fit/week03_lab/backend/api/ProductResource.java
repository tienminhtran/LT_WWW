package vn.edu.iuh.fit.week03_lab.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.week03_lab.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.week03_lab.backend.repositories.entities.Product;

@Path("/products")
public class ProductResource {
    @EJB
    private ProductBeanRemote productBean;
    @GET
    @Produces("application/json")
    public Response getAll() {
        return Response.ok(productBean.getAll()).build();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/{id}")
    public Response getById(@PathParam("id") int id) {
        return Response.ok(productBean.getById(id)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response add(Product product) {
        productBean.add(product);
        return Response.ok(product).build();
    }
}