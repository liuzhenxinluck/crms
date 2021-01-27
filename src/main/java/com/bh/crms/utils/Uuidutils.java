package com.bh.crms.utils;

import java.util.UUID;

public class Uuidutils {
    public  static  String  UUid(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

}
