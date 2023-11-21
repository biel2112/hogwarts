package hogwarts.api.funcionario;

import hogwarts.api.bruxo.Bruxo;
import hogwarts.api.endereco.Endereco;

public record DadosDetalhamentoFuncionario(Long id, Bruxo bruxo, Cargo cargo, String materia, String transformacao, Endereco endereco) {

    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getBruxo(), funcionario.getCargo(), funcionario.getMateria(), funcionario.getTransformacao(), funcionario.getEndereco());
    }

}
