package se.lexicon.reference.component.entity;

import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.so4it.annotation.Allowed;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;

@SpaceClass
public class OrderBookEntity extends IdEntity<String> {


    @Allowed(types = Allowed.Type.NULLABLE,value = "value can be nullable because its autogenerate")

    private String id;
    private String instrumentId;

    private OrderBookEntity() {
    }

    private OrderBookEntity(Builder builder) {
        this.id = builder.id;
        this.instrumentId = Required.notNull(builder.instrumentId, "instrumentId", builder.isTemplate());
    }

    @Override
    @SpaceId(autoGenerate =true)
    public String getId() {
        return id;
    }

    @SpaceRouting
    public String getInstrumentId() {
        return instrumentId;
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }


    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }
    //
    public static class Builder extends AbstractEntityBuilder<OrderBookEntity> {

        private String id;
        private String instrumentId;

        public Builder(boolean template) {
            super(template);
        }

        public OrderBookEntity.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public OrderBookEntity.Builder withInstrumentId(String instrumentId) {
            this.instrumentId = instrumentId;
            return this;
        }

        @Override
        public OrderBookEntity build() {
            return new OrderBookEntity(this);
        }
    }
}