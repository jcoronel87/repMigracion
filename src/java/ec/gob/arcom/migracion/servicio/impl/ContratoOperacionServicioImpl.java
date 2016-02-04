/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio.impl;

import com.saviasoft.persistence.util.dao.GenericDao;
import com.saviasoft.persistence.util.service.impl.GenericServiceImpl;
import ec.gob.arcom.migracion.dao.ContratoOperacionDao;
import ec.gob.arcom.migracion.modelo.ContratoOperacion;
import ec.gob.arcom.migracion.servicio.ContratoOperacionServicio;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Javier Coronel
 */
@Stateless(name = "ContratoOperacionServicio")
public class ContratoOperacionServicioImpl extends GenericServiceImpl<ContratoOperacion, Long>
        implements ContratoOperacionServicio {
    
    @EJB
    private ContratoOperacionDao contratoOperacionDao;

    @Override
    public GenericDao<ContratoOperacion, Long> getDao() {
        return contratoOperacionDao;
    }

    @Override
    public ContratoOperacion findByPk(Long codigoContratoOperacion) {
        return contratoOperacionDao.findByPk(codigoContratoOperacion);
    }

}
