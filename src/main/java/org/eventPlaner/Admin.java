package org.eventPlaner;

import java.util.HashMap;
import java.util.Map;

public class Admin {
private Map<String,String>admins=new HashMap<String,String>(){{
    put("admin1","123");
    put("admin2","456");

}};



    public boolean checkUserName(String userName) {

        return admins.containsKey(userName);
    }

    public boolean checkPassword(String userName, String password) {


        if (!admins.containsKey(userName)) {
            return false; // Username does not exist
        }
        String storedPassword = admins.get(userName);
        return storedPassword.equals(password);
    }
}
