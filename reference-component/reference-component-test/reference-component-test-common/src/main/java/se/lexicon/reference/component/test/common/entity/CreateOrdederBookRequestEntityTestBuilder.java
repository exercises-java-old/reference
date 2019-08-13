package se.lexicon.reference.component.test.common.entity;

import com.so4it.common.util.object.Required;
import com.so4it.test.domain.AbstractTestBuilder;
import se.lexicon.reference.component.entity.CreateOrderBookRequestEntity;

public class CreateOrdederBookRequestEntityTestBuilder extends AbstractTestBuilder<CreateOrderBookRequestEntity> {
    private CreateOrderBookRequestEntity.Builder builder;

    private CreateOrdederBookRequestEntityTestBuilder(CreateOrderBookRequestEntity.Builder builder) {
        this.builder = Required.notNull(builder, "builder");
        this.builder.withInstrumentId("20");
    }

    public static CreateOrdederBookRequestEntityTestBuilder builder() {
        return new CreateOrdederBookRequestEntityTestBuilder(CreateOrderBookRequestEntity.builder());
    }


    @Override
    public CreateOrderBookRequestEntity build() {
        return builder.build();
    }
}
