package se.lexicon.reference.component.client;

import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;

public interface OrderBookClient {


    void createOrderBook(CreateOrderBookRequest createOrderBookRequest);

    OrderBook getOrderBook(String instrumentId);
}