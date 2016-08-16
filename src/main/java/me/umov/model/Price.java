package me.umov.model;

import javax.money.MonetaryAmount;

/**
 * 
 * @author gustavo.miranda
 * Represents the price for each buyer profile
 */
public class Price {

	private MonetaryAmount price;
	private BuyerProfileEnum buyerProfileEnum;

	public MonetaryAmount getPrice() {
		return price;
	}

	public void setPrice(MonetaryAmount price) {
		this.price = price;
	}

	public BuyerProfileEnum getBuyerProfileEnum() {
		return buyerProfileEnum;
	}

	public void setBuyerProfileEnum(BuyerProfileEnum buyerProfileEnum) {
		this.buyerProfileEnum = buyerProfileEnum;
	}

}
