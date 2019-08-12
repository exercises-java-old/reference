package se.lexicon.reference.component.service;


import com.so4it.gs.rpc.Component;
import com.so4it.gs.rpc.ServiceBindingType;

@Component(
        name = "checkout",
        serviceProviders = {
                ReferenceComponentServiceProvider.class,
        },
        defaultServiceType = ServiceBindingType.GS_REMOTING
)
public class ReferenceComponentDescriptor {

}
