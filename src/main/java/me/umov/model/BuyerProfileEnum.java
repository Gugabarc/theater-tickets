package me.umov.model;

/**
 * 
 * @author gustavo.miranda
 * 
 * Buyer profile: KID, STUDENT or SENIOR
 */
public enum BuyerProfileEnum {
	
	KID(1),
	STUDENT(2),
	SENIOR(3);

	private final Integer code;

	private BuyerProfileEnum(final int code) {
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
	public static BuyerProfileEnum forCode(Integer code) {
		for (BuyerProfileEnum type : BuyerProfileEnum.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}
	
	/**
	 * Return if param is a valid value
	 * 
	 * @param buyerProfileEnum
	 * @return
	 */
	public static boolean isBuyerProfileEnumValid(BuyerProfileEnum buyerProfileEnum) {
		boolean isValid = true;
		
		if(buyerProfileEnum == null){
			isValid = false;
		}
		
		return isValid;
	}
	
	/**
	 * Opposite to {@link #isBuyerProfileEnumValid(BuyerProfileEnum)}
	 * @param buyerProfileEnum
	 * @return
	 */
	public static boolean isBuyerProfileEnumInvalid(BuyerProfileEnum buyerProfileEnum) {
		return !isBuyerProfileEnumValid(buyerProfileEnum);
	}
}
