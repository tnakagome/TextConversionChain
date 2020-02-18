package nx.domain.tcc.converters.hms;

import nx.domain.tcc.AbstractConverter;

public class SecondsToMinutesConverter extends AbstractConverter {
	public SecondsToMinutesConverter() {
        super("SecondsToMinuites", "Seconds → Minutes:Seconds");
        this.shortHelp = "Convert seconds to minutes:seconds";
	}

	@Override
	public String convert(String source) {
		try {
			int seconds = Integer.valueOf(source);
			return String.format("%02d:%02d", (seconds / 60), (seconds % 60));
		}
		catch (Exception e) {
			return null;
		}
	}
}
