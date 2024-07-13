package com.marcelle.ForumHubChallenge.controller;

import com.marcelle.ForumHubChallenge.dominio.Usuario.UsuarioRepository;
import com.marcelle.ForumHubChallenge.dominio.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private UsuarioRepository repositoryUsuario;

    @PostMapping
    @Transactional
    public void criar(@RequestBody @Valid DadosCriacaoTopico dados){
    var topico = new Topico(dados);
    topico.setStatus(Status.ABERTO);
        var autorDoTopico = repositoryUsuario.findByEmail(dados.login());
    repository.save(topico);
        System.out.println(autorDoTopico);
    topico.setAutor(autorDoTopico.get(0));

    }
    @GetMapping
    public Page<DadosListarTopico> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListarTopico::new);
        return page;
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTopico dados){
        repository.findById(dados.id());
        var topico = repository.getReferenceById(dados.id());
        if (topico.getStatus().equals(Status.ABERTO)){
            topico.atualizarTopico(dados);
        }
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity solucionar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.setStatus(Status.SOLUCIONADO);
        return ResponseEntity.noContent().build();
    }



}
