/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.resolucao08.controller;

import com.utfpr.resolucao08.model.Funcionario;
import com.utfpr.resolucao08.service.FuncionarioServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author rafad
 */
@RestController
public class UserController {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @GetMapping("/funcionario/")
    public List<Funcionario> getAllFuncionario() {
        return funcionarioService.getAllFuncionario();
    }

    @GetMapping("/customer/{customerId}")
    public Funcionario getFuncionarioById(@PathVariable int funcionarioId) {
        return funcionarioService.getFuncionarioById(funcionarioId);
    }

    @PostMapping("/funcionario/")
    public ResponseEntity<Void> addFuncionario(@RequestBody Funcionario newFuncionario, UriComponentsBuilder builder) {
        Funcionario funcionario = funcionarioService.addFuncionario(newFuncionario);

        if (funcionario == null) {
            return ResponseEntity.noContent().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/funcionario/")
    public ResponseEntity<Funcionario> updateCustomer(@RequestBody Funcionario funcionario) {
        Funcionario f = funcionarioService.getFuncionarioById(funcionario.getId());

        if (f == null) {
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }

        f.setNome(funcionario.getNome());
        f.setIdade(funcionario.getIdade());
        f.setSalario(funcionario.getSalario());

        funcionarioService.updateFuncionario(f);
        return new ResponseEntity<Funcionario>(f, HttpStatus.OK);
    }

    @DeleteMapping("/funcionario/{funcionarioId}")
    public ResponseEntity<Funcionario> delete(@PathVariable int funcionarioId) {
        Funcionario f = funcionarioService.getFuncionarioById(funcionarioId);

        if (f == null) {
            return new ResponseEntity<Funcionario>(HttpStatus.NOT_FOUND);
        }

        funcionarioService.delete(funcionarioId);
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);
    }

}
