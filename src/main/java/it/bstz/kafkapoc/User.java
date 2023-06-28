package it.bstz.kafkapoc;

import java.time.ZonedDateTime;

public class User
{
   public String username;
   public String firstName;
   public String lastName;
   public ZonedDateTime lastAccess;

   @Override public String toString()
   {
      return "User{" +
               "username='" + username + '\'' +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", lastAccess=" + lastAccess +
               '}';
   }
}
