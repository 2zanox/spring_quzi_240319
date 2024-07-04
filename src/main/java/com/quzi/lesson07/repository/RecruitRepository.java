package com.quzi.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quzi.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	public List<RecruitEntity> findById(int id);
	public List<RecruitEntity> findTop3ByOrderById();
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalary(String type, int salary);
	public List<RecruitEntity> findTop3ByOrderBySalaryDesc();
	
}
