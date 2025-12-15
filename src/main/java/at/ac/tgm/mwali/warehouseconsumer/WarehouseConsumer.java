package at.ac.tgm.mwali.warehouseconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class WarehouseConsumer {

    @KafkaListener(topics = "quickstart-events")
    public void receive(String content) {
        System.out.println( "Read from Message Queue: " + content);
    }

}