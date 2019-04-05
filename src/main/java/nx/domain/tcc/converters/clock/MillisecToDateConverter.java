package nx.domain.tcc.converters.clock;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Convert Unix epoch with sub-second string into human readable format.<br>
 * 3 digits from the right will be treated as sub-second string, and
 * the remaining part will be interpreted as date time.
 */
public abstract class MillisecToDateConverter extends MillisecConverter {
    public MillisecToDateConverter(final String dateTimeFormat, final String zoneName) {
        super("MillisecToDate" + zoneName, zoneName, "unix clock (millisec) → " + zoneName + " date-time", dateTimeFormat);
        this.shortHelp = "Convert Unix epoch integer with millisecond into " + zoneName + " date-time string.";
    }

    @Override
    public String convert(final String source) {
        try {
            Instant       instant  = Instant.ofEpochMilli(Long.parseLong(source));
            LocalDateTime time     = LocalDateTime.ofInstant(instant, timezone);
            return millisecFormat.format(time);
        } catch (Exception e) {
        	System.out.format("MillisecToDateConverter.convert(): conversion failed. %s\n", e.getMessage());
            return null;
        }
    }
}
