package com.spark.possystem.util;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class IdGenerator {

    private final Random randomNum = new Random();

    private final String resource = "0123456789qwertyuioplkjhgfdsazxcvbnm";

    public String generateID(int length){
        StringBuilder simpleID = new StringBuilder();
        for(int i=0; i< length; i++){
            simpleID.append(resource.charAt(randomNum.nextInt(35)));
        }
        return simpleID.toString();
    }
}
