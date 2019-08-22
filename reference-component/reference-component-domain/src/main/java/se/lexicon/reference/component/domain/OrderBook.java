package se.lexicon.reference.component.domain;

import com.so4it.common.domain.DomainClass;
import com.so4it.common.util.object.Required;
import com.so4it.common.util.object.ValueObject;

@DomainClass
public class OrderBook extends ValueObject {


    private String id;
    private String instrumentId;

    private OrderBook() {
    }

    private OrderBook(Builder builder) {
        this.id = Required.notNull(builder.id, "id");
        this.instrumentId = Required.notNull(builder.instrumentId, "instrumentId");
    }

    public String getId() {
        return id;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{ id, instrumentId };
    }


    public static Builder builder() {
        return new Builder();
    }
    //
    public static class Builder implements com.so4it.common.builder.Builder<OrderBook> {

        private String id;
        private String instrumentId;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withInstrumentId(String instrumentId) {
            this.instrumentId = instrumentId;
            return this;
        }

        @Override
        public OrderBook build() {
            return new OrderBook(this);
        }
    }
}