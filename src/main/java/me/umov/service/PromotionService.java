package me.umov.service;

import java.util.List;

import javax.money.MonetaryAmount;

import me.umov.dao.PromotionDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.model.Promotion;

public class PromotionService {
	
	private PromotionDAO promotionDAO;
	private PriceService priceService;
	
	public PromotionService(){
	}
	
	public MonetaryAmount calculeDiscount(DiscountDayEnum discountDay, BuyerProfileEnum buyerProfileEnum){
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

	public PromotionDAO getPromotionDAO() {
		return promotionDAO;
	}

	public void setPromotionDAO(PromotionDAO promotionDAO) {
		this.promotionDAO = promotionDAO;
	}

	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}
}
