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

import com.itss.dto.ProfileTO;
import com.itss.exception.DataNotFoundException;
import com.itss.exception.InternalErrorException;
import com.itss.exception.InvalidDataException;
import com.itss.service.IProfileService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@Slf4j	
@RestController
@Api(value = "profile")
@RequestMapping(ProfileController.PROFILE_ROOT_URL)
public class ProfileController {
	
	/** The Constant _ROOT_URL. */
	public static final String PROFILE_ROOT_URL = "/profiles";
	
	@Autowired
	private IProfileService iProfileService;
	
	@ApiOperation(value = "getAll", response = List.class,
			notes = "Retrieves all the available profiles in the system")
	@ApiResponses({@ApiResponse(code = 200, message = "All the profiles have been found."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ResponseEntity<List<ProfileTO>> getAll() {
		try {
			return new ResponseEntity<List<ProfileTO>>(iProfileService.readAll(), HttpStatus.OK);
		}
		catch (InternalErrorException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<List<ProfileTO>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	/**
	 * Save.
	 * @param profile the profile TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	@ApiOperation(value = "create", notes = "Save a profile.")
	@ApiResponses({@ApiResponse(code = 200, message = "The profile has been saved."),
		@ApiResponse(code = 400, message = "Profile data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> save(@RequestBody ProfileTO profileTO) {
		try {
			profileTO = iProfileService.createReturnTO(profileTO);
			log.info("The profile has been saved. " + profileTO);
			return new ResponseEntity<ProfileTO>(profileTO, HttpStatus.CREATED);
		}
		catch (InvalidDataException e) {
			log.error("Profile data is not correct.{}", profileTO);
			return new ResponseEntity<>(e.getErrorTO(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException | DataNotFoundException e) {
			log.error("An internal error has been occurred. {} ", profileTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Update.
	 * @param profile the profile TO
	 * @return the response entity
	 */
	@RequestMapping(value = {"/"}, method = RequestMethod.PUT)
	@ApiOperation(value = "update", notes = "Update a profile.")
	@ApiResponses({@ApiResponse(code = 200, message = "The profile has been saved."),
		@ApiResponse(code = 400, message = "Profile data is not correct."),
		@ApiResponse(code = 500, message = "An internal error has been occurred.")})
	public ResponseEntity<?> update(@Valid @RequestBody ProfileTO profileTO) {
		try {
			iProfileService.update(profileTO);
			log.info("The profile has been updated. " + profileTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (DataNotFoundException | InvalidDataException e) {
			log.error("Profile data is not correct. {}", profileTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		catch (InternalErrorException e) {
			log.error("An internal error has been occurred. {}", profileTO);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
