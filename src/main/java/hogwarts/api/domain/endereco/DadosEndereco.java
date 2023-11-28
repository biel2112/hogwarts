package hogwarts.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String cidade,
        @NotBlank
        String complemento,
        @NotBlank
        String pais) {



}
