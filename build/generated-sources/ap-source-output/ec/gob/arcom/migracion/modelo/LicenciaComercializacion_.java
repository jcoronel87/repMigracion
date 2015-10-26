package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(LicenciaComercializacion.class)
public class LicenciaComercializacion_ { 

    public static volatile SingularAttribute<LicenciaComercializacion, String> apellido;
    public static volatile SingularAttribute<LicenciaComercializacion, String> direccion;
    public static volatile SingularAttribute<LicenciaComercializacion, CatalogoDetalle> codigoMineralInteres;
    public static volatile SingularAttribute<LicenciaComercializacion, Serializable> xmlData;
    public static volatile SingularAttribute<LicenciaComercializacion, String> numeroDocumento;
    public static volatile SingularAttribute<LicenciaComercializacion, String> observacionesLicencia;
    public static volatile SingularAttribute<LicenciaComercializacion, String> observaciones;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> codigoInforme;
    public static volatile SingularAttribute<LicenciaComercializacion, String> nombre;
    public static volatile SingularAttribute<LicenciaComercializacion, CatalogoDetalle> estadoLicencia;
    public static volatile SingularAttribute<LicenciaComercializacion, String> descripcionMaterialComercializar;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<LicenciaComercializacion, Date> fechaOtorga;
    public static volatile SingularAttribute<LicenciaComercializacion, Boolean> migrada;
    public static volatile SingularAttribute<LicenciaComercializacion, Date> fechaCreacion;
    public static volatile SingularAttribute<LicenciaComercializacion, Date> fechaModificacion;
    public static volatile SingularAttribute<LicenciaComercializacion, CatalogoDetalle> codigoTipoMineral;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> codigoParroquida;
    public static volatile SingularAttribute<LicenciaComercializacion, CatalogoDetalle> tipoLicencia;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<LicenciaComercializacion, String> tipoPersona;
    public static volatile SingularAttribute<LicenciaComercializacion, String> campoReservado01;
    public static volatile SingularAttribute<LicenciaComercializacion, String> campoReservado02;
    public static volatile SingularAttribute<LicenciaComercializacion, String> telefono;
    public static volatile SingularAttribute<LicenciaComercializacion, String> campoReservado03;
    public static volatile SingularAttribute<LicenciaComercializacion, String> campoReservado04;
    public static volatile SingularAttribute<LicenciaComercializacion, Date> fechaInscribe;
    public static volatile SingularAttribute<LicenciaComercializacion, String> campoReservado05;
    public static volatile SingularAttribute<LicenciaComercializacion, Date> fechaOtorgamientoLicencia;
    public static volatile SingularAttribute<LicenciaComercializacion, Long> codigoLicenciaComercializacion;
    public static volatile SingularAttribute<LicenciaComercializacion, String> codigoArcom;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<LicenciaComercializacion, String> correoElectronico;
    public static volatile SingularAttribute<LicenciaComercializacion, String> casilleroJudicial;
    public static volatile SingularAttribute<LicenciaComercializacion, Boolean> estadoRegistro;
    public static volatile SingularAttribute<LicenciaComercializacion, BigInteger> codigoCanton;

}