package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Broadcast;
import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.domain.OrderBooks;

public interface OrderBookService {
    String DEFAULT_BEAN_NAME = "orderBookService";

    OrderBook createOrderBook(@Routing("getInstrumentId") CreateOrderBookRequest createOrderBookRequest);

    OrderBook getOrderBook(@Routing String InstrumentId);

    @Broadcast(reducer = OrderBooksRemoteResultReducer.class)
    OrderBooks getAllOrderBooks();
}