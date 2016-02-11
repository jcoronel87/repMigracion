/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.ctrl;

import ec.gob.arcom.migracion.constantes.ConversionEstadosEnum;
import ec.gob.arcom.migracion.ctrl.base.BaseCtrl;
import ec.gob.arcom.migracion.dao.UsuarioDao;
import ec.gob.arcom.migracion.dto.PersonaDto;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.ContratoOperacion;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.LocalidadRegional;
import ec.gob.arcom.migracion.modelo.Usuario;
import ec.gob.arcom.migracion.servicio.ConcesionMineraServicio;
import ec.gob.arcom.migracion.servicio.ContratoOperacionServicio;
import ec.gob.arcom.migracion.servicio.LocalidadRegionalServicio;
import ec.gob.arcom.migracion.servicio.LocalidadServicio;
import ec.gob.arcom.migracion.servicio.PersonaNaturalServicio;
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
 * @author Javier Coronel
 */
@ManagedBean
@ViewScoped
public class ContratoOperacionCtrl extends BaseCtrl {

    @EJB
    private ContratoOperacionServicio contratoOperacionServicio;
    @EJB
    private UsuarioDao usuarioDao;
    @EJB
    private ConcesionMineraServicio concesionMineraServicio;
    @EJB
    private LocalidadRegionalServicio localidadRegionalServicio;
    @EJB
    private LocalidadServicio localidadServicio;
    @EJB
    private PersonaNaturalServicio personaNaturalServicio;
    @ManagedProperty(value = "#{loginCtrl}")
    private LoginCtrl login;

    private ContratoOperacion contratoOperacion;
    private List<ContratoOperacion> contratosOperacion;

    private ConcesionMinera concesionMineraPopup;
    private PersonaDto personaDtoPopup;

    private PersonaDto personaDto;

    private String codigoFiltro;

    private List<SelectItem> provincias;
    private List<SelectItem> cantones;
    private List<SelectItem> parroquias;

    public ContratoOperacion getContratoOperacion() {
        if (contratoOperacion == null) {
            String contratoId = getHttpServletRequestParam("idItem");
            Long idContrato = null;
            if (contratoId != null) {
                idContrato = Long.parseLong(contratoId);
            }
            if (idContrato == null) {
                contratoOperacion = new ContratoOperacion();
                contratoOperacion.setCodigoConcesion(new ConcesionMinera());
                contratoOperacion.setCodigoProvincia(new Localidad());
                contratoOperacion.setCodigoCanton(new Localidad());
                contratoOperacion.setCodigoParroquia(new Localidad());
                contratoOperacion.setTipoContrato(new CatalogoDetalle());
            } else {
                contratoOperacion = contratoOperacionServicio.findByPk(idContrato);
                if (contratoOperacion.getCodigoConcesion() == null) {
                    contratoOperacion.setCodigoConcesion(new ConcesionMinera());
                }
                if (contratoOperacion.getCodigoProvincia() == null) {
                    contratoOperacion.setCodigoProvincia(new Localidad());
                }
                if (contratoOperacion.getCodigoCanton() == null) {
                    contratoOperacion.setCodigoCanton(new Localidad());
                }
                if (contratoOperacion.getCodigoParroquia() == null) {
                    contratoOperacion.setCodigoParroquia(new Localidad());
                }
                if (contratoOperacion.getTipoContrato() == null) {
                    contratoOperacion.setTipoContrato(new CatalogoDetalle());
                }
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
        return "contratoform?faces-redirect=true&idItem=" + contratoItem.getCodigoContratoOperacion();
    }

    public String guardarContrato() {
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        CatalogoDetalle cd = new CatalogoDetalle();
        cd.setCodigoCatalogoDetalle(ConversionEstadosEnum.OTORGADO.getCodigo19());
        contratoOperacion.setEstadoContrato(cd);
        contratoOperacion.setEstadoRegistro(Boolean.TRUE);
        try {
            if (contratoOperacion.getCodigoContratoOperacion() == null) {
                contratoOperacion.setFechaCreacion(new Date());
                contratoOperacion.setUsuarioCreacion(BigInteger.valueOf(us.getCodigoUsuario()));
                contratoOperacionServicio.create(contratoOperacion);
                System.out.println("contratoOperacion.getCodigoContratoOperacion(): " + contratoOperacion.getCodigoContratoOperacion());
                contratoOperacion.setCodigoArcom(contratoOperacion.getCodigoConcesion().getCodigoArcom() + contratoOperacion.getCodigoContratoOperacion());
                contratoOperacionServicio.actualizarContratoOperacion(contratoOperacion);
                //contratoOperacionServicio.guardarTodo(contratoOperacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro guardado con éxito", null));
            } else {
                contratoOperacion.setFechaModificacion(new Date());
                contratoOperacion.setUsuarioModificacion(BigInteger.valueOf(us.getCodigoUsuario()));
                contratoOperacionServicio.actualizarContratoOperacion(contratoOperacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Registro actualizado con éxito", null));
            }
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Error: " + ex.getMessage(), ex.getMessage()));
        }
        return "contratos";
    }

    public List<ContratoOperacion> getContratosOperacion() {
        if (contratosOperacion == null) {
            contratosOperacion = contratoOperacionServicio.findAll();
        }
        return contratosOperacion;
    }

    public void setContratosOperacion(List<ContratoOperacion> contratosOperacion) {
        this.contratosOperacion = contratosOperacion;
    }

    public ConcesionMinera getConcesionMineraPopup() {
        return concesionMineraPopup;
    }

    public void setConcesionMineraPopup(ConcesionMinera concesionMineraPopup) {
        this.concesionMineraPopup = concesionMineraPopup;
    }

    public PersonaDto getPersonaDtoPopup() {
        return personaDtoPopup;
    }

    public void setPersonaDtoPopup(PersonaDto personaDtoPopup) {
        this.personaDtoPopup = personaDtoPopup;
    }

    public void buscarRegistro() {
        concesionMineraPopup = null;
        Usuario us = usuarioDao.obtenerPorLogin(login.getUserName());
        concesionMineraPopup = concesionMineraServicio.obtenerPorCodigoArcom(codigoFiltro);
        if (concesionMineraPopup != null) {
            LocalidadRegional localidadRegionalConcesion = localidadRegionalServicio
                    .obtenerPorCodigoLocalidad(concesionMineraPopup.getCodigoProvincia().longValue());
            LocalidadRegional localidadRegionalUsuario = localidadRegionalServicio
                    .obtenerPorCodigoLocalidad(us.getCodigoProvincia().longValue());
            if (localidadRegionalConcesion.getRegional().getCodigoRegional()
                    .equals(localidadRegionalUsuario.getRegional().getCodigoRegional()) || login.isEconomicoNacional()) {
                concesionMineraPopup.setProvinciaString(localidadServicio
                        .findByPk(concesionMineraPopup.getCodigoProvincia().longValue()).getNombre());
                concesionMineraPopup.setCantonString(localidadServicio
                        .findByPk(concesionMineraPopup.getCodigoCanton().longValue()).getNombre());
                concesionMineraPopup.setParroquiaString(localidadServicio
                        .findByPk(concesionMineraPopup.getCodigoParroquia().longValue()).getNombre());
            } else {
                concesionMineraPopup = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "La concesión existe pero no pertenece a su regional", null));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "La concesión no existe", null));
        }
    }

