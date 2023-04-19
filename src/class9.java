import java.util.List;

public class class9 implements class356 {

    static List field21;

    public static final class9 field30 = new class9(0, "POST", true, true);

    public static final class9 field24 = new class9(1, "GET", true, false);

    static final class9 field22 = new class9(2, "PUT", false, true);

    static final class9 field23 = new class9(3, "PATCH", false, true);

    static final class9 field31 = new class9(4, "DELETE", false, true);

    static int field29;

    static int field28;

    int field20;

    String field25;

    boolean field26;

    boolean field27;

    class9(int var1, String var2, boolean var3, boolean var4) {
        this.field20 = var1;
        this.field25 = var2;
        this.field26 = var3;
        this.field27 = var4;
    }

    public int rsOrdinal() {
        return this.field20;
    }

    boolean method33() {
        return this.field26;
    }

    public String method30() {
        return this.field25;
    }

    boolean method31() {
        return this.field27;
    }
}
