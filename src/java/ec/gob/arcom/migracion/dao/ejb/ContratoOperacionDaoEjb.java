/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.ContratoOperacionDao;
import ec.gob.arcom.migracion.modelo.ContratoOperacion;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Javier Coronel
 */
@Stateless(name = "ContratoOperacionDao")
public class ContratoOperacionDaoEjb extends GenericDaoEjbEl<ContratoOperacion, Long> implements
        ContratoOperacionDao {

    public ContratoOperacionDaoEjb() {
        super(ContratoOperacion.class);
    }

    @Override
    public ContratoOperacion findByPk(Long codigoContratoOperacion) {
        try {
            String jpql = "select co from ContratoOperacion co where co.codigoContratoOperacion = :codigoContratoOperacion";
            Query query = em.createQuery(jpql);
            query.setParameter("codigoContratoOperacion", codigoContratoOperacion);
            ContratoOperacion co = (ContratoOperacion) query.getSingleResult();
            this.refresh(co);
            return co;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

}
