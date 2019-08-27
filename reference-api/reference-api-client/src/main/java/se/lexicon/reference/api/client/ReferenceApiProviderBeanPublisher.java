package se.lexicon.reference.api.client;

import com.so4it.api.AbstractApiClientProviderBeanPublisher;
import com.so4it.api.ApiFrameworkConfiguration;
import com.so4it.api.importer.ApiClientProviderDefinition;
import com.so4it.api.util.StatusRuntimeExceptionBeanProxy;
import com.so4it.common.bean.BeanContext;
import com.so4it.common.bean.BeanProxy;
import com.so4it.common.bean.BeanProxyInvocationHandler;
import com.so4it.ft.core.FaultTolerantBeanProxy;
import com.so4it.metric.springframework.MetricsTimerBeanProxy;
import com.so4it.request.core.RequestContextBeanProxy;
import io.grpc.ManagedChannel;
import se.lexicon.reference.ReferenceApiServiceGrpc;

public class ReferenceApiProviderBeanPublisher extends AbstractApiClientProviderBeanPublisher {

    @Override
    public void publish(ApiClientProviderDefinition apiClientProviderDefinition, BeanContext beanContext, ApiFrameworkConfiguration apiFrameworkConfiguration, ManagedChannel managedChannel) {
        ReferenceApiServiceGrpc.ReferenceApiServiceBlockingStub referenceService = ReferenceApiServiceGrpc.newBlockingStub(managedChannel);
        InstrumentApiClient instrumentApiClient = new InstrumentApiClientImpl(referenceService);
        InstrumentApiClient instrumentApiClientProxy = BeanProxyInvocationHandler.create(
                InstrumentApiClient.class,
                instrumentApiClient,
                createClientInterceptors(beanContext, instrumentApiClient));
        beanContext.register(InstrumentApiClient.DEFAULT_API_BEAN_NAME, instrumentApiClientProxy);


    }

    private static BeanProxy[] createClientInterceptors(BeanContext beanContext, Object target) {
        return new BeanProxy[]{
                StatusRuntimeExceptionBeanProxy.create(),
                MetricsTimerBeanProxy.create(target),
                FaultTolerantBeanProxy.create(target, beanContext),
                RequestContextBeanProxy.create()};
    }

}
