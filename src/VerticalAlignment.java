public enum VerticalAlignment implements class356 {

    field1610(2, 0),

    VerticalAlignment_centered(1, 1),

    field1605(0, 2);

    public static Widget[][] Widget_interfaceComponents;

    public final int value;

    final int id;

    VerticalAlignment(int var3, int var4) {
        this.value = var3;
        this.id = var4;
    }

    public int rsOrdinal() {
        return this.id;
    }

    public static int hashString(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + class100.charToByteCp1252(var0.charAt(var3));
        }

        return var2;
    }

    static final void method1036(String var0) {
        UserComparator5.addGameMessage(30, "", var0);
    }
}
