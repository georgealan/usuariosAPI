package com.george.transaction.api.resource;


import com.george.transaction.api.model.Usuario;
import com.george.transaction.api.repository.UsuarioRepository;
import com.george.transaction.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/b/5c117316f35b3d1274b7879a")
public class InformacoesIndividuais {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;


    /**
     * Método responsável pela pesquisa de um recurso pelo código e retorna apenas um resultado.
     *
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> listarPeloCodigo(@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findOne(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    /**
     * Método responsavel por atualizar o objeto Lancamento pelo código.
     *
     * @param id
     * @param usuario
     * @return
     */
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> atualizarLancamento(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    /**
     * Método responsável por atualizar o objeto.
     *
     * @param id
     */
    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        usuarioRepository.delete(id);
    }
}
