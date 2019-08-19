package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Broadcast;
import com.so4it.gs.rpc.DefaultRemoteResultReducer;
import com.so4it.gs.rpc.Routing;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.domain.Instruments;

import java.math.BigDecimal;

public interface
InstrumentService {
    String DEFAULT_BEAN_NAME = "instrumentService";

    // Instrument createInstrument(@Routing("getId")Instrument instrument);
    Instrument createInstrument(@Routing("getName") Instrument instrument);

    Instrument getInstrument(@Routing String name);

    @Broadcast (reducer = InstrumentsRemoteResultReducer.class)
    Instruments getAllInstruments();
}