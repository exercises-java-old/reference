package se.lexicon.reference.component.service;

import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.reference.component.dao.InstrumentDao;
import se.lexicon.reference.component.domain.CreateInstrumentRequest;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.domain.Instruments;
import se.lexicon.reference.component.entity.InstrumentEntity;

import java.util.Objects;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@ServiceExport(InstrumentService.class)
public class InstrumentServiceImpl implements InstrumentService {


    private InstrumentDao instrumentDao;

    public InstrumentServiceImpl(InstrumentDao instrumentDao) {
        this.instrumentDao = Required.notNull(instrumentDao, "instrumentDao");
    }

    @Override
    public Instrument createInstrument(CreateInstrumentRequest createInstrumentRequest) {
        InstrumentEntity instrumentEntity = InstrumentEntity.builder()
                .withName(createInstrumentRequest
                        .getName())
                .withCurrency(createInstrumentRequest.getCurrency())
                .build();

        instrumentEntity = instrumentDao.insert(instrumentEntity);
        return Instrument.builder()
                .withId(instrumentEntity.getId())
                .withName(instrumentEntity.getName())
                .withCurrency(instrumentEntity.getCurrency())
                .build();
    }

    @Override
    public Instrument getInstrument(String name) {
        InstrumentEntity instrumentEntity = instrumentDao.readIfExists(InstrumentEntity
                .templateBuilder()
                .withName(name)
                .build());

        return Instrument.builder()
                .withId(instrumentEntity.getId())
                .withName(instrumentEntity.getName())
                .withCurrency(instrumentEntity.getCurrency())
                .build();
    }

    @Override
    public Instruments getAllInstruments() {
        Set<InstrumentEntity> entities = instrumentDao.readAll();
        return Instruments.valueOf(entities.stream().map( m -> Instrument.builder()
                .withName(m.getName())
                .withId(m.getId())
                .withCurrency(m.getCurrency())
                .build()).collect(Collectors.toSet()));
    }
}