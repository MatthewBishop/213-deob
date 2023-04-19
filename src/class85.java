public enum class85 implements class356 {

    field872(0, -1),

    field878(1, 1),

    field877(2, 7),

    field871(3, 8),

    field874(4, 9);

    static Archive archive2;

    static Archive archive4;

    final int field873;

    final int field876;

    class85(int var3, int var4) {
        this.field873 = var3;
        this.field876 = var4;
    }

    public int rsOrdinal() {
        return this.field876;
    }

    public static void method500(AbstractArchive var0) {
        StructComposition.StructDefinition_archive = var0;
    }

    static final void method498(int var0, int var1) {
        if (Client.menuOptionsCount >= 2 || Client.isItemSelected != 0 || Client.isSpellSelected) {
            if (Client.showMouseOverText) {
                int var2 = DynamicObject.method461();
                String var3;
                if (Client.isItemSelected == 1 && Client.menuOptionsCount < 2) {
                    var3 = "Use" + " " + Client.field364 + " " + "->";
                } else if (Client.isSpellSelected && Client.menuOptionsCount < 2) {
                    var3 = Client.field530 + " " + Client.field522 + " " + "->";
                } else {
                    var3 = Friend.method2152(var2);
                }

                if (Client.menuOptionsCount > 2) {
                    var3 = var3 + class383.colorStartTag(16777215) + " " + '/' + " " + (Client.menuOptionsCount - 2)
                            + " more options";
                }

                class137.fontBold12.drawRandomAlphaAndSpacing(var3, var0 + 4, var1 + 15, 16777215, 0,
                        Client.cycle / 1000);
            }
        }
    }

    static void method499() {
        if (class132.field1277 != null) {
            Client.field648 = Client.cycle;
            class132.field1277.method1939();

            for (int var0 = 0; var0 < Client.players.length; ++var0) {
                if (Client.players[var0] != null) {
                    class132.field1277.method1936((Client.players[var0].x >> 7) + WorldMapData_0.baseX,
                            (Client.players[var0].y >> 7) + GameObject.baseY);
                }
            }
        }

    }
}
