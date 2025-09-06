package com.conductor.shortenurl.util;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SchedulerTest {
    @Test
    public void testScheculer() {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(4);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println("delete from url_mapping where expire_time < now()");
        }, 11, 24, TimeUnit.HOURS);
        //С����
        // ���ڴ�����
    }
}
