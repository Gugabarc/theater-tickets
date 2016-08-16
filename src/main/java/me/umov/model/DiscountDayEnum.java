package me.umov.model;

/**
 * 
 * @author gustavo.miranda
 * 
 * Represents the day of the promotion
 */
public enum DiscountDayEnum {
	
	SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATURDAY(7),
	HOLIDAY(8);

	private final Integer code;

	private DiscountDayEnum(final int code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}
	
	/**
	 * Get the enum that matches the param code
	 * @param code
	 * @return
	 */
	public static DiscountDayEnum forCode(Integer code) {
		for (DiscountDayEnum type : DiscountDayEnum.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}
	
	/**
	 * Return if param is a valid value
	 * 
	 * @param discountDay
	 * @return
	 */
	public static boolean isDayValid(DiscountDayEnum discountDay) {
		boolean isValid = true;
		
		if(discountDay == null){
			isValid = false;
		}
		
		return isValid;
	}
	
	/**
	 * Opposite to {@link #isDayValid(DiscountDayEnum)}
	 * @param discountDay
	 * @return
	 */
	public static boolean isDayInvalid(DiscountDayEnum discountDay) {
		return !isDayValid(discountDay);
	}

}
