package me.umov.dao;

import java.util.ArrayList;
import java.util.List;

import org.javamoney.moneta.Money;

import me.umov.model.BuyerProfileEnum;
import me.umov.model.Price;

public class PriceDAO {
	
	public static List<Price> prices;
	
	private void create(){
		prices = new ArrayList<Price>();
		
		Price priceStudent = new Price();
		priceStudent.setBuyerProfileEnum(BuyerProfileEnum.STUDENT);
		priceStudent.setPrice(Money.of(8, "BRL"));
		
		prices.add(priceStudent);
		
		Price priceSenior = new Price();
		priceSenior.setBuyerProfileEnum(BuyerProfileEnum.SENIOR);
		priceSenior.setPrice(Money.of(6, "BRL"));
		
		prices.add(priceSenior);
		
		Price priceKid = new Price();
		priceKid.setBuyerProfileEnum(BuyerProfileEnum.KID);
		priceKid.setPrice(Money.of(5.5, "BRL"));
		
		prices.add(priceKid);
		
	}

	public List<Price> list() {
		if(prices == null){
			create();
		}
		
		return prices;
	}

}
