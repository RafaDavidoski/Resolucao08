/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utfpr.resolucao08.service;

import com.utfpr.resolucao08.model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

/**
 *
 * @author rafad
 */
@Component
public class FuncionarioServiceImpl implements FuncionarioService {

    private static List<Funcionario> funcionarios = new ArrayList<>();

    static {
        Funcionario func1 = new Funcionario(1, "Jeffrey Nero Hardy", 41, 155000);
        Funcionario func2 = new Funcionario(2, "Matthew Moore Hardy", 44, (float) 75500.45);

        funcionarios.add(func1);
        funcionarios.add(func2);

    }

    @Override
    public List<Funcionario> getAllFuncionario() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return funcionarios;
    }

    @Override
    public Funcionario getFuncionarioById(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    @Override
    public Funcionario addFuncionario(Funcionario funcionario) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Random random = new Random();
        int nextId = random.nextInt(1000) + 10;

        funcionario.setId(nextId);
        funcionarios.add(funcionario);

        return funcionario;
    }

    @Override
    public void updateFuncionario(Funcionario funcionario) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for(Funcionario oldFuncionario : funcionarios)
        {
            if(oldFuncionario.getId()==funcionario.getId())
            {
                oldFuncionario.setNome(funcionario.getNome());
                oldFuncionario.setIdade(funcionario.getIdade());
                oldFuncionario.setSalario(funcionario.getSalario());
            }
        }
    }

    @Override
    public void delete(long id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        for (Funcionario funcionario : funcionarios)
        {
            if(funcionario.getId()==id)
            {
               // funcionario.removerfuncionario(funcionario);
                break;
            }
        }
    }
}
    
        
