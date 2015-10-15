/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.RegistroPagoObligacionesDao;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "RegistroPagoObligacionesDao")
public class RegistroPagoObligacionesDaoEjb extends GenericDaoEjbEl<RegistroPagoObligaciones, Long> implements
        RegistroPagoObligacionesDao {

    public RegistroPagoObligacionesDaoEjb() {
        super(RegistroPagoObligaciones.class);
    }

    @Override
    public RegistroPagoObligaciones obtenerPorCodigoRegistroPagoObligaciones(Long codigoRegistroPagoObligaciones) {
        try {
            String hql = "select rpo from RegistroPagoObligaciones rpo where rpo.codigoRegistro = :codigoRegistroPagoObligaciones";
            Query query = em.createQuery(hql);
            query.setParameter("codigoRegistroPagoObligaciones", codigoRegistroPagoObligaciones);
            RegistroPagoObligaciones registroPagoObligaciones = (RegistroPagoObligaciones) query.getSingleResult();
            this.refresh(registroPagoObligaciones);
            return registroPagoObligaciones;
        } catch (NoResultException nrException) {
            return null;
        }
    }

}
