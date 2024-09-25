package com.br.studies.crud.controller;

import com.br.studies.crud.dto.CharacterDto;
import com.br.studies.crud.entity.Character;
import com.br.studies.crud.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAllCharacters() {
        return characterService.listALlCharacters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable Integer id) {
        Character character = characterService.findCharacterById(id);
        if (character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody @Valid CharacterDto characterDto) {
        Character character = new Character(characterDto);
        Character characterCreated = characterService.saveCharacter(character);
        if (characterCreated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(characterCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Integer id, @RequestBody Character character) {
        Character characterUpdated = characterService.updateCharacter(id, character);
        if (characterUpdated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(characterUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

}
