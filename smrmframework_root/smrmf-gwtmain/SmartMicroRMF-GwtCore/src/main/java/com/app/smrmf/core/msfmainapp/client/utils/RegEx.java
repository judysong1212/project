/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

public class RegEx {

    public static String EMAIL          = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    public static String CREDIT_CARD    = "^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$";
    public static String CODICE_FISCALE = "[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]";
    public static String ORA_24H        = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    
    
 // 숫자만 가능var intRegex = /[0-9 -()+]+$/;// IP 주소형식var ipRegex = '\b\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}\b';// 0-255 숫자var num0to255Regex = '^([01][0-9][0-9]|2[0-4][0-9]|25[0-5])$';// 0-999 범위의 수var num0to999Regex = '^([0-9]|[1-9][0-9]|[1-9][0-9][0-9])$';// 소수점 허용var floatRegex = '[-+]?([0-9]*\.[0-9]+|[0-9]+)';// 1-50 까지의 숫자var number1to50Regex = /(^[1-9]{1}$|^[1-4]{1}[0-9]{1}$|^50$)/gm;
    
 // 이메일var emailRegex = '^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$';// 카드 번호 4자리var creditCardRegex = '^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\d{3})\d{11})$';// 사용자 이름var usernameRegex = '/^[a-z0-9_-]{3,16}$/';// 비밀번호 - 길이, 대소문자 제한없음var passwordRegex = '/^[a-z0-9_-]{6,18}$/';// 강력한 비밀번호 - 8~15 사이의 수, 최소 1개의 대문자와 소문자 그리고 특수문자 1개 포함var passwordStrengthRegex = /((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15})/gm;// 폰번호var phoneNumber = /[0-9-()+]{3,20}/;

 // RGB 컬러 형식var rgbRegex = /^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/;// Hex 코드 컬러 형식var hexRegex = '/^#?([a-f0-9]{6}|[a-f0-9]{3})$/';// Hex 코드 형식과 16진수로 작성되어 있는지var hexRegex = /(#?([A-Fa-f0-9]){3}(([A-Fa-f0-9]){3})?)/gm;// HTML 태그 형식 #1var htmlTagRegex = '/^< ([a-z]+)([^<]+)*(?:>(.*)< \/\1>|\s+\/>)$/';// HTML 태그 형식 #2var htmlTagRegex = /(\< (/?[^\>]+)\>)/gm;// URL이 다음과 같이 특정 문자열을 포함하고 있는 포맷인지 -> /product/123456789var productUrlRegex = '(\/product\/)?+[0-9]+';// 숫자와 문자만 사용가능var lnhRegex = /([A-Za-z0-9-]+)/gm;   
    
 // jpg, gif, png 이미지, 아래 bmp나 기타 형식은 추가해서 사용가능var imageRegex = /([^\s]+(?=\.(jpg|gif|png))\.\2)/gm;// 모든 이미지 태그var imgTagsRegex = /<img .+?src=\"(.*?)\".+?/>/ig;// 이미지 png 타입<img .+?src=\"(.*?.png)\".+?/>   
    
 /// 일자 포맷 -> 21/3/2006   var dateRegex = /(\d{1,2}\/\d{1,2}\/\d{4})/gm;// 일자 포맷 -> MM/DD/YYYYvar dateMMDDYYYRegex = '^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d$';// 일자 포맷 -> DD/MM/YYYYvar dateDDMMYYYRegex = '^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\d\d$';  
    
    
}
