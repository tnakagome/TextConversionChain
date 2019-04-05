package nx.domain.tcc.converters.clock;

import java.time.LocalDateTime;

public class DateToMillisecConverter extends MillisecConverter {

    public DateToMillisecConverter(final String dateTimeFormat, final String zoneName) {
        super("DateToMillisec" + zoneName, zoneName, zoneName + " date-time (millisec) → unix clock", dateTimeFormat);
        this.shortHelp = "Convert " + zoneName + " date-time string with millisecond into Unix epoch integer.";
    }

    @Override
    public String convert(String source) {
        try {
            LocalDateTime parsed    = LocalDateTime.parse(source, millisecFormat);
            String        subsecond = String.format("%03d", parsed.getNano() / 1000000);
            return Long.toString(parsed.atZone(timezone).toEpochSecond()) + subsecond;
        } catch (Exception e) {
        	System.out.format("DateToMillisecConverter.convert(): conversion failed. %s\n", e.getMessage());
            return null;
        }
    }
}
