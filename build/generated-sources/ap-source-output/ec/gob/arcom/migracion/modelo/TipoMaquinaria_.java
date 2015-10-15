package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.MaquinariaConcesion;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(TipoMaquinaria.class)
public class TipoMaquinaria_ { 

    public static volatile SingularAttribute<TipoMaquinaria, CatalogoDetalle> formaExplotacion;
    public static volatile CollectionAttribute<TipoMaquinaria, MaquinariaConcesion> maquinariaConcesionCollection;
    public static volatile SingularAttribute<TipoMaquinaria, CatalogoDetalle> tipoMaterial;
    public static volatile SingularAttribute<TipoMaquinaria, Long> codigoTipoMaquinaria;
    public static volatile SingularAttribute<TipoMaquinaria, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<TipoMaquinaria, CatalogoDetalle> tipoModalidad;
    public static volatile SingularAttribute<TipoMaquinaria, String> nemonico;
    public static volatile SingularAttribute<TipoMaquinaria, String> descripcion;
    public static volatile SingularAttribute<TipoMaquinaria, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoMaquinaria, Date> fechaModificacion;
    public static volatile SingularAttribute<TipoMaquinaria, Boolean> estadoRegistro;
    public static volatile SingularAttribute<TipoMaquinaria, BigInteger> usuarioCreacion;

}