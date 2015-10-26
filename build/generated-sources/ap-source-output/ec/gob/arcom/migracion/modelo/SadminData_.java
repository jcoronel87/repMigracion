package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.Regimen;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(SadminData.class)
public class SadminData_ { 

    public static volatile SingularAttribute<SadminData, String> sector;
    public static volatile SingularAttribute<SadminData, String> direccion;
    public static volatile SingularAttribute<SadminData, Double> superficie;
    public static volatile SingularAttribute<SadminData, String> canton1;
    public static volatile SingularAttribute<SadminData, String> parroquia1;
    public static volatile SingularAttribute<SadminData, String> provincia;
    public static volatile SingularAttribute<SadminData, String> cedulaRepresentante;
    public static volatile SingularAttribute<SadminData, String> provincia1;
    public static volatile SingularAttribute<SadminData, String> provincia2;
    public static volatile SingularAttribute<SadminData, String> representanteLegal;
    public static volatile SingularAttribute<SadminData, String> nombre;
    public static volatile SingularAttribute<SadminData, Double> orden;
    public static volatile SingularAttribute<SadminData, Date> fechaSustitucion;
    public static volatile SingularAttribute<SadminData, String> codigo;
    public static volatile SingularAttribute<SadminData, Long> id;
    public static volatile SingularAttribute<SadminData, String> tipoSolicitud;
    public static volatile SingularAttribute<SadminData, Boolean> mae;
    public static volatile SingularAttribute<SadminData, String> mineral;
    public static volatile SingularAttribute<SadminData, String> casillero;
    public static volatile SingularAttribute<SadminData, Date> fechaOtorga;
    public static volatile SingularAttribute<SadminData, String> parroquia;
    public static volatile SingularAttribute<SadminData, Date> fechaInforme;
    public static volatile SingularAttribute<SadminData, Double> f1;
    public static volatile SingularAttribute<SadminData, String> obsActosAdmPrevios;
    public static volatile SingularAttribute<SadminData, String> titular;
    public static volatile SingularAttribute<SadminData, String> mineralManifiesto;
    public static volatile SingularAttribute<SadminData, Boolean> senagua;
    public static volatile SingularAttribute<SadminData, String> cedulaRuc;
    public static volatile SingularAttribute<SadminData, String> tipoPersona;
    public static volatile SingularAttribute<SadminData, String> tipoMineral;
    public static volatile SingularAttribute<SadminData, Localidad> codigoCasilleroLocalidad;
    public static volatile SingularAttribute<SadminData, String> telefono;
    public static volatile SingularAttribute<SadminData, String> coordY;
    public static volatile SingularAttribute<SadminData, Date> fechaInscribe;
    public static volatile SingularAttribute<SadminData, Double> plazo;
    public static volatile SingularAttribute<SadminData, Double> manifiestos;
    public static volatile SingularAttribute<SadminData, String> canton;
    public static volatile SingularAttribute<SadminData, CatalogoDetalle> codigoModalidadTrabajo;
    public static volatile SingularAttribute<SadminData, String> fase;
    public static volatile SingularAttribute<SadminData, String> metodoExplotacion;
    public static volatile SingularAttribute<SadminData, String> coordX;
    public static volatile SingularAttribute<SadminData, Double> codPersona;
    public static volatile SingularAttribute<SadminData, String> estado;
    public static volatile SingularAttribute<SadminData, String> email;
    public static volatile SingularAttribute<SadminData, String> regional;
    public static volatile SingularAttribute<SadminData, Regimen> codigoRegimen;
    public static volatile SingularAttribute<SadminData, Double> zona;

}