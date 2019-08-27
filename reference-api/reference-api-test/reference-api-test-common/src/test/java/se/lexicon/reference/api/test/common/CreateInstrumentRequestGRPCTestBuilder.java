package se.lexicon.reference.api.test.common;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.CreateInstrumentRequest;

/**
 * Created by Robert on 2019-08-26.
 */
public class CreateInstrumentRequestGRPCTestBuilder extends AbstractTestBuilder<CreateInstrumentRequest> {

    private CreateInstrumentRequest.Builder builder;

    public CreateInstrumentRequestGRPCTestBuilder(CreateInstrumentRequest.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder = builder
                .setCurrency("SEK")
                .setName("test");
    }

    public static CreateInstrumentRequestGRPCTestBuilder builder() {
        return new CreateInstrumentRequestGRPCTestBuilder(CreateInstrumentRequest.newBuilder());
    }

    @Override
    public CreateInstrumentRequest build() {
        return builder.build();
    }
}
