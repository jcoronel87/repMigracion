/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.servicio;

import com.saviasoft.persistence.util.service.GenericService;
import ec.gob.arcom.migracion.modelo.Fase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */
@Local
public interface FaseServicio extends GenericService<Fase, Long> {
    
    Fase findByNemonico(String nemonico);

    Fase findByNombre(String nombre);

    List<Fase> obtenerFasesLikeDescripcion(String descripcion);
    
}