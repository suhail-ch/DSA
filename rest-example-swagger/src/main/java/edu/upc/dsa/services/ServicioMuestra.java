package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.CovidImpl;
import edu.upc.dsa.UsuarioNotFoundException;
import edu.upc.dsa.models.Lab;
import edu.upc.dsa.models.Muestra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Api(value = "/Orders", description = "Endpoint to Order Service")
@Path("/Orders")
public class ServicioMuestra {

    final static Logger log = Logger.getLogger(ServicioMuestra.class.getName());

    private Covid19Manager f;

    public ServicioMuestra() {
        this.f = CovidImpl.getInstance();

            Lab producto1 = new Lab("JKL","LLL");
            Lab producto2 = new Lab("SDFG", "FTG");
            Lab producto3 = new Lab("TYU", "CBH");
            Lab producto4 = new Lab("AWQ", "VPO");
            f.addLab(producto1);
            f.addLab(producto2);
            f.addLab(producto3);
            f.addLab(producto4);

            this.f.addUsuario("SFFOEMDKD", "Nico","Sanz",21,"B");
            this.f.addUsuario("ODJDKSODS", "Pau", "Perez", 18, "C");
            this.f.addUsuario("XCNSKNSJK", "Cristian", "Jimenez",50, "A");
            this.f.addUsuario("SJBDNCMSN", "Mariam","Berz",12,"D");

    }

    @POST
    @ApiOperation(value = "add Order", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/placeanorder")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addOrder(Muestra o) throws UsuarioNotFoundException {

        String idUser = o.getUsuario().getIdUsuario();

        try {
            this.f.addMuestra(idUser, o);
            return Response.status(201).build();
        } catch (UsuarioNotFoundException e) {
            e.printStackTrace();
            return Response.status(404).build();
        }
    }

    @DELETE
    @ApiOperation(value = "serve an Muestra", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Muestra.class, responseContainer = "Muestra")
    })
    @Path("/serveanorder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response serveAnOrder(){
        Muestra pedido = this.f.getMuestra();

        return Response.status(201).entity(pedido).build();
    }

}
