package hogwarts.api.aluno;

import hogwarts.api.bruxo.DadosBruxo;
import hogwarts.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(
        @NotNull
        Long id,
        DadosBruxo bruxo,
        DadosEndereco endereco,
        String mascote,
        Status status,
        Integer ano) {
}
