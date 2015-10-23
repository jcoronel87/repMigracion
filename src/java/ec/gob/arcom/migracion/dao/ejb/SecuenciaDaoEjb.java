/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.SecuenciaDao;
import ec.gob.arcom.migracion.modelo.Secuencia;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "SecuenciaDao")
public class SecuenciaDaoEjb extends GenericDaoEjbEl<Secuencia, Long> implements
        SecuenciaDao {

    public SecuenciaDaoEjb() {
        super(Secuencia.class);
    }

    @Override
    public Secuencia obtenerPorTabla(String nombreTabla) {
        String hql = "select s from Secuencia s where s.tabla = :nombreTabla";
        Query query = em.createQuery(hql);
        query.setParameter("nombreTabla", nombreTabla);
        Secuencia secuencia = (Secuencia) query.getSingleResult();
        this.refresh(secuencia);
        return secuencia;
    }

}
