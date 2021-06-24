/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrency;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author sumit
 */
public class TestRunnable {
     // runnable with lambda expesion...

    public static void main(String[] args) {
        Runnable runnable = () -> {

            try (BufferedReader reader = new BufferedReader(
                    new FileReader("/home/sumit/Documents/STUDY/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter2/02_03/begin/sample.txt"))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + " reading ..  => " + line);
                }
            } catch (Exception e) {
            }
        };
        
        Thread thread=new Thread(runnable); // new state
        thread.start(); // runnable state 
         // running state -> wait/sleep => block state -> terminated state
    }
}
