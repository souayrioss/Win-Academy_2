package com.win_academy;

import java.util.concurrent.atomic.AtomicInteger;

public class Sales {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id_sale ;
    private int num;

    public Sales(int num) {
        this.id_sale = count.incrementAndGet();
        this.num = num;
    }

    public int getId_sale() {
        return id_sale;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
