/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrency;

import App.AppThread;

/**
 *
 * @author sumit
 */
public class JavaConcurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("app started ..."); 
        
        AppThread appThread1=new AppThread();
        AppThread appThread2=new AppThread();
        AppThread appThread3=new AppThread();
        appThread1.start();
        appThread2.start();
        appThread3.start();
        
    }
    
}
