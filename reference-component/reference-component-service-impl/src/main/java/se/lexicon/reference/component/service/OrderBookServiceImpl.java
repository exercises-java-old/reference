package se.lexicon.reference.component.service;

import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.reference.component.dao.OrderBookDao;
import se.lexicon.reference.component.domain.OrderBook;
import se.lexicon.reference.component.entity.OrderBookEntity;

@ServiceExport(OrderBookService.class)
public class OrderBookServiceImpl implements OrderBookService {
    private OrderBookDao orderBookDao;

    public OrderBookServiceImpl(OrderBookDao orderBookDao) {
        this.orderBookDao = Required.notNull(orderBookDao, "orderbookdao");
    }

    @Override
    public OrderBook createOrderBook(OrderBook orderBook) {
        OrderBookEntity orderBookEntity = OrderBookEntity.builder()
                .withInstrumentId(orderBook.getInstrumentId()).build();
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


}
