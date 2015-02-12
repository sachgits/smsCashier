package com.sach.gits.Sms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/*"FY56QN342 Confirmed. Ksh4,500 sent to JOHN WANGOMBE 0716177982 on 10/11/14 "
* + " at 637 PM New M-PESA balance is Ksh2,624.00. Save & get a loan on Mshwari"
* You have received 10.00 KSH from 720215577. Your account balance is 0.00 KSH, expiry date is 21-02-2015
*/
public class SmsPatterns {

    public Map<MESSAGE_TYPE,String> PATTERN_RECORDS;
    public static enum MESSAGE_TYPE{
        SAMBAZA,SAF_CREDIT_BALANCE,RECEIVED_MPESA,SENT_MPESA,MPESA_BAL,LOW_MPESA_BAL,BONGA_POINTS,
        MPESA_DELAY,SAF_UNKNOWN,
        RECEIVED_AIRTEL_CREDIT,AIRTEL_CREDIT_BAL,RECEIVED_AIRTELMONEY,SENT_AIRTELMONEY,AIRTELMONEY_BAL,AIRTEL_UNKNOWN,
        PRIMIER_BETTING,UNKNOWN
    };

    public SmsPatterns(){
        PATTERN_RECORDS = new HashMap<MESSAGE_TYPE, String>();
        PATTERN_RECORDS.put(MESSAGE_TYPE.SAMBAZA,Patterns.RECEIVED_SAMBAZA_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.SAF_CREDIT_BALANCE, Patterns.SAF_CREDIT_BAL_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.RECEIVED_MPESA, Patterns.RECEIVED_MPESA_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.SENT_MPESA, Patterns.SENT_MPESA_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.MPESA_BAL, Patterns.MPESA_BAL_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.LOW_MPESA_BAL, Patterns.LOW_MPESA_BAL_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.MPESA_DELAY, Patterns.MPESA_DELAY_PATTERN);
        PATTERN_RECORDS.put(MESSAGE_TYPE.RECEIVED_AIRTEL_CREDIT, Patterns.RECEIVED_AIRTEL_CREDIT_PATTERN);
        //put all other records as they patterns are edited
    }

    public MESSAGE_TYPE messageTypeFinder(String message){
        Set<MESSAGE_TYPE> all_types = PATTERN_RECORDS.keySet();
        int size = all_types.size();
        Iterator<MESSAGE_TYPE> iterate = all_types.iterator();
        MESSAGE_TYPE found_type = null;
        while(iterate.hasNext()){
            if(Pattern.matches(PATTERN_RECORDS.get((found_type=iterate.next())),message))
                break;
        }
        return found_type;
    }

    public MESSAGE_TYPE messageTypeFinder2(String message){
        return null;
    }

    public static abstract class Patterns{
        public static String PHONE_NUMBER = "((\\+*254)|0){0,1}7\\d{8}";
        public static String AMOUNT = "\"(Ksh)*(KSH)*(ksh)*\\\\d+(,*\\\\d+)*+\\\\.\\\\d\\\\d\\\\.*\\\\s*(KSH)*(Ksh)*(ksh)*\"";
        public static String DATE_TIME = "\\d{1,2}(/|-)\\d{1,2}(/|-)(20)*1\\d\\.*";
        public static String RECEIVED_SAMBAZA_PATTERN = "(Y|y)ou\\\\s+have\\\\s+received\\\\s+\\\\d+,*(KSH|Ksh|ksh){0,1}\\\\d+.\\\\d\\\\d\\\\s+(KSH|Ksh|ksh){0,1}\"\n" +
                "\t\t\t+ \"\\\\s+from\\\\s+(\\\\+*254|0){0,1}7\\\\d{8}\\\\.*(\\\\s*(Y|y)our\\\\s+account\\\\s+balance\\\\s+is\\\\s+\\\\d+.\\\\d\\\\d\\\\s+KSH,\\\\s\"\n" +
                "\t\t\t+ \"expiry\\\\s+date\\\\s+is\\\\s+\\\\d+-\\\\d+-20\\\\d\\\\d)*";
        public static String SAF_CREDIT_BAL_PATTERN = "";
        public static String RECEIVED_MPESA_PATTERN = "[A-Z0-9]{9}\\\\sConfirmed\\\\.\\\\s*You\\\\s*have\\\\s*received Ksh\\\\d+,*\\\\d*.\\\\d\\\\d\\\\sfrom\\\\s*[A-Z]+\\\\s* [A-Z]*\\\\s*2547\\\\d{8}\\\\s*on\"\n" +
                "\t\t\t+ \" \\\\d{1,2}/\\\\d{1,2}/1\\\\d\\\\sat\\\\s\\\\d{1,2}:\\\\d\\\\d\\\\sP*M*M\\\\s*New M-PESA balance is Ksh\\\\d+,*\\\\d*.\\\\d\\\\d.\\\\s*PIN YAKO SIRI YAKO";
        public static String SENT_MPESA_PATTERN = "[A-Z0-9]{9}\\\\s+(c|C)onfirmed\\\\.\\\\s*Ksh\\\\d+,*\\\\d+\\\\.\\\\d\\\\d\\\\ssent\\\\sto\\\\s[A-Z]+\\\\s+[A-Z]+\\\\s+(\\\\+*254|0){0,1}7\\\\d{8}\\\\.{0,1}\"\n" +
                "\t\t\t+ \"(\\\\son\\\\s\\\\d\\\\d/\\\\d\\\\d/1\\\\d\\\\sat\\\\s\\\\d+:\\\\d\\\\d\\\\sP*A*M\\\\sNew\\\\sM-PESA\\\\sbalance\\\\s*is\\\\sKsh\\\\d+,*\\\\d+.\\\\d\\\\d\\\\.*\\\\s\"\n" +
                "\t\t\t+ \"Save\\\\s&\\\\sget\\\\sa\\\\sloan\\\\son\\\\sMshwari)*";
        public static String MPESA_BAL_PATTERN = "";
        public static String LOW_MPESA_BAL_PATTERN = "Failed.\\\\s*Not\\\\senough\\\\smoney\\\\s*in\\\\syour\\\\sM-PESA\\\\saccount\\\\sto\\\\ssend\\\\sKsh\\\\d+,*\\\\d*.\\\\d\\\\d.\"\n" +
                "\t\t\t+ \" You\\\\smust\\\\sbe\\\\sable\\\\sto\\\\s+pay\\\\sthe+\\\\s+transaction\\\\s*fee\\\\s*as\\\\s*well\\\\s*as\\\\s*the\\\\srequested\\\\samount.\"\n" +
                "\t\t\t+ \"\\\\sYour\\\\sM-PESA\\\\sbalance\\\\sis\\\\sKsh\\\\d+,*\\\\d*.\\\\d\\\\d";
        public static String MPESA_DELAY_PATTERN = "WE WERE UNABLE to that right now please try again later";
        public static String RECEIVED_AIRTEL_CREDIT_PATTERN = "";
        public static String AIRTEL_CREDIT_BAL_PATTERN;
        public static String RECEIVED_AIRTELMONEY_PATTERN;
        public static String SENT_AIRTELMONEY_PATTERN;
        public static String AIRTELMONEY_BAL_PATTERN;
        public static String RECEIVED_ORANGE_CREDIT_PATTERN;
        public static String ORANGE_CREDIT_BAL_PATTERN;
        public static String RECEIVED_ORANGEMONEY_PATTERN;
        public static String SENT_ORANGEMONEY_PATTERN;
        public static String ORANGEMONEY_BAL_PATTERN;

    }
}
