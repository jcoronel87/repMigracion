/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.constantes.ConstantesEnum;
import ec.gob.arcom.migracion.dao.ConcesionMineraDao;
import ec.gob.arcom.migracion.dto.ConcesionMineraDto;
import ec.gob.arcom.migracion.dto.DerechoMineroDto;
import ec.gob.arcom.migracion.modelo.CatalogoDetalle;
import ec.gob.arcom.migracion.modelo.ConcesionMinera;
import ec.gob.arcom.migracion.modelo.Fase;
import ec.gob.arcom.migracion.modelo.Localidad;
import ec.gob.arcom.migracion.modelo.Regional;
import ec.gob.arcom.migracion.servicio.CatalogoDetalleServicio;
import ec.gob.arcom.migracion.servicio.FaseServicio;
import ec.gob.arcom.migracion.servicio.LocalidadServicio;
import ec.gob.arcom.migracion.servicio.RegionalServicio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "ConcesionMineraDao")
public class ConcesionMineraDaoEjb extends GenericDaoEjbEl<ConcesionMinera, Long> implements
        ConcesionMineraDao {

    @EJB
    private RegionalServicio regionalServicio;
    @EJB
    private FaseServicio faseServicio;
    @EJB
    private LocalidadServicio localidadServicio;
    @EJB
    private CatalogoDetalleServicio catalogoDetalleServicio;

    public ConcesionMineraDaoEjb() {
        super(ConcesionMinera.class);
    }

    @Override
    public List<ConcesionMineraDto> obtenerRegistrosPorUsuario(String cedulaRuc, String codigoFiltro, String cedulaTitularFiltro, String nombreAreaFiltro) {
        if (codigoFiltro == null || codigoFiltro.trim().isEmpty()) {
            codigoFiltro = "-1";
        }
        if (cedulaTitularFiltro == null || cedulaTitularFiltro.trim().isEmpty()) {
            cedulaTitularFiltro = "-1";
        }
        if (nombreAreaFiltro == null || nombreAreaFiltro.trim().isEmpty()) {
            nombreAreaFiltro = "-1";
        }
        String sql_ = "select\n"
                + "id as id,                                             codigo as codigo_arcom,                            nombre as nombre_concesion,                                      casillero,        \n"
                + "direccion,                                                                                     telefono,                           titular as titular_nombre,                                                            cedula___ruc as titular_documento,\n"
                + "representante_legal,      cedula_representante,                                 plazo,                                                               fecha_informe,\n"
                + "                                                 superficie,                                                                                    estado,                                                            fase,\n"
                + "tipo_solicitud,                  fecha_otorga,                                                              fecha_inscribe,                                \n"
                + "regional,                                           provincia2 as provincia,                canton1 as canton,                                       parroquia1 as parroquia,                                                          mineral,                                            \n"
                + "orden,                                                                                           coord_x,                                                                                        coord_y,                                                          \n"
                + "manifiestos,                      mineral_manifiesto,                                                    fecha_sustitucion,                          \n"
                + "'S' tipo_tabla \n"
                + "from catmin.sadmin_data_ where orden = 0 \n"
                + "and regional = (select nombre_regional from catmin.localidad_regional l, catmin.usuario, catmin.regional r where numero_documento = '" + cedulaRuc + "'\n"
                + "                and codigo_provincia = l.codigo_localidad\n"
                + "                and l.codigo_regional = r.codigo_regional\n"
                + "                ) \n"
                + "and codigo not in (select codigo_arcom from catmin.concesion_minera c where c.migrada = true and codigo_arcom is not null)\n"
                + "and codigo not in (select codigo_arcom from catmin.licencia_comercializacion l where l.migrada = true and codigo_arcom is not null)\n"
                + "and codigo not in (select codigo_arcom from catmin.planta_beneficio p where p.migrada = true and codigo_arcom is not null)\n"
                + "and ('-1' = '" + codigoFiltro + "' or catmin.sadmin_data_.codigo like '%" + codigoFiltro + "%')\n"
                + "and ('-1' = '" + cedulaTitularFiltro + "' or catmin.sadmin_data_.cedula___ruc like '%" + cedulaTitularFiltro + "%')\n"
                + "and ('-1' = '" + nombreAreaFiltro + "' or lower(catmin.sadmin_data_.nombre) like lower('%" + nombreAreaFiltro + "%'))\n"
                + "union all\n"
                + "\n"
                + "SELECT\n"
                + "cm.codigo_concesion as id,                       cm.codigo_arcom as codigo_arcom,                cm.nombre_concesion as nombre_concesion,     s.casillero_judicial,\n"
                + "    \n"
                + "    (select case when s.tipo_documento = 'Cedula' then \n"
                + "        (select catmin.format_gmadigital(direccion) from catmin.persona_natural where cm.documento_concesionario_principal = numero_documento) \n"
                + "        else \n"
                + "        (select catmin.format_gmadigital(direccion) from catmin.persona_juridica where cm.documento_concesionario_principal = ruc) \n"
                + "    end) as direccion,\n"
                + "               \n"
                + "               (select case when s.tipo_documento = 'Cedula' then \n"
                + "        (select telefono from catmin.persona_natural where cm.documento_concesionario_principal = numero_documento) \n"
                + "        else \n"
                + "        (select telefono from catmin.persona_juridica where cm.documento_concesionario_principal = ruc) \n"
                + "    end) as telefono, \n"
                + "    \n"
                + "       (select case when s.tipo_documento = 'Cedula' then \n"
                + "        (select catmin.format_gmadigital(apellido || ' ' || nombre) from catmin.persona_natural where cm.documento_concesionario_principal = numero_documento) \n"
                + "        else \n"
                + "        (select catmin.format_gmadigital(nombre_comercial) from catmin.persona_juridica where cm.documento_concesionario_principal = ruc) \n"
                + "    end) as titular_nombre,\n"
                + "    \n"
                + "               cm.documento_concesionario_principal AS titular_documento,\n"
                + "               \n"
                + "               (select case when s.tipo_documento = 'Ruc' then \n"
                + "    (select catmin.format_gmadigital(apellido_representante_legal || ' ' || nombre_representante_legal) from catmin.persona_juridica where cm.documento_concesionario_principal = ruc) \n"
                + "        else \n"
                + "        null\n"
                + "    end) as representante_legal,\n"
                + "               \n"
                + "      (select case when s.tipo_documento = 'Ruc' then \n"
                + "    (select documento_representante_legal from catmin.persona_juridica where cm.documento_concesionario_principal = ruc) \n"
                + "        else \n"
                + "        null\n"
                + "    end) as cedula_representante,\n"
                + "               \n"
                + "    s.plazo_concesion,                    cast(null as date) as fecha_informe,                                       \n"
                + "    \n"
                + "               (select superficie_area_minera from catmin.catalogo_detalle, catmin.area_minera where codigo_catalogo_detalle = estado_area \n"
                + "        and codigo_area_minera = (select max(codigo_area_minera) from catmin.area_minera where codigo_concesion = cm.codigo_concesion)) as superficie,\n"
                + "               \n"
                + "                   (select nombre from catmin.catalogo_detalle, catmin.area_minera where codigo_catalogo_detalle = estado_area \n"
                + "        and codigo_area_minera = (select max(codigo_area_minera) from catmin.area_minera where codigo_concesion = cm.codigo_concesion)) as estado,\n"
                + "        \n"
                + "                (select nombre_fase from catmin.fase where codigo_fase = cm.codigo_fase) as fase,\n"
                + "               \n"
                + "    (select nombre_tipo_mineria from catmin.tipo_mineria where cm.codigo_tipo_mineria = codigo_tipo_mineria) as tipo_solicitud,\n"
                + "    cm.fecha_otorga,                                     fecha_inscribe, \n"
                + "    \n"
                + "    \n"
                + "                 (select nombre_regional from catmin.regional r, catmin.localidad_regional l where cm.codigo_provincia = l.codigo_localidad and r.codigo_regional = l.codigo_regional) as regional,\n"
                + "\n"
                + "    (select nombre from catmin.localidad where cm.codigo_provincia = codigo_localidad) as provincia,\n"
                + "    \n"
                + "    (select nombre from catmin.localidad where cm.codigo_canton = codigo_localidad) as canton,\n"
                + "    \n"
                + "    (select nombre from catmin.localidad where cm.codigo_parroquia = codigo_localidad) as parroquia,\n"
                + "  \n"
                + "    case when cm.tipo_material = 'Metálico' then 'METALICO' \n"
                + "        when cm.tipo_material = 'No Metálico' then 'NO METALICO' end as mineral,\n"
                + "        \n"
                + "           (select sd.numero_coordenada from catmin.solicitud_detalle sd where s.codigo_solicitud = sd.codigo_solicitud and sd.coordenada_inicial = true) as orden,    \n"
                + "           (select cast(sd.coordenada_utm_este as varchar(100)) from catmin.solicitud_detalle sd where s.codigo_solicitud = sd.codigo_solicitud and sd.coordenada_inicial = true) as coordenada_x,                             "
                + "           (select cast(sd.coordenada_utm_norte as varchar(100)) from catmin.solicitud_detalle sd where s.codigo_solicitud = sd.codigo_solicitud and sd.coordenada_inicial = true) as coordenada_y,\n"
                + "               \n"
                + "                              \n"
                + "                 (select count(*) from catmin.manifiesto_produccion where codigo_concesion = cm.codigo_concesion) as manifiestos,    \n"
                + "                \n"
                + "    catmin.format_gmadigital(s.material_interes) as mineral_manifiesto, \n"
                + "               \n"
                + "               cast(cm.campo_reservado_10 as date) as fecha_sustitucion,\n"
                + "\n"
                + "    'C' tipo_tabla \n"
                + "FROM\n"
                + "    catmin.solicitud s,\n"
                + "    catmin.concesion_minera cm\n"
                + "    \n"
                + "where cm.codigo_arcom = s.campo_reservado_10\n"
                //quitar
                //+ "and cm.codigo_provincia = (select codigo_provincia from catmin.usuario where numero_documento = '" + cedulaRuc + "') \n"
                //quitar
                + "and cm.codigo_provincia in (select lcr.codigo_localidad from catmin.localidad_regional lcr where lcr.codigo_regional = "
                + "(select r.codigo_regional from catmin.regional r, catmin.localidad_regional lr, catmin.usuario where numero_documento = '" + cedulaRuc + "'\n"
                + "                                 and r.codigo_regional = lr.codigo_regional and lr.codigo_localidad = codigo_provincia)) "
                + "and cm.migrada = true\n"
                + "and ('-1' = '" + codigoFiltro + "' or cm.codigo_arcom like '%" + codigoFiltro + "%')\n"
                + "and ('-1' = '" + cedulaTitularFiltro + "' or cm.documento_concesionario_principal like '%" + cedulaTitularFiltro + "%')\n"
                + "and ('-1' = '" + nombreAreaFiltro + "' or lower(cm.nombre_concesion) like lower('%" + nombreAreaFiltro + "%'))\n"
                + "order by 2";

        String sql = "select\n"
                + "id as id,                                             codigo as codigo_arcom,                            nombre as nombre_concesion,                                      casillero,        \n"
                + "\n"
                + "cedula___ruc as titular_documento,\n"
                + "\n"
                + "plazo,                                                               fecha_informe,\n"
                + "                                                 superficie,                                                                                    estado,                                                            fase,\n"
                + "tipo_solicitud,                  fecha_otorga,                                                              fecha_inscribe,                                \n"
                + "regional,                                           provincia2 as provincia,                canton1 as canton,                                       parroquia1 as parroquia,                                                          \n"
                + "fecha_sustitucion,                          \n"
                + "'S' tipo_tabla \n"
                + "from catmin.sadmin_data_ where orden = 0 \n"
                + "and regional = (select nombre_regional from catmin.localidad_regional l, catmin.usuario, catmin.regional r where numero_documento = '" + cedulaRuc + "'\n"
                + "                and codigo_provincia = l.codigo_localidad\n"
                + "                and l.codigo_regional = r.codigo_regional\n"
                + "                ) \n"
                + "and codigo not in (select codigo_arcom from catmin.concesion_minera c where c.migrada = true)\n"
                + "and codigo not in (select codigo_arcom from catmin.licencia_comercializacion l where l.migrada = true)\n"
                + "and codigo not in (select codigo_arcom from catmin.planta_beneficio p where p.migrada = true)\n"
                + "and ('-1' = '" + codigoFiltro + "' or catmin.sadmin_data_.codigo like '%" + codigoFiltro + "%')\n"
                + "and ('-1' = '" + cedulaTitularFiltro + "' or catmin.sadmin_data_.cedula___ruc like '%%" + cedulaTitularFiltro + "%')\n"
                + "and ('-1' = '" + nombreAreaFiltro + "' or lower(catmin.sadmin_data_.nombre) like lower('%" + nombreAreaFiltro + "%'))\n"
                + "union all\n"
                + "\n"
                + "SELECT\n"
                + "cm.codigo_concesion as id,                       cm.codigo_arcom as codigo_arcom,                cm.nombre_concesion as nombre_concesion,     s.casillero_judicial,\n"
                + "\n"
                + "    \n"
                + "               cm.documento_concesionario_principal AS titular_documento,\n"
                + "               \n"
                + "            \n"
                + "               \n"
                + "    s.plazo_concesion,                    cast(null as date) as fecha_informe,                                       \n"
                + "    \n"
                + "               (select superficie_area_minera from catmin.catalogo_detalle, catmin.area_minera where codigo_catalogo_detalle = estado_area \n"
                + "        and codigo_area_minera = (select max(codigo_area_minera) from catmin.area_minera where codigo_concesion = cm.codigo_concesion)) as superficie,\n"
                + "               \n"
                + "                   (select nombre from catmin.catalogo_detalle, catmin.area_minera where codigo_catalogo_detalle = estado_area \n"
                + "        and codigo_area_minera = (select max(codigo_area_minera) from catmin.area_minera where codigo_concesion = cm.codigo_concesion)) as estado,\n"
                + "        \n"
                + "                (select nombre_fase from catmin.fase where codigo_fase = cm.codigo_fase) as fase,\n"
                + "               \n"
                + "    (select nombre_tipo_mineria from catmin.tipo_mineria where cm.codigo_tipo_mineria = codigo_tipo_mineria) as tipo_solicitud,\n"
                + "    cm.fecha_otorga,                                     fecha_inscribe, \n"
                + "    \n"
                + "    \n"
                + "                 (select nombre_regional from catmin.regional r, catmin.localidad_regional l where cm.codigo_provincia = l.codigo_localidad and r.codigo_regional = l.codigo_regional) as regional,\n"
                + "\n"
                + "    (select nombre from catmin.localidad where cm.codigo_provincia = codigo_localidad) as provincia,\n"
                + "    \n"
                + "    (select nombre from catmin.localidad where cm.codigo_canton = codigo_localidad) as canton,\n"
                + "    \n"
                + "    (select nombre from catmin.localidad where cm.codigo_parroquia = codigo_localidad) as parroquia,\n"
                + "	\n"
                + "               cast(cm.campo_reservado_10 as date) as fecha_sustitucion,\n"
                + "\n"
                + "    'C' tipo_tabla \n"
                + "FROM\n"
                + "    catmin.solicitud s,\n"
                + "    catmin.concesion_minera cm\n"
                + "    \n"
                + "where cm.codigo_arcom = s.campo_reservado_10\n"
                + "and cm.codigo_provincia in (select lcr.codigo_localidad from catmin.localidad_regional lcr where lcr.codigo_regional = "
                + "(select r.codigo_regional from catmin.regional r, catmin.localidad_regional lr, catmin.usuario where numero_documento = '" + cedulaRuc + "'\n"
                + "                                 and r.codigo_regional = lr.codigo_regional and lr.codigo_localidad = codigo_provincia)) "
                + "and cm.migrada = true\n"
                + "and ('-1' = '" + codigoFiltro + "' or cm.codigo_arcom like '%" + codigoFiltro + "%')\n"
                + "and ('-1' = '" + cedulaTitularFiltro + "' or cm.documento_concesionario_principal like '%" + cedulaTitularFiltro + "%')\n"
                + "and ('-1' = '" + nombreAreaFiltro + "' or lower(cm.nombre_concesion) like lower('%" + nombreAreaFiltro + "%'))\n"
                + "order by 2";
        System.out.println("sql concesion: " + sql);

        Query query = em.createNativeQuery(sql);

        List<Object[]> listaTmp = query.getResultList();
        List<ConcesionMineraDto> listaFinal = new ArrayList<>();

        for (Object[] fila : listaTmp) {
            ConcesionMineraDto cmd = new ConcesionMineraDto();
            cmd.setCodigoConcesion(fila[0] != null ? Long.valueOf(fila[0].toString()) : null);
            cmd.setCodigoArcom(fila[1] != null ? fila[1].toString() : null);
            cmd.setNombreConcesion(fila[2] != null ? fila[2].toString() : null);
            cmd.setCasilleroJudicial(fila[3] != null ? fila[3].toString() : null);
            //cmd.setDireccion(fila[4] != null ? fila[4].toString() : null);
            //cmd.setTelefono(fila[5] != null ? fila[5].toString() : null);
            //cmd.setTitularNombre(fila[6] != null ? fila[6].toString() : null);
            cmd.setTitularDocumento(fila[4] != null ? fila[4].toString() : null);
            //cmd.setRepLegalNombre(fila[8] != null ? fila[8].toString() : null);
            //cmd.setRepLegalDocumento(fila[9] != null ? fila[9].toString() : null);
            cmd.setPlazoConcesion(fila[5] != null ? fila[5].toString() : null);
            cmd.setFechaInforme(fila[6] != null ? (Date) fila[6] : null);
            //cmd.setZona(fila[12] != null ? fila[12].toString() : null);
            cmd.setSuperficie(fila[7] != null ? Double.valueOf(fila[7].toString()) : null);
            cmd.setEstadoConcesion(fila[8] != null ? fila[8].toString() : null);
            cmd.setFase(fila[9] != null ? fila[9].toString() : null);
            cmd.setTipoSolicitud(fila[10] != null ? fila[10].toString() : null);
            cmd.setFechaOtorgamiento(fila[11] != null ? (Date) fila[11] : null);
            cmd.setFechaInscripcion(fila[12] != null ? (Date) fila[12] : null);
            cmd.setNombreRegional(fila[13] != null ? fila[13].toString() : null);
            cmd.setProvincia(fila[14] != null ? fila[14].toString() : null);
            cmd.setCanton(fila[15] != null ? fila[15].toString() : null);
            cmd.setParroquia(fila[16] != null ? fila[16].toString() : null);
            //cmd.setMineral(fila[22] != null ? fila[22].toString() : null);
            //cmd.setNumeroCoordenada(fila[24] != null ? Integer.valueOf(fila[24].toString()) : null);
            //cmd.setCoordenadaUtmEste(fila[24] != null ? fila[24].toString() : null);
            //cmd.setCoordenadaUtmNorte(fila[25] != null ? fila[25].toString() : null);
            //cmd.setManifiesto(fila[27] != null ? Integer.valueOf(fila[27].toString()) : null);
            cmd.setTipoTabla(fila[18] != null ? fila[18].toString() : null);
            listaFinal.add(cmd);
        }

        return listaFinal;
    }

    @Override
    public Long obtenerSiguienteCodigoConcesion() {
        String sql = "select max(codigo_concesion + 1) from catmin.concesion_minera";

        Query query = em.createNativeQuery(sql);
        Long codigoConcesion = (Long) query.getSingleResult();
        return codigoConcesion;
    }

    @Override
    public ConcesionMinera findByPk(Long codigoConcesion) {
        try {
            System.out.println("entra findByPk ConcesionMinera");
            String jpql = "select cm from ConcesionMinera cm where cm.codigoConcesion = :codigoConcesion";
            Query query = em.createQuery(jpql);
            query.setParameter("codigoConcesion", codigoConcesion);
            ConcesionMinera concesionMinera = (ConcesionMinera) query.getSingleResult();
            this.refresh(concesionMinera);
            return concesionMinera;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

    @Override
    public ConcesionMinera findByCodigoArcom(String codigoArcom) {
        try {
            String hql = "select cm from ConcesionMinera cm where cm.codigoArcom = :codigoArcom";
            Query query = em.createQuery(hql);
            query.setParameter("codigoArcom", codigoArcom);
            ConcesionMinera concesionMinera = (ConcesionMinera) query.getSingleResult();
            this.refresh(concesionMinera);
            return concesionMinera;
        } catch (NoResultException nrEx) {
            return null;
        }
    }

    @Override
    public void actualizarConcesionMinera(ConcesionMinera concesionMinera) throws Exception {
        String sql = "UPDATE\n"
                + "    catmin.concesion_minera\n"
                + "SET\n";
        if (concesionMinera.getCodigoConcesion() != null) {
            sql = sql + "    codigo_concesion = " + concesionMinera.getCodigoConcesion() + ",\n";
        }
        if (concesionMinera.getCodigoArcom() != null) {
            sql = sql + "    codigo_arcom = '" + concesionMinera.getCodigoArcom() + "',\n";
        }
        if (concesionMinera.getCodigoCensal() != null) {
            sql = sql + "    codigo_censal = '" + concesionMinera.getCodigoCensal() + "',\n";
        }
        if (concesionMinera.getEstadoConcesion() != null && concesionMinera.getEstadoConcesion().getCodigoCatalogoDetalle() != null) {
            sql = sql + "    estado_concesion = " + concesionMinera.getEstadoConcesion().getCodigoCatalogoDetalle() + ",\n";
        }
        if (concesionMinera.getCodigoFase() != null && concesionMinera.getCodigoFase().getCodigoFase() != null) {
            sql = sql + "    codigo_fase = " + concesionMinera.getCodigoFase().getCodigoFase() + ",\n";
        } else {
            sql = sql + "    codigo_fase = " + null + ",\n";
        }
        if (concesionMinera.getNombreConcesion() != null) {
            sql = sql + "    nombre_concesion = '" + concesionMinera.getNombreConcesion() + "',\n";
        }
        if (concesionMinera.getCodigoTipoMineria() != null && concesionMinera.getCodigoTipoMineria().getCodigoTipoMineria() != null) {
            sql = sql + "    codigo_tipo_mineria = " + concesionMinera.getCodigoTipoMineria().getCodigoTipoMineria() + ",\n";
        }
        if (concesionMinera.getNumeroHectareasConcesion() != null) {
            sql = sql + "    numero_hectareas_concesion = " + concesionMinera.getNumeroHectareasConcesion() + ",\n";
        }
        if (concesionMinera.getCodigoZona() != null && concesionMinera.getCodigoZona().getCodigoCatalogoDetalle() != null) {
            sql = sql + "    codigo_zona = " + concesionMinera.getCodigoZona().getCodigoCatalogoDetalle() + ",\n";
        }
        if (concesionMinera.getCodigoRegional() != null && concesionMinera.getCodigoRegional().getCodigoRegional() != null) {
            sql = sql + "    codigo_regional = " + concesionMinera.getCodigoRegional().getCodigoRegional() + ",\n";
        }
        if (concesionMinera.getCodigoRegimen() != null && concesionMinera.getCodigoRegimen().getCodigoRegimen() != null) {
            sql = sql + "    codigo_regimen = " + concesionMinera.getCodigoRegimen().getCodigoRegimen() + ",\n";
        } else {
            sql = sql + "    codigo_regimen = " + null + ",\n";
        }
        if (concesionMinera.getPlazoConcesion() != null) {
            sql = sql + "    plazo_concesion = " + concesionMinera.getPlazoConcesion() + ",\n";
        }
        if (concesionMinera.getCodigoProvincia() != null) {
            sql = sql + "    codigo_provincia = " + concesionMinera.getCodigoProvincia() + ",\n";
        }
        if (concesionMinera.getCodigoCanton() != null) {
            sql = sql + "    codigo_canton = " + concesionMinera.getCodigoCanton() + ",\n";
        }
        if (concesionMinera.getCodigoParroquia() != null) {
            sql = sql + "    codigo_parroquia = " + concesionMinera.getCodigoParroquia() + ",\n";
        }
        if (concesionMinera.getFechaInicioConcesion() != null) {
            sql = sql + "    fecha_inicio_concesion = '" + concesionMinera.getFechaInicioConcesion() + "',\n";
        }
        if (concesionMinera.getFechaFinConcesion() != null) {
            sql = sql + "    fecha_fin_concesion = '" + concesionMinera.getFechaFinConcesion() + "',\n";
        }
        if (concesionMinera.getDocumentoConcesionarioPrincipal() != null) {
            sql = sql + "    documento_concesionario_principal = '" + concesionMinera.getDocumentoConcesionarioPrincipal() + "',\n";
        }
        if (concesionMinera.getNombreConcesionarioPrincipal() != null) {
            sql = sql + "    nombre_concesionario_principal = '" + concesionMinera.getNombreConcesionarioPrincipal() + "',\n";
        }
        if (concesionMinera.getApellidoConcesionarioPrincipal() != null) {
            sql = sql + "    apellido_concesionario_principal = '" + concesionMinera.getApellidoConcesionarioPrincipal() + "',\n";
        }
        if (concesionMinera.getCodigoModalidadTrabajo() != null && concesionMinera.getCodigoModalidadTrabajo().getCodigoCatalogoDetalle() != null) {
            sql = sql + "    codigo_modalidad_trabajo = " + concesionMinera.getCodigoModalidadTrabajo().getCodigoCatalogoDetalle() + ",\n";
        } else {
            sql = sql + "    codigo_modalidad_trabajo = " + null + ",\n";
        }
        if (concesionMinera.getCodigoFormaExplotacion() != null && concesionMinera.getCodigoFormaExplotacion().getCodigoCatalogoDetalle() != null) {
            sql = sql + "    codigo_forma_explotacion = " + concesionMinera.getCodigoFormaExplotacion().getCodigoCatalogoDetalle() + ",\n";
        } else {
            sql = sql + "    codigo_forma_explotacion = " + null + ",\n";
        }
        if (concesionMinera.getModalidad() != null) {
            sql = sql + "    modalidad = '" + concesionMinera.getModalidad() + "',\n";
        }
        if (concesionMinera.getTipoMaterial() != null) {
            sql = sql + "    tipo_material = '" + concesionMinera.getTipoMaterial() + "',\n";
        }
        if (concesionMinera.getFormaExplotacion() != null) {
            sql = sql + "    forma_explotacion = '" + concesionMinera.getFormaExplotacion() + "',\n";
        }
        if (concesionMinera.getMaterialInteres() != null) {
            sql = sql + "    material_interes = '" + concesionMinera.getMaterialInteres() + "',\n";
        } else {
            sql = sql + "    material_interes = " + null + ",\n";
        }
        if (concesionMinera.getVolumenDiarioExplotacion() != null) {
            sql = sql + "    volumen_diario_explotacion = " + concesionMinera.getVolumenDiarioExplotacion() + ",\n";
        }
        //if (concesionMinera.getVolumenTotalExplotacion() != null) {
        sql = sql + "    volumen_total_explotacion = " + concesionMinera.getVolumenTotalExplotacion() + ",\n";
        //} 
        if (concesionMinera.getCasilleroJudicial() != null) {
            sql = sql + "    casillero_judicial = '" + concesionMinera.getCasilleroJudicial() + "',\n";
        } else {
            sql = sql + "    casillero_judicial = " + null + ",\n";
        }
        if (concesionMinera.getAceptaCondiciones() != null) {
            sql = sql + "    acepta_condiciones = " + concesionMinera.getAceptaCondiciones() + ",\n";
        }
        if (concesionMinera.getCampoReservado10() != null) {
            sql = sql + "    campo_reservado_10 = '" + concesionMinera.getCampoReservado10() + "',\n";
        }
        if (concesionMinera.getCampoReservado09() != null) {
            sql = sql + "    campo_reservado_09 = '" + concesionMinera.getCampoReservado09() + "',\n";
        }
        if (concesionMinera.getCampoReservado08() != null) {
            sql = sql + "    campo_reservado_08 = '" + concesionMinera.getCampoReservado08() + "',\n";
        }
        if (concesionMinera.getCampoReservado07() != null) {
            sql = sql + "    campo_reservado_07 = '" + concesionMinera.getCampoReservado07() + "',\n";
        }
        if (concesionMinera.getCampoReservado06() != null) {
            sql = sql + "    campo_reservado_06 = '" + concesionMinera.getCampoReservado06() + "',\n";
        }
        if (concesionMinera.getCampoReservado05() != null) {
            sql = sql + "    campo_reservado_05 = '" + concesionMinera.getCampoReservado05() + "',\n";
        }
        if (concesionMinera.getCampoReservado04() != null) {
            sql = sql + "    campo_reservado_04 = '" + concesionMinera.getCampoReservado04() + "',\n";
        }
        if (concesionMinera.getCampoReservado03() != null) {
            sql = sql + "    campo_reservado_03 = '" + concesionMinera.getCampoReservado03() + "',\n";
        }
        if (concesionMinera.getCampoReservado02() != null) {
            sql = sql + "    campo_reservado_02 = '" + concesionMinera.getCampoReservado02() + "',\n";
        }
        if (concesionMinera.getCampoReservado01() != null) {
            sql = sql + "    campo_reservado_01 = '" + concesionMinera.getCampoReservado01() + "',\n";
        }
        if (concesionMinera.getEstadoRegistro() != null) {
            sql = sql + "    estado_registro = " + concesionMinera.getEstadoRegistro() + ",\n";
        }
        if (concesionMinera.getFechaCreacion() != null) {
            sql = sql + "    fecha_creacion = '" + concesionMinera.getFechaCreacion() + "',\n";
        }
        if (concesionMinera.getUsuarioCreacion() != null) {
            sql = sql + "    usuario_creacion = " + concesionMinera.getUsuarioCreacion() + ",\n";
        }
        if (concesionMinera.getFechaModificacion() != null) {
            sql = sql + "    fecha_modificacion = '" + concesionMinera.getFechaModificacion() + "',\n";
        }
        if (concesionMinera.getUsuarioModificacion() != null) {
            sql = sql + "    usuario_modificacion = " + concesionMinera.getUsuarioModificacion() + ",\n";
        }
        if (concesionMinera.getFechaOtorga() != null) {
            sql = sql + "    fecha_otorga = '" + concesionMinera.getFechaOtorga() + "',\n";
        } else {
            sql = sql + "    fecha_otorga = null" + ",\n";
        }
        if (concesionMinera.getFechaInscribe() != null) {
            sql = sql + "    fecha_inscribe = '" + concesionMinera.getFechaInscribe() + "',\n";
        } else {
            sql = sql + "    fecha_inscribe = null" + ",\n";
        }
        if (concesionMinera.getMae() != null) {
            sql = sql + "    mae = " + concesionMinera.getMae() + " ,\n";
        }
        if (concesionMinera.getSenagua() != null) {
            sql = sql + "    senagua = " + concesionMinera.getSenagua() + " ,\n";
        }
        if (concesionMinera.getObsActosAdmPrevios() != null) {
            sql = sql + "    obs_actos_adm_previos = '" + concesionMinera.getObsActosAdmPrevios() + "',\n";
        }
        if (concesionMinera.getSector() != null) {
            sql = sql + "    sector = '" + concesionMinera.getSector() + "',\n";
        }
        if (concesionMinera.getFechaInforme() != null) {
            sql = sql + "    fecha_informe = '" + concesionMinera.getFechaInforme() + "',\n";
        } else {
            sql = sql + "    fecha_informe = null" + ",\n";
        }
        if (concesionMinera.getCodigoCasilleroLocalidad() != null) {
            sql = sql + "    codigo_casillero_localidad = " + concesionMinera.getCodigoCasilleroLocalidad().getCodigoLocalidad() + ",\n";
        }
        if (concesionMinera.getFechaSustitucion() != null) {
            sql = sql + "    fecha_sustitucion = '" + concesionMinera.getFechaSustitucion() + "',\n";
        } else {
            sql = sql + "    fecha_sustitucion = " + null + ",\n";
        }
        if (concesionMinera.getFechaInscripcionSustitucion() != null) {
            sql = sql + "    fecha_inscripcion_sustitucion = '" + concesionMinera.getFechaInscripcionSustitucion() + "',\n";
        } else {
            sql = sql + "    fecha_inscripcion_sustitucion = null ,\n";
        }
        sql = sql + "    plazo_dias = " + concesionMinera.getDias() + ",\n";
        sql = sql + "    migrada = " + concesionMinera.getMigrada() + "\n";
        sql = sql + "WHERE\n";
        sql = sql + "    codigo_concesion = " + concesionMinera.getCodigoConcesion();;

        Query query = em.createNativeQuery(sql);
        query.executeUpdate();
    }

    @Override
    public List<DerechoMineroDto> busquedaGeneralNacional(String codigo, String nombre, Long codigoRegional, Long codigoProvincia, Long codigoFase,
            Long codigoEstado, String tipoSolicitud, String beneficiarioPrincipal, String tipoPersona, Date fechaDesde, Date fechaHasta) {
        String sql = "";
        if (tipoSolicitud == null || tipoSolicitud.equals(ConstantesEnum.TIPO_SOLICITUD_CONS_MIN.getNemonico())
                || tipoSolicitud.equals(ConstantesEnum.TIPO_SOLICITUD_LIB_APR.getNemonico())
                || tipoSolicitud.equals(ConstantesEnum.TIPO_SOLICITUD_MIN_ART.getNemonico())) {
            sql += "select sd.codigo, sd.nombre, sd.regional, sd.provincia, sd.fase, sd.estado, sd.tipo_solicitud,\n"
                    + "COALESCE(sd.titular, '') as beneficiario_principal, case when char_length (sd.cedula___ruc) = 10 then 'PN' else 'PJ' end as tipo_persona,\n"
                    + "sd.fecha_informe, 'S', sd.id\n"
                    + "from catmin.sadmin_data_ sd where 1=1\n";
            if (codigo != null && !codigo.isEmpty()) {
                sql += "and sd.codigo ilike '%" + codigo + "%'\n";
            }
            if (nombre != null && !nombre.isEmpty()) {
                sql += "and sd.nombre ilike '%" + nombre + "%'\n";
            }
            if (codigoRegional != null) {
                Regional regional = regionalServicio.findByPk(codigoRegional);
                if (regional != null && regional.getNombreRegional() != null) {
                    sql += "and sd.regional ilike '%" + regional.getNombreRegional() + "%'\n";
                }
            }
            if (codigoProvincia != null) {
                Localidad localidad = localidadServicio.findByPk(codigoProvincia);
                if (localidad != null && localidad.getNombre() != null) {
                    sql += "and sd.provincia ilike '%" + localidad.getNombre() + "%'\n";
                }
            }
            if (codigoFase != null) {
                Fase fase = faseServicio.findByPk(codigoFase);
                if (fase != null && fase.getNombreFase() != null) {
                    sql += "and sd.fase ilike '%" + fase.getNombreFase() + "%'\n";
                }
            }
            if (codigoEstado != null) {
                CatalogoDetalle catalogoDetalle = catalogoDetalleServicio.findByPk(codigoEstado);
                if (catalogoDetalle != null && catalogoDetalle.getNombre() != null) {
                    sql += "and sd.estado ilike '%" + catalogoDetalle.getNombre() + "%'\n";
                }
            }
            if (beneficiarioPrincipal != null) {
                sql += "and beneficiario_principal ilike '%" + beneficiarioPrincipal + "%'\n";
            }
            if (tipoPersona != null) {
                sql += "and tipo_persona = '" + tipoPersona + "'\n";
            }
            if (fechaDesde != null) {
//Pendiente            
//sql += "and "
            }
            sql += "union\n";
            sql += "select cm.codigo_arcom, cm.nombre_concesion, r.nombre_regional, prov.nombre, COALESCE(f.nombre_fase, '') as fase, est.nombre as estado, tm.nombre_tipo_mineria,\n"
                    + "COALESCE(cm.nombre_concesionario_principal || ' ' || cm.apellido_concesionario_principal, '') as beneficiario_principal, \n"
                    + "case when char_length (cm.documento_concesionario_principal) = 10 then 'PN' else 'PJ' end as tipo_persona, cm.fecha_creacion, 'C', cm.codigo_concesion\n"
                    + "from catmin.concesion_minera cm, catmin.regional r, catmin.localidad prov, catmin.fase f, catmin.catalogo_detalle est,\n"
                    + "catmin.solicitud s, catmin.tipo_mineria tm\n"
                    + "where cm.codigo_regional = r.codigo_regional\n"
                    + "and prov.codigo_localidad = cm.codigo_provincia\n"
                    + "and f.codigo_fase = cm.codigo_fase\n"
                    + "and est.codigo_catalogo_detalle = cm.estado_concesion\n"
                    + "and s.tipo_solicitud = tm.nemonico_tipo_mineria\n";
            if (codigo != null && !codigo.isEmpty()) {
                sql += "and cm.codigo_arcom ilike '%" + codigo + "%'\n";
            }
            if (nombre != null && !nombre.isEmpty()) {
                sql += "and cm.nombre_concesion ilike '%" + nombre + "%'\n";
            }
            if (codigoRegional != null) {
                sql += "and cm.codigo_regional = " + codigoRegional + "\n";
            }
            if (codigoProvincia != null) {
                sql += "and cm.codigo_provincia = " + codigoProvincia + "\n";
            }
            if (codigoFase != null) {
                sql += "and cm.codigo_fase = " + codigoFase + "\n";
            }
            if (codigoEstado != null) {
                sql += "and cm.estado_concesion = " + codigoEstado + "\n";
            }
            if (beneficiarioPrincipal != null) {
                sql += "and beneficiario_principal ilike '%" + beneficiarioPrincipal + "%'\n";
            }
            if (tipoPersona != null) {
                sql += "and tipo_persona = '" + tipoPersona + "'\n";
            }
            if (fechaDesde != null) {
//Pendiente            
//sql += "and "
            }
        }
        if (tipoSolicitud == null) {
            sql += "union\n";
        }
        if (tipoSolicitud == null || tipoSolicitud.equals(ConstantesEnum.TIPO_SOLICITUD_LIC_COM.getNemonico())) {
            sql += "select l.codigo_arcom, l.nombre || ' ' || l.apellido as nombre, rl.nombre_regional, ll.nombre, '', cd.nombre, 'LICENCIA COMERCIALIZACION',\n"
                    + "COALESCE(l.nombre || ' ' || l.apellido, '') as beneficiario_principal,\n"
                    + "case when char_length (l.numero_documento) = 10 then 'PN' else 'PJ' end, l.fecha_creacion, 'L', l.codigo_licencia_comercializacion\n"
                    + "from catmin.licencia_comercializacion l, catmin.regional rl, catmin.localidad ll, catmin.localidad_regional lrl, catmin.catalogo_detalle cd\n"
                    + "where lrl.codigo_localidad = l.codigo_provincia\n"
                    + "and rl.codigo_regional = lrl.codigo_regional\n"
                    + "and ll.codigo_localidad = l.codigo_provincia\n"
                    + "and cd.codigo_catalogo_detalle = l.estado_licencia\n";
            if (codigo != null && !codigo.isEmpty()) {
                sql += "and l.codigo_arcom ilike '%" + codigo + "%'\n";
            }
            if (nombre != null && !nombre.isEmpty()) {
                sql += "and nombre ilike '%" + nombre + "%'\n";
            }
            if (codigoRegional != null) {
                sql += "and rl.codigo_regional = " + codigoRegional + "\n";
            }
            if (codigoProvincia != null) {
                sql += "and ll.codigo_localidad = " + codigoProvincia + "\n";
            }
            if (codigoEstado != null) {
                sql += "and cd.codigo_catalogo_detalle = " + codigoEstado + "\n";
            }
            if (beneficiarioPrincipal != null) {
                sql += "and beneficiario_principal ilike '%" + beneficiarioPrincipal + "%'\n";
            }
            if (tipoPersona != null) {
                sql += "and tipo_persona = '" + tipoPersona + "'\n";
            }
            if (fechaDesde != null) {
//Pendiente            
//sql += "and "
            }
        }
        if (tipoSolicitud == null) {
            sql += "union\n";
        }
        if (tipoSolicitud == null || tipoSolicitud.equals(ConstantesEnum.TIPO_SOLICITUD_PLAN_BEN.getNemonico())) {
            sql += "select pb.codigo_arcom, pb.nombre_planta_beneficio, rl.nombre_regional, prov.nombre, '', cd.nombre, 'PLANTA BENEFICIO',\n"
                    + "COALESCE(pb.nombre_representante_legal || ' ' || pb.apellido_representante_legal, '') as beneficiario_principal,\n"
                    + "case when char_length (pb.numero_documento_representante_legal) = 10 then 'PN' else 'PJ' end, pb.fecha_creacion, 'P', pb.codigo_planta_beneficio\n"
                    + "from catmin.planta_beneficio pb, catmin.regional rl, catmin.localidad prov, catmin.localidad_regional lrl, catmin.catalogo_detalle cd\n"
                    + "where lrl.codigo_localidad = pb.codigo_provincia\n"
                    + "and rl.codigo_regional = lrl.codigo_regional\n"
                    + "and prov.codigo_localidad = pb.codigo_provincia\n"
                    + "and cd.codigo_catalogo_detalle = pb.estado_planta\n";
            if (codigo != null && !codigo.isEmpty()) {
                sql += "and pb.codigo_arcom ilike '%" + codigo + "%'\n";
            }
            if (nombre != null && !nombre.isEmpty()) {
                sql += "and pb.nombre_planta_beneficio ilike '%" + nombre + "%'\n";
            }
            if (codigoRegional != null) {
                sql += "and r.codigo_regional = " + codigoRegional + "\n";
            }
            if (codigoProvincia != null) {
                sql += "and prov.codigo_localidad = " + codigoProvincia + "\n";
            }
            if (codigoEstado != null) {
                sql += "and cd.codigo_catalogo_detalle = " + codigoEstado + "\n";
            }
            if (beneficiarioPrincipal != null) {
                sql += "and beneficiario_principal ilike '%" + beneficiarioPrincipal + "%'\n";
            }
            if (tipoPersona != null) {
                sql += "and tipo_persona = '" + tipoPersona + "'\n";
            }
            if (fechaDesde != null) {
//Pendiente            
//sql += "and "
            }
        }
        System.out.println("sql derechos mineros nacional: " + sql);
        Query query = em.createNativeQuery(sql);

        List<Object[]> listaTmp = query.getResultList();
        List<DerechoMineroDto> listaFinal = new ArrayList<>();

        for (Object[] fila : listaTmp) {
            DerechoMineroDto dm = new DerechoMineroDto();
            dm.setCodigo(fila[0].toString());
            dm.setNombreDerechoMinero(fila[1] != null ? fila[1].toString() : "Sin nombre");
            dm.setRegional(fila[2] != null ? fila[2].toString() : "Sin regional");
            dm.setProvincia(fila[3] != null ? fila[3].toString() : "Sin provincia");
            dm.setFase(fila[4] != null ? fila[4].toString() : "Sin fase");
            dm.setEstado(fila[5] != null ? fila[5].toString() : "Sin estado");
            dm.setTipoSolicitud(fila[6] != null ? fila[6].toString() : "Sin tipo de solicitud");
            dm.setBeneficiarioPrincipal(fila[7] != null ? fila[7].toString() : "Sin beneficiario");
            dm.setTipoPersona(fila[8] != null ? (fila[8].toString().equals("PN") ? "Persona Natural" : "Persona Jurídica") : "Sin persona");
            dm.setFechaSolicitud(fila[9] != null ? fila[9].toString() : "Sin fecha");
            dm.setTipoDerechoMinero(fila[10].toString());
            dm.setId(Long.valueOf(fila[11].toString()));
            listaFinal.add(dm);
        }
        return listaFinal;
    }

}
