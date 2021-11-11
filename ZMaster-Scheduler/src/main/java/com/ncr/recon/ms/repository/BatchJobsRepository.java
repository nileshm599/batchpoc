package com.ncr.recon.ms.repository;

import org.hibernate.id.UUIDGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncr.recon.ms.bo.BatchJobsBO;

@Repository("batchJobsRepository")
public interface BatchJobsRepository extends JpaRepository<BatchJobsBO, UUIDGenerator>{

}//Interface
