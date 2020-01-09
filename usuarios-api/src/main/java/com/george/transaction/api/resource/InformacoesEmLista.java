package com.george.transaction.api.resource;

import com.george.transaction.api.event.RecursoCriadoEvent;
import javax.servlet.http.HttpServletResponse;
import com.george.transaction.api.model.Usuario;
import com.george.transaction.api.repository.UsuarioRepository;
import com.george.transaction.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/b/5c1172dbf35b3d1274b78786")
public class InformacoesEmLista {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * Método responsável por listar todos os recursos de Lançamentos.
     *
     * @return
     */
    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    /**
     * Método responsável por criar um novo objeto lançamento.
     * Utilizando a classe LançamentoService para tratar as regras de negócio.
     *
     * @param usuario
     * @param response
     * @return
     */
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> criarLancamento(@Valid @RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario usuarioSalvo = usuarioService.salvar(usuario);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }


}
