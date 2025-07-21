package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;
import persistencia.exceptions.NonexistentEntityException;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearUsuario(Usuario usu){
        controlPersis.crearUsuario(usu);    
    }

    public List<Usuario> traerUsuarios(){
        return controlPersis.traerUsuarios();
    }    

    public void borraUsuario(int id_eliminar) throws NonexistentEntityException {
        controlPersis.borrarUsuario(id_eliminar);
    }

    public Usuario traerUsuario(int id_editar) {
        return controlPersis.traerUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        controlPersis.editarUsuario(usu);
    }
}
