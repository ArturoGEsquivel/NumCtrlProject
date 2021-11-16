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

import com.itss.dto.RoleTO;
import com.itss.exception.DataNotFoundException;
import com.itss.exception.InternalErrorException;
import com.itss.exception.InvalidDataException;
import com.itss.service.IRoleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@Slf4j	
@RestController
@Api(value = "role")
@RequestMapping(RoleController.ROLE_ROOT_URL)
public class RoleController {
	
	/** The Constant _ROOT_URL. */
	public static final String ROLE_ROOT_URL = "/roles";
	
	@Autowired
	private IRoleService iroleService;
	
	@ApiOperation(value = "getAll", response = List.class,
			notes = "Retrieves all the available roles in the system")
	@ApiResponses({@ApiResponse(code = 200, message = "All the roles have been found."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ResponseEntity<List<RoleTO>> getAll() {
		try {
			return new ResponseEntity<List<RoleTO>>(iroleService.readAll(), HttpStatus.OK);
		}
		catch (InternalErrorException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<List<RoleTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	/**
	 * Save.
	 * @param role the role TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	@ApiOperation(value = "create", notes = "Save a Role.")
	@ApiResponses({@ApiResponse(code = 200, message = "The role has been saved."),
		@ApiResponse(code = 400, message = "Role data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> save(@RequestBody RoleTO roleTO) {
		try {
			roleTO = iroleService.createReturnTO(roleTO);
			log.info("The Role has been saved. " + roleTO);
			return new ResponseEntity<RoleTO>(roleTO, HttpStatus.CREATED);
		}
		catch (InvalidDataException e) {
			log.error("Role data is not correct.{}", roleTO);
			return new ResponseEntity<>(e.getErrorTO(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException | DataNotFoundException e) {
			log.error("An internal error has been occurred. {} ", roleTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Update.
	 * @param role the role TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.PUT)
	@ApiOperation(value = "update", notes = "Update a role.")
	@ApiResponses({@ApiResponse(code = 200, message = "The role has been saved."),
		@ApiResponse(code = 400, message = "Role data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> update(@Valid @RequestBody RoleTO roleTO) {
		try {
			iroleService.update(roleTO);
			log.info("The role has been updated. " + roleTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (DataNotFoundException | InvalidDataException e) {
			log.error("Role data is not correct. {}", roleTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException e) {
			log.error("An internal error has been occurred. {}", roleTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
