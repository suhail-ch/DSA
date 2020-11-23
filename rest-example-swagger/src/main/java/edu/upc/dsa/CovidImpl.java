package edu.upc.dsa;

import edu.upc.dsa.models.Lab;
import edu.upc.dsa.models.Muestra;
import edu.upc.dsa.models.Usuario;

import java.util.*;
import org.apache.log4j.Logger;

public class CovidImpl implements Covid19Manager {

    final static Logger log = Logger.getLogger(CovidImpl.class);


    private static Covid19Manager instance;

    final LinkedList<Muestra> muestras;
    final List<Lab> labs;
    final HashMap<String, Usuario> usuarios;


    public static Covid19Manager getInstance() {
        if (instance == null) instance = new CovidImpl();
        return instance;
    }

    public CovidImpl() {
        this.usuarios = new HashMap<>();
        this.labs = new ArrayList<>();
        this.muestras = new LinkedList<>();
    }


    public int size() {
        log.info("Tamaño: " + this.labs.size());
        return this.labs.size();
    }

    @Override
    public void addUsuario(String idUsuario, String nombre,String apellido, int edad, String salud) {
        log.info("Nuevo usuario: " + nombre);
        usuarios.put(idUsuario, new Usuario(idUsuario, nombre,apellido, edad, salud));
        log.info("Nuevo usuario añadido");
    }


    @Override
    public Usuario getUsuario(String idUsuario) {
        log.info("getUsuario(" + idUsuario + ")");
        Usuario usuario = this.usuarios.get(idUsuario);
        log.info("Usuario: " + usuario);
        return usuario;
    }

    public HashMap<String, Usuario> todosUsuarios(){
        for (Map.Entry<String, Usuario> stringUserEntry : usuarios.entrySet()) {
            log.info(((Map.Entry) stringUserEntry).getKey() + " " + ((Map.Entry) stringUserEntry).getValue());
        }
        return null;
    }

    public void addLab(Lab p) {
        this.labs.add(p);
    }


    private Lab getLab(String lab) {

        Lab p = null;
        for (Lab lab1 : this.labs) {
            if (lab.equals(lab1.nombre)) {
                p = lab1;
            }
        }
        return p;
    }


    @Override
    public List<Lab> allProducts() {
        List<Lab> ret = new ArrayList<>(this.labs);
        log.info("Todos los products: " + ret);
        return ret;
    }


    @Override
    public void addMuestra(String idUsuario, Muestra p) throws UsuarioNotFoundException {

        Usuario theUser = this.usuarios.get(idUsuario);

        if (theUser != null) {
            p.setUsuario(theUser);
            this.muestras.add(p);
        }
        else {
            throw new UsuarioNotFoundException();
        }
    }


    public Muestra getMuestra(){
        Muestra o =this.muestras.pop();
        Usuario u = o.getUsuario();
        u.addMuestra(o);
        return o;
    }

    public LinkedList<Muestra> getAllOrdersOfAUser(String user) throws UsuarioNotFoundException{
        LinkedList<Muestra> orders;
        Usuario theUser = this.usuarios.get(user);

        if(theUser!=null)
            orders = theUser.getOrderList();
        }
        else {
            throw new UsuarioNotFoundException();
        }
        return muestras;
    }
}

