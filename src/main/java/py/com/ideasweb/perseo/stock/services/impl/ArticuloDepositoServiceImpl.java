package py.com.ideasweb.perseo.stock.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDTO;
import py.com.ideasweb.perseo.stock.dtos.ArticuloDepositoDTO;
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
    public ArticuloDepositoDTO grabar(ArticuloDepositoDTO dto) throws Exception {
       
        if ( !articuloRepo.findById(dto.getArticulo().getIdArticulo()).isPresent()){
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
        return mapper.entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

}
