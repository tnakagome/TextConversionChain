package nx.domain.tcc.converters.clock;

import java.time.LocalDateTime;

public abstract class DateToMicrosecConverter extends MicrosecConverter {

    public DateToMicrosecConverter(final String dateTimeFormat, final String zoneName) {
        super("DateToMicrosec" + zoneName, zoneName, zoneName + " date-time (microsec) → unix clock", dateTimeFormat);
        this.shortHelp = "Convert " + zoneName + " date-time string with microsecond into Unix epoch integer.";
    }

    @Override
    public String convert(String source) {
        try {
            LocalDateTime parsed    = LocalDateTime.parse(source, microsecFormat);
            String        subsecond = String.format("%06d", parsed.getNano());
            return Long.toString(parsed.atZone(timezone).toEpochSecond()) + subsecond;
        } catch (Exception e) {
            return null;
        }
    }
}
