/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao;

import com.saviasoft.persistence.util.dao.GenericDao;
import ec.gob.arcom.migracion.dto.ConcesionMineraDto;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */

@Local
public interface ConcesionMineraDao extends GenericDao<ConcesionMinera, Long> {

    List<ConcesionMineraDto> obtenerRegistrosPorUsuario(String cedulaRuc, String codigoFiltro, String cedulaTitularFiltro, String nombreAreaFiltro);

    Long obtenerSiguienteCodigoConcesion();

    ConcesionMinera findByPk(Long codigoConcesion);

    ConcesionMinera findByCodigoArcom(String codigoArcom);

    void actualizarConcesionMinera(ConcesionMinera concesionMinera) throws Exception;
    
}
