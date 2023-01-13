/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.saiifly.Service;

import com.portfolio.saiifly.Entity.tech;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.saiifly.Repository.Rtech;

@Transactional
@Service
public class Stech {
    @Autowired
    Rtech rtech;
    
    public List<tech> list(){
        return rtech.findAll();
    }
    
    public Optional<tech> getOne(int id){
        return rtech.findById(id);
    }
    
    public Optional<tech> getByNombre(String nombre){
        return rtech.findByNombre(nombre);
    }
    
    public void save(tech skill){
        rtech.save(skill);
    }
    
    public void delete(int id){
        rtech.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rtech.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rtech.existsByNombre(nombre);
    }
}
