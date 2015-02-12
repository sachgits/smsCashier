package com.sach.gits.Calculations;

import com.sach.gits.Sms.MpesaExtracts;
import com.sach.gits.Sms.extracts;

/**
 * Created by sach on 2/9/2015.
 * all nessary processing of extracted messages from new received credo that needs to be mpesad to mpesa_to_credo, to betting games
 * peer-to-peer bettings to Bongapoints and others that will be invented soon
 * makes decision on whether to store incoming records or to send online handles delays in mpesa, airtelmoney
 */
public class calculate {
    public static float amountSpent;// profit from recieved credit
    public static float netprofit;//loss in sending cash
    public static float amountLostInSentMpesa;
    public static float totalCreditSold;
    public Float sendfee;
    public float customersendfee;
    
    public calculate(extracts Xtracts, float send_fee, float customer_send_fee){
        sendfee = send_fee;
        customersendfee = send_fee;
    }

    public Float credoToMpesaCalc(Float creditAmount,float percentage){
        Float amountToReturn = creditAmount - (creditAmount * percentage);
        amountSpent += amountToReturn; //minus mpesa sendfee e.g 25 for 100-2500 45 for 2500-5000
        amountLostInSentMpesa += 0; //replace zero with sendfee as amount lost
        netprofit += (creditAmount * percentage) - sendfee;// amount used to send
        return amountToReturn;
    }

    public Float mpesaToCredoCalc(Float mpesaAmount, float percentage){
        totalCreditSold = mpesaAmount + (mpesaAmount * percentage);
        netprofit -= (mpesaAmount * percentage) + customersendfee;
        return totalCreditSold;
    }

    public Float credo2MpesaProfit(){
        return null;
    }

}
