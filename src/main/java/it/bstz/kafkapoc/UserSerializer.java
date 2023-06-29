package it.bstz.kafkapoc;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;
import io.quarkus.logging.Log;

import static com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

public class UserSerializer extends ObjectMapperSerializer<User> {
   public UserSerializer() {
      super(new ObjectMapper().findAndRegisterModules()
              .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
              .disable(WRITE_DATES_AS_TIMESTAMPS, FAIL_ON_EMPTY_BEANS));
   }

   @Override
   public byte[] serialize(String topic, User data) {
      Log.info("=====UserSerializer SERIALIZING=====");
      Log.info("=====TOPIC: " + topic + "=====");
      Log.info("=====USER: " + data + "=====");
      byte[] serialized = super.serialize(topic, data);
      Log.info("=====UserSerializer OBJECT SERIALIZED=====");
      Log.info(serialized);
      return serialized;
   }
}
