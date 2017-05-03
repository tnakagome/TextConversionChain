package nx.domain.tcc.converters.clock.utc;

import nx.domain.tcc.converters.clock.EpochToDateConverter;

public class EpochToUtcDateConverter extends EpochToDateConverter {
    public EpochToUtcDateConverter() {
        super(System.getProperty("dateTimeFormat"), UTC_ZONENAME);
    }
}
