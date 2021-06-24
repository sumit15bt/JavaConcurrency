/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 *
 * @author sumit
 */
public class AppCallable implements Callable{

    @Override
    public Object call() throws Exception {
         Random generator = new Random();
  
        Integer randomNumber = generator.nextInt(1000);
        return randomNumber;
    }
    
}
