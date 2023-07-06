package com.mashibing.dp.adapter.v2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Client {
    public static void main(String[] args) {
        new Phone().charging(new VoltageAdapter2());
    }
}
