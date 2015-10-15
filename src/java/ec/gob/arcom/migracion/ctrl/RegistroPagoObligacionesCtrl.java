/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.constantes.ConstantesEnum;
import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.Usuario;
import ec.gob.arcom.migracion.servicio.RegistroPagoObligacionesServicio;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CoronelJa
 */
@ManagedBean
@ViewScoped
public class RegistroPagoObligacionesCtrl extends BaseCtrl {
    
    @EJB
    private RegistroPagoObligacionesServicio registroPagoObligacionesServicio;
    
    private RegistroPagoObligaciones registroPagoObligacionesAutoGestion;
    private RegistroPagoObligaciones registroPagoObligacionesAutoGestionAnterior;
    private List<RegistroPagoObligaciones> listaRegistrosAutoGestion;
    private String codigoFiltro;
    
    private boolean sujetoMinero;

    public RegistroPagoObligaciones getRegistroPagoObligacionesAutoGestion() {
        if (registroPagoObligacionesAutoGestion == null) {
            String registroPagoObligacionesId = getHttpServletRequestParam("idItem");
            Long idRegistroPagoObligaciones = null;
            if (registroPagoObligacionesId != null) {
                idRegistroPagoObligaciones = Long.parseLong(registroPagoObligacionesId);
            }
            if (idRegistroPagoObligaciones == null) {
                registroPagoObligacionesAutoGestion = new RegistroPagoObligaciones();
            } else {
                registroPagoObligacionesAutoGestion = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
                registroPagoObligacionesAutoGestionAnterior = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
            }
        }
        return registroPagoObligacionesAutoGestion;
    }

    public void setRegistroPagoObligacionesAutoGestion(RegistroPagoObligaciones registroPagoObligacionesAutoGestion) {
        this.registroPagoObligacionesAutoGestion = registroPagoObligacionesAutoGestion;
    }

    public RegistroPagoObligaciones getRegistroPagoObligacionesAutoGestionAnterior() {
        return registroPagoObligacionesAutoGestionAnterior;
    }

    public void setRegistroPagoObligacionesAutoGestionAnterior(RegistroPagoObligaciones registroPagoObligacionesAutoGestionAnterior) {
        this.registroPagoObligacionesAutoGestionAnterior = registroPagoObligacionesAutoGestionAnterior;
    }
    
    public String editarRegistro() {
        RegistroPagoObligaciones registroPagoObligacionesItem = (RegistroPagoObligaciones) getExternalContext().getRequestMap().get("reg");
        return "autogestionform?faces-redirect=true&idItem=" + registroPagoObligacionesItem.getCodigoRegistro();
    }
    
    public void guardarRegistroAutoGestion() {
        
    }

    public List<RegistroPagoObligaciones> getListaRegistrosAutoGestion() {
        if (listaRegistrosAutoGestion == null) {
            listaRegistrosAutoGestion = registroPagoObligacionesServicio.findAll();
        }
        return listaRegistrosAutoGestion;
    }

    public void setListaRegistrosAutoGestion(List<RegistroPagoObligaciones> listaRegistrosAutoGestion) {
        this.listaRegistrosAutoGestion = listaRegistrosAutoGestion;
    }
    
    public void buscarRegistro() {
        /*System.out.println("entra buscarRegistro");
        System.out.println("instrumento.getCodigoTipoMineria().getCodigoTipoMineria(): " + instrumento.getCodigoTipoMineria().getCodigoTipoMineria());
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        if (instrumento.getCodigoTipoMineria().getCodigoTipoMineria() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Antes de buscar por código debe elegir un tipo de registro", null));
            return;
        }
        if (instrumento.getCodigoTipoMineria().getCodigoTipoMineria().equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                || instrumento.getCodigoTipoMineria().getCodigoTipoMineria().equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                || instrumento.getCodigoTipoMineria().getCodigoTipoMineria().equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
            System.out.println("codigoFiltro: " + codigoFiltro);
            concesionMineraPopup = concesionMineraServicio.obtenerPorCodigoArcom(codigoFiltro);
            concesionMineraPopupAnterior = concesionMineraServicio.obtenerPorCodigoArcom(codigoFiltro);
            System.out.println("concesionMineraPopup: " + concesionMineraPopup);
            if (concesionMineraPopup != null) {
                if (concesionMineraPopup.getCodigoProvincia().equals(us.getCodigoProvincia())) {
                    provincia = localidadServicio.findByPk(concesionMineraPopup.getCodigoProvincia().longValue());
                    canton = localidadServicio.findByPk(concesionMineraPopup.getCodigoCanton().longValue());
                    parroquia = localidadServicio.findByPk(concesionMineraPopup.getCodigoParroquia().longValue());
                } else {
                    concesionMineraPopup = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La concesión existe pero no pertenece a su regional", null));
                }
            }
        } else if (instrumento.getCodigoTipoMineria().getCodigoTipoMineria().equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
            licenciaComercializacionPopup = licenciaComercializacionServicio.obtenerPorCodigoArcom(codigoFiltro);
            licenciaComercializacionPopupAnterior = licenciaComercializacionServicio.obtenerPorCodigoArcom(codigoFiltro);
            if (licenciaComercializacionPopup != null) {
                if (licenciaComercializacionPopup.getCodigoProvincia().equals(us.getCodigoProvincia())) {
                    provincia = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoProvincia().longValue());
                    canton = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoCanton().longValue());
                    parroquia = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoParroquida().longValue());
                } else {
                    licenciaComercializacionPopup = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La licencia existe pero no pertenece a su regional", null));
                }
            }
        } else if (instrumento.getCodigoTipoMineria().getCodigoTipoMineria().equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
            plantaBeneficioPopup = plantaBeneficioServicio.obtenerPorCodigoArcom(codigoFiltro);
            plantaBeneficioPopupAnterior = plantaBeneficioServicio.obtenerPorCodigoArcom(codigoFiltro);
            if (plantaBeneficioPopup != null) {
                if (plantaBeneficioPopup.getCodigoProvincia().equals(us.getCodigoProvincia())) {
                    provincia = localidadServicio.findByPk(plantaBeneficioPopup.getCodigoProvincia().longValue());
                    canton = localidadServicio.findByPk(plantaBeneficioPopup.getCodigoCanton().longValue());
                    parroquia = localidadServicio.findByPk(plantaBeneficioPopup.getCodigoParroquida().longValue());
                } else {
                    plantaBeneficioPopup = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La planta existe pero no pertenece a su regional", null));
                }
            }
        }*/
    }
    
    public void cambiarPopUp() {
        if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro() != null) {
            if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.SUJETO_MINERO.getCodigo())) {
                sujetoMinero = true;
            } else {
                sujetoMinero = false;
            }
        }
    }

    public boolean isSujetoMinero() {
        return sujetoMinero;
    }

    public void setSujetoMinero(boolean sujetoMinero) {
        this.sujetoMinero = sujetoMinero;
    }
    
}