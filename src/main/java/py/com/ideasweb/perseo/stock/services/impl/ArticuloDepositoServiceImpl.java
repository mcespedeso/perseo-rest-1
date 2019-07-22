package py.com.ideasweb.perseo.stock.services.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.DepositoDTO;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.dtos.FamiliaDTO;
import py.com.ideasweb.perseo.stock.dtos.HistoricoArticuloDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloDepositoMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloDepositoRepository;
import py.com.ideasweb.perseo.stock.repositories.ArticuloRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.ArticuloService;

@Service
public class ArticuloDepositoServiceImpl extends BaseServiceImpl
        implements ArticuloDepositoService {

    @Autowired
    ArticuloDepositoRepository repo;

    @Autowired
    ArticuloDepositoMapper mapper;

    @Autowired
    ArticuloRepository articuloRepo;

    @Autowired
    ArticuloService articuloService;

    @Autowired
    DataSource dataSource;

    @Override
    public List<ArticuloDepositoDTO> getBySucursalAndDeposito(
            Integer idSucursal, Integer idDeposito, Boolean all)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findBySucursalIdSucursalAndDepositoIdDeposito(idSucursal,
                        idDeposito));
    }

    @Override
    public List<ArticuloDepositoDTO> getBySucursalAndDepositoByParams(
            Integer idSucursal, Integer idDeposito, String param)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityListToDtoList(
                repo.findBySucursalIdSucursalAndDepositoIdDepositoAndArticuloDescripcionContainsIgnoreCaseOrArticuloCodigoBarraContainsIgnoreCase(
                        idSucursal, idDeposito, param, param));
    }

    @Override
    public ArticuloDepositoDTO getByArticuloAndDeposito(Integer idArticulo,
            Integer idDeposito) throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(
                repo.findByArticuloIdArticuloAndDepositoIdDeposito(idArticulo,
                        idDeposito));
    }

    @Override
    public ArticuloDepositoDTO getByID(Integer idArticuloDeposito)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper.entityToDto(repo.findById(idArticuloDeposito).get());
    }

    @Override
    public ArticuloDepositoDTO grabar(ArticuloDepositoDTO dto)
            throws Exception {

        if (!articuloRepo.findById(dto.getArticulo().getIdArticulo())
                .isPresent()) {
            // si no existe el articulo , grabar
            ArticuloDTO newArticulo = articuloService.grabar(dto.getArticulo());
            dto.setArticulo(newArticulo);
        }

        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public List<ArticuloDepositoDTO> getByEmpresa(Integer idEmpresa)
            throws Exception {
        // TODO Auto-generated method stub
        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public List<HistoricoArticuloDTO> getByTurno(Integer idturno,
            UsuarioDTO usuarioDTO) throws Exception {
        List<HistoricoArticuloDTO> list = new ArrayList<HistoricoArticuloDTO>();
        Connection conn = null;

        try {

            conn = dataSource.getConnection();

            String sql = " select 'V' as tipo, sum( a.cantidad) as venta, 0 as compra, a.id_articulo, c.descripcion as articulo, a.precio_venta, e.precio_costo, c.id_familia,  ";
            sql += " e.id_deposito, d.descripcion as familia, (a.precio_venta*sum( a.cantidad)) as total,  ";
            sql += " f.descripcion as deposito, e.id_articulo_deposito, e.cantidad as saldoactual ";
            sql += " from factura_det a ";
            sql += " join factura_cab b on b.id_factura_cab = a.id_factura_cab   ";
            sql += " join articulo c on c.id_articulo = a.id_articulo   ";
            sql += " join familia d on d.id_familia = c.id_familia   ";
            sql += " join articulo_deposito e on e.id_articulo = a.id_articulo and e.id_sucursal = ? ";
            sql += " join deposito f on f.id_deposito = e.id_deposito  ";
            sql += " where b.id_turno = ? and b.estado = true   ";
            sql += " group by a.id_articulo, c.descripcion, c.id_familia , d.descripcion , e.id_deposito,  ";
            sql += " f.descripcion, a.precio_venta, e.id_articulo_deposito, e.cantidad, a.preci_ocosto  ";
            sql += " union all ";
            sql += " select 'C' as tipo, 0 as venta, sum( a.cantidad) as compra, e.id_articulo, c.descripcion as articulo, a.precio, e.precio_costo, c.id_familia, ";
            sql += " e.id_deposito, d.descripcion as familia, (a.precio*sum( a.cantidad)) as total,  ";
            sql += " f.descripcion as deposito, e.id_articulo_deposito, e.cantidad as saldoactual ";
            sql += " from compra_det a ";
            sql += " join compra_cab b on b.id_compra_cab = a.id_compra_cab ";
            sql += " join articulo_deposito e on e.id_articulo_deposito = a.id_articulo_deposito and e.idsucursal = ? ";
            sql += " join articulo c on c.id_articulo = e.id_articulo ";
            sql += " join deposito f on f.id_deposito = e.id_deposito ";
            sql += " join familia d on d.id_familia = c.id_familia   ";
            sql += " where b.id_turno = ? and b.id_estado_compra in(1,2)   ";
            sql += " group by e.id_articulo, c.descripcion, c.id_familia , d.descripcion , e.id_deposito,  ";
            sql += " f.descripcion, a.precio, e.id_articulo_deposito, e.cantidad, a.precio  ";
            sql += " order by id_familia, articulo ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, usuarioDTO.getSucursal().getIdSucursal());
            ps.setInt(2, idturno);
            ps.setInt(3, usuarioDTO.getSucursal().getIdSucursal());
            ps.setInt(4, idturno);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                HistoricoArticuloDTO art = new HistoricoArticuloDTO();

                art.setActual(rs.getDouble("saldo_actual"));

                // deposito
                DepositoDTO deposito = new DepositoDTO();
                deposito.setIdDeposito(rs.getInt("id_deposito"));
                deposito.setDescripcion(rs.getString("deposito"));

                // familia
                FamiliaDTO familia = new FamiliaDTO();
                familia.setIdFamilia(rs.getInt("id_familia"));
                familia.setDescripcion(rs.getString("familia"));

                // articulo
                ArticuloDepositoDTO articulo = new ArticuloDepositoDTO();
                articulo.setIdArticuloDeposito(
                        rs.getInt("id_articulo_deposito"));
                ArticuloDTO ar = new ArticuloDTO();
                ar.setDescripcion(rs.getString("articulo"));
                // ar.setFamilia(familia);
                ar.getFamilia().setIdFamilia(familia.getIdFamilia());
                articulo.setArticulo(ar);

                art.setDeposito(deposito);
                art.setArticuloDeposito(articulo);

                art.setVenta(rs.getDouble("venta"));
                art.setEntrada(rs.getDouble("compra"));

                art.setPrecioVenta(rs.getDouble("precio_venta"));
                art.setPrecioCosto(rs.getDouble("precio_costo"));

                // controla el anterior via movimiento de articulo
                String sql_hist = " select b.id_articulo_deposito, c.descripcion, a.columna, sum(a.cantidad) as cantidad ";
                sql_hist += " from articulo_movimiento a ";
                sql_hist += " join articulo_deposito b on b.id_articulo = a.id_articulo and b.id_deposito = a.id_deposito ";
                sql_hist += " join articulo c on c.id_articulo = a.id_articulo ";
                sql_hist += " where (a.id_turno < ? or a.id_turno is null) and b.id_articulo_deposito = ? ";
                sql_hist += " group by a.columna, b.id_articulo_deposito, c.descripcion ";
                sql_hist += " order by b.id_articulo_deposito, a.columna ";
                PreparedStatement ps_histo = conn.prepareStatement(sql_hist);
                ps_histo.setInt(1, idturno);
                ps_histo.setInt(2, rs.getInt("id_articulo_deposito"));
                ResultSet rs_histo = ps_histo.executeQuery();
                Double anterior = new Double(0);
                Double ingreso = new Double(0);
                Double egreso = new Double(0);
                while (rs_histo.next()) {
                    if (rs_histo.getString("columna").equals("I")) {
                        ingreso += rs_histo.getDouble("cantidad");
                    } else if (rs_histo.getString("columna").equals("E")) {
                        egreso += rs_histo.getDouble("cantidad");
                    }
                }
                anterior = ingreso - egreso;
                art.setAnterior(anterior);

                list.add(art);

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

}
