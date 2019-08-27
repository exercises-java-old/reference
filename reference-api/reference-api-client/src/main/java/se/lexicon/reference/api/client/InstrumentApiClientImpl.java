package se.lexicon.reference.api.client;

import com.so4it.metric.springframework.MetricsBean;
import se.lexicon.reference.*;
import se.lexicon.reference.api.mapper.CreateInstrumentRequestApi;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;

import java.util.Currency;

@MetricsBean(name = "instrumentApiClient")
public class InstrumentApiClientImpl implements InstrumentApiClient {

    private ReferenceApiServiceGrpc.ReferenceApiServiceBlockingStub instrumentApiService;

    public InstrumentApiClientImpl(ReferenceApiServiceGrpc.ReferenceApiServiceBlockingStub instrumentApiService) {
        this.instrumentApiService = instrumentApiService;
    }

/*    @Override
    public void createMarket() {


        marketService.createApplication()

    }*/

    @Override
    public void createInstrument(CreateInstrumentRequest createInstrumentRequest) {
        CreateInstrumentResponse response = instrumentApiService.createInstrument(CreateInstrumentRequestApi.map(createInstrumentRequest));
    }

    @Override
    public se.lexicon.reference.component.domain.Instrument getInstrument(String name) {
        GetInstrumentResponse response = instrumentApiService.getInstrument(GetInstrumentRequest.newBuilder().setName(name).build());
        return se.lexicon.reference.component.domain.Instrument.builder()
                .withId(response.getId())
                .withName(response.getName())
                .withCurrency(Currency.getInstance(response.getCurrency()))
                .build();
    }


}
