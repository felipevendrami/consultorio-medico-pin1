/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author felip
 */

@Entity
@Table(name = "endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    
    @Column(nullable = false, length = 9)
    private Integer cep;
    
    @Column(nullable = false, length = 60)
    private String bairro;

    @Column(length = 60)
    private String complemento;
    
    @Column(nullable = false, length = 60)
    private String cidade;
    
    @Column(length = 5)
    private Integer numero;
    
    @Column(nullable = false, length = 2)
    private String uf;

    @Column(nullable = false, length = 200)
    private String logradouro;

    public Endereco(){}
    
    public Endereco(Integer cep, String bairro, String complemento, String cidade, Integer numero, String uf, String logradouro) {
        this.cep = cep;
        this.bairro = bairro;
        this.complemento = complemento;
        this.cidade = cidade;
        this.numero = numero;
        this.uf = uf;
        this.logradouro = logradouro;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
