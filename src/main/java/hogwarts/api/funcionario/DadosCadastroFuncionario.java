package hogwarts.api.funcionario;

import hogwarts.api.bruxo.DadosBruxo;
import hogwarts.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(

        @NotNull
        @Valid
        DadosBruxo bruxo,
        @NotNull
        String transformacao,
        @NotNull
        String materia,
        @NotNull
        Cargo cargo,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
