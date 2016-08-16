package me.umov.model;

import java.util.Map;

/**
 * 
 * @author gustavo.miranda
 * Represents a promotion, with a day (or day type) and a list of profiles with discount in that day
 */
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
