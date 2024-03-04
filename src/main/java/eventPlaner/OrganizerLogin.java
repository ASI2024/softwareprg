package eventPlaner;

import java.util.ArrayList;
import java.util.List;

public class OrganizerLogin {

   public List<Organizer>Organizers = new ArrayList<>();
   public  boolean RegistrationFlag;


   public void Registration(String email,String password ,String username ,String city ,String phoneNumber,String status){

       Organizer organizer = new Organizer(email, password, username, city, phoneNumber, status);
       RegistrationFlag = Organizers.add(organizer);

   }

   public boolean Login(String email,String password){

       for(Organizer organizer : Organizers){

           if(organizer.getEmail().equals(email)&&organizer.getPassword().equals(password)) {
               return true;
           }
       }
     return false;
   }

}
