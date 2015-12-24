/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.CoordenadaAreaDao;
import ec.gob.arcom.migracion.modelo.CoordenadaArea;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "CoordenadaAreaDao")
public class CoordenadaAreaDaoEjb extends GenericDaoEjbEl<CoordenadaArea, Long> implements
        CoordenadaAreaDao {

    public CoordenadaAreaDaoEjb() {
        super(CoordenadaArea.class);
    }

    @Override
    public CoordenadaArea findByCodigoAreaOrden(Long codigoArea, BigInteger orden) {
        try {
            String hql = "select ca from CoordenadaArea ca where ca.codigoArea.codigoAreaMinera = :codigoArea and ca.numeroCoordenada = :orden";
            Query query = em.createQuery(hql);
            query.setParameter("codigoArea", codigoArea);
            query.setParameter("orden", orden);

            CoordenadaArea ca = (CoordenadaArea) query.getSingleResult();
            this.refresh(ca);
            return ca;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

    @Override
    public List<CoordenadaArea> findByCodigoArea(Long codigoArea) {
        String jpql = "select ca from CoordenadaArea ca where ca.codigoArea.codigoAreaMinera = :codigoArea";
            Query query = em.createQuery(jpql);
            query.setParameter("codigoArea", codigoArea);

        return query.getResultList();
    }

}
