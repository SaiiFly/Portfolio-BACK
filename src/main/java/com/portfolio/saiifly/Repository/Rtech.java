/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.saiifly.Repository;

import com.portfolio.saiifly.Entity.tech;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Usuario
 */
public interface Rtech extends JpaRepository<tech, Integer>{
    Optional<tech> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
