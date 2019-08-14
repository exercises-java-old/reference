package se.lexicon.reference.component.test.common.domain;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.domain.OrderBook;

public class OrderBookTestBuilder extends AbstractTestBuilder<OrderBook> {

    private OrderBook.Builder builder;

    private OrderBookTestBuilder(OrderBook.Builder builder) {
        this.builder = Required.notNull(builder,"builder");
        this.builder = builder.withId("12345")
                .withInstrumentId("test");
    }

    public static OrderBookTestBuilder builder() {
        return new OrderBookTestBuilder(OrderBook.builder());
    }

    @Override
    public OrderBook build() {
        return builder.build();
    }
}
