package nx.domain.tcc.converters.clock;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Convert Unix epoch with sub-second string into human readable format.<br>
 * 6 digits from the right will be treated as sub-second string, and
 * the remaining part will be interpreted as date time.
 */
public abstract class MicrosecToDateConverter extends MicrosecConverter {
    public MicrosecToDateConverter(final String dateTimeFormat, final String zoneName) {
        super("MicrosecToDate" + zoneName, zoneName, "unix clock (microsec) → " + zoneName + " date-time", dateTimeFormat);
        this.shortHelp = "Convert Unix epoch integer with microsecond into " + zoneName + " date-time string.";
    }

    @Override
    public String convert(final String source) {
        try {
            int length = source.length();
            if (length < 6) {
                String        microsec = source;
                Instant       instant  = Instant.ofEpochSecond(0, Long.parseLong(microsec));
                LocalDateTime time     = LocalDateTime.ofInstant(instant, timezone);
                return microsecFormat.format(time);
            }
            else {
                String        dateTime = source.substring(0, source.length() - 6);
                String        microsec = source.substring(source.length() - 6, source.length());
                Instant       instant  = Instant.ofEpochSecond(Long.parseLong(dateTime), Long.parseLong(microsec));
                LocalDateTime time     = LocalDateTime.ofInstant(instant, timezone);
                return microsecFormat.format(time);
            }
        } catch (Exception e) {
            return null;
        }
    }
}
