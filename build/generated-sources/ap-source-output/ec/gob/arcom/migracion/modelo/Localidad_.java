package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.AreaMinera;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.LocalidadRegional;
import ec.gob.arcom.migracion.modelo.PersonaJuridica;
import ec.gob.arcom.migracion.modelo.PersonaNatural;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.Usuario;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Localidad.class)
public class Localidad_ { 

    public static volatile ListAttribute<Localidad, PersonaNatural> personaNaturalList;
    public static volatile SingularAttribute<Localidad, String> region;
    public static volatile CollectionAttribute<Localidad, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Localidad, BigInteger> usuarioModificacion;
    public static volatile CollectionAttribute<Localidad, LocalidadRegional> localidadRegionalCollection;
    public static volatile SingularAttribute<Localidad, String> descripcion;
    public static volatile SingularAttribute<Localidad, BigInteger> localidadPadre;
    public static volatile SingularAttribute<Localidad, String> codigoInternacional;
    public static volatile ListAttribute<Localidad, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile ListAttribute<Localidad, PersonaJuridica> personaJuridicaList;
    public static volatile SingularAttribute<Localidad, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<Localidad, String> nombre;
    public static volatile SingularAttribute<Localidad, String> nemonico;
    public static volatile SingularAttribute<Localidad, Long> codigoLocalidad;
    public static volatile ListAttribute<Localidad, ConcesionMinera> concesionMineraList;
    public static volatile SingularAttribute<Localidad, Date> fechaCreacion;
    public static volatile SingularAttribute<Localidad, Date> fechaModificacion;
    public static volatile SingularAttribute<Localidad, CatalogoDetalle> tipoLocalidad;
    public static volatile SingularAttribute<Localidad, Boolean> estadoRegistro;
    public static volatile ListAttribute<Localidad, AreaMinera> areaMineraList;

}