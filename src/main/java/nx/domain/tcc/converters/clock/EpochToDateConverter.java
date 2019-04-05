package nx.domain.tcc.converters.clock;

import java.time.Instant;
import java.time.LocalDateTime;

public abstract class EpochToDateConverter extends EpochConverter {
    public EpochToDateConverter(final String dateTimeFormat, final String zoneName) {
        super("EpochToDate" + zoneName, zoneName, "unix clock → " + zoneName + " date-time", dateTimeFormat);
        this.shortHelp = "Convert Unix epoch integer into " + zoneName + " date-time string.";
    }

    @Override
    public String convert(final String source) {
        try {
            Long          parsed  = Long.parseLong(source);
            Instant       instant = Instant.ofEpochSecond(parsed);
            LocalDateTime time    = LocalDateTime.ofInstant(instant, timezone);
            return dateFormat.format(time);
        } catch (Exception e) {
        	System.out.format("EpochToDateConverter.convert(): conversion failed. %s\n", e.getMessage());
            return null;
        }
    }
}
