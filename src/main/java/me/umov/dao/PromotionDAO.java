package me.umov.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import me.umov.model.BuyerProfileEnum;
import me.umov.model.DiscountDayEnum;
import me.umov.model.Promotion;

/**
 * @author gustavo.miranda
 * 
 * Simulates connection to database
 */
@Repository
public class PromotionDAO {
	
	public static List<Promotion> promotions;
	
	/**
	 * Create valid data
	 */
	public void create(){
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
	}

	/**
	 * Return valid data list
	 */
	public List<Promotion> list() {
		if(promotions == null){
			create();
		}
		
		return promotions;
	}

}
