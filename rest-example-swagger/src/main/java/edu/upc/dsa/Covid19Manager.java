package edu.upc.dsa;

import edu.upc.dsa.models.Lab;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Usuario;

import javax.validation.constraints.Future;
import java.util.HashMap;
import java.util.List;

public interface Covid19Manager {

    void addUsuario(String idUsuario, String nombre, String apellido, int edad, String salud);
    Usuario getUsuario(String idUsuario);

    void addMuestra(String idUsuario, Muestra p) throws UsuarioNotFoundException;                                         //Operació: Afegir ordre al sistema
    Muestra getMuestra();

    HashMap<String, Usuario> todosUsuarios();
    int size();

    void addLab(Lab p);
    void addLab(String nombre, String idetificador);

    List<Lab> todosLabs();



//    LinkedList<Order> getAllOrdersOfAUser(String user) throws UserNotFoundException;                        //Operació: Histrial comandas determiant usuari
//    List<Product> productsBySales();                                //Operació: Productes ordenats per venta
//
//    List<Product> allProducts();

}
