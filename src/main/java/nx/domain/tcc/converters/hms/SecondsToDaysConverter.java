package nx.domain.tcc.converters.hms;

import nx.domain.tcc.AbstractConverter;

public class SecondsToDaysConverter extends AbstractConverter {
	public SecondsToDaysConverter() {
        super("SecondsToDays", "Seconds → Days+Hours:Minutes:Seconds");
        this.shortHelp = "Convert seconds to days+hours:minutes:seconds";
	}

	@Override
	public String convert(String source) {
		try {
			int original = Integer.valueOf(source);
			int days     = original / 86400;
			int hours    = (original - (days * 86400)) / 3600;
			int minutes  = (original - (days * 86400 + hours * 3600)) / 60;
			int seconds  = (original - (days * 86400 + hours * 3600 + minutes * 60));
			return String.format("%d+%02d:%02d:%02d", days, hours, minutes, seconds);
		}
		catch (Exception e) {
			return null;
		}
	}
}
