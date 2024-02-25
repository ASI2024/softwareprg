package org.eventPlaner;
import java.util.ArrayList;
import java.util.List;
public class User {
    public static boolean loginFlag;

    public void login(String userName, String password) {
//        loginFlag = true;
        Admin admin = new Admin();
        NormalUser normalUser= new NormalUser();
        ServesProvider servesProvider=new ServesProvider();
        if(admin.checkUserName(userName)){
            if (admin.checkPassword(userName,password))
                loginFlag = true;
            else loginFlag = false;

        }
//        else if (normalUser.checkUserName(userName)) {
//            if (normalUser.checkPassword(password))
//                loginFlag = true;
//            else loginFlag = false;
//
//
//        }
//        else if(servesProvider.checkUserName(userName)){
//            if (servesProvider.checkPassword(password))
//                loginFlag = true;
//            else loginFlag = false;
//
//
//        }
       else loginFlag = false;
    }



}
