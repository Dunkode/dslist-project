package br.dev.ederson.intensivao.spring.dslistmine.repositories;

import br.dev.ederson.intensivao.spring.dslistmine.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
