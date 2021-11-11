package com.ncr.recon.ms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ncr.recon.ms.bo.BatchJobsBO;
import com.ncr.recon.ms.bo.BatchScheduleBO;
import com.ncr.recon.ms.dto.BatchJobsDTO;
import com.ncr.recon.ms.dto.BatchScheduleDTO;
import com.ncr.recon.ms.exceptions.JobNotFoundException;
import com.ncr.recon.ms.repository.BatchJobsRepository;
import com.ncr.recon.ms.repository.BatchScheduleRepository;

import lombok.extern.slf4j.Slf4j;

@Service(value = "masterSchedularServiceImpl")
@Slf4j
public class MasterSchedularServiceImpl implements MasterSchedularService {

	@Autowired(required = true)
	BatchJobsRepository batchJobsRepo;

	@Autowired
	BatchScheduleRepository batchScheduleRepo;

	@Value("${ms.datetimeformat}")
	private String dateFormat;

	@Override
	public List<BatchJobsDTO> fetchScheduledJobs() throws Exception {
		// log.info(dateFormat + "Custom Date time format");
		/*
		 * BatchJobsBO bo = new BatchJobsBO(); bo.setJobname("SampleJob13");
		 * bo.setSchemename("Amex"); bo.setDirections("Incoming");
		 * bo.setRerundetails("No"); bo.setSpringdetails("Spring5.3");
		 * bo.setFilelocation("MQ File"); batchJobsRepo.save(bo);
		 */
		List<BatchJobsBO> listofscheduledjobsbo = batchJobsRepo.findAll();
		// log.info((listofscheduledjobsbo.isEmpty()) ? "Got No Records"
		// : "Got" + listofscheduledjobsbo.size() + "Records");
		System.out.println(LocalDateTime.now());
		return listofscheduledjobsbo.parallelStream().map(batchJobsBO2BatchJobsDTOConversionFunction)
				.collect(Collectors.toList());
	}// method

	@Override
	public BatchScheduleDTO saveNewConfigurationForJob(BatchScheduleDTO dto) throws Exception{
		BatchScheduleBO bo = new BatchScheduleBO();
		BeanUtils.copyProperties(dto, bo);
		bo = batchScheduleRepo.save(bo);
		dto = batchScheduleBO2BatchScheduleDTOConversionFunction.apply(bo);
		return dto;
	}// method

	@Override
	public BatchScheduleDTO updateConfigurationForJob(String jobName) throws Exception{
		BatchScheduleDTO dto;
		Optional<BatchScheduleBO> bo = batchScheduleRepo.findByJobName(jobName);
		if (bo.isPresent()) {
			dto = batchScheduleBO2BatchScheduleDTOConversionFunction.apply(bo.get());
			return dto;
		} else {
			throw new JobNotFoundException("Job with " + jobName + "Not Found");
		} // else
	}// method

	@Override
	public String deleteConfigurationForJob(BatchScheduleDTO dto) throws Exception{

		return null;
	}// method

	private Function<BatchJobsBO, BatchJobsDTO> batchJobsBO2BatchJobsDTOConversionFunction = bo -> {
		BatchJobsDTO dto = new BatchJobsDTO();
		dto.setId(bo.getId().toString());
		dto.setJobname(bo.getJobname());
		dto.setDirections(bo.getDirections());
		dto.setSchemename(bo.getSchemename());
		dto.setRerundetails(bo.getRerundetails());
		dto.setSpringdetails(bo.getSpringdetails());
		dto.setFilelocation(bo.getFilelocation());
		return dto;
	};// function

	private Function<BatchScheduleBO, BatchScheduleDTO> batchScheduleBO2BatchScheduleDTOConversionFunction = bo -> {
		BatchScheduleDTO dto = new BatchScheduleDTO();
		dto.setId(bo.getId().toString());
		dto.setJobName(bo.getJobName());
		dto.setDayOfWeek(bo.getDayOfWeek());
		dto.setTimeOfDay(bo.getTimeOfDay());
		dto.setCronExpression(bo.getCronExpression());
		return dto;
	};// function

}// class
