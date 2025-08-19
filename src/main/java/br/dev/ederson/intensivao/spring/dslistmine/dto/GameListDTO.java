package br.dev.ederson.intensivao.spring.dslistmine.dto;

import br.dev.ederson.intensivao.spring.dslistmine.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO(GameList gameList) {
        this.id = gameList.getId();
        this.name = gameList.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
