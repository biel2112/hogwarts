package hogwarts.api.aluno;

import hogwarts.api.bruxo.Bruxo;
import hogwarts.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Casa casa;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer ano;
    private String mascote;
    @Embedded
    private Bruxo bruxo;
    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAluno dados) {
        this.bruxo = new Bruxo(dados.bruxo());
        this.endereco = new Endereco(dados.endereco());
        this.casa = dados.casa();
        this.status = dados.status();
        this.ano = dados.ano();
        this.mascote = dados.mascote();
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if(dados.bruxo() != null){
            this.bruxo.atualizarInformacoes(dados.bruxo());
        }
        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco());
        }
        if(dados.status() != null){
            this.status = dados.status();
        }
        if(dados.ano() != null){
            this.ano = dados.ano();
        }
        if(dados.mascote() != null){
            this.mascote = dados.mascote();
        }
    }
}
