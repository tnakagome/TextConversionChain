package nx.domain.tcc.converters.clock;

import java.time.format.DateTimeFormatter;

public abstract class MillisecConverter extends ClockConverter {
    DateTimeFormatter millisecFormat = null;

    public MillisecConverter(final String signature, final String zoneName, final String displayString, final String millisecFormat) {
        super(signature, zoneName, displayString);
        this.millisecFormat = DateTimeFormatter.ofPattern(millisecFormat);
    }
}
