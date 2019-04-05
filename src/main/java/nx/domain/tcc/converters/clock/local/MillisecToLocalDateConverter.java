package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.MillisecToDateConverter;

public class MillisecToLocalDateConverter extends MillisecToDateConverter {
    public MillisecToLocalDateConverter() {
        super(System.getProperty("millisecDateTimeFormat"), LOCAL_ZONENAME);
    }
}
