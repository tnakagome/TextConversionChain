package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.DateToEpochConverter;

public class LocalDateToEpochConverter extends DateToEpochConverter {
    public LocalDateToEpochConverter() {
        super(System.getProperty("dateTimeFormat"), LOCAL_ZONENAME);
    }
}
