public class ParamComposition extends DualNode {

    static AbstractArchive ParamDefinition_archive;

    static EvictingDualNodeHashTable ParamDefinition_cached = new EvictingDualNodeHashTable(64);

    static SpritePixels rightTitleSprite;

    char type;

    public int defaultInt;

    public String defaultStr;

    boolean autoDisable = true;

    void postDecode() {
    }

    void decode(Buffer var1) {
        while (true) {
            int var2 = var1.readUnsignedByte();
            if (var2 == 0) {
                return;
            }

            this.decodeNext(var1, var2);
        }
    }

    void decodeNext(Buffer var1, int var2) {
        if (var2 == 1) {
            byte var4 = var1.readByte();
            int var5 = var4 & 255;
            if (var5 == 0) {
                throw new IllegalArgumentException("" + Integer.toString(var5, 16));
            }

            if (var5 >= 128 && var5 < 160) {
                char var6 = class369.cp1252AsciiExtension[var5 - 128];
                if (var6 == 0) {
                    var6 = '?';
                }

                var5 = var6;
            }

            char var3 = (char) var5;
            this.type = var3;
        } else if (var2 == 2) {
            this.defaultInt = var1.readInt();
        } else if (var2 == 4) {
            this.autoDisable = false;
        } else if (var2 == 5) {
            this.defaultStr = var1.readStringCp1252NullTerminated();
        }

    }

    public boolean isString() {
        return this.type == 's';
    }

    public static boolean method1060(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2,
            MidiPcmStream var3) {
        class297.musicPatchesArchive = var0;
        class297.musicSamplesArchive = var1;
        class297.soundEffectsArchive = var2;
        class475.midiPcmStream = var3;
        return true;
    }

    static void method1062(class125 var0, float var1, float var2, float var3, float var4, float var5, float var6,
            float var7, float var8) {
        if (var0 != null) {
            float var9 = var4 - var1;
            if (0.0D != (double) var9) {
                float var10 = var2 - var1;
                float var11 = var3 - var1;
                float[] var12 = new float[] { var10 / var9, var11 / var9 };
                var0.field1217 = var12[0] == 0.33333334F && 0.6666667F == var12[1];
                float var13 = var12[0];
                float var14 = var12[1];
                if ((double) var12[0] < 0.0D) {
                    var12[0] = 0.0F;
                }

                if ((double) var12[1] > 1.0D) {
                    var12[1] = 1.0F;
                }

                float var15;
                if ((double) var12[0] > 1.0D || var12[1] < -1.0F) {
                    var12[1] = 1.0F - var12[1];
                    if (var12[0] < 0.0F) {
                        var12[0] = 0.0F;
                    }

                    if (var12[1] < 0.0F) {
                        var12[1] = 0.0F;
                    }

                    if (var12[0] > 1.0F || var12[1] > 1.0F) {
                        var15 = (float) (1.0D + (double) var12[1] * ((double) var12[1] - 2.0D)
                                + (double) ((var12[0] - 2.0F + var12[1]) * var12[0]));
                        if (class121.field1180 + var15 > 0.0F) {
                            UrlRequester.method670(var12);
                        }
                    }

                    var12[1] = 1.0F - var12[1];
                }

                if (var13 != var12[0]) {
                    float var10000 = var1 + var9 * var12[0];
                    if ((double) var13 != 0.0D) {
                        var6 = var5 + var12[0] * (var6 - var5) / var13;
                    }
                }

                if (var12[1] != var14) {
                    var3 = var9 * var12[1] + var1;
                    if ((double) var14 != 1.0D) {
                        var7 = (float) ((double) var8
                                - (double) (var8 - var7) * (1.0D - (double) var12[1]) / (1.0D - (double) var14));
                    }
                }

                var0.field1221 = var1;
                var0.field1229 = var4;
                class151.method874(0.0F, var12[0], var12[1], 1.0F, var0);
                var15 = var6 - var5;
                float var16 = var7 - var6;
                float var17 = var8 - var7;
                float var18 = var16 - var15;
                var0.field1230 = var17 - var16 - var18;
                var0.field1225 = var18 + var18 + var18;
                var0.field1228 = var15 + var15 + var15;
                var0.field1227 = var5;
            }
        }
    }
}
