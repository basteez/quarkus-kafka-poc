package it.bstz.kafkapoc;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConsumer
{

   @Incoming("kafkaeventsin")
   public void consume(User user)
   {
      Log.info("=========MESSAGECONSUMER CONSUMING EVENT=========");
      Log.info("=========HELLO FROM MESSAGE CONSUMER=========");
      Log.info(user.toString());
   }
}
