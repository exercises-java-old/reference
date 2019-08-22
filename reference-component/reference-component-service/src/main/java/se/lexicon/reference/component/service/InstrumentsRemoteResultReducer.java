package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.RemoteResultReducer;
import com.so4it.gs.rpc.exception.ResultReducerException;
import com.so4it.gs.rpc.remoting.RemoteResult;
import se.lexicon.reference.component.domain.Instrument;
import se.lexicon.reference.component.domain.Instruments;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InstrumentsRemoteResultReducer implements RemoteResultReducer<Instruments> {


    @Override
    public Instruments reduce(List<RemoteResult<Instruments>> list) throws ResultReducerException {
        Set<Instrument> instrumentSet = new HashSet<>();
        list.forEach( rr -> instrumentSet.addAll( rr.getResult().asSet()));
        return Instruments.valueOf(instrumentSet);
    }
}