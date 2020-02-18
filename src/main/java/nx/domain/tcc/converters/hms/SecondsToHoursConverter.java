package nx.domain.tcc.converters.hms;

import nx.domain.tcc.AbstractConverter;

public class SecondsToHoursConverter extends AbstractConverter {
	public SecondsToHoursConverter() {
        super("SecondsToHours", "Seconds → Hours:Minutes:Seconds");
        this.shortHelp = "Convert seconds to hours:minutes:seconds";
    }

	@Override
	public String convert(String source) {
		try {
			int original = Integer.valueOf(source);
			int hours    = original / 3600;
			int minutes  = (original - (hours * 3600)) / 60;
			int seconds  = (original - (hours * 3600 + minutes * 60));
			return String.format("%02d:%02d:%02d", hours, minutes, seconds);
		}
		catch (Exception e) {
			return null;
		}
	}
}
