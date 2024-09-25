package com.br.studies.crud.exception;

public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException(String message) {
        super(message);
    }
}
