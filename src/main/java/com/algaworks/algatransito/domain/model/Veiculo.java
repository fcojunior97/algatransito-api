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

    @Enumerated(EnumType.STRING)
    private CorVeiculo cor;

    private String placa;
    private String renavam;
    private String chassi;
    private String anoFabricacaoModelo;

    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;

    private String combustivel;

    @Enumerated(EnumType.STRING)
    private CategoriaVeiculo categoria;

    @Enumerated(EnumType.STRING)
    private EspecieVeiculo especie;

    @Enumerated(EnumType.STRING)
    private Nacionalidade nacionalidade;

    private String potenciaCilindradas;
    private String capacidadePassageiros;
    private String municipio;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private String licenciamento;
    private String observacao;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;



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

        this.setStatus(StatusVeiculo.EM_CIRCULACAO);
        this.setDataApreensao(null);
    }

    public boolean estaApreendido(){
        return StatusVeiculo.APREENDIDO.equals(this.getStatus());
    }

}
