package com.marianoMatesanz.domain.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.marianoMatesanz.domain.common.constants.Constants;


public class UtilsDate  implements Constants{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtilsDate.class);

    /**
     * Convert String to Date
     * @param strDate
     * @return
     */
	public static Date convertStringtoDate(String fecha, String formatoDate) {
		Date fechaDate = null;
		try {
			if (!UtilsString.isNullOrEmpty(fecha)) {
				SimpleDateFormat formatter  = new SimpleDateFormat(formatoDate);
				formatter .setTimeZone(TimeZone.getTimeZone("GMT"));
				fechaDate = formatter .parse(fecha);
			}

		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}

		return fechaDate;
	}
    
    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return LocalDateTime.ofInstant(
          dateToConvert.toInstant(), ZoneId.systemDefault());
    }
    
    public static Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }
    
    
    public static Date getDateNow() {

    	SimpleDateFormat formatter= new SimpleDateFormat(DATE_FORMAT);
    	
    	Date dateNow = new Date(System.currentTimeMillis());
    	String res = formatter.format( dateNow );
    	dateNow = convertStringtoDate(res, DATE_FORMAT);
    	return dateNow;
    }
}
