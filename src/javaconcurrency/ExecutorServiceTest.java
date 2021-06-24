/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconcurrency;

import App.UserProcessorRunnable;
import Dao.UserDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author sumit
 */
/**
 * 1. ExecutorService also maintiains lifecycle of thread 2.also executes the
 * collection of Runnable/callable objects.
 */
public class ExecutorServiceTest {
    // /home/sumit/Documents/STUDY/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_04/begin/new_users.txt

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> userData = getUserFromFile("/home/sumit/Documents/STUDY/Ex_Files_Java_EE_Concurrency/Exercise Files/Chapter3/03_04/begin/new_users.txt");
        ExecutorService executorService = Executors.newCachedThreadPool();
        UserDao dao = new UserDao();
        for (String user : userData) {
            Future<Integer> future = executorService.submit(new UserProcessorRunnable(user, dao));
//            System.out.println("result of operation => " + future.get()); // block statement
        }
        executorService.shutdown();
        System.out.println(" done .....!");
    }

    public static List<String> getUserFromFile(String fileName) {
        List<String> userList = new ArrayList();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(fileName))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                userList.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return userList;
    }
    
    
}
