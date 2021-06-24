/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrency;

import App.AppCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * @author sumit
 */
public class TestCallable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // FutureTask is a concrete class that
        // implements both Runnable and Future  
        FutureTask[] randomNumberTasks = new FutureTask[5];
        for (int i = 0; i < 5; i++) {
            Callable callable = new AppCallable();
            // Create the FutureTask with Callable
            randomNumberTasks[i] = new FutureTask(callable);

            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }
        for (int i = 0; i < 5; i++)
    {
      System.out.println(randomNumberTasks[i].get());
  
    }
    }

}
