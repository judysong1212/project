package com.app.smrmf.syscom.client.util;

import com.app.smrmf.core.msfmainapp.client.def.BaseRecordDef;


public class StaticGroup {
    public static BaseRecordDef TYPE_FONT = new BaseRecordDef(){
        {
            add("NORMAL", "<p style=\"font-style:normal;\">This is a paragraph, normal.</p>");
            add("ITALIC", "<p style=\"font-style:italic;\">This is a paragraph, normal.</p>");
            add("14PX", "<p style=\"font-size:14px;\">This is a paragraph, normal.</p>");
        }
    };

    public static BaseRecordDef LANGUAGES = new BaseRecordDef(){
        {
            add("ko", "KOREA");
            add("KR", "KOREA"); 
        }
    };

    public static BaseRecordDef SEX = new BaseRecordDef(){
        {
            add("M", "M");
            add("F", "F");
            add("U", "U");
        }
    };

    public static BaseRecordDef SIZE = new BaseRecordDef(){
        {
            add("60", "<= 60kg");
            add("80", "tra 60 e 100kg");
            add("100", "> 100kg");
        }
    };

}
