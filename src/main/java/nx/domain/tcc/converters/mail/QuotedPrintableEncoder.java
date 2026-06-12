package nx.domain.tcc.converters.mail;

import jakarta.mail.internet.MimeUtility;
import nx.domain.tcc.AbstractConverter;

public class QuotedPrintableEncoder extends AbstractConverter {

	public QuotedPrintableEncoder() {
		super("QuotedPrintableEncoder", "text → Quoted Printable (UTF-8)");
		this.shortHelp = "Encode text using Quoted Printable (UTF-8)";
	}

	@Override
	public String convert(String source) {
		try {
			return MimeUtility.encodeText(source, "UTF-8", "Q");
		}
		catch (Exception e) {
			return null;
		}
	}
}
