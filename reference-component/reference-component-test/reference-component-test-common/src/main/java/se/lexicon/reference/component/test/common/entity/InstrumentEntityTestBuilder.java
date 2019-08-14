package se.lexicon.reference.component.test.common.entity;

import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.entity.InstrumentEntity;

import java.util.Currency;

public class InstrumentEntityTestBuilder extends AbstractTestBuilder<InstrumentEntity> {


    private InstrumentEntity.Builder builder;

    public InstrumentEntityTestBuilder(InstrumentEntity.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder
                .withName("Name")
                .withCurrency(Currency.getInstance("SEK"));
    }

    public static InstrumentEntityTestBuilder builder() {
        return new InstrumentEntityTestBuilder(InstrumentEntity.builder());
    }

    @Override
    public InstrumentEntity build() {
        return builder.build();
    }
}