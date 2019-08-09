package se.lexicon.reference.component.entity;

import com.gigaspaces.annotation.pojo.SpaceId;
import com.so4it.common.util.object.Required;
import com.so4it.component.entity.AbstractEntityBuilder;
import com.so4it.component.entity.IdEntity;

public class OrderBookEntity extends IdEntity<String> {
    private String id;
    private String name;

    private OrderBookEntity() {

    }

    @Override
    @SpaceId(autoGenerate = false)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderBookEntity(Builder builder) {
        this.id = builder.id;
        this.name = Required.notNull(builder.name, "name");

    }


    public static Builder builder() {
        return new Builder(false);
    }

    public static Builder templateBuilder() {
        return new Builder(true);
    }

    public static class Builder extends AbstractEntityBuilder<OrderBookEntity> {
        private String id;
        private String name;

        public Builder(boolean template) {
            super(template);
        }

        public OrderBookEntity.Builder withId(String id) {
            this.id = id;
            return this;
        }

        public OrderBookEntity.Builder withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public OrderBookEntity build() {
            return new OrderBookEntity(this);
        }
    }


}
