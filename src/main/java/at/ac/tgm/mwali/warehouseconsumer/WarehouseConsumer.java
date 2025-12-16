package at.ac.tgm.mwali.warehouseconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import at.ac.tgm.mwali.shared.WarehouseData;

import java.util.*;
@Component
public class WarehouseConsumer {

    private static final Logger log = LoggerFactory.getLogger(WarehouseConsumer.class);
    private final List<WarehouseData> warehouses = new ArrayList<>();
    private final KafkaTemplate<String, WarehouseData> feedback;

    public WarehouseConsumer(KafkaTemplate<String, WarehouseData> feedback) {
        this.feedback = feedback;
    }

    @KafkaListener(topics = {"warehouse-001", "warehouse-002", "warehouse-003"})
    public void receive(WarehouseData warehouse) {
        warehouses.add(warehouse);

        log.info("ZENTRALE received Warehouse: {}", warehouse.getWarehouseID());

        //feedback.send("warehouse-feedback", warehouse.getWarehouseID(), warehouse);
        log.info("ZENTRALE feedback sent for {}", warehouse.getWarehouseID());
    }

    public List<WarehouseData> getAllWarehouses() {
        return warehouses;
    }
}
