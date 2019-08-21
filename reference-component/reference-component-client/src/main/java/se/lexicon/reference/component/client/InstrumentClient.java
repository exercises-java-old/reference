package se.lexicon.reference.component.client;

import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;

public interface InstrumentClient {

    void createInstrument(CreateInstrumentRequest createInstrumentRequest);

    Instrument getInstrument(String instrumentName);
}

