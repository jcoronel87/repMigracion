package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.AreaMinera;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.LicenciaComercializacion;
import ec.gob.arcom.migracion.modelo.PlantaBeneficio;
import ec.gob.arcom.migracion.modelo.SujetoMinero;
import ec.gob.arcom.migracion.modelo.TipoMineria;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(Instrumento.class)
public class Instrumento_ { 

    public static volatile SingularAttribute<Instrumento, BigInteger> codigoCostoServicios;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<Instrumento, String> numeroDocumentoCompareciente;
    public static volatile SingularAttribute<Instrumento, BigInteger> resolucionId;
    public static volatile SingularAttribute<Instrumento, String> observaciones;
    public static volatile SingularAttribute<Instrumento, CatalogoDetalle> claseInscripcion;
    public static volatile SingularAttribute<Instrumento, Boolean> institucionOtorgante;
    public static volatile SingularAttribute<Instrumento, ConcesionMinera> concesionMinera;
    public static volatile SingularAttribute<Instrumento, CatalogoDetalle> tipoDocumentoOtorgamiento;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoPago;
    public static volatile SingularAttribute<Instrumento, String> notaria;
    public static volatile SingularAttribute<Instrumento, SujetoMinero> sujetoMinero;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<Instrumento, String> nombreCompareciente;
    public static volatile SingularAttribute<Instrumento, Date> fechaCreacion;
    public static volatile SingularAttribute<Instrumento, PlantaBeneficio> plantaBeneficio;
    public static volatile SingularAttribute<Instrumento, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Instrumento, String> documentoTitular;
    public static volatile SingularAttribute<Instrumento, String> entidadTramite;
    public static volatile SingularAttribute<Instrumento, String> campoReservado01;
    public static volatile SingularAttribute<Instrumento, String> campoReservado02;
    public static volatile SingularAttribute<Instrumento, String> campoReservado03;
    public static volatile SingularAttribute<Instrumento, String> campoReservado04;
    public static volatile SingularAttribute<Instrumento, Date> fechaProtocolizacionNotaria;
    public static volatile SingularAttribute<Instrumento, String> campoReservado05;
    public static volatile SingularAttribute<Instrumento, BigDecimal> valorInstrumento;
    public static volatile SingularAttribute<Instrumento, BigInteger> numeroInscripcion;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoConceptoPago;
    public static volatile SingularAttribute<Instrumento, String> naturalezaActo;
    public static volatile SingularAttribute<Instrumento, LicenciaComercializacion> licenciaComercializacion;
    public static volatile SingularAttribute<Instrumento, String> nombreOtorgante;
    public static volatile SingularAttribute<Instrumento, BigInteger> folioInscripcion;
    public static volatile SingularAttribute<Instrumento, BigInteger> tomoInscripcion;
    public static volatile SingularAttribute<Instrumento, Date> fechaInscripcion;
    public static volatile SingularAttribute<Instrumento, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoCanton;
    public static volatile SingularAttribute<Instrumento, Boolean> datosActualizados;
    public static volatile SingularAttribute<Instrumento, CatalogoDetalle> tipoInstrumento;
    public static volatile SingularAttribute<Instrumento, Long> codigoUsuario;
    public static volatile SingularAttribute<Instrumento, BigInteger> numeroRepertorio;
    public static volatile SingularAttribute<Instrumento, String> nombreInstitucionOtorgante;
    public static volatile SingularAttribute<Instrumento, TipoMineria> codigoTipoMineria;
    public static volatile SingularAttribute<Instrumento, Date> fechaModificacion;
    public static volatile SingularAttribute<Instrumento, Long> codigoInstrumento;
    public static volatile SingularAttribute<Instrumento, Boolean> aplicaPago;
    public static volatile SingularAttribute<Instrumento, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Instrumento, AreaMinera> codigoArea;
    public static volatile SingularAttribute<Instrumento, String> apellidoOtorgante;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoLocalidad;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoTramite;
    public static volatile SingularAttribute<Instrumento, BigInteger> numeroTramite;
    public static volatile SingularAttribute<Instrumento, Date> fechaOtorgamiento;
    public static volatile SingularAttribute<Instrumento, CatalogoDetalle> libroInscripcion;
    public static volatile SingularAttribute<Instrumento, String> numeroDocumentoOtorgante;
    public static volatile SingularAttribute<Instrumento, String> apellidoCompareciente;
    public static volatile SingularAttribute<Instrumento, BigInteger> codigoSolicitud;

}