package it.bstz.kafkapoc;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kafka.InjectKafkaCompanion;
import io.quarkus.test.kafka.KafkaCompanionResource;
import io.smallrye.reactive.messaging.kafka.companion.ConsumerTask;
import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@QuarkusTest
@QuarkusTestResource(KafkaCompanionResource.class)
public class MessageConsumerTest
{
   @InjectKafkaCompanion KafkaCompanion kafkaCompanion;

   @Test
   public void consume() throws InterruptedException
   {
      User user = new User();
      user.username = "basteez";
      user.firstName = "Tiziano";
      user.lastName = "Basile";
      user.lastAccess = ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS);

      // Produce a message with the companion
      kafkaCompanion
               .produceWithSerializers(UserSerializer.class)
               .fromRecords(new ProducerRecord<>("topic1", user));

      ConsumerTask<Object, Object> consumer = kafkaCompanion
               .consumeWithDeserializers(UserDeserializer.class)
               .withGroupId("test")
               .withAutoCommit()
               .fromTopics("topic1", 1)
               .awaitCompletion();
   }
}
