package com.msfgwt.client.test.reflection;

import com.msfgwt.reflection.client.HasReflect;
import com.msfgwt.reflection.client.Reflectable;

/**
 * 
 * @author James Luo
 *
 * 12/08/2010 4:59:10 PM
 */
public class KnowIssues {
	
	static class ClassPackageVisable{
		
	}
	
	//@Reflect_Full
	public static class KnowIssueFunctionWithNoPublicParameters{
		
		private String name;
		
		public void setClass(ClassPackageVisable clazz){
			
		}
		
		public ClassPackageVisable getClassA(){
			return null;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
	
	@Reflectable(methods=false)
	public static class KnowIssueFunctionWithNoPublicParameters_HowFix{
		
		private String name;
		
		public void setClass(ClassPackageVisable clazz){
			
		}
		
		public ClassPackageVisable getClassA(){
			return null;
		}

		@HasReflect
		public void setName(String name) {
			this.name = name;
		}

		@HasReflect
		public String getName() {
			return name;
		}
	}
}
