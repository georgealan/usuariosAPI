package com.george.transaction.api.service;

import com.george.transaction.api.model.Usuario;
import com.george.transaction.api.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Long codigo, Usuario usuario){
        Usuario usuarioSalvo = buscarLancamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(usuario, usuarioSalvo, "codigo");
        return usuarioRepository.save(usuarioSalvo);
    }

    public Usuario buscarLancamentoPeloCodigo(Long codigo) {
        Usuario usuarioSalvo = usuarioRepository.findOne(codigo);
        if (usuarioSalvo == null){
            throw new EmptyResultDataAccessException(1);
        }
        return usuarioSalvo;
    }
}
