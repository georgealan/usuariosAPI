package com.george.transaction.api.event.listener;

import com.george.transaction.api.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @author George Alan
 * Esta classe é responsável por escutar a classe RecursoCriadoEvent, toda vez que a classe do
 * evento for evocada esta classe vai escutar ela.
 *
 *
 */
@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

    /**
     * Método responsável por adicionar nos parametros os dados recuperados da classe
     * RecursoCriadoEvent, com os dados recebidos ela seta eles para as variáveis response
     * e codigo, ela recupera da classe pelo get(), e adiciona para o método adicionarHeaderLocation.
     * @param recursoCriadoEvent
     */
    @Override
    public void onApplicationEvent(RecursoCriadoEvent recursoCriadoEvent) {
        HttpServletResponse response = recursoCriadoEvent.getResponse();
        Long codigo = recursoCriadoEvent.getCodigo();
        adicionarHeaderLocation(response, codigo);
    }

    /**
     * Método responsável por mapear a URI atual que está sendo requisitada, pelo código, e
     * a resposta vai ser setada no Header da requisição.
     * @param response
     * @param codigo
     */
    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("location", uri.toASCIIString());
    }
}
