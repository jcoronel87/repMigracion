/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao;

import com.saviasoft.persistence.util.dao.GenericDao;
import ec.gob.arcom.migracion.modelo.Regimen;
import javax.ejb.Local;

/**
 *
 * @author CoronelJa
 */

@Local
public interface RegimenDao extends GenericDao<Regimen, Long> {
    
}
