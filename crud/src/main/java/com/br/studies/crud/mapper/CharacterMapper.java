package com.br.studies.crud.mapper;

import com.br.studies.crud.dto.CharacterDto;
import com.br.studies.crud.dto.CharacterIdDto;
import org.mapstruct.Mapper;
import com.br.studies.crud.entity.Character;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDto toDto(Character character);
    CharacterIdDto toDtoId(Character character);
    Character toEntityId(CharacterIdDto characterIdDto);
    List<CharacterIdDto> toDtoIdList(List<Character> characters);
}
