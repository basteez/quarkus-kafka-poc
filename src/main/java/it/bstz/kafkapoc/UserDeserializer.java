package it.bstz.kafkapoc;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class UserDeserializer extends ObjectMapperDeserializer<User>
{
   public UserDeserializer()
   {
      super(User.class);
   }
}
