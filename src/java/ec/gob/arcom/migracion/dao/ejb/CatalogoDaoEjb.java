/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.CatalogoDao;
import ec.gob.arcom.migracion.modelo.Catalogo;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "CatalogoDao")
public class CatalogoDaoEjb extends GenericDaoEjbEl<Catalogo, Long> implements
        CatalogoDao {

    public CatalogoDaoEjb() {
        super(Catalogo.class);
    }

    @Override
    public Catalogo findByPk(Long id) {
        StringBuilder hql = new StringBuilder(100);
        hql.append("select c from Catalogo c where ");
        hql.append("c.id = :id ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("id", id);

        Catalogo catalogo = (Catalogo) query.getSingleResult();
        this.refresh(catalogo);
        return catalogo;
    }

    @Override
    public Catalogo findByNemonico(String nemonico) {
        StringBuilder hql = new StringBuilder(100);
        hql.append("select c from Catalogo c where ");
        hql.append("c.nemonico = :nemonico ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("nemonico", nemonico);

        Catalogo catalogo = (Catalogo) query.getSingleResult();
        this.refresh(catalogo);
        return catalogo;
    }

    @Override
    public Catalogo findByNombre(String nombre) {
        System.out.println("nombre en dao: " + nombre);
        StringBuilder hql = new StringBuilder(100);
        hql.append("select c from Catalogo c where ");
        hql.append("lower(c.nombre) = :nombre ");

        Query query = em.createQuery(hql.toString());
        query.setParameter("nombre", nombre.toLowerCase());
        Catalogo catalogo = null;
        try {
        catalogo = (Catalogo) query.getSingleResult();
        this.refresh(catalogo);
        } catch (NoResultException nrEx) {
            catalogo = null;
        }
        return catalogo;
    }

}
