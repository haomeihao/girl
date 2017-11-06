package com.imooc.girl.web.thread.communication;

/**
 * 线程通信
 * Created by hmh on 2017/10/10.
 */
public class MySignal {

    // 1、通过共享对象通信
    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess(){
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData){
        this.hasDataToProcess = hasData;
    }

    // 2、忙等待(Busy Wait)
    private MySignal sharedSignal = null;

    public void busyWait() {
        while (!sharedSignal.hasDataToProcess()) {

        }
    }

    // 3、wait(),notify()和notifyAll()

    // 4、丢失的信号（Missed Signals）

    // 5、假唤醒

    // 6、多个线程等待相同信号



}
