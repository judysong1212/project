/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.server.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class ExportData extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ExportData.class);

    public static final String KO_CONTENT_TYPE  = "text/html; charset=windows-1252";
    public static final String NOT_AUTHOR_PAGE  = "not_authorized.jsp";
    public static final String NOT_QUE_PAGE  = "not_authorized.jsp";
    public static final String APPLICATION_NAME = "MSF";

    //This variables are initialized once and reused
    //private WritableCellFormat normalFormat;
    //private WritableCellFormat dateFormat;
    //private WritableCellFormat dateTimeFormat;
    //private WritableCellFormat boldFormat;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
//            myInitContext(session);
            String   XLSParam    = MSFSharedUtils.allowNulls(request.getParameter("XLSParam")) ;

            MSFSysm0100BM user = (MSFSysm0100BM)session.getAttribute("extermuser");
            if ( user==null) {
                response.sendRedirect(NOT_AUTHOR_PAGE);
                return;
            }

            ServiceParameters sessionObject = (ServiceParameters) session.getAttribute(XLSParam);
            session.removeAttribute(XLSParam);
            String sheetName                  = null;
            String className                  = null;
            ColumnAttribute[] tableAttributes = null;
            IColumnFilter columnFilters       = null;
            List<ColumnOrder> columnOrders    = null;
            String customMethodName           = null;
            if (sessionObject != null) {
                sheetName        = sessionObject.getSheetName();
                className        = sessionObject.getClsName();
                tableAttributes  = sessionObject.getTableAttributes();
                columnFilters    = sessionObject.getColumnFilters(); 
                columnOrders     = sessionObject.getColumnOrders();
                customMethodName = sessionObject.getCustomMethodName();
                //Take from the list of ColumnAttributes only those we want to use in export
                ArrayList<ColumnAttribute> exportList = new ArrayList<ColumnAttribute>();
                for (ColumnAttribute c :tableAttributes) {
                    if ( c!=null && c.isVisibleInExport() ) {
                        exportList.add(c);
                    }
                }
                ColumnAttribute[] exportTableAttributes = new ColumnAttribute[exportList.size()];
                for (int i=0 ; i<exportList.size() ; i++) {
                    exportTableAttributes[i] = exportList.get(i);
                }
                tableAttributes = exportTableAttributes;
                sessionObject.setTableAttributes(exportTableAttributes);
            }
            if (className != null && tableAttributes != null) {

                  List<BaseModel> list = new ArrayList<BaseModel>();
//TODO 항상메서드가 존재해야함 VO 클래스 객체을 넘겨주면서 값을 받아서 처리한다.
                if ( MSFSharedUtils.paramNull(customMethodName) ) {
//                    PagingLoadResult<BaseModel> result = 
//                    GenericDaoUtils.getListGenericObjectsMapWithParameters(
//                                className,
//                                tableAttributes,
//                                columnFilters,
//                                columnOrders,
//                                null);
//                    list = result.getData();
                    //PagingValues pagingValues = MSFServerUtils.getPagingValues(null, columnOrders);
                    //HibernateUtils.getListGenericObjectsUsingHQL(
                    //        className, tableAttributes, filters, columnOrders, pagingValues.start, pagingValues.offsetLimit, pagingValues.executeRecordCount, list);
                    //PagingLoadResult<BaseModel> result = HibernateUtils.getListGenericObjects(
                    //        className, tableAttributes, filters, columnOrders, null);
                    //List<BaseModel> list = result.getData();
                } else {
                    PagingLoadResult<BaseModel> result = MSFServerUtils.invokeCustomListMethod(
                            sessionObject, user, request, response, getServletContext(), getServletConfig());
                    list = result.getData();
                }

                if (list != null) {
                    OutputStream out = null;
                    try
                    {
                    	
                    	String tmCurrDate = SmrmfUtils.convertDateToString(new Date()); 
                        response.setContentType("application/vnd.ms-excel");
                        response.setHeader("Content-Disposition", "attachment; filename=ExprotData" +  tmCurrDate + ".xls");
                        WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
                        WritableSheet s = w.createSheet(sheetName, 0);

                        WritableCellFormat boldFormat = getBoldFormat();
                        boldFormat.setBackground(Colour.GRAY_25);

                        for ( int i=0 ; tableAttributes!=null && i<tableAttributes.length ; i++ ) {
                            ColumnAttribute attribute = tableAttributes[i];
                            String label = (MSFSharedUtils.paramNull(attribute.getLabel()) ? attribute.getName() : attribute.getLabel()) ;
                            s.addCell(new Label(i, 0, label, boldFormat));
                        }
                        int row = 1;
                        for (BaseModel bm : list) {
                            writeBaseModel(row++, tableAttributes, bm, s);
                        }
                        
                        w.write();
                        w.close();
                    } catch (Exception e) {
                        throw new ServletException("Exception in Excel Servlet", e);
                    } finally {
                        if (out != null) {
                            out.close();
                        }
                    }
                } else {
                    response.sendRedirect(NOT_QUE_PAGE);
                    return;
                }
            }
        } catch (Exception e2) {
            logger.error("Error in doPost(): "+e2, e2);
            response.setContentType(KO_CONTENT_TYPE);
            response.sendRedirect(NOT_AUTHOR_PAGE);
        }
    }

