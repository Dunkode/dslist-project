package br.dev.ederson.intensivao.spring.dslistmine.controllers;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameListDTO;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameListRepository;
import br.dev.ederson.intensivao.spring.dslistmine.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
}
