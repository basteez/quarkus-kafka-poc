package it.bstz.kafkapoc;

import io.quarkus.logging.Log;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StringConsumer
{

   @Incoming("stringchannel")
   public void consumeString(String s)
   {
      Log.info("=========STRINGCONSUMER CONSUMING EVENT=========");
      Log.info("=========HELLO FROM THE STRING CONSUMER=========");
      Log.info(s);
   }
}
