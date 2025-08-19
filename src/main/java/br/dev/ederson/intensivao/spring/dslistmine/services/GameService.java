package br.dev.ederson.intensivao.spring.dslistmine.services;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameMinDTO;
import br.dev.ederson.intensivao.spring.dslistmine.entities.Game;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream().map(GameMinDTO::new).toList();
    }
}
