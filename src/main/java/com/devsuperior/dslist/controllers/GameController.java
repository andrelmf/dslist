package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll(){
        List<GameMinDTO> result = gameService.findAll();
        if(!result.isEmpty()){
            for(GameMinDTO game : result){
                Long id = game.getId();
//                game.add(linkTo(methodOn(GameController.class).getUniqueGame(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
