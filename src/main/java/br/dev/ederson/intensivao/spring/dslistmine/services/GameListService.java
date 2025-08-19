package br.dev.ederson.intensivao.spring.dslistmine.services;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameListDTO;
import br.dev.ederson.intensivao.spring.dslistmine.entities.GameList;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }
}
