package se.lexicon.reference.component.domain;

import com.so4it.common.domain.DomainClass;
import com.so4it.common.util.object.Required;
import com.so4it.common.util.object.ValueObject;

import java.util.Currency;

@DomainClass
public class Instrument extends ValueObject {


    private String id;
    private String name;
    private Currency currency;

    private Instrument() {
    }

    private Instrument(Builder builder) {
        this.id = Required.notNull(builder.id, "id");
        this.name = Required.notNull(builder.name, "name");
        this.currency = Required.notNull(builder.currency, "currency");
    }

    public Currency getCurrency() {
        return currency;
    }

      public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object[] getIdFields() {
        return new Object[]{id, name};
    }


    public static Builder builder() {
        return new Builder();
    }
    //
    public static class Builder implements com.so4it.common.builder.Builder<Instrument> {

        private String id;
        private String name;
        private Currency currency;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCurrency(Currency currency) {
            this.currency = currency;
            return this;
        }

        @Override
        public Instrument build() {
            return new Instrument(this);
        }
    }
}