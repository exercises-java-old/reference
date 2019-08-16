package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Broadcast;
import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;

import java.util.List;

public interface OrderBookService {
    String DEFAULT_BEAN_NAME = "orderBookService";

    OrderBook createOrderBook(@Routing("getInstrumentId") CreateOrderBookRequest createOrderBookRequest);

    OrderBook getOrderbook(@Routing String InstrumentId);

    @Broadcast
    List<OrderBook> getAllOrderBooks();
}