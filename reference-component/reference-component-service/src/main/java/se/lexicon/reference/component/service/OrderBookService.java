package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;

public interface OrderBookService {
    String DEFAULT_BEAN_NAME = "orderBookService";

    OrderBook createOrderBook(@Routing("getInstrumentId") CreateOrderBookRequest createOrderBookRequest);

    OrderBook getOrderbook(@Routing String InstrumentId);
}