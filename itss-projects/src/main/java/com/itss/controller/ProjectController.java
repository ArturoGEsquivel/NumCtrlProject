package com.itss.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itss.dto.ProjectTO;
import com.itss.exception.DataNotFoundException;
import com.itss.exception.InternalErrorException;
import com.itss.exception.InvalidDataException;
import com.itss.service.IProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@Slf4j	
@RestController
@Api(value = "project")
@RequestMapping(ProjectController.PROJECT_ROOT_URL)
public class ProjectController {
	
	/** The Constant _ROOT_URL. */
	public static final String PROJECT_ROOT_URL = "/projects";
	
	@Autowired
	private IProjectService iProjectService;
	
	@ApiOperation(value = "getAll", response = List.class,
			notes = "Retrieves all the available projects in the system")
	@ApiResponses({@ApiResponse(code = 200, message = "All the projects have been found."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ResponseEntity<List<ProjectTO>> getAll() {
		try {
			return new ResponseEntity<List<ProjectTO>>(iProjectService.readAll(), HttpStatus.OK);
		}
		catch (InternalErrorException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<List<ProjectTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * Save.
	 * @param project the project TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	@ApiOperation(value = "create", notes = "Save a project.")
	@ApiResponses({@ApiResponse(code = 200, message = "The project has been saved."),
		@ApiResponse(code = 400, message = "Project data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> save(@RequestBody ProjectTO projectTO) {
		try {
			projectTO = iProjectService.createReturnTO(projectTO);
			log.info("The project has been saved. " + projectTO);
			return new ResponseEntity<ProjectTO>(projectTO, HttpStatus.CREATED);
		}
		catch (InvalidDataException e) {
			log.error("Project data is not correct.{}", projectTO);
			return new ResponseEntity<>(e.getErrorTO(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException | DataNotFoundException e) {
			log.error("An internal error has been occurred. {} ", projectTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Update.
	 * @param project the project TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.PUT)
	@ApiOperation(value = "update", notes = "Update a project.")
	@ApiResponses({@ApiResponse(code = 200, message = "The project has been saved."),
		@ApiResponse(code = 400, message = "Project data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> update(@Valid @RequestBody ProjectTO projectTO) {
		try {
			iProjectService.update(projectTO);
			log.info("The project has been updated. " + projectTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (DataNotFoundException | InvalidDataException e) {
			log.error("Project data is not correct. {}", projectTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException e) {
			log.error("An internal error has been occurred. {}", projectTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
