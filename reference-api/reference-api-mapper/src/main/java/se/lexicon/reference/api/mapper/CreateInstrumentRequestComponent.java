package se.lexicon.reference.api.mapper;

import com.so4it.common.util.Mapper;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;

import java.util.Currency;

/**
 * Created by Robert on 2019-08-26.
 */
public class CreateInstrumentRequestComponent {

    public static CreateInstrumentRequest map(se.lexicon.reference.CreateInstrumentRequest createInstrumentRequest) {
        return Mapper.of(createInstrumentRequest, CreateInstrumentRequest::builder)
                .map(se.lexicon.reference.CreateInstrumentRequest::getName, CreateInstrumentRequest.Builder::withName)
                .map(se.lexicon.reference.CreateInstrumentRequest::getCurrency, (t, v) -> t.withCurrency(Currency.getInstance(v)))
                .build(CreateInstrumentRequest.Builder::build);
    }
}
