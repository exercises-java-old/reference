package se.lexicon.reference.component.test.common.domain;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;

import java.util.Currency;

public class CreateInstrumentRequestTestBuilder extends AbstractTestBuilder<CreateInstrumentRequest> {
    private CreateInstrumentRequest.Builder builder;
    public CreateInstrumentRequestTestBuilder(CreateInstrumentRequest.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder = builder.withName("name").withCurrency(Currency.getInstance("SEK"));
    }

    public static CreateInstrumentRequestTestBuilder builder() {
        return new CreateInstrumentRequestTestBuilder(CreateInstrumentRequest.builder());
    }

    @Override
    public CreateInstrumentRequest build() {
        return builder.build();
    }

}
