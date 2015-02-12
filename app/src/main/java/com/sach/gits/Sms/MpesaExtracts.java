package com.sach.gits.Sms;

/*"FY56QN342 Confirmed. Ksh4,500 sent to JOHN WANGOMBE 0716177982 on 10/11/14 "
* + " at 637 PM New M-PESA balance is Ksh2,624.00. Save & get a loan on Mshwari"
* You have received 10.00 KSH from 720215577. Your account balance is 0.00 KSH, expiry date is 21-02-2015
*/
/*
 * "[A-Z0-9]{9}\\sConfirmed. Ksh\\d?,?\\d+\\ssent\\sto\\s[A-Z]+\\s[A-Z]+\\s07\\d{8}\\son\\s\\d\\d/\\d\\d/1\\d\\sat\\s\\d+:\\d\\d\\sP*A*M\\sNew\\sM-PESA\\sbalance\\sis\\sKsh\\d+,*\\d+.\\d\\d.\\sSave\\s&\\sget\\sa\\sloan\\son\\sMshwari"
 *
 * "FY56QN342 Confirmed. Ksh4,500 sent to JOHN WANGOMBE 0716177982 on 10/11/14 "
* + " at 6:37 PM New M-PESA balance is Ksh2,624.00. Save & get a loan on Mshwari"
*
* "You\\s+have\\s+received\\s+\\d+,*\\d+.\\d\\d\\s+KSH\\s+from\\s+7\\d{8}.\\s*Your\\s+account\\s+balance\\s+is\\s+\\d+.\\d\\d\\s+KSH,\\sexpiry\\s+date\\s+is\\s+\\d+-\\d+-20\\d\\d"
*
* "You have received 300.00 KSH from 720215577. Your account balance is 30000.00 KSH, expiry date is 21-02-2015"
*
* FP78IH507 Confirmed. You have received Ksh2,000.00 fromWINFRED KAMAU 254703362382on 6/9/14 at 4:06 PMNew M-PESA balance is Ksh2,005.00.PIN YAKO SIRI YAKO
*
* "[A-Z0-9]{9}\\sConfirmed. You have received Ksh\\d+,*\\d*.\\d\\d\\sfrom\\s*[A-Z]+\\s* [A-Z]*\\s*2547\\d{8}\\s*on"
*	+ " \\d{1,2}/\\d{1,2}/1\\d\\sat\\s\\d{1,2}:\\d\\d\\sP*M*M\\s*New M-PESA balance is Ksh\\d+,*\\d*.\\d\\d.\\s*PIN YAKO SIRI YAKO"
*
* "Failed. Not enough money in your M-PESA account to send Ksh10.00. You must be able to pay the transaction"
* +"fee as well as the requested amount. Your M-PESA balance is Ksh0.00"
*
* "Failed. Not enough money in your M-PESA account to send Ksh\\d+,*\\d*.\\d\\d. You must be able to pay the transaction fee as well as the requested
*  amount. Your M-PESA balance is Ksh\\d+,*\\d*.\\d\\d";
*
*/

public class MpesaExtracts extends extracts{
    public String confirmationcode;
    public String fullnames;
    public static Float balance;

    public MpesaExtracts(String message){
        super(message);
        confirmationcode = message.split(" ")[0];//in a hurry please implement this
        fullnames = "JOHN WANGOMBE";//implement this
        balance = (float)2624.0; //implement this
    }


}
