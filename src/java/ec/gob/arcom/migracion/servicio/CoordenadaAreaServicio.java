/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio;

import com.saviasoft.persistence.util.service.GenericService;
import ec.gob.arcom.migracion.modelo.CoordenadaArea;
import java.math.BigInteger;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */
@Local
public interface CoordenadaAreaServicio extends GenericService<CoordenadaArea, Long> {

    CoordenadaArea findByCodigoAreaOrden(Long codigoArea, BigInteger orden);
    
}
