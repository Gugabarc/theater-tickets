package me.umov.service;

import java.util.List;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.umov.dao.PriceDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.Price;

/**
 * 
 * @author gustavo.miranda
 * Service class for price
 */
@Service
public class PriceService {
	
	@Autowired
	private PriceDAO priceDAO;
	
	public PriceService(){
	}
	
	public List<Price> list(){
		return priceDAO.list();
	}
	
	/**
	 * Find the standard value for a buyer profile
	 * @param buyerProfileEnum
	 * @return
	 */
	public MonetaryAmount findValueByBuyerProfile(BuyerProfileEnum buyerProfileEnum){
		for(Price p : priceDAO.list()){
			if(p.getBuyerProfileEnum() == buyerProfileEnum){
				return p.getPrice();
			}
		}
		return null;
	}

}
