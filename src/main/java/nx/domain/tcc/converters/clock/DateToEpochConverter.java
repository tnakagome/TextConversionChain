package nx.domain.tcc.converters.clock;

import java.time.LocalDateTime;

public abstract class DateToEpochConverter extends EpochConverter {
    public DateToEpochConverter(final String dateTimeFormat, final String zoneName) {
        super("DateToEpoch" + zoneName, zoneName, zoneName + " date-time → unix clock", dateTimeFormat);
        this.shortHelp = "Convert " + zoneName + " date-time string into Unix epoch integer.";
    }

    @Override
    public String convert(String source) {
        try {
            LocalDateTime parsed = LocalDateTime.parse(source, dateFormat);
            return Long.toString(parsed.atZone(timezone).toEpochSecond());
        } catch (Exception e) {
        	System.out.format("DateToEpochConverter.convert(): conversion failed. %s\n", e.getMessage());
            return null;
        }
    }
}