    public void buscarPersona() {
        System.out.println("entra buscarPersona");
        System.out.println("contratoOperacion.getNumeroDocumento(): " + contratoOperacion.getNumeroDocumento());
        personaDto = personaNaturalServicio.obtenerPersonaPorNumIdentificacion(contratoOperacion.getNumeroDocumento());
        System.out.println("personaDto: " + personaDto);
        if (personaDto == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "No existe persona", null));
            return;
        }
    }

    public PersonaDto getPersonaDto() {
        return personaDto;
    }

    public void setPersonaDto(PersonaDto personaDto) {
        this.personaDto = personaDto;
    }

    public void seleccionarConcesion() {
        PersonaDto pDto = personaNaturalServicio.
                obtenerPersonaPorNumIdentificacion(concesionMineraPopup.getDocumentoConcesionarioPrincipal());
        concesionMineraPopup.setNombreConcesionarioPrincipal(pDto.getNombres());
        concesionMineraPopup.setApellidoConcesionarioPrincipal(pDto.getApellidos());
        contratoOperacion.setCodigoConcesion(concesionMineraPopup);
        RequestContext.getCurrentInstance().execute("PF('dlgBusqCod').hide()");
    }

    public void seleccionarPersona() {
        contratoOperacion.setNumeroDocumento(personaDto.getIdentificacion());
        RequestContext.getCurrentInstance().execute("PF('dlgBusqPersona').hide()");
    }

    public String getCodigoFiltro() {
        return codigoFiltro;
    }

    public void setCodigoFiltro(String codigoFiltro) {
        this.codigoFiltro = codigoFiltro;
    }

    public LoginCtrl getLogin() {
        return login;
    }

    public void setLogin(LoginCtrl login) {
        this.login = login;
    }

    public List<SelectItem> getProvincias() {
        if (provincias == null) {
            provincias = new ArrayList<>();
            Localidad catalogoProvincia = localidadServicio.findByNemonico("EC").get(0);
            List<Localidad> provinciasCat = localidadServicio.findByLocalidadPadre(BigInteger.valueOf(catalogoProvincia.getCodigoLocalidad()));

            for (Localidad provincia : provinciasCat) {
                provincias.add(new SelectItem(provincia.getCodigoLocalidad().toString(), provincia.getNombre().toUpperCase()));
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
            if (contratoOperacion.getCodigoProvincia() == null
                    || contratoOperacion.getCodigoProvincia().getCodigoLocalidad() == null) {
                return cantones;
            }
            Localidad catalogoCanton = localidadServicio.findByPk(Long.valueOf(contratoOperacion.getCodigoProvincia().getCodigoLocalidad().toString()));
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

    public List<SelectItem> getParroquias() {
        if (parroquias == null) {
            parroquias = new ArrayList<>();
            if (contratoOperacion.getCodigoCanton() == null
                    || contratoOperacion.getCodigoCanton().getCodigoLocalidad() == null) {
                return parroquias;
            }
            Localidad catalogoParroquia = localidadServicio.findByPk(Long.valueOf(contratoOperacion.getCodigoCanton().getCodigoLocalidad().toString()));
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

    public void cargaCantones() {
        cantones = null;
        parroquias = null;
        contratoOperacion.getCodigoCanton().setCodigoLocalidad(null);
        getCantones();
        getParroquias();
    }

    public void cargaParroquias() {
        parroquias = null;
        getParroquias();
    }
}
