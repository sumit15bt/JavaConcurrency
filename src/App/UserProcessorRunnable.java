/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Dao.UserDao;
import beans.User;
import java.util.StringTokenizer;
import java.util.concurrent.Callable;

/**
 *
 * @author sumit
 */
public class UserProcessorRunnable implements Callable<Integer> {

    private String userRecord;
    private UserDao userDao;

    public UserProcessorRunnable(String userRecord, UserDao userDao) {
        this.userRecord = userRecord;
        this.userDao = userDao;
    }

    @Override
    public Integer call() throws Exception {
        int rows = 0;
        System.out.println(Thread.currentThread().getName() + " processing for " + userRecord);
        StringTokenizer stringTokenizer = new StringTokenizer(userRecord, ",");
        User user = null;
        while (stringTokenizer.hasMoreTokens()) {
            user = new User();
            user.setEmail(stringTokenizer.nextToken());
            user.setName(stringTokenizer.nextToken());
            user.setId(Integer.parseInt(stringTokenizer.nextToken()));
            rows = userDao.saveUser(user);
        }
        return rows;
    }

}
