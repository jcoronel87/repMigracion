package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.Localidad;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(PersonaNatural.class)
public class PersonaNatural_ { 

    public static volatile SingularAttribute<PersonaNatural, String> apellido;
    public static volatile SingularAttribute<PersonaNatural, String> direccion;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<PersonaNatural, String> numeroDocumento;
    public static volatile SingularAttribute<PersonaNatural, String> ruc;
    public static volatile SingularAttribute<PersonaNatural, Date> fechaNacimiento;
    public static volatile SingularAttribute<PersonaNatural, String> nombre;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> edad;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<PersonaNatural, Long> tipoDocumento;
    public static volatile SingularAttribute<PersonaNatural, Date> fechaCreacion;
    public static volatile SingularAttribute<PersonaNatural, Date> fechaModificacion;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<PersonaNatural, String> campoReservado01;
    public static volatile SingularAttribute<PersonaNatural, String> campoReservado02;
    public static volatile SingularAttribute<PersonaNatural, String> telefono;
    public static volatile SingularAttribute<PersonaNatural, String> campoReservado03;
    public static volatile SingularAttribute<PersonaNatural, String> campoReservado04;
    public static volatile SingularAttribute<PersonaNatural, String> campoReservado05;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<PersonaNatural, CatalogoDetalle> genero;
    public static volatile SingularAttribute<PersonaNatural, String> email;
    public static volatile SingularAttribute<PersonaNatural, Localidad> codigoLocalidad;
    public static volatile SingularAttribute<PersonaNatural, String> casilleroJudicial;
    public static volatile SingularAttribute<PersonaNatural, Boolean> estadoRegistro;
    public static volatile SingularAttribute<PersonaNatural, BigInteger> codigoCanton;
    public static volatile SingularAttribute<PersonaNatural, String> celular;

}