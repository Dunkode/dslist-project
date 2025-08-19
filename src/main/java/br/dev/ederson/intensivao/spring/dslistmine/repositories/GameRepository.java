package br.dev.ederson.intensivao.spring.dslistmine.repositories;

import br.dev.ederson.intensivao.spring.dslistmine.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
