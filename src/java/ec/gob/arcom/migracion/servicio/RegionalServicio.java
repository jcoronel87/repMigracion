/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio;

import com.saviasoft.persistence.util.service.GenericService;
import ec.gob.arcom.migracion.modelo.Regional;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */
@Local
public interface RegionalServicio extends GenericService<Regional, Long> {
    
    Regional findByNemonico(String nemonico);

    Regional findByNombre(String nombre);

    String findByCedulaRucUsuario(String cedulaRucUsuario);
    
}
