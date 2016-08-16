package me.umov.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import me.umov.dao.PromotionDAO;
import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.model.Promotion;

public class PromotionServiceTest {
	
	@Mock
	private PromotionDAO promotionDAO;
	
	@Mock
	private PriceService priceService;
	
	@InjectMocks
	private PromotionService promotionService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		List<Promotion> promotions = new ArrayList<Promotion>();
		
		promotions = createPromotionValues();
		
		Mockito.when(promotionDAO.list()).thenReturn(promotions);
		
		Mockito.when(priceService.findValueByBuyerProfile(BuyerProfileEnum.KID)).thenReturn(Money.of(10, "BRL"));
		Mockito.when(priceService.findValueByBuyerProfile(BuyerProfileEnum.STUDENT)).thenReturn(Money.of(20, "BRL"));
		Mockito.when(priceService.findValueByBuyerProfile(BuyerProfileEnum.SENIOR)).thenReturn(Money.of(30, "BRL"));
	}

	private List<Promotion> createPromotionValues() {
		List<Promotion> promotions;
		promotions = new ArrayList<Promotion>();
		
		Promotion sundayPromo = new Promotion();
		sundayPromo.setDiscountDay(DiscountDayEnum.SUNDAY);
		Map<BuyerProfileEnum, Double> sundayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		sundayPromoProf.put(BuyerProfileEnum.SENIOR, 0.05);
		sundayPromo.setProfiles(sundayPromoProf);
		
		promotions.add(sundayPromo);
		
		Promotion mondayPromo = new Promotion();
		mondayPromo.setDiscountDay(DiscountDayEnum.MONDAY);
		Map<BuyerProfileEnum, Double> mondayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		mondayPromoProf.put(BuyerProfileEnum.SENIOR, 0.1);
		mondayPromoProf.put(BuyerProfileEnum.KID, 0.1);
		mondayPromoProf.put(BuyerProfileEnum.STUDENT, 0.35);
		mondayPromo.setProfiles(mondayPromoProf);
		
		promotions.add(mondayPromo);
		
		Promotion tuesdayPromo = new Promotion();
		tuesdayPromo.setDiscountDay(DiscountDayEnum.TUESDAY);
		Map<BuyerProfileEnum, Double> tuesdayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		tuesdayPromoProf.put(BuyerProfileEnum.SENIOR, 0.15);
		tuesdayPromoProf.put(BuyerProfileEnum.KID, 0.15);
		tuesdayPromoProf.put(BuyerProfileEnum.STUDENT, 0.35);
		tuesdayPromo.setProfiles(tuesdayPromoProf);
		
		promotions.add(tuesdayPromo);
		
		Promotion wednesdayPromo = new Promotion();
		wednesdayPromo.setDiscountDay(DiscountDayEnum.WEDNESDAY);
		Map<BuyerProfileEnum, Double> wednesdayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		wednesdayPromoProf.put(BuyerProfileEnum.SENIOR, 0.4);
		wednesdayPromoProf.put(BuyerProfileEnum.KID, 0.3);
		wednesdayPromoProf.put(BuyerProfileEnum.STUDENT, 0.5);
		wednesdayPromo.setProfiles(wednesdayPromoProf);
		
		promotions.add(wednesdayPromo);
		
		Promotion thursdayPromo = new Promotion();
		thursdayPromo.setDiscountDay(DiscountDayEnum.THURSDAY);
		Map<BuyerProfileEnum, Double> thursdayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		thursdayPromoProf.put(BuyerProfileEnum.SENIOR, 0.3);
		thursdayPromoProf.put(BuyerProfileEnum.STUDENT, 0.35);
		thursdayPromo.setProfiles(thursdayPromoProf);
		
		promotions.add(thursdayPromo);
		
		Promotion fridayPromo = new Promotion();
		fridayPromo.setDiscountDay(DiscountDayEnum.FRIDAY);
		Map<BuyerProfileEnum, Double> fridayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		fridayPromoProf.put(BuyerProfileEnum.KID, 0.11);
		fridayPromoProf.put(BuyerProfileEnum.STUDENT, 0.35);
		fridayPromo.setProfiles(fridayPromoProf);
		
		promotions.add(fridayPromo);
		
		Promotion saturdayPromo = new Promotion();
		saturdayPromo.setDiscountDay(DiscountDayEnum.SATURDAY);
		Map<BuyerProfileEnum, Double> saturdayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		saturdayPromoProf.put(BuyerProfileEnum.SENIOR, 0.05);
		saturdayPromo.setProfiles(saturdayPromoProf);
		
		promotions.add(saturdayPromo);
		
		Promotion holidayPromo = new Promotion();
		holidayPromo.setDiscountDay(DiscountDayEnum.HOLIDAY);
		Map<BuyerProfileEnum, Double> holidayPromoProf = new HashMap<BuyerProfileEnum, Double>();
		holidayPromoProf.put(BuyerProfileEnum.SENIOR, 0.05);
		holidayPromoProf.put(BuyerProfileEnum.STUDENT, 0.35);
		holidayPromo.setProfiles(holidayPromoProf);
		
		promotions.add(holidayPromo);
		
		return promotions;
	}
	
	@Test
	public void calculatePriceForStudentsTest(){
		BuyerProfileEnum student = BuyerProfileEnum.STUDENT;
		
		MonetaryAmount value = promotionService.calculeDiscount(DiscountDayEnum.MONDAY, student);
		Assert.assertEquals(Money.of(13, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.TUESDAY, student);
		Assert.assertEquals(Money.of(13, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.WEDNESDAY, student);
		Assert.assertEquals(Money.of(10, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.THURSDAY, student);
		Assert.assertEquals(Money.of(13, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.FRIDAY, student);
		Assert.assertEquals(Money.of(13, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SATURDAY, student);
		Assert.assertEquals(Money.of(20, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SUNDAY, student);
		Assert.assertEquals(Money.of(20, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.HOLIDAY, student);
		Assert.assertEquals(Money.of(13, "BRL"), value);
	}
	
	@Test
	public void calculatePriceForKidsTest(){
		BuyerProfileEnum kid = BuyerProfileEnum.KID;
		
		MonetaryAmount value = promotionService.calculeDiscount(DiscountDayEnum.MONDAY, kid);
		Assert.assertEquals(Money.of(9, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.TUESDAY, kid);
		Assert.assertEquals(Money.of(8.5, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.WEDNESDAY, kid);
		Assert.assertEquals(Money.of(7, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.THURSDAY, kid);
		Assert.assertEquals(Money.of(10, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.FRIDAY, kid);
		Assert.assertEquals(Money.of(8.9, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SATURDAY, kid);
		Assert.assertEquals(Money.of(10, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SUNDAY, kid);
		Assert.assertEquals(Money.of(10, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.HOLIDAY, kid);
		Assert.assertEquals(Money.of(10, "BRL"), value);
	}
	
	@Test
	public void calculatePriceForSeniorsTest(){
		BuyerProfileEnum senior = BuyerProfileEnum.SENIOR;
		
		MonetaryAmount value = promotionService.calculeDiscount(DiscountDayEnum.MONDAY, senior);
		Assert.assertEquals(Money.of(27, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.TUESDAY, senior);
		Assert.assertEquals(Money.of(25.5, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.WEDNESDAY, senior);
		Assert.assertEquals(Money.of(18, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.THURSDAY, senior);
		Assert.assertEquals(Money.of(21, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.FRIDAY, senior);
		Assert.assertEquals(Money.of(30, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SATURDAY, senior);
		Assert.assertEquals(Money.of(28.5, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.SUNDAY, senior);
		Assert.assertEquals(Money.of(28.5, "BRL"), value);
		
		value = promotionService.calculeDiscount(DiscountDayEnum.HOLIDAY, senior);
		Assert.assertEquals(Money.of(28.5, "BRL"), value);
	}

}
