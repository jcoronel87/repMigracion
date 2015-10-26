package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.SolicitudDetalle;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Solicitud.class)
public class Solicitud_ { 

    public static volatile SingularAttribute<Solicitud, BigInteger> estadoSolicitud;
    public static volatile SingularAttribute<Solicitud, String> apellidoRepresentanteLegal;
    public static volatile SingularAttribute<Solicitud, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<Solicitud, String> materialInteres;
    public static volatile SingularAttribute<Solicitud, String> campoReservado10;
    public static volatile SingularAttribute<Solicitud, Long> secuenciaSolicitud;
    public static volatile SingularAttribute<Solicitud, String> representanteLegal;
    public static volatile SingularAttribute<Solicitud, Integer> edadSolicitante;
    public static volatile SingularAttribute<Solicitud, String> tipoSolicitud;
    public static volatile SingularAttribute<Solicitud, String> codigoCensal;
    public static volatile SingularAttribute<Solicitud, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<Solicitud, Date> fechaCreacion;
    public static volatile SingularAttribute<Solicitud, String> tipoMaterial;
    public static volatile SingularAttribute<Solicitud, String> tipoCoordenada;
    public static volatile SingularAttribute<Solicitud, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Solicitud, String> nombreConcesionarioPrincipal;
    public static volatile SingularAttribute<Solicitud, String> modalidad;
    public static volatile SingularAttribute<Solicitud, String> campoReservado01;
    public static volatile SingularAttribute<Solicitud, String> campoReservado02;
    public static volatile SingularAttribute<Solicitud, String> ciudadSolicitante;
    public static volatile SingularAttribute<Solicitud, String> campoReservado03;
    public static volatile SingularAttribute<Solicitud, String> campoReservado04;
    public static volatile SingularAttribute<Solicitud, String> campoReservado05;
    public static volatile SingularAttribute<Solicitud, String> campoReservado06;
    public static volatile SingularAttribute<Solicitud, String> campoReservado07;
    public static volatile SingularAttribute<Solicitud, String> campoReservado08;
    public static volatile SingularAttribute<Solicitud, String> campoReservado09;
    public static volatile SingularAttribute<Solicitud, String> documentoConcesionarioPrincipal;
    public static volatile SingularAttribute<Solicitud, String> casilleroJudicial;
    public static volatile SingularAttribute<Solicitud, BigInteger> plazoConcesion;
    public static volatile SingularAttribute<Solicitud, Boolean> aceptaCondiciones;
    public static volatile SingularAttribute<Solicitud, Date> fechaNacimientoSolicitante;
    public static volatile SingularAttribute<Solicitud, String> documentoSolicitante;
    public static volatile SingularAttribute<Solicitud, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Solicitud, Double> numeroHectareas;
    public static volatile SingularAttribute<Solicitud, BigInteger> codigoCanton;
    public static volatile SingularAttribute<Solicitud, String> telefonoConvencionalSolicitante;
    public static volatile SingularAttribute<Solicitud, Date> fechaSolicitud;
    public static volatile SingularAttribute<Solicitud, BigInteger> codigoInforme;
    public static volatile SingularAttribute<Solicitud, BigInteger> codigoUsuario;
    public static volatile SingularAttribute<Solicitud, String> emailSolicitante;
    public static volatile SingularAttribute<Solicitud, String> rucSolicitante;
    public static volatile SingularAttribute<Solicitud, String> apellidoSolicitante;
    public static volatile SingularAttribute<Solicitud, Boolean> migrada;
    public static volatile SingularAttribute<Solicitud, String> tipoDocumento;
    public static volatile SingularAttribute<Solicitud, Double> volumenDiarioExplotacion;
    public static volatile SingularAttribute<Solicitud, Date> fechaModificacion;
    public static volatile SingularAttribute<Solicitud, String> nombreRepresentanteLegal;
    public static volatile SingularAttribute<Solicitud, String> apellidoConcesionarioPrincipal;
    public static volatile SingularAttribute<Solicitud, String> telefonoCelularSolicitante;
    public static volatile SingularAttribute<Solicitud, String> direccionSolicitante;
    public static volatile SingularAttribute<Solicitud, String> tipoPersona;
    public static volatile SingularAttribute<Solicitud, String> nombreArea;
    public static volatile SingularAttribute<Solicitud, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Solicitud, String> formaExplotacion;
    public static volatile ListAttribute<Solicitud, SolicitudDetalle> solicitudDetalleList;
    public static volatile SingularAttribute<Solicitud, String> nombreSolicitante;
    public static volatile SingularAttribute<Solicitud, String> nombreRazonSocial;
    public static volatile SingularAttribute<Solicitud, String> zona;
    public static volatile SingularAttribute<Solicitud, Double> volumenTotalExplotacion;
    public static volatile SingularAttribute<Solicitud, Long> codigoSolicitud;

}