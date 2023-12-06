package hogwarts.api.controller;

import hogwarts.api.domain.aula.AgendamentoAula;
import hogwarts.api.domain.aula.DadosAgendamentoAula;
import hogwarts.api.domain.aula.DadosCancelamentoAula;
import hogwarts.api.domain.aula.DadosDetalhamentoAula;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AgendamentoAula agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoAula dados){
        agenda.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoAula(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoAula dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
