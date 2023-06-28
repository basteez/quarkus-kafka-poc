package it.bstz.kafkapoc;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.kafka.InjectKafkaCompanion;
import io.quarkus.test.kafka.KafkaCompanionResource;
import io.smallrye.reactive.messaging.kafka.companion.ConsumerTask;
import io.smallrye.reactive.messaging.kafka.companion.KafkaCompanion;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;

@QuarkusTest
@QuarkusTestResource(KafkaCompanionResource.class)
public class StringConsumerTest
{
   @InjectKafkaCompanion KafkaCompanion kafkaCompanion;

   @Test
   public void consume() throws InterruptedException
   {

      // Produce a message with the companion
      kafkaCompanion
               .produceStrings()
               .fromRecords(new ProducerRecord<>("topic2", "This is a message sent to kafka"));

      ConsumerTask<String, String> consumer = kafkaCompanion
               .consumeStrings()
               .withGroupId("test")
               .withAutoCommit()
               .fromTopics("topic2", 1)
               .awaitCompletion();
   }
}
