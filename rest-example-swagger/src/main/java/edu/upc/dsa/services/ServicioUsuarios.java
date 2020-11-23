package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.CovidImpl;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Api(value = "/Usuarios", description = "Endpoint to Usuarios Service")
@Path("/Users")
public class ServicioUsuarios {
    final Covid19Manager c;

    public ServicioUsuarios() {
        this.c = CovidImpl.getInstance();

        this.c.addUsuario("SFFOEMDKD", "Nico","Sanz",21,"B");
        this.c.addUsuario("ODJDKSODS", "Pau", "Perez", 18, "C");
        this.c.addUsuario("XCNSKNSJK", "Cristian", "Jimenez",50, "A");
        this.c.addUsuario("SJBDNCMSN", "Mariam","Berz",12,"D");

    }



    @GET
    @ApiOperation(value = "get a Usuario", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") String id) {
        Usuario u = this.c.getUsuario(id);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
    }

    @POST
    @ApiOperation(value = "Crear nuevo Usuario", notes = "---")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuario usuario) {

        if (usuario.getIdUsuario()==null || usuario.getNombre()==null || usuario.getApellido()==null || usuario.getEdad()==0 || usuario.getSalud()==null)  return Response.status(500).entity(usuario).build();
        this.c.addUsuario(usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(),usuario.getEdad(),usuario.getSalud());
        return Response.status(201).entity(usuario).build();
    }

    @GET
    @ApiOperation(value = "get all users in the list", notes = "x")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class, responseContainer = "List of Users")
    })
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        HashMap<String, Usuario> users  = this.c.todosUsuarios();

        GenericEntity<HashMap<String, Usuario>> entity = new GenericEntity<HashMap<String, Usuario>>(users){};
        return Response.status(201).entity(entity).build();
    }
}
