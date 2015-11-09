/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio.impl;

import com.saviasoft.persistence.util.dao.GenericDao;
import com.saviasoft.persistence.util.service.impl.GenericServiceImpl;
import ec.gob.arcom.migracion.dao.RegistroPagoObligacionesDao;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.servicio.RegistroPagoObligacionesServicio;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author CoronelJa
 */
@Stateless(name = "RegistroPagoObligacionesServicio")
public class RegistroPagoObligacionesServicioImpl extends GenericServiceImpl<RegistroPagoObligaciones, Long>
        implements RegistroPagoObligacionesServicio {
    
    @EJB
    private RegistroPagoObligacionesDao registroPagoObligacionesDao;

    @Override
    public GenericDao<RegistroPagoObligaciones, Long> getDao() {
        return registroPagoObligacionesDao;
    }

    @Override
    public RegistroPagoObligaciones obtenerPorCodigoRegistroPagoObligaciones(Long codigoRegistroPagoObligaciones) {
        return registroPagoObligacionesDao.obtenerPorCodigoRegistroPagoObligaciones(codigoRegistroPagoObligaciones);
    }

    @Override
    public void actualizarRegistroPagoObligaciones(RegistroPagoObligaciones registroPagoObligaciones) throws Exception {
        registroPagoObligacionesDao.actualizarRegistroPagoObligaciones(registroPagoObligaciones);
    }

}
