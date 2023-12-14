package com.app.smrmf.pkg.proc.payr.generics;

import com.ibm.icu.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayrServerUtilsGM
{
	private static final Logger logger = LoggerFactory.getLogger(PayrServerUtilsGM.class);
	public static boolean getAgeYn(String payFamyResnRegnNum)
  {
    boolean result = false;
    
    
    String birthStr = payFamyResnRegnNum.substring(0, 6); //birthStr은 급여가족주민번호를 첫번째 자리에서부터 6번째 전 자리까지 자른 값 -> 0 1 2 3 4 5 -> 주민번호 앞자리
    //bisrthStr = 주민번호앞자리, 생년월일
    //century = 주민번호 뒷자리 첫번째숫자
    int century = Integer.parseInt(payFamyResnRegnNum.substring(6, 7)); //century는 주민번호 뒷자리 첫째자리를 자른 값
    if ((century == 9) || (century == 0)) {
      birthStr = "18" + birthStr;
    } else if ((century == 1) || (century == 2) || (century == 5) || (century == 6)) {
      birthStr = "19" + birthStr;
    } else if ((century == 3) || (century == 4) || (century == 7) || (century == 8)) {
      birthStr = "20" + birthStr;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREAN);
    
    GregorianCalendar today = new GregorianCalendar();
    GregorianCalendar birth = new GregorianCalendar();
    try
    {
      Date birthDay = sdf.parse(birthStr); //ex) 19901025
      birth.setTime(birthDay);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    int factor = 0;
    
    logger.debug("century : " + century);
    
    logger.debug("birthStr : " + birthStr);
    
    logger.debug("sdf : " + sdf); 
    
    logger.debug("today : " + today);
    
    logger.debug("birth : " + birth);
    
    logger.debug("today.get(6) : " + today.get(6));
    
    logger.debug("birth.get(6) : " + birth.get(6));
    
    logger.debug("today.get(1) : " + today.get(1));
    
    logger.debug("birth.get(1) : " + birth.get(1));
    
    if (today.get(6) < birth.get(6)) {
      factor = -1;
    }
    int age = today.get(1) - birth.get(1) + factor;
    
    logger.debug("factor : " + factor);
    logger.debug("age : " + age);
    
    if (age < 19) {
      result = true;
    }
    return result;
  }
}
