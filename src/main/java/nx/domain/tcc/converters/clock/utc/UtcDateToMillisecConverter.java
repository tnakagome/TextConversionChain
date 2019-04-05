package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.DateToMillisecConverter;

public class UtcDateToMillisecConverter extends DateToMillisecConverter {
    public UtcDateToMillisecConverter() {
        super(System.getProperty("millisecDateTimeFormat"), UTC_ZONENAME);
    }
}
