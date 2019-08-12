package se.lexicon.reference.component.service;

import com.so4it.common.util.object.Required;
import com.so4it.gs.rpc.ServiceExport;
import se.lexicon.reference.component.dao.InstrumentDao;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.entity.InstrumentEntity;

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
                .build();
    }

    @Override
    public Instrument getInstrument(String id) {
        InstrumentEntity instrumentEntity = instrumentDao.read(id);
        return Instrument.builder().withId(id).withName(instrumentEntity.getName()).build();
    }
}