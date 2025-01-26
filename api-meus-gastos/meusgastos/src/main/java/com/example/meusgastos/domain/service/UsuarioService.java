package com.example.meusgastos.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.meusgastos.domain.exception.ResourceBadRequestException;
import com.example.meusgastos.domain.exception.ResourceNotFoundException;
import com.example.meusgastos.domain.model.Usuario;
import com.example.meusgastos.domain.repository.UsuarioRepository;
import com.example.meusgastos.dto.usuario.UsuarioRequestDto;
import com.example.meusgastos.dto.usuario.UsuarioResponseDto;

public class UsuarioService implements ICRUDService<UsuarioRequestDto, UsuarioResponseDto>{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<UsuarioResponseDto> obterTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
            .map(usuario -> mapper.map(usuario, UsuarioResponseDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDto obterPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            throw new ResourceNotFoundException("Não foi possível encontrar o usuário com id: " + id);
        }

        return mapper.map(usuario.get(), UsuarioResponseDto.class);
    }

    @Override
    public UsuarioResponseDto cadastrar(UsuarioRequestDto dto) {
        validarDados(dto);

        Usuario usuario = mapper.map(dto, Usuario.class);

        usuario = usuarioRepository.save(usuario);

        return mapper.map(usuario, UsuarioResponseDto.class);

    }

    @Override
    public UsuarioResponseDto atualizar(Long id, UsuarioRequestDto dto) {
        obterPorId(id);

        validarDados(dto);

        Usuario usuario = mapper.map(dto, Usuario.class);
        usuario.setId(id);
        usuario = usuarioRepository.save(usuario);
        return mapper.map(usuario, UsuarioResponseDto.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);

        usuarioRepository.deleteById(id);
    }

    private void validarDados(UsuarioRequestDto dto) {
        if (dto.getEmail() == null || dto.getSenha() == null) {
            throw new ResourceBadRequestException("Email e senha são obrigatórios");
        }
    }
    
}
