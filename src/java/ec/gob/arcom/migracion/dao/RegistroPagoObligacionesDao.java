/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao;

import com.saviasoft.persistence.util.dao.GenericDao;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */

@Local
public interface RegistroPagoObligacionesDao extends GenericDao<RegistroPagoObligaciones, Long> {

    RegistroPagoObligaciones obtenerPorCodigoRegistroPagoObligaciones(Long codigoRegistroPagoObligaciones);

    void actualizarRegistroPagoObligaciones(RegistroPagoObligaciones registroPagoObligaciones) throws Exception;

    List<RegistroPagoObligaciones> obtenerPRUNacional();

}
