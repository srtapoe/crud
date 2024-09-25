package com.br.studies.crud.service;

import com.br.studies.crud.dto.CharacterDto;
import com.br.studies.crud.dto.CharacterIdDto;
import com.br.studies.crud.entity.Character;
import com.br.studies.crud.exception.CharacterNotFoundException;
import com.br.studies.crud.mapper.CharacterMapper;
import com.br.studies.crud.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;
    private final CharacterMapper characterMapper;

    public CharacterService(CharacterRepository characterRepository, CharacterMapper characterMapper) {
        this.characterRepository = characterRepository;
        this.characterMapper = characterMapper;
    }

    public List<CharacterIdDto> listALlCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characterMapper.toDtoIdList(characters);
    }

    public CharacterDto findCharacterById(Integer id) {
        Character character = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character is not found!"));

        return characterMapper.toDto(character);
    }

    public CharacterIdDto saveCharacter(CharacterIdDto character) {
            Character characterResponse = characterMapper.toEntityId(character);
            Character characterSaved = characterRepository.save(characterResponse);

            return characterMapper.toDtoId(characterSaved);
    }

    public CharacterIdDto updateCharacter(Integer id, CharacterIdDto characterUpdated) {
        Character savedInDatabase = characterRepository.findById(id)
                .orElseThrow(() -> new CharacterNotFoundException("Character is not found!"));

        savedInDatabase.setName(characterUpdated.name());
        savedInDatabase.setSeries(characterUpdated.series());
        savedInDatabase.setActor(characterUpdated.actor());


        Character updatedCharacter = characterRepository.save(savedInDatabase);
        return characterMapper.toDtoId(updatedCharacter);
    }

    public void deleteCharacter(Integer id) {
       Character character = characterRepository.findById(id)
               .orElseThrow(() -> new CharacterNotFoundException("Character is not found!"));

       characterRepository.delete(character);
    }
}
