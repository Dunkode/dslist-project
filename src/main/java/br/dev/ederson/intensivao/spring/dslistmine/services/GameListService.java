package br.dev.ederson.intensivao.spring.dslistmine.services;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameListDTO;
import br.dev.ederson.intensivao.spring.dslistmine.projections.GameMinProjection;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameListRepository;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> gameMinProjections = gameRepository.searchByList(listId);
        GameMinProjection removed = gameMinProjections.remove(sourceIndex);
        gameMinProjections.add(destinationIndex, removed);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            GameMinProjection gAux = gameMinProjections.get(i);
            gameListRepository.updateBelongingPosition(listId, gAux.getId(), i);
        }

    }


}
