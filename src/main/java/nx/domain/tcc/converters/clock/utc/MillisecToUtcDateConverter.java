package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.MillisecToDateConverter;

public class MillisecToUtcDateConverter extends MillisecToDateConverter {
    public MillisecToUtcDateConverter() {
        super(System.getProperty("millisecDateTimeFormat"), UTC_ZONENAME);
    }
}
