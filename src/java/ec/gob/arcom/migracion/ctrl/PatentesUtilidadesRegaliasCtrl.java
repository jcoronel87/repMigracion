/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.constantes.ConstantesEnum;
import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.dao.UsuarioDao;
import ec.gob.arcom.migracion.modelo.Auditoria;
import ec.gob.arcom.migracion.modelo.ConceptoPago;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import static ec.gob.arcom.migracion.modelo.Instrumento_.licenciaComercializacion;
import ec.gob.arcom.migracion.modelo.LicenciaComercializacion;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.PlantaBeneficio;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.SujetoMinero;
import ec.gob.arcom.migracion.modelo.Usuario;
import ec.gob.arcom.migracion.servicio.AuditoriaServicio;
import ec.gob.arcom.migracion.servicio.ConcesionMineraServicio;
import ec.gob.arcom.migracion.servicio.LicenciaComercializacionServicio;
import ec.gob.arcom.migracion.servicio.LocalidadServicio;
import ec.gob.arcom.migracion.servicio.PlantaBeneficioServicio;
import ec.gob.arcom.migracion.servicio.RegistroPagoObligacionesServicio;
import ec.gob.arcom.migracion.servicio.SujetoMineroServicio;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author CoronelJa
 */
@ManagedBean
@ViewScoped
public class PatentesUtilidadesRegaliasCtrl extends BaseCtrl {

    @EJB
    private RegistroPagoObligacionesServicio registroPagoObligacionesServicio;
    @EJB
    private LocalidadServicio localidadServicio;
    @EJB
    private ConcesionMineraServicio concesionMineraServicio;
    @EJB
    private LicenciaComercializacionServicio licenciaComercializacionServicio;
    @EJB
    private PlantaBeneficioServicio plantaBeneficioServicio;
    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private SujetoMineroServicio sujetoMineroServicio;
    @EJB
    private AuditoriaServicio auditoriaServicio;
    @ManagedProperty(value = "#{loginCtrl}")
    private LoginCtrl login;
    private RegistroPagoObligaciones patentesRegaliasUtilidades;
    private RegistroPagoObligaciones patentesRegaliasUtilidadesAnterior;
    private List<RegistroPagoObligaciones> listaPatentesRegaliasUtilidades;
    private String codigoFiltro;

    private boolean sujetoMinero;

    private ConcesionMinera concesionMineraPopup;
    private LicenciaComercializacion licenciaComercializacionPopup;
    private PlantaBeneficio plantaBeneficioPopup;

    private Localidad provincia;
    private Localidad canton;
    private Localidad parroquia;

    private SujetoMinero sujetoMineroPopUp;

    private ConcesionMinera concesionMineraPopupAnterior;
    private LicenciaComercializacion licenciaComercializacionPopupAnterior;
    private PlantaBeneficio plantaBeneficioPopupAnterior;
    private SujetoMinero sujetoMineroPopUpAnterior;

    private String identificacionSujetoMinero;
    
    private List<SelectItem> provincias;
    private List<SelectItem> cantones;
    private List<SelectItem> parroquias;
    
    public RegistroPagoObligaciones getPatentesRegaliasUtilidades() {
        if (patentesRegaliasUtilidades == null) {
            String registroPagoObligacionesId = getHttpServletRequestParam("idItem");
            Long idRegistroPagoObligaciones = null;
            if (registroPagoObligacionesId != null) {
                idRegistroPagoObligaciones = Long.parseLong(registroPagoObligacionesId);
            }
            if (idRegistroPagoObligaciones == null) {
                patentesRegaliasUtilidades = new RegistroPagoObligaciones();
                patentesRegaliasUtilidades.setCodigoConceptoPago(new ConceptoPago());
            } else {
                patentesRegaliasUtilidades = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
                patentesRegaliasUtilidadesAnterior = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
                patentesRegaliasUtilidades.getCodigoConcesion();
                patentesRegaliasUtilidades.getCodigoLicenciaComercializacion();
                patentesRegaliasUtilidades.getCodigoPlantaBeneficio();
            }
        }
        return patentesRegaliasUtilidades;
    }

    public void setPatentesRegaliasUtilidades(RegistroPagoObligaciones patentesRegaliasUtilidades) {
        this.patentesRegaliasUtilidades = patentesRegaliasUtilidades;
    }

