package hogwarts.api.domain.funcionario;

import hogwarts.api.domain.bruxo.Bruxo;
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

    public Funcionario(DadosCadastroFuncionario dados) {
        this.bruxo = new Bruxo(dados.bruxo());
        this.transformacao = dados.transformacao();
        this.materia = dados.materia();
        this.cargo = dados.cargo();
    }

    public void atualizarInformacoes(DadosAtualizacaoFuncionario dados) {
        if(dados.bruxo() != null){
            this.bruxo.atualizarInformacoes(dados.bruxo());
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
