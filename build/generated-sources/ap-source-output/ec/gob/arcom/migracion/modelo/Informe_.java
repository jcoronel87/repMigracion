package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.Informe;
import ec.gob.arcom.migracion.modelo.MaquinariaConcesion;
import ec.gob.arcom.migracion.modelo.Periodo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(Informe.class)
public class Informe_ { 

    public static volatile SingularAttribute<Informe, String> antecedentes;
    public static volatile SingularAttribute<Informe, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<Informe, Serializable> xmlData;
    public static volatile SingularAttribute<Informe, String> campoReservado10;
    public static volatile SingularAttribute<Informe, BigInteger> codigoAdjunto;
    public static volatile SingularAttribute<Informe, String> destinatario;
    public static volatile SingularAttribute<Informe, String> observaciones;
    public static volatile SingularAttribute<Informe, BigInteger> secuenciaSolicitud;
    public static volatile SingularAttribute<Informe, String> consideraciones;
    public static volatile SingularAttribute<Informe, BigInteger> codigoPago;
    public static volatile SingularAttribute<Informe, String> tipoSolicitud;
    public static volatile SingularAttribute<Informe, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<Informe, CatalogoDetalle> estadoInforme;
    public static volatile SingularAttribute<Informe, Date> fechaCreacion;
    public static volatile SingularAttribute<Informe, BigDecimal> costoPatente;
    public static volatile SingularAttribute<Informe, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Informe, String> entidadTramite;
    public static volatile SingularAttribute<Informe, String> campoReservado01;
    public static volatile SingularAttribute<Informe, String> campoReservado02;
    public static volatile SingularAttribute<Informe, Informe> informe;
    public static volatile SingularAttribute<Informe, String> campoReservado03;
    public static volatile SingularAttribute<Informe, String> numeroDocumentoPersona;
    public static volatile SingularAttribute<Informe, String> campoReservado04;
    public static volatile SingularAttribute<Informe, String> campoReservado05;
    public static volatile SingularAttribute<Informe, String> campoReservado06;
    public static volatile SingularAttribute<Informe, String> campoReservado07;
    public static volatile SingularAttribute<Informe, String> campoReservado08;
    public static volatile SingularAttribute<Informe, String> campoReservado09;
    public static volatile SingularAttribute<Informe, Informe> informe1;
    public static volatile SingularAttribute<Informe, String> cargoRemitente;
    public static volatile SingularAttribute<Informe, String> remitente;
    public static volatile SingularAttribute<Informe, String> urlDocumentoAdjunto;
    public static volatile SingularAttribute<Informe, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Informe, String> claseInforme;
    public static volatile SingularAttribute<Informe, BigInteger> numeroGuia;
    public static volatile SingularAttribute<Informe, String> numeroMemorando;
    public static volatile SingularAttribute<Informe, BigInteger> codigoCanton;
    public static volatile SingularAttribute<Informe, Boolean> emiteClausula;
    public static volatile SingularAttribute<Informe, Long> codigoInforme;
    public static volatile SingularAttribute<Informe, Boolean> cumple;
    public static volatile SingularAttribute<Informe, BigInteger> codigoConcesion;
    public static volatile SingularAttribute<Informe, Boolean> confirmaPago;
    public static volatile SingularAttribute<Informe, Boolean> validado;
    public static volatile SingularAttribute<Informe, Date> fechaInforme;
    public static volatile SingularAttribute<Informe, Periodo> codigoPeriodo;
    public static volatile SingularAttribute<Informe, Date> fechaModificacion;
    public static volatile SingularAttribute<Informe, String> recomendaciones;
    public static volatile SingularAttribute<Informe, BigDecimal> valorRegalia;
    public static volatile SingularAttribute<Informe, String> observacionValidacion;
    public static volatile SingularAttribute<Informe, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Informe, String> tipoInforme;
    public static volatile SingularAttribute<Informe, BigInteger> codigoArea;
    public static volatile SingularAttribute<Informe, Date> fechaValidacion;
    public static volatile CollectionAttribute<Informe, MaquinariaConcesion> maquinariaConcesionCollection;
    public static volatile SingularAttribute<Informe, BigDecimal> valorUtilidad;
    public static volatile SingularAttribute<Informe, BigInteger> codigoTramite;
    public static volatile SingularAttribute<Informe, BigInteger> codigoSolicitud;

}