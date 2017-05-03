package nx.domain.tcc.converters.ipaddr;

import java.net.InetAddress;
import java.net.UnknownHostException;

import nx.domain.tcc.AbstractConverter;

public class FqdnToIPv4Converter extends AbstractConverter {
    public FqdnToIPv4Converter() {
        super("FqdnToIPv4", "FQDN → IPv4 (DNS lookup)");
        this.shortHelp = "Perform DNS lookup to get an IPv4 address for FQDN.";
    }

    @Override
    public String convert(String source) {
        try {
            InetAddress resolved = InetAddress.getByName(source);
            return resolved.getHostAddress();
        } catch (UnknownHostException e) {
            return "Unknown Host";
        }
    }
}
