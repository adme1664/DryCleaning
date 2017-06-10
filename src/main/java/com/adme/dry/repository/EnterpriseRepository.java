package com.adme.dry.repository;

import com.adme.dry.entities.TblEnterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Adme System on 6/10/2017.
 */
@Repository
public interface EnterpriseRepository extends JpaRepository<TblEnterprise,Integer> {
}
