package br.dev.ederson.intensivao.spring.dslistmine.controllers;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameListDTO;
import br.dev.ederson.intensivao.spring.dslistmine.dto.GameMinDTO;
import br.dev.ederson.intensivao.spring.dslistmine.dto.ReplacementDTO;
import br.dev.ederson.intensivao.spring.dslistmine.services.GameListService;
import br.dev.ederson.intensivao.spring.dslistmine.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping("/{listId}/replacement")
    public void replacement(@PathVariable Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getDestinationIndex());
    }
}
