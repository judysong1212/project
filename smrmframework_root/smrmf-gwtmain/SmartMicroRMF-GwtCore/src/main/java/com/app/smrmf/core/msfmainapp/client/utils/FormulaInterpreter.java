/*
 * Micro Smart Framework - Framework GWT (Google) + Ext GWT (Sencha) for RIA Applications
 * Copyright(c) 2014, atres
 * 
 * http://visionit.kr
 *
 */
package com.app.smrmf.core.msfmainapp.client.utils;

public class FormulaInterpreter {

    private static String zc;

    public static double string2double(String op)
    {
        if (op.length()>0){
            op = op.replace(" ", "");
            if (op.startsWith("(") && 
                    getParenthesis(op,0) ==op.length()-1)
                op=op.substring(1,op.length()-1);
            try {
                double res = 0;
                res = Double.valueOf(op).doubleValue();
                return res;
            } catch (Exception e) {

            }
            if (op.length()==2 && op=="PI") return Math.PI;
            try {
                double res = 0;
                if (op.length()==1 && TryVariable(op,res)) 
                    return res;
            } catch (Exception e) {

            }
            int pos=0,level=6,parenthesis=0;
            for (int i=op.length()-1;i>-1;i--)
            {
                switch (op.substring(i,i+1).charAt(0))
                {
                case '(':parenthesis++;break;
                case ')':parenthesis--;break;
                case '+':if(parenthesis==0 && level>0){pos=i;level=0;}break;
                case '-':if(parenthesis==0 && level>1){pos=i;level=1;}break;
                case '*':if(parenthesis==0 && level>2){pos=i;level=2;}break;
                case '%':if(parenthesis==0 && level>3){pos=i;level=3;}break;
                case '/':if(parenthesis==0 && level>4){pos=i;level=4;}break;
                case '^':if(parenthesis==0 && level>5){pos=i;level=5;}break;
                }
            }
            if (pos!=0 && pos!=op.length()-1) {
                zc=op.substring(pos,pos+1);
                String t1,t2;
                t1=op.substring(0,pos);
                t2=op.substring(pos+1,op.length());
                switch (zc.charAt(0))
                {
                case '+':return string2double(t1)+string2double(t2);
                case '-':return string2double(t1)-string2double(t2);
                case '*':return string2double(t1)*string2double(t2);
                case '/':return string2double(t1)/string2double(t2);
                //case '%':return Math.IEEEremainder(FormulaInterpreter(t1),FormulaInterpreter(t2));
                case '^':return Math.pow(string2double(t1),string2double(t2));
                }
            }
        }
        return 0.0;
    }

    private static int parenthesis = 0;

    private static int getParenthesis(String op,int start)
    {
        int res=start;
        for (int i=start;i<op.length();i++)
        {
            switch (op.substring(i,i+1).charAt(0))
            {
            case '(':parenthesis++;break;
            case ')':parenthesis--;break;
            }
            if (parenthesis==0){res=i;break;}
        }
        return res;
    }

    private static String vars="";
    private final static String allowed="abcdefgxyz";
    private static double[] values=new double[10];

    private static boolean TryVariable(String Op, double wert)
    {
        int i=vars.indexOf(Op);
        if (i!=-1)
        {
            wert=values[i];
            return true;
        }
        else
        {
            wert=0.0;
            return false;
        }
    }

}
