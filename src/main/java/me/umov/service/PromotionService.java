package me.umov.service;

import java.util.List;

import javax.money.MonetaryAmount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.umov.dao.PromotionDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.model.Promotion;

/**
 * 
 * @author gustavo.miranda
 * Service class for promotions
 */
@Service
public class PromotionService {
	
	@Autowired
	private PromotionDAO promotionDAO;
	
	@Autowired
	private PriceService priceService;
	
	public PromotionService(){
	}
	
	/**
	 * Returns the price with the discount for the buyer profile and day params
	 * 
	 * @param discountDay
	 * @param buyerProfileEnum
	 * @return MonetaryAmount
	 */
	public MonetaryAmount calculateDiscount(DiscountDayEnum discountDay, BuyerProfileEnum buyerProfileEnum){
		List<Promotion> list = promotionDAO.list();
		Promotion promotion = null;
		
		for (Promotion p : list) {
			if(discountDay == p.getDiscountDay()){
				promotion = p;
				break;
			}
		}
		
		Double discountPercent = promotion.getProfiles().get(buyerProfileEnum);
		
		MonetaryAmount price = priceService.findValueByBuyerProfile(buyerProfileEnum);
		
		if(discountPercent != null){
			return price.subtract(price.multiply(discountPercent));
		}
		
		return price;
	}
}
