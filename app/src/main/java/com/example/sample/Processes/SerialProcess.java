package com.example.sample.Processes;

public class SerialProcess implements Runnable{

    private Thread thread;
    private boolean isRunning;

    public void start() {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (isRunning){

        }

    }
}
