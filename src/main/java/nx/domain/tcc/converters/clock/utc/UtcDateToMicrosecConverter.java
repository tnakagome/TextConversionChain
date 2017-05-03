package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.DateToMicrosecConverter;

public class UtcDateToMicrosecConverter extends DateToMicrosecConverter {
    public UtcDateToMicrosecConverter() {
        super(System.getProperty("microsecDateTimeFormat"), UTC_ZONENAME);
    }
}
