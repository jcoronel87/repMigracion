/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.UsuarioRolDao;
import ec.gob.arcom.migracion.modelo.UsuarioRol;
import ec.gob.arcom.migracion.modelo.UsuarioRolPK;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "UsuarioRolDao")
public class UsuarioRolDaoEjb extends GenericDaoEjbEl<UsuarioRol, UsuarioRolPK> implements
        UsuarioRolDao {

    public UsuarioRolDaoEjb() {
        super(UsuarioRol.class);
    }

    @Override
    public UsuarioRol obtenerPorCodigoUsuario(Long codigoUsuario) {
        try {
            String jpql = "select ur from UsuarioRol ur where ur.usuarioRolPK.codigoUsuario = :codigoUsuario";
            Query query = em.createQuery(jpql);
            query.setParameter("codigoUsuario", codigoUsuario);
            UsuarioRol usuarioRol = (UsuarioRol) query.getSingleResult();
            this.refresh(usuarioRol);
            return usuarioRol;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

}
