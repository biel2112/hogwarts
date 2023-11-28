package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.DadosBruxo;
import hogwarts.api.domain.endereco.DadosEndereco;
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
