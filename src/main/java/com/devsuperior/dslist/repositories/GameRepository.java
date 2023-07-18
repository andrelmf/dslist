package com.devsuperior.dslist.repositories;

import com.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {

    //  Notação @Query utilizada para fazer uma consulta SQL personalizada ao banco de datos, a consulta abaixo é ativada a partir do método
//  "searchByList(Long listId) onde há o parâmetro do tipo Long e o :listId no código da consulta é a bind para o listId que esta
//  presente no parâmetro do método.
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
//  O resultado da consulta deverá ser uma interface.
    List<GameMinProjection> searchByList(Long listId);
}
