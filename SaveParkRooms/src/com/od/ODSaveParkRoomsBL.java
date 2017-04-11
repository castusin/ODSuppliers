package com.od;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cis.CISConstants;
import com.cis.CISResults;
import com.cis.testServiceTime;


public class ODSaveParkRoomsBL {
	
	ApplicationContext ctx=new ClassPathXmlApplicationContext("spring-servlet.xml"); 
	ODSaveParkRoomsDAO parkRoomsDAO=(ODSaveParkRoomsDAO)ctx.getBean("SaveParkRoomsDAO");
	
	// private static final AtomicInteger count = new AtomicInteger(100001); 
	  
	  
	public CISResults saveParkRooms(ODSaveParkRoomsModel saveParkRooms) {
		
		  // ODSaveParkInfoModel park = new ODSaveParkInfoModel();
		
		// Capture service Start time
		    testServiceTime seriveTimeCheck=new testServiceTime();
		    Calendar current = Calendar.getInstance();
		    DateFormat formatterTime = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		    TimeZone objTime = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		    formatterTime.setTimeZone( objTime);
		    String serviceStartTime=formatterTime.format(current.getTime());
		 			
			 final Logger logger = Logger.getLogger(ODSaveParkInfoBL.class);
			// int parkId = count.incrementAndGet();
			 Calendar currentdate = Calendar.getInstance();
		     DateFormat formatter = new SimpleDateFormat(CISConstants.GS_DATE_FORMAT);
		     TimeZone obj = TimeZone.getTimeZone(CISConstants.TIME_ZONE2);
		     formatter.setTimeZone(obj);
		     String ODDate=formatter.format(currentdate.getTime());
		   		 int parkId=	 saveParkRooms.getParkId();
			 CISResults cisResults = parkRoomsDAO.saveParkRooms(parkId,saveParkRooms.getRoomTypeCode(),saveParkRooms.getRommTypeDescription(),saveParkRooms.getMaxPeople(),saveParkRooms.getMaxAdults(),saveParkRooms.getMaxKids(),saveParkRooms.getMaxQty(),saveParkRooms.getRegularPrice(),ODDate);
			
			
			/* parkRooms=saveParkInfoDAO.saveParkRooms(parkId,saveParkInfo.getParkRooms());
			 
			CISResults.setParkRooms(parkRooms);
			 
			 parkFacilities=saveParkInfoDAO.saveParkFacilities(parkId,facilitiesModel.getFacilityTypeCode(),facilitiesModel.getFacilityTypeDescription(),facilitiesModel.getTicketType(),facilitiesModel.getMaxQty(),facilitiesModel.getCurrentAvailableQty(),facilitiesModel.getPrice());
			 
			 CISResults.setParkFacilities(parkFacilities);
			 parkPricing=saveParkInfoDAO.saveParkFacilities(parkId,pricingModel.getRoomTypeCode(),pricingModel.getFromDate(),pricingModel.getToDate(),pricingModel.getCurrentPrice());
			 
			 CISResults.setParkPricing(parkPricing);*/
			 
			 
			 
			 logger.debug("save ParkInfoBL service" +cisResults);
			 
			// Capture Service End time
			  Calendar ServiceEnd= Calendar.getInstance();
		      DateFormat formatter1 = new SimpleDateFormat(CISConstants.DATE_FORMAT);
		      TimeZone obj1 = TimeZone.getTimeZone(CISConstants.TIME_ZONE);
		      formatter1.setTimeZone(obj1);
			  String serviceEndTime=formatter1.format(ServiceEnd.getTime());
			  seriveTimeCheck.getServiceTime(serviceEndTime,serviceStartTime);
			  
			 return cisResults;
		}

	}
