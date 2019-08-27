package se.lexicon.reference.api.client;

import com.so4it.api.ApiClientProvider;
import com.so4it.api.Reference;

@ApiClientProvider(value = Reference.NAME,
        specification = Reference.PATH,
        version = Reference.VERSION,
        beanPublisher = ReferenceApiProviderBeanPublisher.class)


public class ReferenceApiProvider {
}
