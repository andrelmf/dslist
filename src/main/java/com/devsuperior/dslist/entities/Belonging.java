package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
//  EmbeddedId[Integrado] > Utilizado para eu indicar o id da entidade incorporada.
    private BelongingPK id = new BelongingPK();
    private Integer position;

//  Constructors
    public Belonging(){

    }
    public Belonging(Game game, GameList list, Integer position){
        this.id.setGame(game);
        id.setList(list);
        this.position = position;
    }

//  Getters and Setters
    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }
//  Hash Code + Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
