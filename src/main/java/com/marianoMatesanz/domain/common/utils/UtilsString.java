package com.marianoMatesanz.domain.common.utils;

import java.util.function.Supplier;

public class UtilsString {
	
	/**
	 * Protect null pointer get´s access 
	 *
	 * 
	 * @param <T>
	 * @param supplier
	 * @return
	 */
	public static <T> T nullGuard(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (NullPointerException ignored) {
			return null;
		}
	}
	
	/**
	 * Look if a String us null or empty
	 *
	 * @param aData cadena a explorar
	 * @return true si la cadena es vacia o nula en caso contrario devuelve false
	 */
	public static boolean isNullOrEmpty(String aData) {

		return (aData == null || aData.length() == 0);

	}

}
