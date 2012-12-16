
package Controladores;

import javax.swing.*;
import DAO.UsuarioJpaController;
import DAO.TarjetaJpaController;
import Logica.Usuario;
import Logica.Tarjeta;
import javax.persistence.EntityManager;
import Controladores.FabricaObjetos;
import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
import java.util.Iterator;

public class ControladorUsuario {
    
    
    
     String matricula;
     String estado;
     String ano;
     String fabricante;
     String capacidad;
     String cilindrinaje;
     String chasis;
     String tipoBus;
     
     private FabricaObjetos mi_fabrica;    
     UsuarioJpaController DaoUsuario;
     TarjetaJpaController DaoTarjeta;
     EntityManager manager;
     

   
    public ControladorUsuario()
    {
       mi_fabrica = new FabricaObjetos();   
       manager= mi_fabrica.crear().createEntityManager();

       //se requiere ingresar por parametro una fabrica de objetos para manipular las entidades (crear, modificar..en fin)
       DaoUsuario = new UsuarioJpaController(mi_fabrica.getFactory());
    }
    
    public Usuario consultarUsuario(String pin)
    {
         Iterator i;
            //sirve para ejecutar consultas
        
            i = manager.createQuery("SELECT u FROM Usuario u WHERE (u.pinTarjeta = '"+pin+"')").getResultList().iterator();
            System.out.print("id |\t Nombre  |\t serial |\t proveedor\n");
            
            Usuario myusuario = new Usuario();
            
            while(i.hasNext())
            {
                myusuario = (Usuario) i.next();
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.println(myusuario.getIdUsuario()+"\t"+myusuario.getNombre()+"\t"+myusuario.getCiudad()+"\t"+myusuario.getDireccion()+"\t"+myusuario.getTelefono()+"\t"+myusuario.getPinTarjeta());
            }
            return myusuario;
         
    }
    
    public void agregarUsuario(String idUsuario, String nombre,  String ciudad, String direccion, String telefono, String pinTarjeta) throws PreexistingEntityException, Exception
    {
        Usuario myusuario = new Usuario();
        Tarjeta tarjeta = new Tarjeta();
        myusuario.setIdUsuario(idUsuario);
        myusuario.setNombre(nombre);
        myusuario.setCiudad(ciudad);
        myusuario.setDireccion(direccion);
        myusuario.setTelefono(telefono);
        myusuario.setPinTarjeta(tarjeta);
        

        DaoUsuario.create(myusuario);
    }
    
    public void editarUsuario(String idUsuario,String nombre,String ciudad,String direccion,String telefono,String pinTarjeta)
    {
        Usuario usuarioEncontrado = DaoUsuario.findUsuario(idUsuario);
        Tarjeta tarjeta = DaoTarjeta.findTarjeta(pinTarjeta);
        
        usuarioEncontrado.setIdUsuario(idUsuario);
        usuarioEncontrado.setNombre(nombre);
        usuarioEncontrado.setCiudad(ciudad);
        usuarioEncontrado.setDireccion(direccion);
        usuarioEncontrado.setTelefono(telefono);
        usuarioEncontrado.setPinTarjeta(tarjeta);
        
        
        try 
        {   
            DaoUsuario.edit(usuarioEncontrado);
            
        }
        catch (NonexistentEntityException ex) 
        {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex) 
        {
            System.out.println(ex.getMessage());
        }
    }     
    
    public void eliminarUsuario(String idUsuario) throws IllegalOrphanException, NonexistentEntityException
    {
        DaoUsuario.destroy(idUsuario);
    }
    
    
    
}
