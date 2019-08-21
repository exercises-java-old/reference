package se.lexicon.reference.component.client;

import com.so4it.common.util.object.Required;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.service.InstrumentService;

public class InstrumentClientImpl implements InstrumentClient {

    private InstrumentService instrumentService;

    public InstrumentClientImpl(InstrumentService instrumentService) {
        this.instrumentService = Required.notNull(instrumentService,"instrumentService");
    }


    @Override
    public void createInstrument(CreateInstrumentRequest createInstrumentRequest) {
        instrumentService.createInstrument(createInstrumentRequest);
    }

    @Override
    public Instrument getInstrument(String instrumentName) {
        return instrumentService.getInstrument(instrumentName);
    }
}
