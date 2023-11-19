package hogwarts.api.funcionario;

import hogwarts.api.bruxo.Bruxo;
import hogwarts.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "funcionarios")
@Entity(name = "Funcionario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transformacao;
    private String materia;
    @Embedded
    private Bruxo bruxo;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @Embedded
    private Endereco endereco;

    public Funcionario(DadosCadastroFuncionario dados) {
        this.bruxo = new Bruxo(dados.bruxo());
        this.endereco = new Endereco(dados.endereco());
        this.transformacao = dados.transformacao();
        this.materia = dados.materia();
        this.cargo = dados.cargo();
    }

    public void atualizarInformacoes(DadosAtualizacaoFuncionario dados) {
        if(dados.bruxo() != null){
            this.bruxo.atualizarInformacoes(dados.bruxo());
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if(dados.transformacao() != null){
            this.transformacao = dados.transformacao();
        }
        if(dados.materia() != null){
            this.materia = dados.materia();
        }
        if(dados.cargo() != null){
            this.cargo = dados.cargo();
        }
    }
}
