/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio;

import com.saviasoft.persistence.util.service.GenericService;
import ec.gob.arcom.migracion.modelo.Localidad;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */
@Local
public interface LocalidadServicio extends GenericService<Localidad, Long> {
    
    List<Localidad> findByNemonico(String nemonico);
    
    Localidad findByCodInternacional(String codInternacional);

    List<Localidad> findByLocalidadPadre(BigInteger localidadPadre);
    
}
