package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.Localidad;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(PersonaJuridica.class)
public class PersonaJuridica_ { 

    public static volatile SingularAttribute<PersonaJuridica, String> direccion;
    public static volatile SingularAttribute<PersonaJuridica, String> apellidoRepresentanteLegal;
    public static volatile SingularAttribute<PersonaJuridica, BigInteger> codigoParroquia;
    public static volatile SingularAttribute<PersonaJuridica, String> ruc;
    public static volatile SingularAttribute<PersonaJuridica, Date> fechaConstitucion;
    public static volatile SingularAttribute<PersonaJuridica, BigInteger> codigoProvincia;
    public static volatile SingularAttribute<PersonaJuridica, String> nombreLegal;
    public static volatile SingularAttribute<PersonaJuridica, Date> fechaCreacion;
    public static volatile SingularAttribute<PersonaJuridica, Date> fechaModificacion;
    public static volatile SingularAttribute<PersonaJuridica, String> nombreComercial;
    public static volatile SingularAttribute<PersonaJuridica, String> nombreRepresentanteLegal;
    public static volatile SingularAttribute<PersonaJuridica, String> documentoRepresentanteLegal;
    public static volatile SingularAttribute<PersonaJuridica, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<PersonaJuridica, String> campoReservado01;
    public static volatile SingularAttribute<PersonaJuridica, String> campoReservado02;
    public static volatile SingularAttribute<PersonaJuridica, String> telefono;
    public static volatile SingularAttribute<PersonaJuridica, String> campoReservado03;
    public static volatile SingularAttribute<PersonaJuridica, String> campoReservado04;
    public static volatile SingularAttribute<PersonaJuridica, Boolean> esPublica;
    public static volatile SingularAttribute<PersonaJuridica, String> campoReservado05;
    public static volatile SingularAttribute<PersonaJuridica, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<PersonaJuridica, CatalogoDetalle> clasePersona;
    public static volatile SingularAttribute<PersonaJuridica, String> email;
    public static volatile SingularAttribute<PersonaJuridica, Localidad> codigoLocalidad;
    public static volatile SingularAttribute<PersonaJuridica, String> casilleroJudicial;
    public static volatile SingularAttribute<PersonaJuridica, Boolean> estadoRegistro;
    public static volatile SingularAttribute<PersonaJuridica, BigInteger> codigoCanton;
    public static volatile SingularAttribute<PersonaJuridica, String> celular;

}