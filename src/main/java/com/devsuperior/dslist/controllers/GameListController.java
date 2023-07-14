package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        if(!result.isEmpty()){
            for(GameListDTO game : result){
                Long id = game.getId();
//                game.add(linkTo(methodOn(GameListController.class).findById(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }



}
