public class class126 implements class356 {

    static WorldMap worldMap;

    static final class126 field1243 = new class126(0, 0, (String) null, 0);

    static final class126 field1240 = new class126(1, 1, (String) null, 9);

    static final class126 field1241 = new class126(2, 2, (String) null, 3);

    static final class126 field1246 = new class126(3, 3, (String) null, 6);

    static final class126 field1247 = new class126(4, 4, (String) null, 1);

    static final class126 field1244 = new class126(5, 5, (String) null, 3);

    static Archive archive12;

    static Archive archive15;

    final int field1245;

    final int field1250;

    final int field1242;

    class126(int var1, int var2, String var3, int var4) {
        this.field1245 = var1;
        this.field1250 = var2;
        this.field1242 = var4;
    }

    public int rsOrdinal() {
        return this.field1250;
    }

    int method755() {
        return this.field1242;
    }

    static int method754(int var0, Script var1, boolean var2) {
        if (var0 == 7463) {
            boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            GrandExchangeOfferOwnWorldComparator.method365(var3);
            return 1;
        } else {
            return 2;
        }
    }
}
