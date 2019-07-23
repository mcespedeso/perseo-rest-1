package py.com.ideasweb.perseo.comunes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import py.com.ideasweb.perseo.common.BaseServiceImpl;
import py.com.ideasweb.perseo.comunes.dtos.ClienteDTO;
import py.com.ideasweb.perseo.comunes.mapper.ClienteMapper;
import py.com.ideasweb.perseo.comunes.repositories.ClienteRepository;
import py.com.ideasweb.perseo.comunes.services.ClienteService;

@Service
public class ClienteServiceImpl extends BaseServiceImpl
        implements ClienteService {

    @Autowired
    ClienteRepository repo;

    @Autowired
    ClienteMapper mapper;

    @Override
    public List<ClienteDTO> getByEmpresa(Integer idEmpresa) throws Exception {

        return mapper
                .entityListToDtoList(repo.findByEmpresaIdEmpresa(idEmpresa));
    }

    @Override
    public ClienteDTO getById(Integer idCliente) throws Exception {

        return mapper.entityToDto(repo.findById(idCliente).get());
    }

    @Override
    public ClienteDTO grabar(ClienteDTO cliente) throws Exception {

        return mapper.entityToDto(repo.save(mapper.dtoToEntity(cliente)));
    }

    @Override
    public List<ClienteDTO> getByTipoDocAndDOc(String tipodoc, String nrodoc)
            throws Exception {

        return mapper.entityListToDtoList(
                repo.findByTipoDocumentoCodTipoDocAndNrodoc(tipodoc, nrodoc));
    }

    @Override
    public List<ClienteDTO> getByNombres(String nombres) throws Exception {

        return mapper.entityListToDtoList(
                repo.findByNombreApellidoIgnoreCaseContaining(nombres));
    }

    @Override
    public List<ClienteDTO> getByUsuario(Integer idUsuario) throws Exception {

        return mapper
                .entityListToDtoList(repo.findByUsuarioIdUsuario(idUsuario));
    }

    @Override
    public ClienteDTO getByDoc(String nrodoc) throws Exception {

        return repo.findByNrodoc(nrodoc).map(mapper::entityToDto)
                .orElse(new ClienteDTO());
    }

}
