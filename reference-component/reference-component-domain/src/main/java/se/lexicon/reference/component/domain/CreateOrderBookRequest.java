package se.lexicon.reference.component.domain;

import com.so4it.common.util.object.Required;
import com.so4it.common.util.object.ValueObject;

public class CreateOrderBookRequest extends ValueObject {


    private String instrumentId;

    private CreateOrderBookRequest() {
    }

    private CreateOrderBookRequest(Builder builder) {
        this.instrumentId = Required.notNull(builder.instrumentId, "instrumentId");
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[0];
    }


    public static Builder builder() {
        return new Builder();
    }
    //
    public static class Builder implements com.so4it.common.builder.Builder<CreateOrderBookRequest> {

        private String instrumentId;

        public Builder withInstrumentId(String instrumentId) {
            this.instrumentId = instrumentId;
            return this;
        }

        @Override
        public CreateOrderBookRequest build() {
            return new CreateOrderBookRequest(this);
        }
    }
}