//    private void myInitContext(HttpSession session) {
//        try {
//            ServletContext context = getServletContext();
//            // Read servlet context or session parameters here
//        }
//        catch (Exception e) {
//            System.err.println("ECCEZIONE in myInitContext: "+e);
//        }
//    }
    
    private void writeBaseModel(int r, ColumnAttribute[] tableAttributes, BaseModel bm, WritableSheet s) {
        try {
            for ( int i=0 ; tableAttributes!=null && i<tableAttributes.length ; i++ ) {
                ColumnAttribute attribute = tableAttributes[i];
                    WritableCell cell = getCell(i, r, bm.get(attribute.getName()), attribute.getType());
                    if (cell != null)
                        s.addCell(cell);
            }
        } catch (Exception e) {
            logger.error("Exception in writeBaseModel():", e);
        }
    }

    private WritableCell getCell(int c, int r, Object object, int type) {
        WritableCell cell = null;
        if (object != null) {
            if (object instanceof Date){
                if ( type==ColumnDef.TYPE_DATETIME ) {
                    cell = new DateTime(c, r, (Date)object, getDateTimeFormat());
                } else {
                    cell = new DateTime(c, r, (Date)object, getDateFormat());
                }
            } else if (object instanceof Double){
                cell = new jxl.write.Number(c, r, (Double)object, getNormalFormat());
            } else {
                cell = new Label(c, r, object.toString(), getNormalFormat());
            }
//            switch (type) {
//                case ColumnDef.TYPE_DATE:
//                    cell = new DateTime(c, r, (Date)object, getNormalDateFont());
//                    break;
//                case ColumnDef.TYPE_DATETIME:
//                    cell = new DateTime(c, r, (Date)object, getNormalDateTimeFont());
//                    break;
//                case ColumnDef.TYPE_DOUBLE:
//                    cell = new jxl.write.Number(c, r, (Double)object, getNormalFont());
//                    break;
//                case ColumnDef.TYPE_STRING:
//                case ColumnDef.TYPE_LONG:
//                case ColumnDef.TYPE_BOOLEAN:
//                    cell = new Label(c, r, object.toString(), getNormalFont());
//                    break;
//                default:
//                    cell = new Label(c, r, object.toString(), getNormalFont());
//                    break;
//            }
        } 
        return cell;
    }

    private synchronized WritableCellFormat getNormalFormat() {
        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
        WritableCellFormat format = new WritableCellFormat(font);
        return format;
    }
    private synchronized WritableCellFormat getDateFormat() {
        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
        WritableCellFormat format = new WritableCellFormat(font, DateFormats.FORMAT1);
        return format;
    }
    private synchronized WritableCellFormat getDateTimeFormat() {
        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
        WritableCellFormat format = new WritableCellFormat(font, DateFormats.FORMAT9);
        return format;
    }
    private synchronized WritableCellFormat getBoldFormat() {
        WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
        WritableCellFormat format = new WritableCellFormat(font);
        return format;
    }

//    private WritableCellFormat getNormalFormat() {
//        if (normalFormat == null) {
//            initNormalFormat();
//        }
//        return normalFormat;
//    }
//    private synchronized void initNormalFormat() {
//        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
//        normalFormat = new WritableCellFormat(font);
//    }

//    private WritableCellFormat getDateFormat() {
//        if (dateFormat == null) {
//            initDateFormat();
//        }
//        return dateFormat;
//    }
//    private synchronized void initDateFormat() {
//        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
//        dateFormat = new WritableCellFormat(font, DateFormats.FORMAT1);
//    }

//    private WritableCellFormat getDateTimeFormat() {
//        if (dateTimeFormat == null) {
//            initDateTimeFormat();
//        }
//        return dateTimeFormat;
//    }
//    private synchronized void initDateTimeFormat() {
//        WritableFont font = new WritableFont(WritableFont.ARIAL, 10);
//        dateTimeFormat = new WritableCellFormat(font, DateFormats.FORMAT9);
//    }

//    private WritableCellFormat getBoldFormat() {
//        if (boldFormat == null) {
//            initBoldFormat();
//        }
//        return boldFormat;
//    }
//    private synchronized void initBoldFormat() {
//        WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
//        boldFormat = new WritableCellFormat(font);
//        try {
//            boldFormat.setBackground(Colour.GRAY_25);
//        } catch (Exception ex) {
//            logger.error("Exception in initBoldFormat(): "+ex, ex);
//        }
//    }

}