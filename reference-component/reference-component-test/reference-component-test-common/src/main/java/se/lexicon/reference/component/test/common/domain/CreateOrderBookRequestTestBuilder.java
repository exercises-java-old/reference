package se.lexicon.reference.component.test.common.domain;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;

public class CreateOrderBookRequestTestBuilder extends AbstractTestBuilder<CreateOrderBookRequest> {
    private CreateOrderBookRequest.Builder builder;

    public CreateOrderBookRequestTestBuilder(CreateOrderBookRequest.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder = builder.withInstrument("12");
    }

    public static CreateOrderBookRequestTestBuilder builder() {
        return new CreateOrderBookRequestTestBuilder(CreateOrderBookRequest.builder());
    }

    @Override
    public CreateOrderBookRequest build() {
        return builder.build();
    }
}
