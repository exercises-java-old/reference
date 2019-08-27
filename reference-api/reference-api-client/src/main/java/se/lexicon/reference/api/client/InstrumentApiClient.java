package se.lexicon.reference.api.client;


import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;

public interface InstrumentApiClient {

    String DEFAULT_API_BEAN_NAME = "referenceApiClient";


    void createInstrument(CreateInstrumentRequest createInstrumentRequest);

    Instrument getInstrument(String name);
}
