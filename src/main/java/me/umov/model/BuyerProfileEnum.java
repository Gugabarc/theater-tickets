package me.umov.model;

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
	
	public static BuyerProfileEnum forCode(Integer code) {
		for (BuyerProfileEnum type : BuyerProfileEnum.values()) {
			if (type.getCode().equals(code)) {
				return type;
			}
		}
		return null;
	}

}
