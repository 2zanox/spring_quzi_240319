package com.quzi.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quzi.lesson07.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {

}
