package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.MicrosecToDateConverter;

public class MicrosecToLocalDateConverter extends MicrosecToDateConverter {
    public MicrosecToLocalDateConverter() {
        super(System.getProperty("microsecDateTimeFormat"), LOCAL_ZONENAME);
    }
}
