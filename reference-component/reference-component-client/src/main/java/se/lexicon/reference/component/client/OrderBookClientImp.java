package se.lexicon.reference.component.client;

import com.so4it.common.util.object.Required;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.service.OrderBookService;

public class OrderBookClientImp implements OrderBookClient {
   private OrderBookService orderBookService;

    public OrderBookClientImp(OrderBookService orderBookService) {
        this.orderBookService = Required.notNull(orderBookService,"orderBookService");
    }

    @Override
    public void createOrderBook(CreateOrderBookRequest createOrderBookRequest) {
        orderBookService.createOrderBook(createOrderBookRequest);

    }

    @Override
    public OrderBook getOrderBook(String instrumentId) {
        return orderBookService.getOrderbook(instrumentId);
    }
}
