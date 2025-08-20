package br.dev.ederson.intensivao.spring.dslistmine.services;

import br.dev.ederson.intensivao.spring.dslistmine.dto.GameListDTO;
import br.dev.ederson.intensivao.spring.dslistmine.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }


}
