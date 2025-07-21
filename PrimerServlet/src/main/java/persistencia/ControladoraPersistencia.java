package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityNotFoundException;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public void crearUsuario(Usuario usu){
        usuJpa.create(usu);
    }

    public List<Usuario> traerUsuarios(){
        return usuJpa.findUsuarioEntities();
    }

    public void borrarUsuario(int id_eliminar) throws NonexistentEntityException {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (EntityNotFoundException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }

    public Usuario traerUsuario(int id_editar) {
        return usuJpa.findUsuario(id_editar);
    }

    public void editarUsuario(Usuario usu) {
        try {
            usuJpa.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}