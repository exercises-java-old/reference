package se.lexicon.reference.component.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.so4it.common.domain.AbstractIterable;
import com.so4it.common.domain.AbstractIterableDeserializer;
import com.so4it.common.domain.AbstractIterableSerializer;
import com.so4it.common.domain.DomainClass;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

@DomainClass
@JsonDeserialize(
        using = Instruments.Deserializer.class
)
@JsonSerialize(
        using = Instruments.Serializer.class
)
public class Instruments extends AbstractIterable<Instrument> {


    private static final long serialVersionUID = 1L;

    public Instruments() {
        super(Instrument.class, Instruments.class);
    }

    public static Instruments valueOf(Instrument... endpointRegistrations) {
        return (Instruments) AbstractIterable.valueOf(endpointRegistrations, Instrument.class, Instruments.class);
    }

    public static Instruments valueOf(Set<Instrument> endpointRegistrations) {
        return (Instruments) AbstractIterable.valueOf(endpointRegistrations, Instrument.class, Instruments.class);
    }

    public static Instruments valueOf(Iterable<Instrument> endpointRegistrations) {
        return (Instruments) AbstractIterable.valueOf(endpointRegistrations, Instrument.class, Instruments.class);
    }

    public Map<String, Instruments> map(Function<Instrument, String> mapper) {
        return null;
    }

    public static class Serializer extends AbstractIterableSerializer<Instrument> {
        protected Serializer() {
            super(Instrument.class, Instruments.class);
        }
    }

    public static class Deserializer extends AbstractIterableDeserializer<Instrument> {
        protected Deserializer() {
            super(Instrument.class, Instruments.class);
        }
    }
}