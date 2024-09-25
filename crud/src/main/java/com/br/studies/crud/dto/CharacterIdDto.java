package com.br.studies.crud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CharacterIdDto(@NotBlank @NotNull Integer id,
                             @NotBlank @NotNull String name,
                             @NotBlank @NotNull String series,
                             @NotBlank @NotNull String actor) {
}
