package nx.domain.tcc.converters.clock;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import nx.domain.tcc.AbstractConverter;

public abstract class ClockConverter extends AbstractConverter {
    protected static final String UTC_ZONENAME   = "UTC";
    protected static final String LOCAL_ZONENAME = "Local";

    protected ZoneId            timezone;

    public ClockConverter(final String signature, final String zoneName, final String displayString) {
        super(signature, displayString);

        if (zoneName.equals(UTC_ZONENAME))
            this.timezone = ZoneOffset.UTC;
        else
            this.timezone = ZonedDateTime.now().getZone();
    }
}
