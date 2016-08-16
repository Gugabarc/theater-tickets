package me.umov.main;

import java.util.Locale;
import java.util.Scanner;

import javax.money.MonetaryAmount;
import javax.money.format.AmountFormatQueryBuilder;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

import org.javamoney.moneta.format.CurrencyStyle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import me.umov.config.AppConfig;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.service.PromotionService;

/**
 * @author gustavo.miranda
 *
 * Main class
 *
 */
public class App {
	
	public static void main(String[] args) {
		/**
		 * SETUP
		 */
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PromotionService promotionService = ctx.getBean(PromotionService.class);
		
		Scanner in = new Scanner(System.in);
		
		DiscountDayEnum discountDay = null;
		BuyerProfileEnum buyerProfileEnum = null;
		
		/**
		 * Execution
		 */
		while(true){
			printDayOptions();
			
			discountDay = getDayInput(in);
			
			printBuyerProfileOptions();
			
			buyerProfileEnum = getBuyerProfileInput(in);
			
			MonetaryAmount finalPriceWithDiscout = promotionService.calculateDiscount(discountDay, buyerProfileEnum);
				
			MonetaryAmountFormat moneyFormat = MonetaryFormats.getAmountFormat(AmountFormatQueryBuilder.of(new Locale("pt","BR")).set(CurrencyStyle.SYMBOL).build()); 
				
			System.out.println(moneyFormat.format(finalPriceWithDiscout));
			
			printExitOptions();
			
			if(in.nextInt() == 2){
				System.out.println("Encerrando aplicacao...");
				break;
			}
		}
		
		in.close();
	}

	/**
	 * Print options for exiting the app
	 */
	private static void printExitOptions() {
		System.out.println("Deseja calcular outro desconto?");
		System.out.println("1 - Sim");
		System.out.println("2 - Encerrar");
	}

	/**
	 * Read and validate the buyer profile input
	 * @param in
	 * @return
	 */
	private static BuyerProfileEnum getBuyerProfileInput(Scanner in) {
		BuyerProfileEnum buyerProfileEnum;
		do{
			int buyerProfileCode = in.nextInt();
			buyerProfileEnum = BuyerProfileEnum.forCode(buyerProfileCode);
		} while(isBuyerProfileInvalid(buyerProfileEnum));
		return buyerProfileEnum;
	}

	/**
	 * Read and validate the day input
	 * @param in
	 * @return
	 */
	private static DiscountDayEnum getDayInput(Scanner in) {
		DiscountDayEnum discountDay;
		do{
			int dayCode = in.nextInt();
			discountDay = DiscountDayEnum.forCode(dayCode);
		} while(isDayInvalid(discountDay));
		return discountDay;
	}

	/**
	 * Print buyer profile options in menu
	 */
	private static void printBuyerProfileOptions() {
		System.out.println("Escolha o perfil do comprador:");
		System.out.println("1 - Crianca");
		System.out.println("2 - Estudante");
		System.out.println("3 - Idoso");
	}

	/**
	 * Print day options in menu
	 */
	private static void printDayOptions() {
		System.out.println("Escolha o dia da semana para calcular o desconto:");
		System.out.println("1 - Domingo");
		System.out.println("2 - Segunda");
		System.out.println("3 - Terca");
		System.out.println("4 - Quarta");
		System.out.println("5 - Quinta");
		System.out.println("6 - Sexta");
		System.out.println("7 - Sabado");
		System.out.println("8 - Feriado");
	}
	
	/**
	 * Validate buyer profile
	 * 
	 * @param buyerProfileEnum
	 * @return
	 */
	private static boolean isBuyerProfileInvalid(BuyerProfileEnum buyerProfileEnum) {
		if(BuyerProfileEnum.isBuyerProfileEnumInvalid(buyerProfileEnum)){
			System.out.println("Perfil de comprador invalido, tente novamente:");
			return true;
		}
		return false;
	}

	/**
	 * Validate day
	 * 
	 * @param discountDay
	 * @return
	 */
	private static boolean isDayInvalid(DiscountDayEnum discountDay) {
		if(DiscountDayEnum.isDayInvalid(discountDay)){
			System.out.println("Dia invalido, tente novamente:");
			return true;
		}
		return false;
	}
}
