package com.tedy.Banking.Utils;

import java.time.Year;

public class AccountUtils {

    /**
     *  custom errror messages
     */
    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already has an account created";

    public static final String ACCOUNT_CREATION_SUCCESS = "002";

    public static final String ACCOUNT_CREATION_MESSAGE = "Congrats you account has successfully been created";

    public static final String STOCK_UPDATE_SUCCESS = "003";

    public static final String STOCK_UPDATE_MESSAGE = "Securities Table has been successfully update";


    public static String generateAccountNumber(){

    /**
     * 2-23 + randomSixDigits rand generated hash for account number.
     */
    Year currentYear = Year.now();

    int min = 1000000;
    int max = 9999999;

    int randNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);

    //convert the current and randomNumber to string, then concat the Year.

    String year = String.valueOf(currentYear);

    String randomNumber = String.valueOf(randNumber);

    StringBuilder accountNumber = new StringBuilder();

    return accountNumber.append(year).append(randomNumber).toString();

    };



}
