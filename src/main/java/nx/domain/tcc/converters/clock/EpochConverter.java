package nx.domain.tcc.converters.clock;

import java.time.format.DateTimeFormatter;

public abstract class EpochConverter extends ClockConverter {
    protected DateTimeFormatter dateFormat;

    public EpochConverter(final String signature, final String zoneName, final String displayString, final String dateTimeFormat) {
        super(signature, zoneName, displayString);
        this.dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
    }
}
