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
    private String name;

    private OrderBookEntity() {

    }

    private OrderBookEntity(Builder builder) {
        this.id = builder.id;
        this.name = Required.notNull(builder.name, "name");

    }

    @Override
    @SpaceId(autoGenerate =true)
    @SpaceRouting
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
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
