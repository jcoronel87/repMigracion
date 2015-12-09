/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.dto.DerechoMineroDto;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.servicio.ConcesionMineraServicio;
import ec.gob.arcom.migracion.servicio.LocalidadServicio;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author CoronelJa
 */
@ManagedBean
@ViewScoped
public class DerechosMinerosCtrl extends BaseCtrl {

    @EJB
    private ConcesionMineraServicio concesionMineraServicio;
    @EJB
    private LocalidadServicio localidadServicio;

    private String codigo;
    private String nombreDerechoMinero;
    private Long codigoRegional;
    private Long codigoProvincia;
    private Long codigoFase;
    private Long codigoEstado;
    private String tipoSolicitudNemonico;
    private String beneficiarioPrincipal;
    private String tipoPersona;
    private Date fecha;

    private boolean mostrarLista = false;
    private List<DerechoMineroDto> listaRegistros;

    private List<SelectItem> provincias;

    public void buscar() {
        mostrarLista = true;
        listaRegistros = null;
        getListaRegistros();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreDerechoMinero() {
        return nombreDerechoMinero;
    }

    public void setNombreDerechoMinero(String nombreDerechoMinero) {
        this.nombreDerechoMinero = nombreDerechoMinero;
    }

    public Long getCodigoRegional() {
        return codigoRegional;
    }

    public void setCodigoRegional(Long codigoRegional) {
        this.codigoRegional = codigoRegional;
    }

    public Long getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(Long codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public Long getCodigoFase() {
        return codigoFase;
    }

    public void setCodigoFase(Long codigoFase) {
        this.codigoFase = codigoFase;
    }

    public Long getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Long codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getTipoSolicitudNemonico() {
        return tipoSolicitudNemonico;
    }

    public void setTipoSolicitudNemonico(String tipoSolicitudNemonico) {
        this.tipoSolicitudNemonico = tipoSolicitudNemonico;
    }

    public String getBeneficiarioPrincipal() {
        return beneficiarioPrincipal;
    }

    public void setBeneficiarioPrincipal(String beneficiarioPrincipal) {
        this.beneficiarioPrincipal = beneficiarioPrincipal;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isMostrarLista() {
        return mostrarLista;
    }

    public void setMostrarLista(boolean mostrarLista) {
        this.mostrarLista = mostrarLista;
    }

    public List<DerechoMineroDto> getListaRegistros() {
        if (listaRegistros == null) {
            System.out.println(codigo + " " + nombreDerechoMinero + " " + codigoRegional
                    + " " + codigoProvincia + " " + codigoFase + " " + codigoEstado + " " + tipoSolicitudNemonico
                    + " " + beneficiarioPrincipal + " " + tipoPersona + " " + fecha);
            listaRegistros = concesionMineraServicio.obtenerDerechosMinerosNacional(codigo, nombreDerechoMinero, codigoRegional,
                    codigoProvincia, codigoFase, codigoEstado, tipoSolicitudNemonico, beneficiarioPrincipal, tipoPersona, fecha);
        }
        return listaRegistros;
    }

    public void setListaRegistros(List<DerechoMineroDto> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<SelectItem> getProvincias() {
        if (provincias == null) {
            provincias = new ArrayList<>();
            Localidad catalogoProvincia = localidadServicio.findByNemonico("EC").get(0);
            List<Localidad> provinciasCat = localidadServicio.findByLocalidadPadre(BigInteger.valueOf(catalogoProvincia.getCodigoLocalidad()));

            for (Localidad provincia : provinciasCat) {
                provincias.add(new SelectItem(provincia.getCodigoLocalidad(), provincia.getNombre().toUpperCase()));
            }
        }
        return provincias;
    }

    public void setProvincias(List<SelectItem> provincias) {
        this.provincias = provincias;
    }

    public String verDerechoMinero() {
        DerechoMineroDto derechoMineroDtoItem = (DerechoMineroDto) getExternalContext().getRequestMap().get("reg");
        if (derechoMineroDtoItem.getTipoDerechoMinero().equals("C")) {
            return "concesionmineraformro?faces-redirect=true&idItem=" + derechoMineroDtoItem.getId();
        } else if (derechoMineroDtoItem.getTipoDerechoMinero().equals("S")) {
            return "areamineraformro?faces-redirect=true&idItem=" + derechoMineroDtoItem.getId();
        } else if (derechoMineroDtoItem.getTipoDerechoMinero().equals("L")) {
            return "licenciacomercializacionformro?faces-redirect=true&idItem=" + derechoMineroDtoItem.getId();
        } else if (derechoMineroDtoItem.getTipoDerechoMinero().equals("P")) {
            return "plantabeneficioformro?faces-redirect=true&idItem=" + derechoMineroDtoItem.getId();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se encuentra el registro seleccionado", null));
            return null;
        }
    }

}
