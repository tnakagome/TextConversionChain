package nx.domain.tcc.converters.mail;

import java.io.UnsupportedEncodingException;

import jakarta.mail.internet.MimeUtility;
import nx.domain.tcc.AbstractConverter;

public class QuotedPrintableDecoder extends AbstractConverter {

	public QuotedPrintableDecoder() {
		super("QuotedPrintableDecoder", "Quoted Printable  → text");
		this.shortHelp = "Decode Quoted Printable string to text";
	}

	@Override
	public String convert(String source) {
		try {
			return MimeUtility.decodeText(source);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
