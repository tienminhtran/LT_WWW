package vn.edu.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.business.ProductBeanRemote;
import vn.edu.iuh.fit.backend.repositories.entities.Product;

@Path("/products")
public class ProductResource {


    @EJB
    public ProductBeanRemote productBean;

    @GET
    @Produces("application/json")
    public Response getProduct(){
        return Response.ok(productBean.getAllProducts()).build();
    }
    @GET
    @Path("/{id}")
    public Response getProductById(int id){
        return Response.ok(productBean.getProductById(id)).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Transactional
    public Response add(Product product){
        try {
            Product p = productBean.addProduct(product);
            return Response.status(Response.Status.CREATED).entity(p).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


}
