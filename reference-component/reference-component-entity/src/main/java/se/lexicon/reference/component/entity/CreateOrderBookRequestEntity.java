package se.lexicon.reference.component.entity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;
import se.lexicon.reference.component.domain.CreateOrderBookRequest;
@SpaceClass
public class CreateOrderBookRequestEntity extends IdEntity<String> {

    private String instrumentId;

    private CreateOrderBookRequestEntity() {


    }

    private CreateOrderBookRequestEntity(Builder builder) {
        this.instrumentId = Required.notNull(builder.instrumentId, "instumentId", builder.isTemplate());

    }

    @Override
    public String getId() {
        return null;
    }
@SpaceRouting
@SpaceId
    public String getInstrumentId() {
        return instrumentId;
    }

    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }

    public static class Builder extends AbstractEntityBuilder<CreateOrderBookRequestEntity> {
        private String instrumentId;

        public Builder(boolean template) {
            super(template);
        }

        public CreateOrderBookRequestEntity.Builder withInstrumentId(String instrumentId) {
            this.instrumentId = instrumentId;
            return this;
        }

        @Override
        public CreateOrderBookRequestEntity build() {
            return new CreateOrderBookRequestEntity(this);
        }
    }


}
