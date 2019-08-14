package se.lexicon.reference.component.service;

import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.reference.component.dao.InstrumentDao;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.entity.InstrumentEntity;

import java.util.Currency;

@ServiceExport(InstrumentService.class)
public class InstrumentServiceImpl implements InstrumentService {


    private InstrumentDao instrumentDao;

    public InstrumentServiceImpl(InstrumentDao instrumentDao) {
        this.instrumentDao = Required.notNull(instrumentDao, "instrumentDao");
    }

    @Override
    public Instrument createInstrument(Instrument instrument) {
        InstrumentEntity instrumentEntity = InstrumentEntity.builder()
                .withName(instrument.getName()).build();
        instrumentEntity = instrumentDao.insert(instrumentEntity);
        return Instrument.builder()
                .withId(instrumentEntity.getId())
                .withName(instrumentEntity.getName())
                .withCurrency(instrumentEntity.getCurrency())
                .build();
    }

    @Override
    //  koden från Magnus tidigare skola - account
//    public Instrument getInstrument(String id) {
//        InstrumentEntity instrumentEntity = instrumentDao.read(id);
//        return Instrument.builder().withId(id).withName(instrumentEntity.getName()).withCurrency(instrumentEntity.getCurrency()).build();
//    }

    public Instrument getInstrument(String name) {
        InstrumentEntity instrumentEntity = instrumentDao.read(name);
        return Instrument.builder().withId(instrumentEntity.getId()).withName(name).withCurrency(instrumentEntity.getCurrency()).build();
    }
}