package com.algaworks.algatransito.domain.model;

import com.algaworks.algatransito.domain.exception.NegocioException;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    private String marca;
    private String modelo;
    private String placa;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Autuacao> autuacoes = new ArrayList<>();


    public void adicionarAutuacao(Autuacao autuacao) {
        autuacao.setDataOcorrencia(OffsetDateTime.now());
        autuacao.setVeiculo(this);
        getAutuacoes().add(autuacao);
    }

    public void apreender() {

        if(estaApreendido()){
            throw new NegocioException("Não é possivel alterar o status de APREENDIDO para APREENDIDO");
        }

        this.setStatus(StatusVeiculo.APREENDIDO);
        this.setDataApreensao(OffsetDateTime.now());
    }

    public void removerApreensao() {

        if(!estaApreendido()){
            throw new NegocioException("O veiculo não está APREENDIDO");
        }

        this.setStatus(StatusVeiculo.REGULAR);
        this.setDataApreensao(null);
    }

    public boolean estaApreendido(){
        return StatusVeiculo.APREENDIDO.equals(this.getStatus());
    }

}
