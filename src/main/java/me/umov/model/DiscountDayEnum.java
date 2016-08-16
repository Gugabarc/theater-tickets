package me.umov.model;

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
	
	public static DiscountDayEnum forCode(Integer code) {
		for (DiscountDayEnum type : DiscountDayEnum.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}

}
