package nx.domain.tcc.converters.clock;

import java.time.format.DateTimeFormatter;

public abstract class MicrosecConverter extends ClockConverter {
    DateTimeFormatter microsecFormat = null;

    public MicrosecConverter(final String signature, final String zoneName, final String displayString, final String microsecFormat) {
        super(signature, zoneName, displayString);
        this.microsecFormat = DateTimeFormatter.ofPattern(microsecFormat);
    }
}
