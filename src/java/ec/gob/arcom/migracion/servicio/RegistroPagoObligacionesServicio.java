/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio;

import com.saviasoft.persistence.util.service.GenericService;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */
@Local
public interface RegistroPagoObligacionesServicio extends GenericService<RegistroPagoObligaciones, Long> {

    RegistroPagoObligaciones obtenerPorCodigoRegistroPagoObligaciones(Long codigoRegistroPagoObligaciones);

    void actualizarRegistroPagoObligaciones(RegistroPagoObligaciones registroPagoObligaciones) throws Exception;

    List<RegistroPagoObligaciones> obtenerPRUNacional();

    List<RegistroPagoObligaciones> obtenerPorNumeroComprobanteArcom(String numeroComprobanteArcom);

}
