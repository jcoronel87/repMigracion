package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.ConceptoPago;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(TipoMineria.class)
public class TipoMineria_ { 

    public static volatile SingularAttribute<TipoMineria, String> nemonicoTipoMineria;
    public static volatile SingularAttribute<TipoMineria, BigInteger> usuarioModificacion;
    public static volatile ListAttribute<TipoMineria, ConceptoPago> conceptoPagoList;
    public static volatile SingularAttribute<TipoMineria, String> nombreTipoMineria;
    public static volatile SingularAttribute<TipoMineria, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoMineria, Long> codigoTipoMineria;
    public static volatile ListAttribute<TipoMineria, ConcesionMinera> concesionMineraList;
    public static volatile SingularAttribute<TipoMineria, Date> fechaModificacion;
    public static volatile SingularAttribute<TipoMineria, String> descripcionTipoMineria;
    public static volatile SingularAttribute<TipoMineria, Boolean> estadoRegistro;
    public static volatile SingularAttribute<TipoMineria, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<TipoMineria, Boolean> esTipoDerecho;

}