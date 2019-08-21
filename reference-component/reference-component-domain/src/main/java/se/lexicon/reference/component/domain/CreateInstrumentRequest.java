package se.lexicon.reference.component.domain;

import com.so4it.common.util.object.Required;
import com.so4it.common.util.object.ValueObject;

import java.util.Currency;

public class CreateInstrumentRequest extends ValueObject {


    private String name;
    private Currency currency;

    private CreateInstrumentRequest() {
    }

    private CreateInstrumentRequest(Builder builder) {
        this.name = Required.notNull(builder.name, "name");
        this.currency = Required.notNull(builder.currency, "currency");
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[] { name, currency };
    }


    public static Builder builder() {
        return new Builder();
    }
    //
    public static class Builder implements com.so4it.common.builder.Builder<CreateInstrumentRequest> {

        private String name;
        private Currency currency;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        @Override
        public CreateInstrumentRequest build() {
            return new CreateInstrumentRequest(this);
        }
    }
}