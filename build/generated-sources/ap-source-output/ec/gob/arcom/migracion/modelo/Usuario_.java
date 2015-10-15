package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.Localidad;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellido;
    public static volatile SingularAttribute<Usuario, String> direccion;
    public static volatile SingularAttribute<Usuario, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<Usuario, String> numeroDocumento;
    public static volatile SingularAttribute<Usuario, Long> codigoUsuario;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> tipoUsuario;
    public static volatile SingularAttribute<Usuario, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<Usuario, Date> fechaCreacion;
    public static volatile SingularAttribute<Usuario, String> login;
    public static volatile SingularAttribute<Usuario, Date> fechaModificacion;
    public static volatile SingularAttribute<Usuario, String> clave;
    public static volatile SingularAttribute<Usuario, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Usuario, String> campoReservado01;
    public static volatile SingularAttribute<Usuario, String> campoReservado02;
    public static volatile SingularAttribute<Usuario, String> telefono;
    public static volatile SingularAttribute<Usuario, String> campoReservado03;
    public static volatile SingularAttribute<Usuario, String> campoReservado04;
    public static volatile SingularAttribute<Usuario, String> campoReservado05;
    public static volatile SingularAttribute<Usuario, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Usuario, String> correoElectronico;
    public static volatile SingularAttribute<Usuario, Localidad> codigoLocalidad;
    public static volatile SingularAttribute<Usuario, String> casilleroJudicial;
    public static volatile SingularAttribute<Usuario, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Usuario, BigInteger> codigoCanton;
    public static volatile SingularAttribute<Usuario, String> celular;

}