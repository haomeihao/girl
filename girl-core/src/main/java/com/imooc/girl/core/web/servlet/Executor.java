package com.imooc.girl.core.web.servlet;

import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by hmh on 2017/8/17.
 */
public class Executor implements Runnable {
    private AsyncContext ctx = null;

    public Executor(AsyncContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void run() {
        try {
            //等待十秒钟，以模拟业务方法的执行
            Thread.sleep(10000);

            PrintWriter out = ctx.getResponse().getWriter();
            out.println("业务处理完毕的时间：" + new Date() + ".");
            out.flush();
            System.out.println("业务处理完毕的时间：" + new Date() + ".");

            ctx.complete();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
