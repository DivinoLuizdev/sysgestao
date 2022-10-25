package br.com.aulaws.sysgestao.domain;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.Link;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O nome deve ser obrigatório!")
    private String nome;
    @CPF
    @NotNull(message = "O cpf deve ser obrigatório!")
    private String cpf;
    @Email
    private String email;
    @Range(min = 1, max = 100, message = "A idade deve estar entre 1 a 100 anos!")
    private Integer idade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id")
    private Endereco endereco;

    public Cliente() {
        
    }

    public Cliente(String nome, String cpf, String email, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public void add(Link withSelfRel) {
    }

    
}
