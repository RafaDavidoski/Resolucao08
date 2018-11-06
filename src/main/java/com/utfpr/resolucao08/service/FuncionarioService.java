/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.resolucao08.service;

import com.utfpr.resolucao08.model.Funcionario;
import java.util.List;

/**
 *
 * @author rafad
 */
public interface FuncionarioService {
    
    public List<Funcionario>getAllFuncionario();
    
    public Funcionario getFuncionarioById(long id);
    
    public Funcionario addFuncionario(Funcionario funcionario);
    
    public void updateFuncionario(Funcionario funcionario);
    
    public void delete(long id);
    
}
