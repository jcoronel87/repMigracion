/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author CoronelJa
 */
@Entity
@Table(name = "planta_beneficio", catalog = "arcom_catmin", schema = "catmin")
@NamedQueries({
    @NamedQuery(name = "PlantaBeneficio.findAll", query = "SELECT p FROM PlantaBeneficio p")})
public class PlantaBeneficio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_planta_beneficio")
    private Long codigoPlantaBeneficio;
    @Size(max = 100)
    @Column(name = "nombre_planta_beneficio")
    private String nombrePlantaBeneficio;
    @Size(max = 20)
    @Column(name = "numero_documento_representante_legal")
    private String numeroDocumentoRepresentanteLegal;
    @Size(max = 100)
    @Column(name = "nombre_representante_legal")
    private String nombreRepresentanteLegal;
    @Size(max = 100)
    @Column(name = "apellido_representante_legal")
    private String apellidoRepresentanteLegal;
    @Size(max = 30)
    @Column(name = "telefono_planta")
    private String telefonoPlanta;
    @Size(max = 100)
    @Column(name = "direccion_planta")
    private String direccionPlanta;
    @Size(max = 100)
    @Column(name = "casillero_judicial")
    private String casilleroJudicial;
    @Column(name = "codigo_provincia")
    private BigInteger codigoProvincia;
    @Column(name = "codigo_canton")
    private BigInteger codigoCanton;
    @Column(name = "codigo_parroquida")
    private BigInteger codigoParroquida;
    @Size(max = 30)
    @Column(name = "material_a_explotar")
    private String materialAExplotar;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "volumen_a_explotar")
    private BigDecimal volumenAExplotar;
    @Size(max = 20)
    @Column(name = "tipo_planta")
    private String tipoPlanta;
    @Column(name = "capacidad_instalada")
    private BigDecimal capacidadInstalada;
    @Column(name = "capacidad_operativa")
    private BigDecimal capacidadOperativa;
    @Size(max = 200)
    @Column(name = "balance_metalurgico")
    private String balanceMetalurgico;
    @Size(max = 200)
    @Column(name = "ley_cabeza")
    private String leyCabeza;
    @Size(max = 200)
    @Column(name = "ley_concentrado")
    private String leyConcentrado;
    @Column(name = "tonelaje_tratamiento")
    private BigDecimal tonelajeTratamiento;
    @Column(name = "tonelaje_concentrado")
    private BigDecimal tonelajeConcentrado;
    @Column(name = "tonelaje_colas")
    private BigDecimal tonelajeColas;
    @Size(max = 200)
    @Column(name = "tipo_producto_final")
    private String tipoProductoFinal;
    @Column(name = "peso_producto_final")
    private BigDecimal pesoProductoFinal;
    @Column(name = "recuperacion")
    private BigDecimal recuperacion;
    @Size(max = 200)
    @Column(name = "relavera")
    private String relavera;
    @Column(name = "ancho_relavera")
    private BigDecimal anchoRelavera;
    @Column(name = "longitud_relavera")
    private BigDecimal longitudRelavera;
    @Size(max = 255)
    @Column(name = "campo_reservado_10")
    private String campoReservado10;
    @Size(max = 255)
    @Column(name = "campo_reservado_09")
    private String campoReservado09;
    @Size(max = 255)
    @Column(name = "campo_reservado_08")
    private String campoReservado08;
    @Size(max = 255)
    @Column(name = "campo_reservado_07")
    private String campoReservado07;
    @Size(max = 255)
    @Column(name = "campo_reservado_06")
    private String campoReservado06;
    @Size(max = 255)
    @Column(name = "campo_reservado_05")
    private String campoReservado05;
    @Size(max = 255)
    @Column(name = "campo_reservado_04")
    private String campoReservado04;
    @Size(max = 255)
    @Column(name = "campo_reservado_03")
    private String campoReservado03;
    @Size(max = 255)
    @Column(name = "campo_reservado_02")
    private String campoReservado02;
    @Size(max = 255)
    @Column(name = "campo_reservado_01")
    private String campoReservado01;
    //@Column(name = "xml_data")
    //private Serializable xmlData;
    @Column(name = "estado_registro")
    private Boolean estadoRegistro;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "usuario_creacion")
    private BigInteger usuarioCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "usuario_modificacion")
    private BigInteger usuarioModificacion;
    @Size(max = 100)
    @Column(name = "codigo_arcom")
    private String codigoArcom;
    @Column(name = "fecha_otorga")
    @Temporal(TemporalType.DATE)
    private Date fechaOtorga;
    @Column(name = "fecha_inscribe")
    @Temporal(TemporalType.DATE)
    private Date fechaInscribe;
    @JoinColumn(name = "categoria_planta", referencedColumnName = "codigo_catalogo_detalle")
    @ManyToOne
    private CatalogoDetalle categoriaPlanta;
    @JoinColumn(name = "estado_planta", referencedColumnName = "codigo_catalogo_detalle")
    @ManyToOne
    private CatalogoDetalle estadoPlanta;
    @JoinColumn(name = "unidad_peso", referencedColumnName = "codigo_catalogo_detalle")
    @ManyToOne
    private CatalogoDetalle unidadPeso;
    @Column(name = "mae")
    private boolean mae;
    @Column(name = "senagua")
    private boolean senagua;
    @Column(name = "obs_acto_administrativo")
    private String obsActoAdministrativo;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @JoinColumn(name = "codigo_procedencia_material", referencedColumnName = "codigo_catalogo_detalle")
    @ManyToOne
    private CatalogoDetalle codigoProcedenciaMaterial;
    @Column(name = "zona")
    private String zona;
    @Column(name = "plazo")
    private BigInteger plazo;
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Column(name = "migrada")
    private boolean migrada;

    public PlantaBeneficio() {
    }

    public PlantaBeneficio(Long codigoPlantaBeneficio) {
        this.codigoPlantaBeneficio = codigoPlantaBeneficio;
    }

    public Long getCodigoPlantaBeneficio() {
        return codigoPlantaBeneficio;
    }

    public void setCodigoPlantaBeneficio(Long codigoPlantaBeneficio) {
        this.codigoPlantaBeneficio = codigoPlantaBeneficio;
    }

    public String getNombrePlantaBeneficio() {
        return nombrePlantaBeneficio;
    }

    public void setNombrePlantaBeneficio(String nombrePlantaBeneficio) {
        this.nombrePlantaBeneficio = nombrePlantaBeneficio;
    }

    public String getNumeroDocumentoRepresentanteLegal() {
        return numeroDocumentoRepresentanteLegal;
    }

    public void setNumeroDocumentoRepresentanteLegal(String numeroDocumentoRepresentanteLegal) {
        this.numeroDocumentoRepresentanteLegal = numeroDocumentoRepresentanteLegal;
    }

    public String getNombreRepresentanteLegal() {
        return nombreRepresentanteLegal;
    }

    public void setNombreRepresentanteLegal(String nombreRepresentanteLegal) {
        this.nombreRepresentanteLegal = nombreRepresentanteLegal;
    }

    public String getApellidoRepresentanteLegal() {
        return apellidoRepresentanteLegal;
    }

    public void setApellidoRepresentanteLegal(String apellidoRepresentanteLegal) {
        this.apellidoRepresentanteLegal = apellidoRepresentanteLegal;
    }

    public String getTelefonoPlanta() {
        return telefonoPlanta;
    }

    public void setTelefonoPlanta(String telefonoPlanta) {
        this.telefonoPlanta = telefonoPlanta;
    }

    public String getDireccionPlanta() {
        return direccionPlanta;
    }

    public void setDireccionPlanta(String direccionPlanta) {
        this.direccionPlanta = direccionPlanta;
    }

    public String getCasilleroJudicial() {
        return casilleroJudicial;
    }

    public void setCasilleroJudicial(String casilleroJudicial) {
        this.casilleroJudicial = casilleroJudicial;
    }

    public BigInteger getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(BigInteger codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public BigInteger getCodigoCanton() {
        return codigoCanton;
    }

    public void setCodigoCanton(BigInteger codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    public BigInteger getCodigoParroquida() {
        return codigoParroquida;
    }

    public void setCodigoParroquida(BigInteger codigoParroquida) {
        this.codigoParroquida = codigoParroquida;
    }

    public String getMaterialAExplotar() {
        return materialAExplotar;
    }

    public void setMaterialAExplotar(String materialAExplotar) {
        this.materialAExplotar = materialAExplotar;
    }

    public BigDecimal getVolumenAExplotar() {
        return volumenAExplotar;
    }

    public void setVolumenAExplotar(BigDecimal volumenAExplotar) {
        this.volumenAExplotar = volumenAExplotar;
    }

    public String getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(String tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    public BigDecimal getCapacidadInstalada() {
        return capacidadInstalada;
    }

    public void setCapacidadInstalada(BigDecimal capacidadInstalada) {
        this.capacidadInstalada = capacidadInstalada;
    }

    public BigDecimal getCapacidadOperativa() {
        return capacidadOperativa;
    }

    public void setCapacidadOperativa(BigDecimal capacidadOperativa) {
        this.capacidadOperativa = capacidadOperativa;
    }

    public String getBalanceMetalurgico() {
        return balanceMetalurgico;
    }

    public void setBalanceMetalurgico(String balanceMetalurgico) {
        this.balanceMetalurgico = balanceMetalurgico;
    }

    public String getLeyCabeza() {
        return leyCabeza;
    }

    public void setLeyCabeza(String leyCabeza) {
        this.leyCabeza = leyCabeza;
    }

    public String getLeyConcentrado() {
        return leyConcentrado;
    }

    public void setLeyConcentrado(String leyConcentrado) {
        this.leyConcentrado = leyConcentrado;
    }

    public BigDecimal getTonelajeTratamiento() {
        return tonelajeTratamiento;
    }

    public void setTonelajeTratamiento(BigDecimal tonelajeTratamiento) {
        this.tonelajeTratamiento = tonelajeTratamiento;
    }

    public BigDecimal getTonelajeConcentrado() {
        return tonelajeConcentrado;
    }

    public void setTonelajeConcentrado(BigDecimal tonelajeConcentrado) {
        this.tonelajeConcentrado = tonelajeConcentrado;
    }

    public BigDecimal getTonelajeColas() {
        return tonelajeColas;
    }

    public void setTonelajeColas(BigDecimal tonelajeColas) {
        this.tonelajeColas = tonelajeColas;
    }

    public String getTipoProductoFinal() {
        return tipoProductoFinal;
    }

    public void setTipoProductoFinal(String tipoProductoFinal) {
        this.tipoProductoFinal = tipoProductoFinal;
    }

    public BigDecimal getPesoProductoFinal() {
        return pesoProductoFinal;
    }

    public void setPesoProductoFinal(BigDecimal pesoProductoFinal) {
        this.pesoProductoFinal = pesoProductoFinal;
    }

    public BigDecimal getRecuperacion() {
        return recuperacion;
    }

    public void setRecuperacion(BigDecimal recuperacion) {
        this.recuperacion = recuperacion;
    }

    public String getRelavera() {
        return relavera;
    }

    public void setRelavera(String relavera) {
        this.relavera = relavera;
    }

    public BigDecimal getAnchoRelavera() {
        return anchoRelavera;
    }

    public void setAnchoRelavera(BigDecimal anchoRelavera) {
        this.anchoRelavera = anchoRelavera;
    }

    public BigDecimal getLongitudRelavera() {
        return longitudRelavera;
    }

    public void setLongitudRelavera(BigDecimal longitudRelavera) {
        this.longitudRelavera = longitudRelavera;
    }

    public String getCampoReservado10() {
        return campoReservado10;
    }

    public void setCampoReservado10(String campoReservado10) {
        this.campoReservado10 = campoReservado10;
    }

    public String getCampoReservado09() {
        return campoReservado09;
    }

    public void setCampoReservado09(String campoReservado09) {
        this.campoReservado09 = campoReservado09;
    }

    public String getCampoReservado08() {
        return campoReservado08;
    }

    public void setCampoReservado08(String campoReservado08) {
        this.campoReservado08 = campoReservado08;
    }

    public String getCampoReservado07() {
        return campoReservado07;
    }

    public void setCampoReservado07(String campoReservado07) {
        this.campoReservado07 = campoReservado07;
    }

    public String getCampoReservado06() {
        return campoReservado06;
    }

    public void setCampoReservado06(String campoReservado06) {
        this.campoReservado06 = campoReservado06;
    }

    public String getCampoReservado05() {
        return campoReservado05;
    }

    public void setCampoReservado05(String campoReservado05) {
        this.campoReservado05 = campoReservado05;
    }

    public String getCampoReservado04() {
        return campoReservado04;
    }

    public void setCampoReservado04(String campoReservado04) {
        this.campoReservado04 = campoReservado04;
    }

    public String getCampoReservado03() {
        return campoReservado03;
    }

    public void setCampoReservado03(String campoReservado03) {
        this.campoReservado03 = campoReservado03;
    }

    public String getCampoReservado02() {
        return campoReservado02;
    }

    public void setCampoReservado02(String campoReservado02) {
        this.campoReservado02 = campoReservado02;
    }

    public String getCampoReservado01() {
        return campoReservado01;
    }

    public void setCampoReservado01(String campoReservado01) {
        this.campoReservado01 = campoReservado01;
    }

    /*public Serializable getXmlData() {
        return xmlData;
    }

    public void setXmlData(Serializable xmlData) {
        this.xmlData = xmlData;
    }*/

    public Boolean getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(Boolean estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigInteger getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(BigInteger usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public BigInteger getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(BigInteger usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getCodigoArcom() {
        return codigoArcom;
    }

    public void setCodigoArcom(String codigoArcom) {
        this.codigoArcom = codigoArcom;
    }

    public Date getFechaOtorga() {
        return fechaOtorga;
    }

    public void setFechaOtorga(Date fechaOtorga) {
        this.fechaOtorga = fechaOtorga;
    }

    public Date getFechaInscribe() {
        return fechaInscribe;
    }

    public void setFechaInscribe(Date fechaInscribe) {
        this.fechaInscribe = fechaInscribe;
    }

    public CatalogoDetalle getCategoriaPlanta() {
        return categoriaPlanta;
    }

    public void setCategoriaPlanta(CatalogoDetalle categoriaPlanta) {
        this.categoriaPlanta = categoriaPlanta;
    }

    public CatalogoDetalle getEstadoPlanta() {
        return estadoPlanta;
    }

    public void setEstadoPlanta(CatalogoDetalle estadoPlanta) {
        this.estadoPlanta = estadoPlanta;
    }

    public CatalogoDetalle getUnidadPeso() {
        return unidadPeso;
    }

    public void setUnidadPeso(CatalogoDetalle unidadPeso) {
        this.unidadPeso = unidadPeso;
    }

    public boolean isMae() {
        return mae;
    }

    public void setMae(boolean mae) {
        this.mae = mae;
    }

    public boolean isSenagua() {
        return senagua;
    }

    public void setSenagua(boolean senagua) {
        this.senagua = senagua;
    }

    public String getObsActoAdministrativo() {
        return obsActoAdministrativo;
    }

    public void setObsActoAdministrativo(String obsActoAdministrativo) {
        this.obsActoAdministrativo = obsActoAdministrativo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public CatalogoDetalle getCodigoProcedenciaMaterial() {
        return codigoProcedenciaMaterial;
    }

    public void setCodigoProcedenciaMaterial(CatalogoDetalle codigoProcedenciaMaterial) {
        this.codigoProcedenciaMaterial = codigoProcedenciaMaterial;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public BigInteger getPlazo() {
        return plazo;
    }

    public void setPlazo(BigInteger plazo) {
        this.plazo = plazo;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public boolean isMigrada() {
        return migrada;
    }

    public void setMigrada(boolean migrada) {
        this.migrada = migrada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPlantaBeneficio != null ? codigoPlantaBeneficio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantaBeneficio)) {
            return false;
        }
        PlantaBeneficio other = (PlantaBeneficio) object;
        if ((this.codigoPlantaBeneficio == null && other.codigoPlantaBeneficio != null) || (this.codigoPlantaBeneficio != null && !this.codigoPlantaBeneficio.equals(other.codigoPlantaBeneficio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PlantaBeneficio{" + "codigoPlantaBeneficio=" + codigoPlantaBeneficio + ", nombrePlantaBeneficio=" + nombrePlantaBeneficio + ", numeroDocumentoRepresentanteLegal=" + numeroDocumentoRepresentanteLegal
                + ", nombreRepresentanteLegal=" + nombreRepresentanteLegal + ", apellidoRepresentanteLegal=" + apellidoRepresentanteLegal + ", telefonoPlanta=" + telefonoPlanta + ", direccionPlanta=" + direccionPlanta
                + ", casilleroJudicial=" + casilleroJudicial + ", codigoProvincia=" + codigoProvincia + ", codigoCanton=" + codigoCanton + ", codigoParroquida=" + codigoParroquida + ", materialAExplotar="
                + materialAExplotar + ", volumenAExplotar=" + volumenAExplotar + ", tipoPlanta=" + tipoPlanta + ", capacidadInstalada=" + capacidadInstalada + ", capacidadOperativa=" + capacidadOperativa
                + ", balanceMetalurgico=" + balanceMetalurgico + ", leyCabeza=" + leyCabeza + ", leyConcentrado=" + leyConcentrado + ", tonelajeTratamiento=" + tonelajeTratamiento + ", tonelajeConcentrado="
                + tonelajeConcentrado + ", tonelajeColas=" + tonelajeColas + ", tipoProductoFinal=" + tipoProductoFinal + ", pesoProductoFinal=" + pesoProductoFinal + ", recuperacion=" + recuperacion + ", relavera="
                + relavera + ", anchoRelavera=" + anchoRelavera + ", longitudRelavera=" + longitudRelavera + ", campoReservado10=" + campoReservado10 + ", campoReservado09=" + campoReservado09 + ", campoReservado08="
                + campoReservado08 + ", campoReservado07=" + campoReservado07 + ", campoReservado06=" + campoReservado06 + ", campoReservado05=" + campoReservado05 + ", campoReservado04=" + campoReservado04
                + ", campoReservado03=" + campoReservado03 + ", campoReservado02=" + campoReservado02 + ", campoReservado01=" + campoReservado01 + ", estadoRegistro=" + estadoRegistro + ", fechaCreacion="
                + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + ", fechaModificacion=" + fechaModificacion + ", usuarioModificacion=" + usuarioModificacion + ", codigoArcom=" + codigoArcom + ", fechaOtorga="
                + fechaOtorga + ", fechaInscribe=" + fechaInscribe + ", categoriaPlanta=" + (categoriaPlanta != null ? categoriaPlanta.getCodigoCatalogoDetalle() : null) + ", estadoPlanta=" + (estadoPlanta != null ? estadoPlanta.getCodigoCatalogoDetalle() : null)
                + ", unidadPeso=" + (unidadPeso != null ? unidadPeso.getCodigoCatalogoDetalle() : null) + ", mae=" + mae + ", senagua=" + senagua + ", obsActoAdministrativo=" + obsActoAdministrativo + ", correoElectronico=" + correoElectronico
                + ", codigoProcedenciaMaterial=" + (codigoProcedenciaMaterial != null ? codigoProcedenciaMaterial.getCodigoCatalogoDetalle() : null) + ", zona=" + zona + ", plazo=" + plazo + ", tipoPersona=" + tipoPersona + ", migrada=" + migrada + '}';
    }

}
