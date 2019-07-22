package py.com.ideasweb.perseo.stock.services.impl;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.seguridad.dtos.UsuarioDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloPrecioVentaDetDTO;
import py.com.ideasweb.perseo.stock.dtos.FamiliaDTO;
import py.com.ideasweb.perseo.stock.dtos.HistoricoPrecioVentaDTO;
import py.com.ideasweb.perseo.stock.mapper.ArticuloPrecioVentaDetMapper;
import py.com.ideasweb.perseo.stock.repositories.ArticuloPrecioVentaDetRepository;
import py.com.ideasweb.perseo.stock.services.ArticuloDepositoService;
import py.com.ideasweb.perseo.stock.services.ArticuloPrecioVentaDetService;
import py.com.ideasweb.perseo.stock.services.FamiliaService;
import py.com.ideasweb.perseo.stock.services.HistoricoPrecioVentaService;

@Service
public class ArticuloPrecioVentaDetServiceImpl extends BaseServiceImpl
        implements ArticuloPrecioVentaDetService {

    private static final Logger logger = LoggerFactory
            .getLogger(ArticuloPrecioVentaDetServiceImpl.class);

    @Autowired
    ArticuloPrecioVentaDetMapper mapper;

    @Autowired
    ArticuloPrecioVentaDetRepository repo;

    @Autowired
    ArticuloDepositoService articuloDepositoService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    FamiliaService familiaService;

    @Autowired
    HistoricoPrecioVentaService historicoPrecioVentaService;

    @Override
    public List<ArticuloPrecioVentaDetDTO> getByPrecioVentaCab(
            Integer idArticuloPrecioVentaCab) throws Exception {
        return mapper.entityListToDtoList(
                repo.findByArticuloPrecioVentaCabIdArticuloPrecioVentaCab(
                        idArticuloPrecioVentaCab));
    }

    @Override
    public ArticuloPrecioVentaDetDTO getById(Integer idArticuloPrecioVentaDet)
            throws Exception {
        return mapper
                .entityToDto(repo.findById(idArticuloPrecioVentaDet).get());
    }

    @Override
    public ArticuloPrecioVentaDetDTO grabar(ArticuloPrecioVentaDetDTO dto)
            throws Exception {
        return mapper.entityToDto(repo.save(mapper.dtoToEntity(dto)));
    }

    @Override
    public void updatePrecioByFamilia(Integer idfamilia, UsuarioDTO usuario)
            throws Exception {

        logger.info(
                "Actualizando precio de venta para todas las listas para la familia: "
                        + idfamilia);
        try {
            FamiliaDTO familia = familiaService.getByID(idfamilia);

            // actualizar todos los depositos

            List<ArticuloDepositoDTO> list = articuloDepositoService
                    .getByEmpresa(usuario.getEmpresa().getIdEmpresa());

            list.stream().forEach(ad -> {
                if (ad.getArticulo().getFamilia().getIdFamilia() == familia
                        .getIdFamilia()) {
                    // actualizar el precio
                    Double precio = ad.getPrecioCosto() + (ad.getPrecioCosto()
                            * familia.getPorcentajeGanancia() / 100);

                    String sql = " update articuloprecioventadet  set precio = ?  ";
                    sql += " where idarticulo = ? ";
                    jdbcTemplate.update(sql, precio,
                            ad.getArticulo().getIdArticulo());

                    try {
                        // registrar el historico
                        HistoricoPrecioVentaDTO historico = new HistoricoPrecioVentaDTO();
                        historico
                                .setFecha(new Date(System.currentTimeMillis()));
                        historico.setConcepto(
                                "Modificacion del porcentaje de gananancia de la Familia para todas las listas"
                                        + familia.getDescripcion());
                        historico.setPrecioCosto(ad.getPrecioCosto());
                        historico.setPrecioVenta(precio);
                        historico
                                .setPorcentaje(familia.getPorcentajeGanancia());
                        historico.setUsuario(usuario);
                        historicoPrecioVentaService.grabar(historico);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void updatePrecioByListacab(UsuarioDTO usuario, Integer idDeposito,
            Integer idarticuloprecioventacab, String concepto)
            throws Exception {

        logger.info("Actualizando precio de venta para la lista: "
                + idarticuloprecioventacab + " para el deposito " + idDeposito);
        try {

            getByPrecioVentaCab(idarticuloprecioventacab).stream()
                    .forEach(apvd -> {

                        try {
                            FamiliaDTO familia = familiaService.getByID(apvd
                                    .getArticulo().getFamilia().getIdFamilia());

                            ArticuloDepositoDTO ad = articuloDepositoService
                                    .getByArticuloAndDeposito(
                                            apvd.getArticulo().getIdArticulo(),
                                            idDeposito);

                            Double precio = ad.getPrecioCosto()
                                    + (ad.getPrecioCosto()
                                            * familia.getPorcentajeGanancia()
                                            / 100);

                            apvd.setPrecio(precio);

                            grabar(apvd);

                            // registrar en historico de precio venta
                            HistoricoPrecioVentaDTO historico = new HistoricoPrecioVentaDTO();
                            historico.setFecha(
                                    new Date(System.currentTimeMillis()));
                            historico.setConcepto(concepto);
                            historico.setPrecioCosto(ad.getPrecioCosto());
                            historico.setPrecioVenta(precio);
                            historico.setPorcentaje(
                                    familia.getPorcentajeGanancia());
                            historico.setUsuario(usuario);
                            historico.setArticuloPrecioVentaDet(apvd);
                            historicoPrecioVentaService.grabar(historico);
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }

                    });

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void setPrecioArticulo(ArticuloDTO articulo,
            Integer idprecioventacab, UsuarioDTO usuario) throws Exception {

        try {
            ArticuloPrecioVentaDetDTO apvd = getByArticuloAndPrecioVentaCab(
                    articulo.getIdArticulo(), idprecioventacab);

            if (apvd.getIdArticuloPrecioVentaDet() == null) {
                System.out
                        .println("NO EXISTE EL ARTICULO EN LA LISTA DE PRECIO");
                apvd.setArticulo(articulo);

                apvd.setPrecio(new Double(0));
                grabar(apvd);

                // registrar en historico de precio venta
                HistoricoPrecioVentaDTO historico = new HistoricoPrecioVentaDTO();
                historico.setFecha(new Date(System.currentTimeMillis()));
                historico.setConcepto(
                        "Se agrego un articulo desde el mantenimiento");
                historico.setPrecioCosto(new Double(0));
                historico.setPrecioVenta(new Double(0));
                historico.setPorcentaje(new Double(0));
                // historico.setUsuario(usuario);
                historico.setArticuloPrecioVentaDet(apvd);
                historicoPrecioVentaService.grabar(historico);
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public ArticuloPrecioVentaDetDTO getByArticuloAndPrecioVentaCab(
            Integer idarticulo, Integer idarticuloprecioventacab)
            throws Exception {

        return mapper.entityToDto(
                repo.findByArticuloPrecioVentaCabIdArticuloPrecioVentaCabAndArticuloIdArticulo(
                        idarticuloprecioventacab, idarticulo));
    }

}
