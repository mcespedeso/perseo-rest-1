package py.com.ideasweb.perseo.transaccion.services;

import java.util.List;

import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.transaccion.dtos.TurnoDTO;

public interface TurnoService {

    List<TurnoDTO> getByUsuario(Integer idusuario, Integer limit)
            throws Exception;

    TurnoDTO getActivoByUsuario(Integer idusuario) throws Exception;

    String generarReporteMovimientoByUsuario(TurnoDTO idturno,
            UsuarioDTO usuario) throws Exception;

    String cerrarTurnoByUsuario(TurnoDTO turno, UsuarioDTO usuario)
            throws Exception;

    TurnoDTO getById(Integer idTurno) throws Exception;

    TurnoDTO grabar(TurnoDTO turno) throws Exception;
}
