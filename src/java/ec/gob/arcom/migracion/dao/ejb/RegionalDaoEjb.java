/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.RegionalDao;
import ec.gob.arcom.migracion.modelo.Regional;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "RegionalDao")
public class RegionalDaoEjb extends GenericDaoEjbEl<Regional, Long> implements
        RegionalDao {

    public RegionalDaoEjb() {
        super(Regional.class);
    }

    @Override
    public Regional findByPk(Long id) {
        StringBuilder hql = new StringBuilder(100);
        hql.append("select r from Regional r where ");
        hql.append("r.codigoRegional = :id ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("id", id);

        Regional regional = (Regional) query.getSingleResult();
        this.refresh(regional);
        return regional;
    }

    @Override
    public Regional findByNemonico(String nemonico) {
        StringBuilder hql = new StringBuilder(100);
        hql.append("select r from Regional r where ");
        hql.append("r.nemonicoRegional = :nemonico ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("nemonico", nemonico);

        Regional regional = (Regional) query.getSingleResult();
        this.refresh(regional);
        return regional;
    }

    @Override
    public Regional findByNombre(String nombre) {
        StringBuilder hql = new StringBuilder(100);
        hql.append("select r from Regional r where ");
        hql.append("c.nombreRegional = :nombre ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("nombre", nombre);

        Regional regional = (Regional) query.getSingleResult();
        this.refresh(regional);
        return regional;
    }

    @Override
    public String findByCedulaRuc(String cedulaRuc) {
        String sql = "select nombre_regional from catmin.regional r, catmin.localidad_regional lr\n"
                + "where lr.codigo_localidad =  (select codigo_provincia from catmin.usuario where numero_documento = '" + cedulaRuc + "') \n"
                + "and lr.codigo_regional = r.codigo_regional";
        try {
            Query query = em.createNativeQuery(sql);
            String regional = query.getSingleResult().toString();
            return regional;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

}
