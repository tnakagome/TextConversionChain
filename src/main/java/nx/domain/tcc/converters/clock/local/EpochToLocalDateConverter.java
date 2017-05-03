package nx.domain.tcc.converters.clock.local;

import nx.domain.tcc.converters.clock.EpochToDateConverter;

public class EpochToLocalDateConverter extends EpochToDateConverter {
    public EpochToLocalDateConverter() {
        super(System.getProperty("dateTimeFormat"), LOCAL_ZONENAME);
    }
}
