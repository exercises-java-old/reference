package se.lexicon.reference.component.service;

        import com.so4it.gs.rpc.Routing;
        import se.lexicon.reference.component.domain.OrderBook;

public interface OrderBookService {
    String DEFAULT_BEAN_NAME = "orderBookService";

    OrderBook createOrderBook(@Routing("getInstrumentId") OrderBook orderBook);

    OrderBook getOrderbook(@Routing String InstrumentId);

}
