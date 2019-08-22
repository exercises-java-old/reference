package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Broadcast;
import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.domain.Instruments;

public interface InstrumentService {
    String DEFAULT_BEAN_NAME = "instrumentService";

    // Instrument createInstrument(@Routing("getId")Instrument instrument), we routing on name instead;
    Instrument createInstrument(@Routing("getName") CreateInstrumentRequest createInstrumentRequest);

    Instrument getInstrument(@Routing String name);

    @Broadcast (reducer = InstrumentsRemoteResultReducer.class)
    Instruments getAllInstruments();
}