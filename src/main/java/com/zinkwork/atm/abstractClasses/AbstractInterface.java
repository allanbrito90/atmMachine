package com.zinkwork.atm.abstractClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractInterface<T extends AbstractModel, L extends Long> extends JpaRepository<T,L> {
}
