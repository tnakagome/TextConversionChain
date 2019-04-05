package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.DateToMillisecConverter;

public class LocalDateToMillisecConverter extends DateToMillisecConverter {
    public LocalDateToMillisecConverter() {
        super(System.getProperty("millisecDateTimeFormat"), LOCAL_ZONENAME);
    }
}
