package at.ac.tgm.mwali.warehouseconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics = "quickstart-events")
    public void processMessage(String content) {
        System.out.println( "Read from Message Queue: " + content);
    }

}