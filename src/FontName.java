public class FontName {

    static int field3970;

    static int foundItemIndex;

    public static final FontName FontName_plain11 = new FontName("p11_full");

    public static final FontName FontName_plain12 = new FontName("p12_full");

    public static final FontName FontName_bold12 = new FontName("b12_full");

    public static final FontName FontName_verdana11 = new FontName("verdana_11pt_regular");

    public static final FontName FontName_verdana13 = new FontName("verdana_13pt_regular");

    public static final FontName FontName_verdana15 = new FontName("verdana_15pt_regular");

    static int[] regionMapArchiveIds;

    static int field3968;

    String name;

    FontName(String var1) {
        this.name = var1;
    }

    public static FontName[] method2388() {
        return new FontName[] { FontName_verdana11, FontName_plain12, FontName_verdana15, FontName_plain11,
                FontName_verdana13, FontName_bold12 };
    }
}
