package nx.domain.tcc;

public enum Encoding {
    ISO_2022_JP("ISO-2022-JP"), EUC_JP("EUC-JP"), SJIS("SJIS"), UTF8("UTF-8");

    public final String name;

    Encoding(final String name) {
        this.name = name;
    }
}
