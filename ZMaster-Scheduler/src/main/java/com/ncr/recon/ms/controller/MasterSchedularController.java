package com.ncr.recon.ms.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ncr.recon.ms.dto.BatchJobsDTO;
import com.ncr.recon.ms.dto.BatchScheduleDTO;
import com.ncr.recon.ms.service.MasterSchedularServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/scheduler")
@Slf4j
@Validated
public class MasterSchedularController {

	@Autowired(required = true)
	private MasterSchedularServiceImpl service;

	/**
	 * Exposes an EndPoint to Fetch All Jobs In System.
	 * 
	 * http://localhost:8082/scheduler/getAllScheduled
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getAllScheduled", produces = "application/json")
	public @ResponseBody ResponseEntity<List<BatchJobsDTO>> retriveAllScheduledJobs() throws Exception {
		List<BatchJobsDTO> list = service.fetchScheduledJobs();
		// log.info((list.isEmpty()) ? "Got No Records" : "Got" + list.size() +
		// "Records");
		return new ResponseEntity<>(list, HttpStatus.OK);
	}// method

	/**
	 * Expose an end-point to add the configuration of any scheduled or to be
	 * scheduled Job http://localhost:8082/scheduler/add
	 * 
	 * @param RequestBody
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<BatchScheduleDTO> addNewConfigurationForJob(
			@Valid @RequestBody BatchScheduleDTO dto) throws Exception {
		BatchScheduleDTO saved = service.saveNewConfigurationForJob(dto);
		return ((saved == null) ? new ResponseEntity<BatchScheduleDTO>(saved, HttpStatus.NOT_IMPLEMENTED)
				: new ResponseEntity<BatchScheduleDTO>(saved, HttpStatus.CREATED));
	}// method

	/**
	 * Expose an end-point to update the configuration of any scheduled or to be
	 * scheduled Job http://localhost:8082/scheduler/update/{jobName}
	 * 
	 * @param jobName
	 * @return ResponseEntity<BatchScheduleDTO>
	 * @throws Exception
	 */
	@PutMapping(value = "/update/{jobName}", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<BatchScheduleDTO> updateNewConfigurationForJob(
			@Valid @Size(min= 3 , message = "Job Name should contain min 3 Chars") @PathVariable String jobName)
			throws Exception {
		BatchScheduleDTO dto = null;
		dto = service.updateConfigurationForJob(jobName.trim());
		return ((dto == null) ? new ResponseEntity<BatchScheduleDTO>(dto, HttpStatus.NOT_MODIFIED)
				: new ResponseEntity<BatchScheduleDTO>(dto, HttpStatus.ACCEPTED));
	}// method

	/**
	 * Expose an end-point to update the configuration of any scheduled or to be
	 * scheduled Job
	 * 
	 * @param dto
	 * @return ResponseEntity
	 * @throws Exception
	 */
	@DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
	public @ResponseBody ResponseEntity<String> deleteConfigurationForJob(@Valid @RequestBody BatchScheduleDTO dto)
			throws Exception {
		String message = service.deleteConfigurationForJob(dto);
		return (message != null) ? new ResponseEntity<>(message, HttpStatus.NOT_MODIFIED)
				: new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}// method

}// class
