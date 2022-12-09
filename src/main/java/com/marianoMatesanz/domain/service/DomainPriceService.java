package com.marianoMatesanz.domain.service;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marianoMatesanz.application.request.FindPriceRequest;
import com.marianoMatesanz.application.response.FindPriceResponse;
import com.marianoMatesanz.domain.common.constants.Constants;
import com.marianoMatesanz.domain.common.mapper.Mapper;
import com.marianoMatesanz.domain.common.utils.UtilsDate;
import com.marianoMatesanz.domain.model.Price;
import com.marianoMatesanz.domain.repository.PriceRepository;

/**
 * ServiceImpl is the service class that implements Service interface In this
 * service class data is fetched from database
 */
public class DomainPriceService implements PriceService, Constants {

	private static final Logger LOGGER = LoggerFactory.getLogger(DomainPriceService.class);
	private final String className = this.getClass().getSimpleName();

	private final PriceRepository priceRepository;
	

    public DomainPriceService(final PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    

	/**
	 * Method implementation for list Price
	 */
	@Override
	public List<FindPriceResponse> findPrice(FindPriceRequest findPriceRequest) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		Collection<Price> prices;
		List<FindPriceResponse> pricesResponse = null;

		try {
			prices = priceRepository.findByPrice(findPriceRequest.getProductId(), findPriceRequest.getBrand_id(),
					UtilsDate.convertToDateViaSqlTimestamp(findPriceRequest.getStartDate()));
			LOGGER.debug("Price list==" + prices);

			pricesResponse = prices.stream().map(price -> Mapper.priceToFindPriceResponse(price))
					.collect(Collectors.toList());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		return pricesResponse;
	}

	/**
	 * Method implementation for listing all the Prices
	 * 
	 * @return List of all Price objects
	 */
	@Override
	public List<Price> findAll() {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		List<Price> priceList = priceRepository.findAll();

		LOGGER.debug("Price list==" + priceList);
		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		return priceList;
	}

	/**
	 * Method implementation for fetching the single Price object, based on Id
	 * 
	 * @param id Unique identifier of the Price
	 * @return Single Price object, based on Id
	 */
	@Override
	public Optional<Price> findById(long id) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		Optional<Price> price = priceRepository.findById(id);

		LOGGER.debug("Price==" + price);
		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		return price;
	}

	/**
	 * Method implementation for deleting an item from the Price based on Id
	 * 
	 * @param id Unique identifier of the Price to be deleted
	 * @return True or False
	 */
	@Override
	public boolean deleteById(long id) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));
		boolean isDeleted = false;

		try {
			// Delete the PriceComments before deleting the Price.
			Optional<Price> deletionPrice = findById(id);
			if (deletionPrice.isPresent()) {

				priceRepository.delete(deletionPrice.get());
				isDeleted = true;
			}
		} catch (Exception ex) {
			LOGGER.error(ex.getMessage());
		}

		LOGGER.debug("isDeleted==" + isDeleted);
		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		return isDeleted;
	}



	/**
	 * Method implementation for updating an item of Price
	 * 
	 * @param Price object to be updated
	 * @return Newly created or updated Price object
	 */
	@Override
	public Price updateStartDate(Price price) {

		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LOGGER.info(MessageFormat.format(LOGGER_ENTRY, className, methodName));

		Price priceReturn = null;

		Optional<Price> updatePrice = findById(price.getSystemPriceId());

		if (updatePrice.isPresent()) {
			// Set the Creation Date only during initial creation of the Price
			if (price.getStartDate() == null)
				updatePrice.get().setStartDate(new Date());

			updatePrice.get().setPriority(price.getPriority());
			priceReturn = priceRepository.save(updatePrice.get());

		}

		LOGGER.debug(" item==" + priceReturn);
		LOGGER.info(MessageFormat.format(LOGGER_EXIT, className, methodName));

		return priceReturn;
	}



}