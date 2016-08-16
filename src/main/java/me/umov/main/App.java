package me.umov.main;

import java.util.Locale;
import java.util.Scanner;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.format.CurrencyStyle;

import me.umov.dao.PriceDAO;
import me.umov.dao.PromotionDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.service.PriceService;
import me.umov.service.PromotionService;

public class App {
	
	public static void main(String[] args) {
		/**
		 * SETUP
		 */
		PromotionService promoService = new PromotionService();
		PriceService priceService = new PriceService();
		PromotionDAO promoDAO = new PromotionDAO();
		PriceDAO priceDAO = new PriceDAO();
		priceService.setPriceDAO(priceDAO);
		promoService.setPriceService(priceService);
		promoService.setPromotionDAO(promoDAO);
		
		Scanner in = new Scanner(System.in);
		
		/**
		 * MENU
		 */
		System.out.println("Escolha o dia da semana para calcular o desconto:");
		System.out.println("1 - Domingo");
		System.out.println("2 - Segunda");
		System.out.println("3 - Terca");
		System.out.println("4 - Quarta");
		System.out.println("5 - Quinta");
		System.out.println("6 - Sexta");
		System.out.println("7 - Sabado");
		
		int dayCode = in.nextInt();
		
		System.out.println("Escolha o perfil do comprador:");
		System.out.println("1 - Crianca");
		System.out.println("2 - Estudante");
		System.out.println("3 - Idoso");
		
		int buyerProfileCode = in.nextInt();
		
		DiscountDayEnum discountDay = DiscountDayEnum.forCode(dayCode);
		BuyerProfileEnum buyerProfileEnum = BuyerProfileEnum.forCode(buyerProfileCode);
		
		MonetaryAmount calculeDiscount = promoService.calculeDiscount(discountDay, buyerProfileEnum);
		
		MonetaryAmountFormat formatoPadrao = MonetaryFormats.getAmountFormat(AmountFormatQueryBuilder.of(new Locale("pt","BR")).set(CurrencyStyle.SYMBOL).build()); 
		
		System.out.println(formatoPadrao.format(calculeDiscount));
		
		in.close();
	}
}
