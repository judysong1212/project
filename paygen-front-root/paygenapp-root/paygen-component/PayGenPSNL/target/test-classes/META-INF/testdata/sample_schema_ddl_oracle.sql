DROP IF EXISTS table PSNL0114;
	

 CREATE TABLE PSNL0114 
   (	"DPOB_CD" VARCHAR2(14 BYTE) NOT NULL , 
	"SYSTEMKEY" VARCHAR2(8 BYTE) NOT NULL , 
	"OPZTN_SEIL_NUM" NUMBER(8,0) NOT NULL , 
	"JN_DT" VARCHAR2(8 BYTE), 
	"JN_OPZTN_NM" VARCHAR2(100 BYTE), 
	"ODTY_NM" VARCHAR2(50 BYTE), 
	"WIRL_DT" VARCHAR2(8 BYTE), 
	"JN_PAYR_DDUC_DIV_CD" VARCHAR2(8 BYTE), 
	"JN_PAYR_DDUC_YN" VARCHAR2(1 BYTE), 
	"JN_CNTB_DDUC_DIV_CD" VARCHAR2(8 BYTE), 
	"JN_CNTB_MKNM" VARCHAR2(50 BYTE), 
	"TXEM_RDUC_DIV_CD" VARCHAR2(8 BYTE), 
	"JN_CTNT" VARCHAR2(4000 BYTE), 
	"KYBDR" VARCHAR2(10 BYTE), 
	"INPT_DT" DATE, 
	"INPT_ADDR" VARCHAR2(15 BYTE), 
	"ISMT" VARCHAR2(10 BYTE), 
	"REVN_DT" DATE, 
	"REVN_ADDR" VARCHAR2(15 BYTE), 
	 CONSTRAINT "XPKPSNL0114" PRIMARY KEY ("DPOB_CD", "SYSTEMKEY", "OPZTN_SEIL_NUM")
   )  ;
 

   DROP IF EXISTS table PAYR0470;
   
   
    CREATE TABLE PAYR0470 
   (	"DPOB_CD" VARCHAR2(14 BYTE) NOT NULL , 
	"PAY_DDUC_CD" VARCHAR2(8 BYTE) NOT NULL , 
	"PYMT_DDUC_DIV_CD" VARCHAR2(8 BYTE), 
	"PAY_DDUC_GRP_CD" VARCHAR2(8 BYTE), 
	"PAY_DDUC_NM" VARCHAR2(200 BYTE), 
	"PAY_DDUC_USE_YN" VARCHAR2(1 BYTE), 
	"PAY_DDUC_SUM" NUMBER(10,0), 
	"PAY_DDUC_RTO" NUMBER(6,3), 
	"YRTX_DDUC_DIV_CD" VARCHAR2(8 BYTE), 
	"GRP_APPTN_DIV_CD" VARCHAR2(8 BYTE), 
	"PAY_DDUC_BGNN_DT" VARCHAR2(8 BYTE), 
	"PAY_DDUC_END_DT" VARCHAR2(8 BYTE), 
	"KYBDR" VARCHAR2(20 BYTE), 
	"INPT_DT" VARCHAR2(14 BYTE), 
	"INPT_ADDR" VARCHAR2(15 BYTE), 
	"ISMT" VARCHAR2(20 BYTE), 
	"REVN_DT" VARCHAR2(14 BYTE), 
	"REVN_ADDR" VARCHAR2(15 BYTE), 
	"PAYR_TERM_DDUC_YN" VARCHAR2(1 BYTE), 
	 CONSTRAINT "XPK_PAYR0470" PRIMARY KEY ("DPOB_CD", "PAY_DDUC_CD")
   )  ;
 
