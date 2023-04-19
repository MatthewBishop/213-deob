public enum class123 implements class356 {

    field1207(0, 0),

    field1200(1, 1),

    field1202(2, 2),

    field1203(3, 3),

    field1204(4, 4);

    static int field1209;

    static SpritePixels leftTitleSprite;

    static class170 mouseWheel;

    final int field1206;

    final int field1205;

    class123(int var3, int var4) {
        this.field1206 = var3;
        this.field1205 = var4;
    }

    public int rsOrdinal() {
        return this.field1205;
    }

    static void sortWorlds(World[] var0, int var1, int var2, int[] var3, int[] var4) {
        if (var1 < var2) {
            int var5 = var1 - 1;
            int var6 = var2 + 1;
            int var7 = (var2 + var1) / 2;
            World var8 = var0[var7];
            var0[var7] = var0[var1];
            var0[var1] = var8;

            while (var5 < var6) {
                boolean var9 = true;

                int var10;
                int var11;
                int var12;
                do {
                    --var6;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var6].index;
                            var12 = var8.index;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var6].population;
                            var12 = var8.population;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var6].isMembersOnly() ? 1 : 0;
                            var12 = var8.isMembersOnly() ? 1 : 0;
                        } else {
                            var11 = var0[var6].id;
                            var12 = var8.id;
                        }

                        if (var12 != var11) {
                            if ((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                var9 = true;

                do {
                    ++var5;

                    for (var10 = 0; var10 < 4; ++var10) {
                        if (var3[var10] == 2) {
                            var11 = var0[var5].index;
                            var12 = var8.index;
                        } else if (var3[var10] == 1) {
                            var11 = var0[var5].population;
                            var12 = var8.population;
                            if (var11 == -1 && var4[var10] == 1) {
                                var11 = 2001;
                            }

                            if (var12 == -1 && var4[var10] == 1) {
                                var12 = 2001;
                            }
                        } else if (var3[var10] == 3) {
                            var11 = var0[var5].isMembersOnly() ? 1 : 0;
                            var12 = var8.isMembersOnly() ? 1 : 0;
                        } else {
                            var11 = var0[var5].id;
                            var12 = var8.id;
                        }

                        if (var11 != var12) {
                            if ((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                                var9 = false;
                            }
                            break;
                        }

                        if (var10 == 3) {
                            var9 = false;
                        }
                    }
                } while (var9);

                if (var5 < var6) {
                    World var13 = var0[var5];
                    var0[var5] = var0[var6];
                    var0[var6] = var13;
                }
            }

            sortWorlds(var0, var1, var6, var3, var4);
            sortWorlds(var0, var6 + 1, var2, var3, var4);
        }

    }
}
