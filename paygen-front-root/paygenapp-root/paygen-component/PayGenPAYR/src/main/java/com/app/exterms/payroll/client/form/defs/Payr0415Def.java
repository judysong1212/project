/**
 * 공통화면 팝업 
 */
package com.app.exterms.payroll.client.form.defs;

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0415BM;
import com.app.exterms.payroll.client.languages.PayrConstants;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;

/**====================================================
디자인화면 수정시 extends 부분을 다음과 같이 수정하여 사용한 후 다시 원복한다.
extends MSFPanel ->  extends LayoutContainer  implements IMSFWindow { 
상속받아 소스를 구현한 경우에는 에러나는 부분을 수정하여 처리 해야함.
=====================================================**/
public class Payr0415Def  extends TableDef implements PayrDaoConstants {

	private int row = 0;
	private PayrConstants PayrLabel = PayrConstants.INSTANCE;

	public Payr0415Def(String chkDef){

		if("PAYRP150001".equals(chkDef)){
			setTitle(PayrLabel.titlePayr0415());
			setDaoClass(CLASS_PAYR0415_COPY_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0415_COPY_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayrP150001ToPayr0415());
		}else{
			setTitle(PayrLabel.titlePayr0415());
			setDaoClass(CLASS_PAYR0415_DATA_LIST);
			setCustomListMethod(CLASS_PAYR0415_DATA_LIST);
			setAutoFillGrid(true);
			setShowFilterToolbar(false);
			// setCustomListMethod(SysConfiguration.CUSTOM_SERVICE_SKIP_CALL);
			setCheckBoxOnGridRows(true);
			setColumnsDefinition(getPayr1500ToPayr0415());
		}
	}

	public List<ColumnDef> getPayr1500ToPayr0415(){


		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Payr0415BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		listColumnDefs.add(new ColumnDef("일련번호", Payr0415BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});

		/** column 급여년도 : payYr */
		listColumnDefs.add(new ColumnDef("년도", Payr0415BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 50, true, true, true){
			{

			}
		});

		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Payr0415BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});
		/** column 직종 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종", Payr0415BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});
		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0415BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 호봉등급 : pyspGrdeNm */
		listColumnDefs.add(new ColumnDef("호봉등급", Payr0415BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		}); 
		/** column 직종세코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세코드", Payr0415BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0415BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		}); 

		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Payr0415BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
			{

			}
		});


		//        /** column 입력자 : kybdr */
		//        listColumnDefs.add(new ColumnDef("입력자", Payr0415BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 입력일자 : inptDt */
		//        listColumnDefs.add(new ColumnDef("입력일자", Payr0415BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 입력주소 : inptAddr */
		//        listColumnDefs.add(new ColumnDef("입력주소", Payr0415BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정자 : ismt */
		//        listColumnDefs.add(new ColumnDef("수정자", Payr0415BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정일자 : revnDt */
		//        listColumnDefs.add(new ColumnDef("수정일자", Payr0415BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정주소 : revnAddr */
		//        listColumnDefs.add(new ColumnDef("수정주소", Payr0415BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });

		return listColumnDefs;



	}
	
	public List<ColumnDef> getPayrP150001ToPayr0415(){


		List<ColumnDef> listColumnDefs = new ArrayList<ColumnDef>(); 	

		/** column 사업장코드 : dpobCd */
		listColumnDefs.add(new ColumnDef("사업장코드", Payr0415BM.ATTR_DPOBCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		listColumnDefs.add(new ColumnDef("일련번호", Payr0415BM.ATTR_TYPOCCUGRDEMPPGSEILNUM, ColumnDef.TYPE_BIGDECIMAL , 90, true, false, true){
			{

			}
		});

		/** column 급여년도 : payYr */
		listColumnDefs.add(new ColumnDef("년도", Payr0415BM.ATTR_PAYYR, ColumnDef.TYPE_STRING , 50, true, false, true){
			{

			}
		});

		/** column 직종코드 : typOccuCd */
		listColumnDefs.add(new ColumnDef("직종코드", Payr0415BM.ATTR_TYPOCCUCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});
		/** column 직종 : typOccuNm */
		listColumnDefs.add(new ColumnDef("직종", Payr0415BM.ATTR_TYPOCCUNM, ColumnDef.TYPE_STRING, 90, true, true, true){
			{

			}
		});
		/** column 호봉등급코드 : pyspGrdeCd */
		listColumnDefs.add(new ColumnDef("호봉등급코드", Payr0415BM.ATTR_PYSPGRDECD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 호봉등급 : pyspGrdeNm */
		listColumnDefs.add(new ColumnDef("호봉등급", Payr0415BM.ATTR_PYSPGRDENM, ColumnDef.TYPE_STRING, 90, true, false, true){
			{

			}
		}); 
		/** column 직종세코드 : dtilOccuClsDivCd */
		listColumnDefs.add(new ColumnDef("직종세코드", Payr0415BM.ATTR_DTILOCCUCLSDIVCD, ColumnDef.TYPE_STRING , 90, false, false, true){
			{

			}
		});

		/** column 직종세통합코드 : dtilOccuInttnCd */
		listColumnDefs.add(new ColumnDef("직종세통합코드", Payr0415BM.ATTR_DTILOCCUINTTNCD, ColumnDef.TYPE_STRING , 90, true, false, true){
			{

			}
		}); 

		/** column 직종세 : dtilOccuClsDivNm */
		listColumnDefs.add(new ColumnDef("직종세", Payr0415BM.ATTR_DTILOCCUCLSDIVNM, ColumnDef.TYPE_STRING, 90, false, true, true){
			{

			}
		});

		/** column 직종세사용여부 : dtilOccuClsUseYn */
		listColumnDefs.add(new ColumnDef("이관여부", Payr0415BM.ATTR_TRANSFER_YN, ColumnDef.TYPE_BOOLEAN , 90, true, true, true){
			{

			}
		});
		//        /** column 입력자 : kybdr */
		//        listColumnDefs.add(new ColumnDef("입력자", Payr0415BM.ATTR_KYBDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 입력일자 : inptDt */
		//        listColumnDefs.add(new ColumnDef("입력일자", Payr0415BM.ATTR_INPTDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 입력주소 : inptAddr */
		//        listColumnDefs.add(new ColumnDef("입력주소", Payr0415BM.ATTR_INPTADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정자 : ismt */
		//        listColumnDefs.add(new ColumnDef("수정자", Payr0415BM.ATTR_ISMT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정일자 : revnDt */
		//        listColumnDefs.add(new ColumnDef("수정일자", Payr0415BM.ATTR_REVNDT, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });
		//        /** column 수정주소 : revnAddr */
		//        listColumnDefs.add(new ColumnDef("수정주소", Payr0415BM.ATTR_REVNADDR, ColumnDef.TYPE_STRING , 90, true, false, true){
		//        	{
		//
		//        	}
		//        });

		return listColumnDefs;



	}
}