    public RegistroPagoObligaciones getPatentesRegaliasUtilidadesAnterior() {
        return patentesRegaliasUtilidadesAnterior;
    }

    public void setPatentesRegaliasUtilidadesAnterior(RegistroPagoObligaciones patentesRegaliasUtilidadesAnterior) {
        this.patentesRegaliasUtilidadesAnterior = patentesRegaliasUtilidadesAnterior;
    }

    public String editarRegistro() {
        RegistroPagoObligaciones registroPagoObligacionesItem = (RegistroPagoObligaciones) getExternalContext().getRequestMap().get("reg");
        return "autogestionform?faces-redirect=true&idItem=" + registroPagoObligacionesItem.getCodigoRegistro();
    }

    public String guardarRegistroAutoGestion() {
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        try {
            if (patentesRegaliasUtilidades.getCodigoRegistro()== null) {
                System.out.println("entra create");
                patentesRegaliasUtilidades.setEstadoRegistro(true);
                patentesRegaliasUtilidades.setFechaCreacion(new Date());
                patentesRegaliasUtilidades.setUsuarioCreacion(BigInteger.valueOf(us.getCodigoUsuario()));
                System.out.println("registroPagoObligacionesAutoGestion.getCodigoDerechoMinero(): " + patentesRegaliasUtilidades.getCodigoDerechoMinero());
                if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                        || patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                        || patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
                    System.out.println("entra if concesion");
                    ConcesionMinera cm = new ConcesionMinera();
                    cm.setCodigoConcesion(patentesRegaliasUtilidades.getCodigoDerechoMinero());
                    patentesRegaliasUtilidades.setCodigoConcesion(cm);
                }
                if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
                    System.out.println("entra if licencia");
                    LicenciaComercializacion lc = new LicenciaComercializacion();
                    lc.setCodigoLicenciaComercializacion(patentesRegaliasUtilidades.getCodigoDerechoMinero());
                    patentesRegaliasUtilidades.setCodigoLicenciaComercializacion(lc);
                }
                if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
                    System.out.println("entra if planta");
                    PlantaBeneficio pb = new PlantaBeneficio();
                    pb.setCodigoPlantaBeneficio(patentesRegaliasUtilidades.getCodigoDerechoMinero());
                    patentesRegaliasUtilidades.setCodigoPlantaBeneficio(pb);
                }
                registroPagoObligacionesServicio.create(patentesRegaliasUtilidades);
                Auditoria auditoria = new Auditoria();
                auditoria.setAccion("INSERT");
                auditoria.setDetalleAnterior(licenciaComercializacion.toString());
                auditoria.setDetalleCambios(null);
                auditoria.setFecha(getCurrentTimeStamp());
                auditoria.setUsuario(BigInteger.valueOf(us.getCodigoUsuario()));
                auditoriaServicio.create(auditoria);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro guardado con éxito", null));
            } else {
                System.out.println("entra update");
                patentesRegaliasUtilidades.setFechaModificacion(new Date());
                patentesRegaliasUtilidades.setUsuarioModificacion(BigInteger.valueOf(us.getCodigoUsuario()));
                registroPagoObligacionesServicio.actualizarRegistroPagoObligaciones(patentesRegaliasUtilidades);
                Auditoria auditoria = new Auditoria();
                auditoria.setAccion("UPDATE");
                auditoria.setDetalleAnterior(patentesRegaliasUtilidadesAnterior.toString());
                auditoria.setDetalleCambios(licenciaComercializacion.toString());
                auditoria.setFecha(getCurrentTimeStamp());
                auditoria.setUsuario(BigInteger.valueOf(us.getCodigoUsuario()));
                auditoriaServicio.create(auditoria);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro actualizado con éxito", null));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "No se pudo guardar el registro", ex.getMessage()));
            ex.printStackTrace();
        }
        return "autogestion";
    }

    public List<RegistroPagoObligaciones> getListaPatentesRegaliasUtilidades() {
        if (listaPatentesRegaliasUtilidades == null) {
            listaPatentesRegaliasUtilidades = registroPagoObligacionesServicio.findAll();
        }
        return listaPatentesRegaliasUtilidades;
    }

    public void setListaPatentesRegaliasUtilidades(List<RegistroPagoObligaciones> listaPatentesRegaliasUtilidades) {
        this.listaPatentesRegaliasUtilidades = listaPatentesRegaliasUtilidades;
    }

    public void buscarRegistro() {
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        if (patentesRegaliasUtilidades.getCodigoTipoRegistro() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Antes de buscar por código debe elegir un tipo de registro", null));
            return;
        }
        if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                || patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                || patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
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
        } else if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
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
        } else if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
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
        }
    }

    public void cambiarPopUp() {
        if (patentesRegaliasUtilidades.getCodigoTipoRegistro() != null) {
            if (patentesRegaliasUtilidades.getCodigoTipoRegistro().equals(ConstantesEnum.SUJETO_MINERO.getCodigo())) {
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

    public String getCodigoFiltro() {
        return codigoFiltro;
    }

    public void setCodigoFiltro(String codigoFiltro) {
        this.codigoFiltro = codigoFiltro;
    }

    public ConcesionMinera getConcesionMineraPopup() {
        return concesionMineraPopup;
    }

    public void setConcesionMineraPopup(ConcesionMinera concesionMineraPopup) {
        this.concesionMineraPopup = concesionMineraPopup;
    }

    public LicenciaComercializacion getLicenciaComercializacionPopup() {
        return licenciaComercializacionPopup;
    }

    public void setLicenciaComercializacionPopup(LicenciaComercializacion licenciaComercializacionPopup) {
        this.licenciaComercializacionPopup = licenciaComercializacionPopup;
    }

    public PlantaBeneficio getPlantaBeneficioPopup() {
        return plantaBeneficioPopup;
    }

    public void setPlantaBeneficioPopup(PlantaBeneficio plantaBeneficioPopup) {
        this.plantaBeneficioPopup = plantaBeneficioPopup;
    }

    public Localidad getProvincia() {
        return provincia;
    }

    public void setProvincia(Localidad provincia) {
        this.provincia = provincia;
    }

    public Localidad getCanton() {
        return canton;
    }

    public void setCanton(Localidad canton) {
        this.canton = canton;
    }

    public Localidad getParroquia() {
        return parroquia;
    }

    public void setParroquia(Localidad parroquia) {
        this.parroquia = parroquia;
    }

    public void seleccionarConcesion() {
        patentesRegaliasUtilidades.setCodigoConcesion(concesionMineraPopup);
        patentesRegaliasUtilidades.getCodigoConcesion();
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public void seleccionarLicencia() {
        patentesRegaliasUtilidades.setCodigoLicenciaComercializacion(licenciaComercializacionPopup);
        patentesRegaliasUtilidades.getCodigoLicenciaComercializacion();
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public void seleccionarPlanta() {
        patentesRegaliasUtilidades.setCodigoPlantaBeneficio(plantaBeneficioPopup);
        patentesRegaliasUtilidades.getCodigoPlantaBeneficio();
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public SujetoMinero getSujetoMineroPopUp() {
        return sujetoMineroPopUp;
    }

    public void setSujetoMineroPopUp(SujetoMinero sujetoMineroPopUp) {
        this.sujetoMineroPopUp = sujetoMineroPopUp;
    }

    public LoginCtrl getLogin() {
        return login;
    }

    public void setLogin(LoginCtrl login) {
        this.login = login;
    }

    public ConcesionMinera getConcesionMineraPopupAnterior() {
        return concesionMineraPopupAnterior;
    }

    public void setConcesionMineraPopupAnterior(ConcesionMinera concesionMineraPopupAnterior) {
        this.concesionMineraPopupAnterior = concesionMineraPopupAnterior;
    }

    public LicenciaComercializacion getLicenciaComercializacionPopupAnterior() {
        return licenciaComercializacionPopupAnterior;
    }

    public void setLicenciaComercializacionPopupAnterior(LicenciaComercializacion licenciaComercializacionPopupAnterior) {
        this.licenciaComercializacionPopupAnterior = licenciaComercializacionPopupAnterior;
    }

    public PlantaBeneficio getPlantaBeneficioPopupAnterior() {
        return plantaBeneficioPopupAnterior;
    }

    public void setPlantaBeneficioPopupAnterior(PlantaBeneficio plantaBeneficioPopupAnterior) {
        this.plantaBeneficioPopupAnterior = plantaBeneficioPopupAnterior;
    }

    public String getIdentificacionSujetoMinero() {
        return identificacionSujetoMinero;
    }

    public void setIdentificacionSujetoMinero(String identificacionSujetoMinero) {
        this.identificacionSujetoMinero = identificacionSujetoMinero;
    }

    public void buscarSujetoMinero() {
        sujetoMineroPopUp = sujetoMineroServicio.obtenerPorIdentificacion(identificacionSujetoMinero);
        sujetoMineroPopUpAnterior = sujetoMineroServicio.obtenerPorIdentificacion(identificacionSujetoMinero);
        if (sujetoMineroPopUp == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Sujeto minero no existe", null));
        } else {
            patentesRegaliasUtilidades.getCodigoSujetoMinero();
        }
    }

    public SujetoMinero getSujetoMineroPopUpAnterior() {
        return sujetoMineroPopUpAnterior;
    }

    public void setSujetoMineroPopUpAnterior(SujetoMinero sujetoMineroPopUpAnterior) {
        this.sujetoMineroPopUpAnterior = sujetoMineroPopUpAnterior;
    }

    public List<SelectItem> getProvincias() {
        if (provincias == null) {
            provincias = new ArrayList<>();
            Localidad catalogoProvincia = localidadServicio.findByNemonico("EC").get(0);
            List<Localidad> provinciasCat = localidadServicio.findByLocalidadPadre(BigInteger.valueOf(catalogoProvincia.getCodigoLocalidad()));

            for (Localidad provincia : provinciasCat) {
                provincias.add(new SelectItem(provincia.getCodigoInternacional(), provincia.getNombre().toUpperCase()));
            }
        }
        return provincias;
    }

    public void setProvincias(List<SelectItem> provincias) {
        this.provincias = provincias;
    }

    public List<SelectItem> getCantones() {
        if (cantones == null) {
            cantones = new ArrayList<>();
            if (patentesRegaliasUtilidades.getCodigoProvincia() == null) {
                return cantones;
            }
            Localidad catalogoCanton = localidadServicio.findByPk(Long.valueOf(patentesRegaliasUtilidades.getCodigoProvincia().toString()));
            if (catalogoCanton == null || (catalogoCanton != null && catalogoCanton.getCodigoLocalidad() == null)) {
                return cantones;
            }
            List<Localidad> cantonCat = localidadServicio.findByLocalidadPadre(BigInteger.valueOf(catalogoCanton.getCodigoLocalidad()));

            for (Localidad canton : cantonCat) {
                cantones.add(new SelectItem(canton.getCodigoLocalidad().toString(), canton.getNombre().toUpperCase()));
            }
        }
        return cantones;
    }

    public void setCantones(List<SelectItem> cantones) {
        this.cantones = cantones;
    }
    
    public void cargaCantones() {
        cantones = null;
        parroquias = null;
        patentesRegaliasUtilidades.setCodigoCanton(null);
        getCantones();
        getParroquias();
    }

    public List<SelectItem> getParroquias() {
        if (parroquias == null) {
            parroquias = new ArrayList<>();
            if (patentesRegaliasUtilidades.getCodigoCanton() == null) {
                return parroquias;
            }
            Localidad catalogoParroquia = localidadServicio.findByPk(Long.valueOf(patentesRegaliasUtilidades.getCodigoCanton().toString()));
            if (catalogoParroquia == null || (catalogoParroquia != null && catalogoParroquia.getCodigoInternacional() == null)) {
                return parroquias;
            }
            List<Localidad> parroquiaCat = localidadServicio.findByLocalidadPadre(BigInteger.valueOf(catalogoParroquia.getCodigoLocalidad()));

            for (Localidad parroquia : parroquiaCat) {
                parroquias.add(new SelectItem(parroquia.getCodigoLocalidad().toString(), parroquia.getNombre().toUpperCase()));
            }
        }
        return parroquias;
    }

    public void setParroquias(List<SelectItem> parroquias) {
        this.parroquias = parroquias;
    }
    
    public void cargaParroquias() {
        parroquias = null;
        getParroquias();
    }

}
