package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(SujetoMinero.class)
public class SujetoMinero_ { 

    public static volatile SingularAttribute<SujetoMinero, String> apellido;
    public static volatile SingularAttribute<SujetoMinero, String> direccion;
    public static volatile SingularAttribute<SujetoMinero, CatalogoDetalle> tipoSujetoMinero;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<SujetoMinero, String> numeroDocumentoCompareciente;
    public static volatile SingularAttribute<SujetoMinero, String> numeroDocumento;
    public static volatile SingularAttribute<SujetoMinero, String> rucCompareciente;
    public static volatile SingularAttribute<SujetoMinero, String> claseInscripcion;
    public static volatile SingularAttribute<SujetoMinero, String> observaciones;
    public static volatile SingularAttribute<SujetoMinero, String> nombre;
    public static volatile SingularAttribute<SujetoMinero, Long> codigoSujetoMinero;
    public static volatile SingularAttribute<SujetoMinero, String> notaria;
    public static volatile SingularAttribute<SujetoMinero, Date> fechaOtorgacionDerecho;
    public static volatile SingularAttribute<SujetoMinero, Date> fechaProtocolizacionDerecho;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<SujetoMinero, String> numeroRepertorio;
    public static volatile SingularAttribute<SujetoMinero, String> nombreCompareciente;
    public static volatile SingularAttribute<SujetoMinero, Date> fechaCreacion;
    public static volatile SingularAttribute<SujetoMinero, Date> fechaModificacion;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<SujetoMinero, CatalogoDetalle> estadoSujetoMinero;
    public static volatile SingularAttribute<SujetoMinero, String> naturalezaActoContrato;
    public static volatile SingularAttribute<SujetoMinero, String> telefono;
    public static volatile SingularAttribute<SujetoMinero, String> rucOtorgante;
    public static volatile SingularAttribute<SujetoMinero, String> numeroInscripcion;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<SujetoMinero, String> apellidoOtorgante;
    public static volatile SingularAttribute<SujetoMinero, String> nombreOtorgante;
    public static volatile SingularAttribute<SujetoMinero, String> email;
    public static volatile SingularAttribute<SujetoMinero, String> folioInscripcion;
    public static volatile SingularAttribute<SujetoMinero, String> tomoInscripcion;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> codigoLocalidad;
    public static volatile SingularAttribute<SujetoMinero, String> libroInscripcion;
    public static volatile SingularAttribute<SujetoMinero, String> numeroDocumentoOtorgante;
    public static volatile SingularAttribute<SujetoMinero, Date> fechaInscripcion;
    public static volatile SingularAttribute<SujetoMinero, String> apellidoCompareciente;
    public static volatile SingularAttribute<SujetoMinero, Boolean> estadoRegistro;
    public static volatile SingularAttribute<SujetoMinero, String> celular;
    public static volatile SingularAttribute<SujetoMinero, BigInteger> codigoCanton;

}