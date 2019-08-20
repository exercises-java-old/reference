package se.lexicon.reference.component.service;

import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.reference.component.dao.OrderBookDao;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.domain.OrderBooks;
import se.lexicon.reference.component.entity.OrderBookEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ServiceExport(OrderBookService.class)
public class OrderBookServiceImpl implements OrderBookService {
    private OrderBookDao orderBookDao;

    public OrderBookServiceImpl(OrderBookDao orderBookDao) {
        this.orderBookDao = Required.notNull(orderBookDao, "orderbookdao");
    }

    @Override
    public OrderBook createOrderBook(CreateOrderBookRequest createOrderBookRequest) {
        OrderBookEntity orderBookEntity = OrderBookEntity.builder()
                .withInstrumentId(createOrderBookRequest.getInstrumentId())
                .build();
        orderBookEntity = orderBookDao.insert(orderBookEntity);
        return OrderBook.builder()
                .withId(orderBookEntity.getId())
                .withInstrumentId(orderBookEntity.getInstrumentId())
                .build();

    }

    @Override
    public OrderBook getOrderbook(String instrumentId) {

        OrderBookEntity orderBookEntity = orderBookDao.readIfExists(OrderBookEntity.templateBuilder().withInstrumentId(instrumentId).build());
        return OrderBook.builder().withId(instrumentId).withInstrumentId(orderBookEntity.getInstrumentId()).build();
    }

    @Override
    public OrderBooks getAllOrderBooks() {
        Set<OrderBookEntity> entities=orderBookDao.readAll();
        return OrderBooks.valueOf(entities.stream().map(rr->OrderBook.builder()
                    .withId(rr.getId())
                    .withInstrumentId(rr.getInstrumentId()).build()).collect(Collectors.toSet()));
    }
}
