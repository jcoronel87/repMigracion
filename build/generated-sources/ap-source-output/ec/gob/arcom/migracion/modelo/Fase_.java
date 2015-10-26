package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-23T19:42:28")
@StaticMetamodel(Fase.class)
public class Fase_ { 

    public static volatile SingularAttribute<Fase, String> nombreFase;
    public static volatile SingularAttribute<Fase, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<Fase, String> nemonicoFase;
    public static volatile SingularAttribute<Fase, String> descripcionFase;
    public static volatile SingularAttribute<Fase, Long> codigoFase;
    public static volatile ListAttribute<Fase, ConcesionMinera> concesionMineraList;
    public static volatile SingularAttribute<Fase, Date> fechaCreacion;
    public static volatile SingularAttribute<Fase, Date> fechaModificacion;
    public static volatile SingularAttribute<Fase, Boolean> estadoRegistro;
    public static volatile SingularAttribute<Fase, BigInteger> usuarioCreacion;

}