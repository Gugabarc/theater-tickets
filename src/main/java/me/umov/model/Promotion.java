package me.umov.model;

import java.util.Map;

public class Promotion {

	private DiscountDayEnum discountDay;
	private Map<BuyerProfileEnum, Double> profiles;

	public DiscountDayEnum getDiscountDay() {
		return discountDay;
	}

	public void setDiscountDay(DiscountDayEnum discountDay) {
		this.discountDay = discountDay;
	}

	public Map<BuyerProfileEnum, Double> getProfiles() {
		return profiles;
	}

	public void setProfiles(Map<BuyerProfileEnum, Double> profiles) {
		this.profiles = profiles;
	}

}
