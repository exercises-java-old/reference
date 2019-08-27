package se.lexicon.reference.api.mapper;

import com.so4it.common.util.Mapper;
import se.lexicon.reference.CreateInstrumentRequest;

/**
 * Created by Robert on 2019-08-27.
 */
public class CreateInstrumentRequestApi {

    public static CreateInstrumentRequest map(se.lexicon.reference.component.domain.CreateInstrumentRequest createInstrumentRequest) {
        return Mapper.of(createInstrumentRequest, () -> CreateInstrumentRequest.newBuilder())
                .map((source) -> source.getCurrency(), (builder, currency) -> builder.setCurrency(currency.getCurrencyCode()))
                .map((source) -> source.getName(), (builder, name) -> builder.setName(name))
                .build((builder) -> builder.build());
    }

}
