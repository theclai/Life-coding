package practice;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskScheduling {
    public static void main(String[] args) {
        taskSchedule();
    }

    public static void taskSchedule() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on: " + new Date() + "n" +
                        "Thread's name: " + Thread.currentThread().getName());
            }
        };
        Timer timer = new Timer("Timer");
        timer.schedule(task, 1000L);
    }
}
