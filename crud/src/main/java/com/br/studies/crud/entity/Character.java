package com.br.studies.crud.entity;


import com.br.studies.crud.dto.CharacterDto;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "personagem")
@Table(name = "personagem")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String series;
    private String actor;

    public Character(CharacterDto characterDto) {
        this.name = characterDto.name();
        this.series = characterDto.series();
        this.actor = characterDto.actor();
    }
}
