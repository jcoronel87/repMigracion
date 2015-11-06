/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.arcom.migracion.dao.ejb;

import com.saviasoft.persistence.util.dao.eclipselink.GenericDaoEjbEl;
import ec.gob.arcom.migracion.dao.RegistroPagoObligacionesDao;
import ec.gob.arcom.migracion.modelo.RegistroPagoObligaciones;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author coronelja
 */
@Stateless(name = "RegistroPagoObligacionesDao")
public class RegistroPagoObligacionesDaoEjb extends GenericDaoEjbEl<RegistroPagoObligaciones, Long> implements
        RegistroPagoObligacionesDao {

    public RegistroPagoObligacionesDaoEjb() {
        super(RegistroPagoObligaciones.class);
    }

    @Override
    public RegistroPagoObligaciones obtenerPorCodigoRegistroPagoObligaciones(Long codigoRegistroPagoObligaciones) {
        try {
            String hql = "select rpo from RegistroPagoObligaciones rpo where rpo.codigoRegistro = :codigoRegistroPagoObligaciones";
            Query query = em.createQuery(hql);
            query.setParameter("codigoRegistroPagoObligaciones", codigoRegistroPagoObligaciones);
            RegistroPagoObligaciones registroPagoObligaciones = (RegistroPagoObligaciones) query.getSingleResult();
            this.refresh(registroPagoObligaciones);
            return registroPagoObligaciones;
        } catch (NoResultException nrException) {
            return null;
        }
    }

    @Override
    public void actualizarRegistroPagoObligaciones(RegistroPagoObligaciones registroPagoObligaciones) throws Exception {
        String sql = "UPDATE catmin.registro_pago_obligaciones \n"
                + "SET codigo_registro = " + registroPagoObligaciones.getCodigoRegistro() + ", \n";
        if (registroPagoObligaciones.getCodigoConceptoPago() != null) {
            sql += "codigo_concepto_pago = " + registroPagoObligaciones.getCodigoConceptoPago().getCodigoConceptoPago() + ", \n";
        }
        sql += "codigo_concesion = " + registroPagoObligaciones.getCodigoConcesion().getCodigoConcesion() + ", \n"
                + "codigo_area = " + registroPagoObligaciones.getCodigoArea().getCodigoAreaMinera() + ", \n"
                + "codigo_informe = " + registroPagoObligaciones.getCodigoInforme() + ", \n"
                + "codigo_licencia_comercializacion = " + registroPagoObligaciones.getCodigoLicenciaComercializacion().getCodigoLicenciaComercializacion() + ", \n"
                + "codigo_planta_beneficio = " + registroPagoObligaciones.getCodigoPlantaBeneficio().getCodigoPlantaBeneficio() + ", \n";
        if (registroPagoObligaciones.getFechaEmisionPago() != null) {
            sql += "fecha_emision_pago = '" + registroPagoObligaciones.getFechaEmisionPago() + "', \n";
        }
        sql += "codigo_banco = " + registroPagoObligaciones.getCodigoBanco().getCodigoCatalogo() + ", \n"
                + "lugar_emision_pago = " + registroPagoObligaciones.getLugarEmisionPago().getCodigoLocalidad() + ", \n"
                + "valor_pago = " + registroPagoObligaciones.getValorPago() + ", \n"
                + "numero_comprobante_banco = '" + registroPagoObligaciones.getNumeroComprobanteBanco() + "', \n"
                + "documento_persona_pago = '" + registroPagoObligaciones.getDocumentoPersonaPago() + "', \n"
                + "nombre_persona_pago = '" + registroPagoObligaciones.getNombrePersonaPago() + "', \n"
                + "apellido_persona_pago = '" + registroPagoObligaciones.getApellidoPersonaPago() + "', \n"
                + "numero_comprobante_arcom = '" + registroPagoObligaciones.getNumeroComprobanteArcom() + "', \n"
                + "estado_pago = " + registroPagoObligaciones.getEstadoPago().getCodigoCatalogoDetalle() + ", \n"
                + "codigo_solicitud = " + registroPagoObligaciones.getCodigoSolicitud() + ", \n"
                + "numero_tramite = " + registroPagoObligaciones.getNumeroTramite() + ", \n"
                + "entidad_tramite = '" + registroPagoObligaciones.getEntidadTramite() + "', \n"
                + "campo_reservado_05 = '" + registroPagoObligaciones.getCampoReservado05() + "', \n"
                + "campo_reservado_04 = '" + registroPagoObligaciones.getCampoReservado04() + "', \n"
                + "campo_reservado_03 = '" + registroPagoObligaciones.getCampoReservado03() + "', \n"
                + "campo_reservado_02 = '" + registroPagoObligaciones.getCampoReservado02() + "', \n"
                + "campo_reservado_01 = '" + registroPagoObligaciones.getCampoReservado01() + "', \n"
                + "estado_registro = " + registroPagoObligaciones.getEstadoRegistro() + ", \n"
                + "fecha_creacion = '" + registroPagoObligaciones.getFechaCreacion() + "', \n"
                + "usuario_creacion = " + registroPagoObligaciones.getUsuarioCreacion() + ", \n"
                + "fecha_modificacion = '" + registroPagoObligaciones.getFechaModificacion() + "', \n"
                + "usuario_modificacion = " + registroPagoObligaciones.getUsuarioModificacion() + ", \n"
                + "cantidad = " + registroPagoObligaciones.getCantidad() + ", \n"
                + "costo = " + registroPagoObligaciones.getCosto() + ", \n"
                + "observacion_analista_economico = '" + registroPagoObligaciones.getObservacionAnalistaEconomico() + "', \n"
                + "fecha_revision_analista_economico = '" + registroPagoObligaciones.getFechaRevisionAnalistaEconomico() + "', \n"
                + "aprobado_analista_economico = " + registroPagoObligaciones.getAprobadoAnalistaEconomico() + ", \n"
                + "observacion_coordinador_regional = '" + registroPagoObligaciones.getObservacionCoordinadorRegional() + "', \n"
                + "fecha_revision_coordinador_regional = '" + registroPagoObligaciones.getFechaRevisionCoordinadorRegional() + "', \n"
                + "aprobado_coordinador_regional = " + registroPagoObligaciones.getAprobadoCoordinadorRegional() + ", \n"
                + "valor_adicional = " + registroPagoObligaciones.getValorAdicional() + ", \n"
                + "descripcion_motivo_valor_adicional = '" + registroPagoObligaciones.getDescripcionMotivoValorAdicional() + "', \n"
                + "valor_total_pago = " + registroPagoObligaciones.getValorTotalPago() + ", \n"
                + "valor_pagado_usuario = " + registroPagoObligaciones.getValorPagadoUsuario() + ", \n"
                + "valor_concepto_pago = " + registroPagoObligaciones.getValorConceptoPago() + ", \n"
                + "subsanar_pago = " + registroPagoObligaciones.getSubsanarPago() + ", \n"
                + "presenta_documentos = " + registroPagoObligaciones.getPresentaDocumentos() + " \n"
                + "WHERE codigo_registro = " + registroPagoObligaciones.getCodigoRegistro();
    }

}
