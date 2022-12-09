package com.marianoMatesanz.application.rest;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marianoMatesanz.application.request.FindPriceRequest;
import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.Price;
import com.marianoMatesanz.domain.common.constants.Constants;
import com.marianoMatesanz.domain.service.PriceService;

/**
 * Controller class for Prices This class is responsible for exposing the REST
 * APIs.
 *
 */

@RequestMapping("/price")
@RestController
public class PriceController implements Constants {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceController.class);
	private final String className = this.getClass().getSimpleName();

	private final PriceService priceService;

	
    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }
    
    
	/**
	 * Method for creating an item in the Price This method accepts
	 * HTTP_REQUEST_METHOD:POST
	 *
	 * @param Price object to be created
	 * @return Response Entity with Http Status Code and Newly created Price
	 *         object
	 */
	
	@PostMapping(value = "/findPrice" , consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<FindPriceResponse>> findPrice(@RequestBody FindPriceRequest price) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		try {

			List<FindPriceResponse> priceReturn = priceService.findPrice(price);

			return new ResponseEntity<>(priceReturn!= null ? priceReturn: Collections.emptyList(), HttpStatus.OK);
		
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));
		}
	}

	/**
	 * Method for listing all the Prices This method accepts HTTP_REQUEST_METHOD:GET
	 *
	 * @return Response Entity with Http Status Code and List of all Price
	 *         objects
	 */
	@GetMapping(path="/allPrices", produces = "application/json")
	public ResponseEntity< List<Price> > getAllPrice() {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		try {
			List<Price> priceList = priceService.findAll();
			LOGGER.debug("List==" + priceList.toString());
			return new ResponseEntity<>(priceList, HttpStatus.OK);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));
		}
	}

	/**
	 * Method for listing an price by id This method accepts HTTP_REQUEST_METHOD:GET
	 *
	 * @param id Unique identifier of the Price
	 * @return Response Entity with Http Status Code and Single Price object,
	 *         based on Id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Price> getPriceById(@PathVariable("id") long id) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		Optional<Price> Price = priceService.findById(id);
		if (Price.isPresent()) {
			LOGGER.debug("Item==" + Price);
			LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));
			return new ResponseEntity<>(Price.get(), HttpStatus.OK);
		} else {
			LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Method for deleting an price by Id This method accepts
	 * HTTP_REQUEST_METHOD:DELETE
	 *
	 * @param id Unique identifier of the Price to be deleted
	 * @return Response Entity with Http Status Code
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deletePriceById(@PathVariable("id") long id) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		try {
			if (priceService.deleteById(id))
				return new ResponseEntity<>(HttpStatus.OK);
			else
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} finally {
			LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));
		}
	}

	/**
	 * Method for updating an item of the Price This method accepts
	 * HTTP_REQUEST_METHOD:PUT
	 *
	 * @param priceUpdate Price object to be updated
	 * @return Response Entity with Http Status Code and Updated Price object
	 */
	@PutMapping("/updateStartDate")
	public ResponseEntity<Price> updateStartDate(@RequestBody Price priceUpdate) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		 Optional<Price> priceReturn = priceService.updateStartDate(priceUpdate);

		LOGGER.debug("Item==" + priceReturn != null ? "not found Price" : priceReturn.toString());
		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		if (priceReturn.isPresent())
			return new ResponseEntity<>(priceReturn.get(), HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

	}


}
