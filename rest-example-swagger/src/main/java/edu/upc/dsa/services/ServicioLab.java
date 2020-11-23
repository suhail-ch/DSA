package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.CovidImpl;
import edu.upc.dsa.models.Lab;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Api(value = "/Products", description = "Endpoint to Product Service")
@Path("/Products")
public class ServicioLab {

    private Covid19Manager r;

    public ServicioLab () {
        this.r = CovidImpl.getInstance();
        Lab producto1 = new Lab("JKL","LLL");
        Lab producto2 = new Lab("SDFG", "FTG");
        Lab producto3 = new Lab("TYU", "CBH");
        Lab producto4 = new Lab("AWQ", "VPO");
        r.addLab(producto1);
        r.addLab(producto2);
        r.addLab(producto3);
        r.addLab(producto4);
    }

//    @POST
//    @ApiOperation(value = "create a new Product", notes = "---")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response=Lab.class),
//            @ApiResponse(code = 500, message = "Validation Error")
//
//    })

//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response newProduct(Product product) {
//
//        if (product.getName()==null || product.getDescription()==null || product.getPrize()==0)  return Response.status(500).entity(product).build();
//        this.r.addProducto(product);
//        return Response.status(201).entity(product).build();
//    }
//
//    @GET
//    @ApiOperation(value = "get all Products", notes = "---")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List of all products"),
//    })
//    @Path("/")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getProducts() {
//
//        List<Product> products = this.g.allProducts();
//
//        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
//        return Response.status(201).entity(entity).build()  ;
//
//    }
//
//    @GET
//    @ApiOperation(value = "get all products sorted by price", notes = "---")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer = "List of Products")
//    })
//    @Path("/sortedbyprice")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getProductsSortedByPrice() {
//        List<Product> products = this.g.productsByPrize();
//
//        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
//        return Response.status(201).entity(entity).build();
//    }
//
//    @GET
//    @ApiOperation(value = "get all products sorted by number of sales", notes = "x")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer = "List of Products")
//    })
//    @Path("/sortedbysales")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getOrders() {
//        List<Product> productos  = this.g.productsBySales();
//
//        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(productos){};
//        return Response.status(201).entity(entity).build();
//    }
}
