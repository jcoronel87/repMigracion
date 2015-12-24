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
import ec.gob.arcom.migracion.modelo.LicenciaComercializacion;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.LocalidadRegional;
import ec.gob.arcom.migracion.modelo.PlantaBeneficio;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.SujetoMinero;
import ec.gob.arcom.migracion.modelo.Usuario;
import ec.gob.arcom.migracion.servicio.AuditoriaServicio;
import ec.gob.arcom.migracion.servicio.ConcesionMineraServicio;
import ec.gob.arcom.migracion.servicio.LicenciaComercializacionServicio;
import ec.gob.arcom.migracion.servicio.LocalidadRegionalServicio;
import ec.gob.arcom.migracion.servicio.LocalidadServicio;
import ec.gob.arcom.migracion.servicio.PlantaBeneficioServicio;
import ec.gob.arcom.migracion.servicio.RegistroPagoObligacionesServicio;
import ec.gob.arcom.migracion.servicio.SecuenciaServicio;
import ec.gob.arcom.migracion.servicio.SujetoMineroServicio;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author CoronelJa
 */
@ManagedBean
@ViewScoped
public class RegistroPagoObligacionesCtrl extends BaseCtrl {

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
    @EJB
    private SecuenciaServicio secuenciaServicio;
    @EJB
    private LocalidadRegionalServicio localidadRegionalServicio;
    @ManagedProperty(value = "#{loginCtrl}")
    private LoginCtrl login;
    private RegistroPagoObligaciones registroPagoObligacionesAutoGestion;
    private RegistroPagoObligaciones registroPagoObligacionesAutoGestionAnterior;
    private List<RegistroPagoObligaciones> listaRegistrosAutoGestion;
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
    
    private List<RegistroPagoObligaciones> registrosPRUNacional;

