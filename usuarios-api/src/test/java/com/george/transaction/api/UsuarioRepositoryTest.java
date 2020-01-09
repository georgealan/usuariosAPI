package com.george.transaction.api;

import com.george.transaction.api.model.Usuario;
import com.george.transaction.api.repository.UsuarioRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.*;

/**
 * @author George Alan Rufo
 * Teste de repositório do banco de dados.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UsuarioRepositoryTest {

    Usuario usuario, usuario2;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void initUser() {
        usuario = new Usuario("george@gmail.com", "George");
        usuario2 = new Usuario("flavia@gmail.com", "Flavia");
    }

    @Test
    public void createShouldPersistData() {
        usuarioRepository.save(usuario);
        assertThat(usuario.getId()).isNotNull();
        assertThat(usuario.getEmail()).isEqualTo("george@gmail.com");
        assertThat(usuario.getNome()).isEqualTo("George");
    }

    @Test
    public void deleteShouldRemoveData() {
        usuarioRepository.save(usuario);
        usuarioRepository.delete(usuario);
        assertThat(usuarioRepository.findOne(usuario.getId())).isNull();
    }

    @Test
    public void updateShouldChangeAndPersistData() {
        usuarioRepository.save(usuario);
        usuario.setEmail("elias@gmail.com");
        usuario.setNome("Elias");
        usuarioRepository.save(usuario);
        usuario = usuarioRepository.findOne(usuario.getId());
        assertThat(usuario.getEmail()).isEqualTo("elias@gmail.com");
        assertThat(usuario.getNome()).isEqualTo("Elias");
    }

    @Test
    public void constraintNullValuesException() {
        thrown.expect(ConstraintViolationException.class);
        usuarioRepository.save(new Usuario());
    }
}
