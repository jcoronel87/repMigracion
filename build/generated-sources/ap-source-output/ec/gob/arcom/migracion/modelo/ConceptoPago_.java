package ec.gob.arcom.migracion.modelo;

import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import ec.gob.arcom.migracion.modelo.TipoMineria;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-15T09:46:38")
@StaticMetamodel(ConceptoPago.class)
public class ConceptoPago_ { 

    public static volatile SingularAttribute<ConceptoPago, String> descripcionConceptoPago;
    public static volatile SingularAttribute<ConceptoPago, BigInteger> usuarioModificacion;
    public static volatile SingularAttribute<ConceptoPago, String> nombreConceptoPago;
    public static volatile SingularAttribute<ConceptoPago, Date> fechaCreacion;
    public static volatile SingularAttribute<ConceptoPago, TipoMineria> codigoTipoMineria;
    public static volatile SingularAttribute<ConceptoPago, String> nemonicoConceptoPago;
    public static volatile SingularAttribute<ConceptoPago, Date> fechaModificacion;
    public static volatile ListAttribute<ConceptoPago, RegistroPagoObligaciones> registroPagoObligacionesList;
    public static volatile SingularAttribute<ConceptoPago, Boolean> estadoRegistro;
    public static volatile SingularAttribute<ConceptoPago, BigInteger> usuarioCreacion;
    public static volatile SingularAttribute<ConceptoPago, Long> codigoConceptoPago;

}