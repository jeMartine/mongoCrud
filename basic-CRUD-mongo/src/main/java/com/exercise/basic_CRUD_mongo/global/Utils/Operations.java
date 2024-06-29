package com.exercise.basic_CRUD_mongo.global.Utils;

public class Operations {
    public static String trimBrackets(String message){
        return message.replaceAll("[\\[\\]]", "");
    }
}
