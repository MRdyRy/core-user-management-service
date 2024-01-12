package com.rudy.ryanto.core.management.util;

import java.util.UUID;

public class SequenceGenerator {

    public static Long generateId(){
        return UUID.randomUUID().hashCode() & Long.MAX_VALUE;
    }
}
