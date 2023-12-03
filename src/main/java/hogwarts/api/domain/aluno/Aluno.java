package hogwarts.api.domain.aluno;

import hogwarts.api.domain.bruxo.Bruxo;
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

    public Aluno(DadosCadastroAluno dados) {
        this.bruxo = new Bruxo(dados.bruxo());
        this.casa = dados.casa();
        this.status = dados.status();
        this.ano = dados.ano();
        this.mascote = dados.mascote();
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if(dados.bruxo() != null){
            this.bruxo.atualizarInformacoes(dados.bruxo());
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
