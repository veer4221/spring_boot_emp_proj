package com.epm.manage.repositories;

import com.epm.manage.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepositories extends JpaRepository<Project,Long> {
}
