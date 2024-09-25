package com.br.studies.crud.service;

import com.br.studies.crud.entity.Character;
import com.br.studies.crud.exception.CharacterNotFoundException;
import com.br.studies.crud.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> listALlCharacters() {
        return characterRepository.findAll();
    }

    public Character findCharacterById(Integer id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character is not found!"));
    }

    public Character saveCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character updateCharacter(Integer id, Character characterUpdated) {
        Character character = findCharacterById(id);
        character.setName(characterUpdated.getName());
        character.setSeries(characterUpdated.getSeries());
        return characterRepository.save(characterUpdated);
    }

    public void deleteCharacter(Integer id) {
        Character character = findCharacterById(id);
        characterRepository.delete(character);
    }
}
