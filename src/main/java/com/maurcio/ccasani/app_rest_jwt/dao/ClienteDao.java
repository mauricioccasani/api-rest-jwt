package com.maurcio.ccasani.app_rest_jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurcio.ccasani.app_rest_jwt.entity.Cliente;
@Repository
public interface ClienteDao extends JpaRepository<Cliente, Integer> {

}
