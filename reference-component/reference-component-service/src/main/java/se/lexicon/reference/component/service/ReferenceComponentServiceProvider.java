package se.lexicon.reference.component.service;

import com.so4it.gs.rpc.Service;
import com.so4it.gs.rpc.ServiceBindingType;
import com.so4it.gs.rpc.ServiceProvider;

@ServiceProvider
public interface ReferenceComponentServiceProvider {

    @Service(value = ServiceBindingType.GS_REMOTING, name = OrderBookService.DEFAULT_BEAN_NAME)
    OrderBookService getOrderBookService();

    @Service(value = ServiceBindingType.GS_REMOTING, name = InstrumentService.DEFAULT_BEAN_NAME)
    InstrumentService getInstrumentService();
}