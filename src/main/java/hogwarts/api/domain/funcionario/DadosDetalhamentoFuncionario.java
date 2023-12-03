package hogwarts.api.domain.funcionario;

import hogwarts.api.domain.bruxo.Bruxo;

public record DadosDetalhamentoFuncionario(Long id, Bruxo bruxo, Cargo cargo, String materia, String transformacao) {

    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getBruxo(), funcionario.getCargo(), funcionario.getMateria(), funcionario.getTransformacao());
    }

}
