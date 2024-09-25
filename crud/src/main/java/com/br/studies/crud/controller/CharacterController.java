package com.br.studies.crud.controller;

import com.br.studies.crud.dto.CharacterDto;
import com.br.studies.crud.dto.CharacterIdDto;
import com.br.studies.crud.entity.Character;
import com.br.studies.crud.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<CharacterIdDto>> getAllCharacters() {
        List<CharacterIdDto> characterDtos = characterService.listALlCharacters();
        return ResponseEntity.ok(characterDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDto> getCharacter(@PathVariable Integer id) {
        CharacterDto character = characterService.findCharacterById(id);
        if (character == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(character);
    }

    @PostMapping
    public ResponseEntity<CharacterIdDto> createCharacter(@RequestBody @Valid CharacterIdDto characterDto) {
        CharacterIdDto characterIdDto = characterService.saveCharacter(characterDto);
        if (characterIdDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(characterIdDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterIdDto> updateCharacter(@PathVariable Integer id, @RequestBody CharacterIdDto character) {
        CharacterIdDto characterUpdated = characterService.updateCharacter(id, character);
        if (characterUpdated == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(characterUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.noContent().build();
    }

}
