package br.dev.ederson.intensivao.spring.dslistmine.controllers;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameDTO;
import br.dev.ederson.intensivao.spring.dslistmine.dto.GameMinDTO;
import br.dev.ederson.intensivao.spring.dslistmine.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "games")
public class GamerController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> getGames() {
        return gameService.findAll();
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        return gameService.findById(id);
    }
}
