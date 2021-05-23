package com.epm.manage.repositories;

import com.epm.manage.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepositories extends JpaRepository<Emp,Long> {
}
