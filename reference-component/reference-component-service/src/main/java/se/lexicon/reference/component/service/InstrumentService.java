package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.Instrument;

public interface InstrumentService {
    String DEFAULT_BEAN_NAME = "instrumentService";

    Instrument createInstrument(@Routing("getId")Instrument instrument);

    Instrument getInstrument(@Routing String id);
}
