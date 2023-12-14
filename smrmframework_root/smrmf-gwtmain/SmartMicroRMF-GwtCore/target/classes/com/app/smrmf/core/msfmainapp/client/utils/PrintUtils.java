/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

import java.util.HashMap;
import java.util.List;

import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.dto.ReportParam;
import com.app.smrmf.core.msfmainapp.client.generics.MSFGridPanel;
import com.app.smrmf.core.msfmainapp.client.widget.MSFImage;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class PrintUtils {
   
    public final static String RDA_DIR_PATH_CHAR = MSFConfiguration.RDA_DIR_PATH_CHAR;          //파일경로 구분자    
    
    public final static String REPORT_PARAMS = "reportParams";
    private static boolean POST_CALL = false;  

    public static GridCellRenderer<BaseModel> printButtonRenderer = new GridCellRenderer<BaseModel>() {  
        public Object render(final BaseModel model, String property, ColumnData config, final int rowIndex,  
                final int colIndex, ListStore<BaseModel> store, Grid<BaseModel>  grid) {
            final List<ReportParam> matchParams = (List<ReportParam>)grid.getData(REPORT_PARAMS);
            MSFImage btn = new MSFImage();
            //Button bt = new Button();
            btn.setId(property);
            //bt.setIcon(MSFMainApp.ICONS.printer());
            btn.setIcon(MSFMainApp.CUSTOM_ICONS.printer());
            btn.setToolTip(MSFMainApp.MSFCONSTANTS.BtStampa());
//          bt.addSelectionListener(new SelectionListener<ButtonEvent>() {
//          public void componentSelected(ButtonEvent ce) {
//              final Button button = ce.getButton();
//              final BaseModel model = button.getData("model");
//              MessageBox.confirm(MSFMainApp.MSFCONSTANTS.BtConferma(), MSFMainApp.MSFMESSAGES.confStampa(),  
//                      new Listener<MessageBoxEvent>() {
//                  public void handleEvent(MessageBoxEvent be) {
//                      if ("yes".equals(be.getButtonClicked().getItemId())) {
//                          print(model, button.getId(), matchParams);
//                      }
//                  }  
//              });                    
//          }
//      });
            btn.addClickHandler(new ClickHandler() {
                public void onClick(ClickEvent arg0) {
                    final MSFImage source = (MSFImage) arg0.getSource();
                    final BaseModel model = source.getData("model");
                    MessageBox.confirm(MSFMainApp.MSFCONSTANTS.BtConferma(), MSFMainApp.MSFMESSAGES.confStampa(),  
                            new Listener<MessageBoxEvent>() {
                        public void handleEvent(MessageBoxEvent be) {
                            if ("yes".equals(be.getButtonClicked().getItemId())) {
                                print(model, source.getId(), matchParams);
                            }
                        }  
                    });                    
                }
            });
            btn.setData("model", model);
            return btn ;
        }
    };
        
    public static void addPrintButton(Component component, final String report, List<ReportParam> matchParams) {
        addPrintButton(component, -1, report, matchParams);
    }
    
    public static void addPrintButton(Component component, int index, final String report, List<ReportParam> matchParams) {
        ColumnModel columnModel = null;
        Grid grid = null;
        if (component instanceof MSFGridPanel) {
            grid = ((MSFGridPanel)component).getGrid();
        } else if (component instanceof Grid) {
            grid = (Grid)component;
        }
        if (grid != null) {
            grid.setData(REPORT_PARAMS, matchParams);
            columnModel = grid.getColumnModel();
            if (columnModel != null) {
                List<ColumnConfig> columnConfigs = columnModel.getColumns();
                ColumnConfig stampa = new ColumnConfig("stampa", 40) {{
                    setRenderer(printButtonRenderer);
                    setFixed(true);
                    setId(report);
                }};
                if (index >= 0) {
                    columnConfigs.add(index, stampa);
                } else {
                    columnConfigs.add(stampa);
                }
            }
        }
    }

    public static void print(BaseModel model, String reportName, List<ReportParam> matchParams) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("rdaFile", reportName); 
        if (matchParams != null && matchParams.size() > 0) {
            for (ReportParam reportParam : matchParams) {
                String value = MSFSharedUtils.convertObjectToString(model.get(GWTUtils.adjustsColumnDefName(reportParam.getModelAttrName())));
                if (MSFSharedUtils.isEmpty(value) && !MSFSharedUtils.isEmpty(reportParam.getDefaultValue())) {
                    value = reportParam.getDefaultValue();
                }
                params.put(reportParam.getRdaAttrName(), value);
            }
        }
        GWTUtils.runReport(getBaseURL(), params, isPostCall());
    }
    
    /*
    - function     : rdaPrint(svDirPath, svRdaFile, svRdaParam)
    - description  : 폼내 RD 뷰어에 보고서 파일을 호출한다.
    - argument     : String svDirPath(L1/L2 경로명),           // 예) 인사급여 파일경로  psnl
                     String svRdaFile(Report 파일명),       // 예) 실제 mrd 파일. PSNLT0253.mrd
                     String svRdaParam(Report 조회 parameter)  // 예) RD에서 사용하는 parameter "/rp [] [] [] []" 
    - return value : 
    */
    public static void rdaPrint(String svDirPath, String svRdaFile, String svRdaParam) {
    	String rdaServerPath =  MSFMainApp.getMsg("PayGen.RdaServerPath");  
        HashMap<String, String> params = new HashMap<String, String>(); 
        params.put("svDirPath", rdaServerPath + RDA_DIR_PATH_CHAR + svDirPath + RDA_DIR_PATH_CHAR );    //파일경로명
        params.put("svRdaParam", svRdaParam);  //param
        params.put("rdaFile", svRdaFile);      //파일명
        params.put("rdaUrl", getRdaBaseURL());  //rda server
        params.put("pageUrl", GWT.getHostPageBaseURL());      //pageBase Url
       
        GWTUtils.runRdaReport(getPopupUrl(), params, isPostCall() );
    }
    
    
    /*
    - function     : rdaPrint(svDirPath, svRdaFile, svRdaParam)
    - description  : 폼내 RD 뷰어에 보고서 파일을 호출한다.
    - argument     : String svDirPath(L1/L2 경로명),           // 예) 인사급여 파일경로  psnl
                     String svRdaFile(Report 파일명),       // 예) 실제 mrd 파일. PSNLT0253.mrd
                     String svRdaParam(Report 조회 parameter)  // 예) RD에서 사용하는 parameter "/rp [] [] [] []" 
    - return value : 
    */
    public static void rexPrint(String svDirPath, String svRexFile, String svRexParam) {
    	String rexServerPath =  MSFMainApp.getMsg("PayGen.RexServerPath");  
        HashMap<String, String> params = new HashMap<String, String>(); 
        params.put("svDirPath", rexServerPath + RDA_DIR_PATH_CHAR + svDirPath + RDA_DIR_PATH_CHAR );    //파일경로명
        params.put("svRexParam", svRexParam);  //param
        params.put("rexFile", svRexFile);      //파일명
        params.put("rexUrl", getRexBaseURL());  //rex server
        params.put("pageUrl", GWT.getHostPageBaseURL());      //pageBase Url
       
        GWTUtils.runRexReport(getRexPopupUrl(), params, isPostCall() );
    }
    
    /**
     * server 호출 : do 
     * @return
     */
    public static String getRexPopupUrl(){
        String url = MSFMainApp.getMsg("PayGen.RexServerUrl"); 
 
        return GWT.getHostPageBaseURL() + url;
    }
    
    public static String getPopupUrl(){
        String url = MSFMainApp.getMsg("PayGen.ReportsPopupServerUrl"); 
 
        return GWT.getHostPageBaseURL() + url;
    }
    
     public static String getBaseURL(){
        String url = MSFMainApp.getMsg("PayGen.RdaReportService");
//        if (MSFSharedUtils.isEmpty(url)) {
//            return REPORTS_SERVER_URL;
//        }
        return url;
    }
     
     public static String getRexBaseURL(){
         String url = MSFMainApp.getMsg("PayGen.RexReportService");
//         if (MSFSharedUtils.isEmpty(url)) {
//             return REPORTS_SERVER_URL;
//         }
         return url;
     }
     
    
    public static String getRdaBaseURL(){
        String url = MSFMainApp.getMsg("PayGen.RdaReportService");
//        if (MSFSharedUtils.isEmpty(url)) {
//            return REPORTS_SERVER_URL;
//        }
        return url;
    }

    public static boolean isPostCall() {
        return POST_CALL;
    }
    
    public static void setPostCall(boolean bol) {
        POST_CALL = bol;
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 :  팝업 우편모아 서비스 호출 서비스 팝업   
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : postPopUp
     * @date : Mar 28, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Mar 28, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param svDirPath
     * @param svRexFile
     * @param svRexParam
     */
    public static void postPopUp(String svDirPath,  HashMap<String, String>  svPostParam) {
    	String postServicePath =   GWT.getHostPageBaseURL() + "postAddr/addrDoroApi.do";
        
        GWTUtils.runPostPopUp(postServicePath, svPostParam, isPostCall() );
    }

}
