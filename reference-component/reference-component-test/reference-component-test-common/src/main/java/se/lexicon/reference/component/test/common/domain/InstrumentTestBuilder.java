package se.lexicon.reference.component.test.common.domain;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.domain.Instrument;

public class InstrumentTestBuilder extends AbstractTestBuilder<Instrument> {


    private Instrument.Builder builder;

    private InstrumentTestBuilder(Instrument.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder = builder.withId("12345")
                .withName("test");
    }

    public static InstrumentTestBuilder builder() {
        return new InstrumentTestBuilder(Instrument.builder());
    }

    @Override
    public Instrument build() {
        return builder.build();
    }
}