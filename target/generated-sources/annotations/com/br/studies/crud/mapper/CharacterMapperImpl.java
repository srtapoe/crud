package com.br.studies.crud.mapper;

import com.br.studies.crud.dto.CharacterDto;
import com.br.studies.crud.dto.CharacterIdDto;
import com.br.studies.crud.entity.Character;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T11:19:36-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDto toDto(Character character) {
        if ( character == null ) {
            return null;
        }

        String name = null;
        String series = null;
        String actor = null;

        name = character.getName();
        series = character.getSeries();
        actor = character.getActor();

        CharacterDto characterDto = new CharacterDto( name, series, actor );

        return characterDto;
    }

    @Override
    public CharacterIdDto toDtoId(Character character) {
        if ( character == null ) {
            return null;
        }

        Integer id = null;
        String name = null;
        String series = null;
        String actor = null;

        id = character.getId();
        name = character.getName();
        series = character.getSeries();
        actor = character.getActor();

        CharacterIdDto characterIdDto = new CharacterIdDto( id, name, series, actor );

        return characterIdDto;
    }

    @Override
    public Character toEntity(CharacterDto characterDto) {
        if ( characterDto == null ) {
            return null;
        }

        Character character = new Character();

        character.setName( characterDto.name() );
        character.setSeries( characterDto.series() );
        character.setActor( characterDto.actor() );

        return character;
    }

    @Override
    public Character toEntityId(CharacterIdDto characterIdDto) {
        if ( characterIdDto == null ) {
            return null;
        }

        Character character = new Character();

        if ( characterIdDto.id() != null ) {
            character.setId( characterIdDto.id() );
        }
        character.setName( characterIdDto.name() );
        character.setSeries( characterIdDto.series() );
        character.setActor( characterIdDto.actor() );

        return character;
    }

    @Override
    public List<CharacterDto> toDtoList(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<CharacterDto> list = new ArrayList<CharacterDto>( characters.size() );
        for ( Character character : characters ) {
            list.add( toDto( character ) );
        }

        return list;
    }

    @Override
    public List<CharacterIdDto> toDtoIdList(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<CharacterIdDto> list = new ArrayList<CharacterIdDto>( characters.size() );
        for ( Character character : characters ) {
            list.add( toDtoId( character ) );
        }

        return list;
    }

    @Override
    public List<Character> toEntityList(List<CharacterDto> characterDtos) {
        if ( characterDtos == null ) {
            return null;
        }

        List<Character> list = new ArrayList<Character>( characterDtos.size() );
        for ( CharacterDto characterDto : characterDtos ) {
            list.add( toEntity( characterDto ) );
        }

        return list;
    }
}
