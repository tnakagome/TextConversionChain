package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.DateToMicrosecConverter;

public class LocalDateToMicrosecConverter extends DateToMicrosecConverter {
    public LocalDateToMicrosecConverter() {
        super(System.getProperty("microsecDateTimeFormat"), LOCAL_ZONENAME);
    }
}
