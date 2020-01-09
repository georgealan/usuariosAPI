package com.george.transaction.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

/**
 * @author George Alan
 * Esta classe é um evento que serve para disparar quando for necessário um cabeçalho
 */
public class RecursoCriadoEvent extends ApplicationEvent {

    private HttpServletResponse response;
    private Long codigo;

    /**
     * Este é o construtor da classe que passa como atributo 3 objetos.
     * Abaixo temos o construtor da classe, onde setamos os atributos para inicializarmos
     * a classe, para ela não ser inicializada de forma default. Com isso a classe será
     * inicializada com os valores dos atributos setados.
     * O Object source é o objeto em si.
     *
     * @param source
     * @param response
     * @param codigo
     */
    public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.response = response;
        this.codigo = codigo;
    }

    /**
     * Métodos Getters e Setters.
     * @return
     */
    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}
