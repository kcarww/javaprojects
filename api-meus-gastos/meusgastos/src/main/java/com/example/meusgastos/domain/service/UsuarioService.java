package com.example.meusgastos.domain.service;

import java.util.List;

import com.example.meusgastos.dto.usuario.UsuarioRequestDto;
import com.example.meusgastos.dto.usuario.UsuarioResponseDto;

public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto>{

    @Override
    public List<UsuarioResponseDto> obterTodos() {
        throw new UnsupportedOperationException("Unimplemented method 'obterTodos'");
    }

    @Override
    public UsuarioResponseDto obterPorId(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'obterPorId'");
    }

    @Override
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
    }

    @Override
    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto dto) {
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void deletar(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }
    
}
