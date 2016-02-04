/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.modelo.ContratoOperacion;
import ec.gob.arcom.migracion.servicio.ContratoOperacionServicio;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Javier Coronel
 */
@ManagedBean
@ViewScoped
public class ContratoCtrl extends BaseCtrl {
    
    @EJB
    private ContratoOperacionServicio contratoOperacionServicio;
    
    private ContratoOperacion contratoOperacion;

    public ContratoOperacion getContratoOperacion() {
        if (contratoOperacion == null) {
            String contratoId = getHttpServletRequestParam("idItem");
            Long idContrato = null;
            if (contratoId != null) {
                idContrato = Long.parseLong(contratoId);
            }
            if (idContrato == null) {
                contratoOperacion = new ContratoOperacion();
            } else {
                contratoOperacion = contratoOperacionServicio.findByPk(idContrato);
            }
        }
        return contratoOperacion;
    }

    public void setContratoOperacion(ContratoOperacion contratoOperacion) {
        this.contratoOperacion = contratoOperacion;
    }
    
    public void buscar() {
        
    }
    
    public String editarRegistro() {
        ContratoOperacion contratoItem = (ContratoOperacion) getExternalContext().getRequestMap().get("reg");
        return null;
    }
    
    public String guardarRegistro() {
        return null;
    }
    
}
