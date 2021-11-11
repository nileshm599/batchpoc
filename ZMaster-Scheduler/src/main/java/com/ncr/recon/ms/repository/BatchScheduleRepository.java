package com.ncr.recon.ms.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncr.recon.ms.bo.BatchScheduleBO;
import com.ncr.recon.ms.exceptions.JobNotFoundException;

@Repository("batchScheduleRepository")
public interface BatchScheduleRepository extends JpaRepository<BatchScheduleBO, Serializable> {

	@Query(value = "SELECT bs.jobName FROM BatchScheduleBO bs WHERE bs.jobName= :name")
	public Optional<BatchScheduleBO> findByJobName(@Param("name") String jobName) throws IllegalArgumentException , JobNotFoundException;

}
