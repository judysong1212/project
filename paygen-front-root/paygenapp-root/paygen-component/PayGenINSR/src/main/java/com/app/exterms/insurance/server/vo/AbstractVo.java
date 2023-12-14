package com.app.exterms.insurance.server.vo;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AbstractVo {
	
	@Override
	public String toString() {
	    return ToStringBuilder.reflectionToString(this , ToStringStyle.MULTI_LINE_STYLE);
	  }
}
