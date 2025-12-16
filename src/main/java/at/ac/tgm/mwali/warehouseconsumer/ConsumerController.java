package at.ac.tgm.mwali.warehouseconsumer;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import at.ac.tgm.mwali.shared.WarehouseData;

import java.util.List;

@RestController
public class ConsumerController {
    private final WarehouseConsumer consumer;

    public ConsumerController(WarehouseConsumer consumer) {
        this.consumer = consumer;
    }
    @PostMapping(value = "/warehouses", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<WarehouseData> getWarehouses() {
        return consumer.getAllWarehouses();
    }
}
