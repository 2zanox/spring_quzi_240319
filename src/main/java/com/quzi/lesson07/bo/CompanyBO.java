package com.quzi.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quzi.lesson07.entity.CompanyEntity;
import com.quzi.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	// Insert
	// input: 4개의 파라미터(name, business, scale, headcount)
	// output: CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
		// 1) CompanyEntity company = CompanyEntity.builder()
		
		
		// 1) return companyRepository.save(company);
		// 2) 컴퍼니를 객체 안담고 바로 출력
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	// Update
	// input: id, scale, headcount
	// output: CompanyEntity
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {
		// 기존 데이터 조회
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// Entity 데이터 값 변경
		if (company != null) {
			company = companyRepository.save(company.toBuilder()					
					.scale(scale)
					.headcount(headcount)
					.build());
			
//			company = company.toBuilder()
//					.scale(scale)
//					.headcount(headcount)
//					.build();
			
			// update save요청
			//company = companyRepository.save(company);
		}
		return company;
	}
	
	// Delete
	// input: id
	// output: X
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
	
}
