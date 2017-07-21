package com.adme.dry.utilities;

import java.util.HashMap;

/**
 * Created by Adme System on 7/9/2017.
 */
public class utils {

    private static int COMMUNICATION_TELEPHONE=1;
    private static int COMMUNICATION_EMAIL=2;
    private static String STR_COM_TEL="Telephone";
    private static String STR_COM_EMAIL="Email";
    public static HashMap  mapOfTypeCommunication(){
        HashMap typeOf=new HashMap();
        typeOf.put(COMMUNICATION_TELEPHONE,STR_COM_TEL);
        typeOf.put(COMMUNICATION_EMAIL,STR_COM_EMAIL);
        return typeOf;
    }
}
