package se.lexicon.reference.component.service;

        import com.so4it.gs.rpc.Routing;
        import se.lexicon.reference.component.domain.OrderBook;

public interface OrderBookService {
    String DEFAULT_BEAN_NAME = "orderBookService";

    OrderBook createOrderBook(@Routing("getId") OrderBook orderBook);

    OrderBook getOrderbook(@Routing String id);
    String getNameToId(@Routing String id);
}
