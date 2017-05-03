package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.MicrosecToDateConverter;

public class MicrosecToUtcDateConverter extends MicrosecToDateConverter {
    public MicrosecToUtcDateConverter() {
        super(System.getProperty("microsecDateTimeFormat"), UTC_ZONENAME);
    }
}
