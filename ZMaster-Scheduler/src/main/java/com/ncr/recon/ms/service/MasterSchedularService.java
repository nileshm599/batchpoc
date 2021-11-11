package com.ncr.recon.ms.service;

import java.util.List;

import com.ncr.recon.ms.dto.BatchJobsDTO;
import com.ncr.recon.ms.dto.BatchScheduleDTO;

public interface MasterSchedularService {

	List<BatchJobsDTO> fetchScheduledJobs() throws Exception;
	BatchScheduleDTO saveNewConfigurationForJob(BatchScheduleDTO dto)throws Exception;
	BatchScheduleDTO updateConfigurationForJob(String jobName)throws Exception;
	String deleteConfigurationForJob(BatchScheduleDTO dto)throws Exception;
	
}//Interface
