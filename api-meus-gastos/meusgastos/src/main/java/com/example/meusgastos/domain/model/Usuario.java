package com.example.meusgastos.domain.model;

import java.util.Date;
import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private long id;

    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String foto;

    @Column(nullable = false)
    private Date dataCadastro;

    private Date dataInativacao;

    @OneToMany(mappedBy = "usuario")
    private List<Titulo> titulos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public List<Titulo> getTitulos() {
        return titulos;
    }

    public void setTitulos(List<Titulo> titulos) {
        this.titulos = titulos;
    }



    //#region Região do framework
    // @Override
    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return null;
    // }

    // @Override
    // public String getPassword() {
    //     return senha;
    // }

    // @Override
    // public String getUsername() {
    //     return email;
    // }

    // @Override
    // public boolean isAccountNonLocked() {
    //     return true;
    // }

    // @Override
    // public boolean isCredentialsNonExpired() {
    //     return true;
    // }

    // @Override
    // public boolean isEnabled() {
    //     return true;
    // }

    //#endregion

    
}
