package me.umov.service;

import java.util.List;

import javax.money.MonetaryAmount;

import me.umov.dao.PriceDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.Price;

public class PriceService {
	
	private PriceDAO priceDAO;
	
	public PriceService(){
	}
	
	public List<Price> list(){
		return priceDAO.list();
	}
	
	public MonetaryAmount findValueByBuyerProfile(BuyerProfileEnum buyerProfileEnum){
		for(Price p : priceDAO.list()){
			if(p.getBuyerProfileEnum() == buyerProfileEnum){
				return p.getPrice();
			}
		}
		return null;
	}

	public PriceDAO getPriceDAO() {
		return priceDAO;
	}

	public void setPriceDAO(PriceDAO priceDAO) {
		this.priceDAO = priceDAO;
	}

}
