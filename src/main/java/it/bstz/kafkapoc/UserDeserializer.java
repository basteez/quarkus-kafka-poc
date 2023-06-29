package it.bstz.kafkapoc;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import io.quarkus.logging.Log;

public class UserDeserializer extends ObjectMapperDeserializer<User> {
   public UserDeserializer() {
      super(User.class);
   }

   @Override
   public User deserialize(String topic, byte[] data) {
      Log.info("=====UserDeserialize DESERIALIZING=====");
      Log.info("=====TOPIC: " + topic + "=====");
      Log.info("=====DATA: " + data + "=====");
      User u = super.deserialize(topic, data);
      Log.info("=====DESERIALIZED DATA: " + u + "=====");
      return u;

   }
}