    public RegistroPagoObligaciones getRegistroPagoObligacionesAutoGestion() {
        if (registroPagoObligacionesAutoGestion == null) {
            String registroPagoObligacionesId = getHttpServletRequestParam("idItem");
            Long idRegistroPagoObligaciones = null;
            if (registroPagoObligacionesId != null) {
                idRegistroPagoObligaciones = Long.parseLong(registroPagoObligacionesId);
            }
            if (idRegistroPagoObligaciones == null) {
                registroPagoObligacionesAutoGestion = new RegistroPagoObligaciones();
                registroPagoObligacionesAutoGestion.setCodigoConceptoPago(new ConceptoPago());
            } else {
                registroPagoObligacionesAutoGestion = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
                registroPagoObligacionesAutoGestionAnterior = registroPagoObligacionesServicio.obtenerPorCodigoRegistroPagoObligaciones(idRegistroPagoObligaciones);
                registroPagoObligacionesAutoGestion.getCodigoConcesion();
                registroPagoObligacionesAutoGestion.getCodigoLicenciaComercializacion();
                registroPagoObligacionesAutoGestion.getCodigoPlantaBeneficio();
                if (registroPagoObligacionesAutoGestion.getCodigoConceptoPago() == null) {
                    registroPagoObligacionesAutoGestion.setCodigoConceptoPago(new ConceptoPago());
                }
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

    public String guardarRegistroAutoGestion() {
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        try {
            if (registroPagoObligacionesAutoGestion.getCodigoRegistro()== null) {
                System.out.println("entra create");
                registroPagoObligacionesAutoGestion.setEstadoRegistro(true);
                registroPagoObligacionesAutoGestion.setFechaCreacion(new Date());
                registroPagoObligacionesAutoGestion.setUsuarioCreacion(BigInteger.valueOf(us.getCodigoUsuario()));
                System.out.println("registroPagoObligacionesAutoGestion.getCodigoDerechoMinero(): " + registroPagoObligacionesAutoGestion.getCodigoDerechoMinero());
                if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                        || registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                        || registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
                    System.out.println("entra if concesion");
                    ConcesionMinera cm = new ConcesionMinera();
                    cm.setCodigoConcesion(registroPagoObligacionesAutoGestion.getCodigoDerechoMinero());
                    registroPagoObligacionesAutoGestion.setCodigoConcesion(cm);
                }
                if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
                    System.out.println("entra if licencia");
                    LicenciaComercializacion lc = new LicenciaComercializacion();
                    lc.setCodigoLicenciaComercializacion(registroPagoObligacionesAutoGestion.getCodigoDerechoMinero());
                    registroPagoObligacionesAutoGestion.setCodigoLicenciaComercializacion(lc);
                }
                if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
                    System.out.println("entra if planta");
                    PlantaBeneficio pb = new PlantaBeneficio();
                    pb.setCodigoPlantaBeneficio(registroPagoObligacionesAutoGestion.getCodigoDerechoMinero());
                    registroPagoObligacionesAutoGestion.setCodigoPlantaBeneficio(pb);
                }
                //Secuencia secuencia = secuenciaServicio.obtenerPorNemonico(codigoFiltro)
                registroPagoObligacionesServicio.create(registroPagoObligacionesAutoGestion);
                Auditoria auditoria = new Auditoria();
                auditoria.setAccion("INSERT");
                auditoria.setDetalleAnterior(registroPagoObligacionesAutoGestion.toString());
                auditoria.setDetalleCambios(null);
                auditoria.setFecha(getCurrentTimeStamp());
                auditoria.setUsuario(BigInteger.valueOf(us.getCodigoUsuario()));
                auditoriaServicio.create(auditoria);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro guardado con éxito", null));
            } else {
                System.out.println("entra update");
                registroPagoObligacionesAutoGestion.setFechaModificacion(new Date());
                registroPagoObligacionesAutoGestion.setUsuarioModificacion(BigInteger.valueOf(us.getCodigoUsuario()));
                registroPagoObligacionesServicio.actualizarRegistroPagoObligaciones(registroPagoObligacionesAutoGestion);
                Auditoria auditoria = new Auditoria();
                auditoria.setAccion("UPDATE");
                auditoria.setDetalleAnterior(registroPagoObligacionesAutoGestionAnterior.toString());
                auditoria.setDetalleCambios(registroPagoObligacionesAutoGestion.toString());
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
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Antes de buscar por código debe elegir un tipo de registro", null));
            return;
        }
        if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getCodigo())
                || registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getCodigo())
                || registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getCodigo())) {
            System.out.println("codigoFiltro: " + codigoFiltro);
            concesionMineraPopup = concesionMineraServicio.obtenerPorCodigoArcom(codigoFiltro);
            concesionMineraPopupAnterior = concesionMineraServicio.obtenerPorCodigoArcom(codigoFiltro);
            System.out.println("concesionMineraPopup: " + concesionMineraPopup);
            if (concesionMineraPopup != null) {
                LocalidadRegional localidadRegionalConcesion = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(concesionMineraPopup.getCodigoProvincia().longValue());
                LocalidadRegional localidadRegionalUsuario = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(us.getCodigoProvincia().longValue());
                if (localidadRegionalConcesion.getRegional().getCodigoRegional()
                        .equals(localidadRegionalUsuario.getRegional().getCodigoRegional())) {
                    provincia = localidadServicio.findByPk(concesionMineraPopup.getCodigoProvincia().longValue());
                    canton = localidadServicio.findByPk(concesionMineraPopup.getCodigoCanton().longValue());
                    parroquia = localidadServicio.findByPk(concesionMineraPopup.getCodigoParroquia().longValue());
                } else {
                    concesionMineraPopup = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La concesión existe pero no pertenece a su regional", null));
                }
            }
        } else if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getCodigo())) {
            licenciaComercializacionPopup = licenciaComercializacionServicio.obtenerPorCodigoArcom(codigoFiltro);
            licenciaComercializacionPopupAnterior = licenciaComercializacionServicio.obtenerPorCodigoArcom(codigoFiltro);
            if (licenciaComercializacionPopup != null) {
                LocalidadRegional localidadRegionalLicencia = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(licenciaComercializacionPopup.getCodigoProvincia().longValue());
                LocalidadRegional localidadRegionalUsuario = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(us.getCodigoProvincia().longValue());
                if (localidadRegionalLicencia.getRegional().getCodigoRegional()
                        .equals(localidadRegionalUsuario.getRegional().getCodigoRegional())) {
                    provincia = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoProvincia().longValue());
                    canton = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoCanton().longValue());
                    parroquia = localidadServicio.findByPk(licenciaComercializacionPopup.getCodigoParroquida().longValue());
                } else {
                    licenciaComercializacionPopup = null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "La licencia existe pero no pertenece a su regional", null));
                }
            }
        } else if (registroPagoObligacionesAutoGestion.getCodigoTipoRegistro().equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getCodigo())) {
            plantaBeneficioPopup = plantaBeneficioServicio.obtenerPorCodigoArcom(codigoFiltro);
            plantaBeneficioPopupAnterior = plantaBeneficioServicio.obtenerPorCodigoArcom(codigoFiltro);
            if (plantaBeneficioPopup != null) {
                LocalidadRegional localidadRegionalPlanta = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(plantaBeneficioPopup.getCodigoProvincia().longValue());
                LocalidadRegional localidadRegionalUsuario = localidadRegionalServicio
                        .obtenerPorCodigoLocalidad(us.getCodigoProvincia().longValue());
                if (localidadRegionalPlanta.getRegional().getCodigoRegional()
                        .equals(localidadRegionalUsuario.getRegional().getCodigoRegional())) {
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
        registroPagoObligacionesAutoGestion.setCodigoConcesion(concesionMineraPopup);
        registroPagoObligacionesAutoGestion.getCodigoConcesion();
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public void seleccionarLicencia() {
        registroPagoObligacionesAutoGestion.setCodigoLicenciaComercializacion(licenciaComercializacionPopup);
        registroPagoObligacionesAutoGestion.getCodigoLicenciaComercializacion();
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public void seleccionarPlanta() {
        registroPagoObligacionesAutoGestion.setCodigoPlantaBeneficio(plantaBeneficioPopup);
        registroPagoObligacionesAutoGestion.getCodigoPlantaBeneficio();
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
            registroPagoObligacionesAutoGestion.getCodigoSujetoMinero();
        }
    }

    public SujetoMinero getSujetoMineroPopUpAnterior() {
        return sujetoMineroPopUpAnterior;
    }

    public void setSujetoMineroPopUpAnterior(SujetoMinero sujetoMineroPopUpAnterior) {
        this.sujetoMineroPopUpAnterior = sujetoMineroPopUpAnterior;
    }
    
    protected String formarCodigoComprobante(String prefijoComprobante, Long secuencial) {
        //prefijoComprobante es el prefijo de la regional
        String codigo = secuencial.toString();
        while (codigo.length() < 8) {
            codigo = "0" + codigo;
        }
        codigo = "A-" + prefijoComprobante + codigo;
        return codigo;
    }

    public List<RegistroPagoObligaciones> getRegistrosPRUNacional() {
        if (registrosPRUNacional == null) {
            registrosPRUNacional = registroPagoObligacionesServicio.obtenerPRUNacional();
        }
        return registrosPRUNacional;
    }

    public void setRegistrosPRUNacional(List<RegistroPagoObligaciones> registrosPRUNacional) {
        this.registrosPRUNacional = registrosPRUNacional;
    }
    
}
