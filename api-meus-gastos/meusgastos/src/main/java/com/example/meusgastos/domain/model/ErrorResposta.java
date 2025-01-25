package com.example.meusgastos.domain.model;

public class ErrorResposta {
    public String dataHora;
    public Integer status;
    public String titulo;
    public String mensagem;

    
    public ErrorResposta(String dataHora, Integer status, String titulo, String mensagem) {
        this.dataHora = dataHora;
        this.status = status;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    

}
