package com.br.studies.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CharacterDto (@NotNull @NotBlank String name, @NotNull @NotBlank String series, String actor) {
}
