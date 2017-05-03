package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.DateToEpochConverter;

public class UtcDateToEpochConverter extends DateToEpochConverter {
    public UtcDateToEpochConverter() {
        super(System.getProperty("dateTimeFormat"), UTC_ZONENAME);
    }
}
