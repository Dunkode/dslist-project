package br.dev.ederson.intensivao.spring.dslistmine.services;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameDTO;
import br.dev.ederson.intensivao.spring.dslistmine.dto.GameMinDTO;
import br.dev.ederson.intensivao.spring.dslistmine.entities.Game;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> allGames = gameRepository.findAll();
        return allGames.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

}
