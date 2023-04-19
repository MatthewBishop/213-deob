public class KitDefinition extends DualNode {

    static int field1519;

    static AbstractArchive KitDefinition_archive;

    static AbstractArchive KitDefinition_modelsArchive;

    public static int KitDefinition_fileCount;

    static EvictingDualNodeHashTable KitDefinition_cached = new EvictingDualNodeHashTable(64);

    static AbstractSocket js5Socket;

    static SpritePixels[] headIconHintSprites;

    public int bodypartID = -1;

    int[] models2;

    short[] recolorFrom;

    short[] recolorTo;

    short[] retextureFrom;

    short[] retextureTo;

    int[] models = new int[] { -1, -1, -1, -1, -1 };

    public boolean nonSelectable = false;

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
            this.bodypartID = var1.readUnsignedByte();
        } else {
            int var3;
            int var4;
            if (var2 == 2) {
                var3 = var1.readUnsignedByte();
                this.models2 = new int[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.models2[var4] = var1.readUnsignedShort();
                }
            } else if (var2 == 3) {
                this.nonSelectable = true;
            } else if (var2 == 40) {
                var3 = var1.readUnsignedByte();
                this.recolorFrom = new short[var3];
                this.recolorTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.recolorFrom[var4] = (short) var1.readUnsignedShort();
                    this.recolorTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 == 41) {
                var3 = var1.readUnsignedByte();
                this.retextureFrom = new short[var3];
                this.retextureTo = new short[var3];

                for (var4 = 0; var4 < var3; ++var4) {
                    this.retextureFrom[var4] = (short) var1.readUnsignedShort();
                    this.retextureTo[var4] = (short) var1.readUnsignedShort();
                }
            } else if (var2 >= 60 && var2 < 70) {
                this.models[var2 - 60] = var1.readUnsignedShort();
            }
        }

    }

    public boolean ready() {
        if (this.models2 == null) {
            return true;
        } else {
            boolean var1 = true;

            for (int var2 = 0; var2 < this.models2.length; ++var2) {
                if (!KitDefinition_modelsArchive.tryLoadFile(this.models2[var2], 0)) {
                    var1 = false;
                }
            }

            return var1;
        }
    }

    public ModelData getModelData() {
        if (this.models2 == null) {
            return null;
        } else {
            ModelData[] var1 = new ModelData[this.models2.length];

            for (int var2 = 0; var2 < this.models2.length; ++var2) {
                var1[var2] = ModelData.ModelData_get(KitDefinition_modelsArchive, this.models2[var2], 0);
            }

            ModelData var4;
            if (var1.length == 1) {
                var4 = var1[0];
            } else {
                var4 = new ModelData(var1, var1.length);
            }

            int var3;
            if (this.recolorFrom != null) {
                for (var3 = 0; var3 < this.recolorFrom.length; ++var3) {
                    var4.recolor(this.recolorFrom[var3], this.recolorTo[var3]);
                }
            }

            if (this.retextureFrom != null) {
                for (var3 = 0; var3 < this.retextureFrom.length; ++var3) {
                    var4.retexture(this.retextureFrom[var3], this.retextureTo[var3]);
                }
            }

            return var4;
        }
    }

    public boolean method997() {
        boolean var1 = true;

        for (int var2 = 0; var2 < 5; ++var2) {
            if (this.models[var2] != -1 && !KitDefinition_modelsArchive.tryLoadFile(this.models[var2], 0)) {
                var1 = false;
            }
        }

        return var1;
    }

    public ModelData getKitDefinitionModels() {
        ModelData[] var1 = new ModelData[5];
        int var2 = 0;

        for (int var3 = 0; var3 < 5; ++var3) {
            if (this.models[var3] != -1) {
                var1[var2++] = ModelData.ModelData_get(KitDefinition_modelsArchive, this.models[var3], 0);
            }
        }

        ModelData var5 = new ModelData(var1, var2);
        int var4;
        if (this.recolorFrom != null) {
            for (var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                var5.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
            }
        }

        if (this.retextureFrom != null) {
            for (var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                var5.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
            }
        }

        return var5;
    }

    static final boolean method1000(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
        int var5 = var0;
        int var6 = var1;
        byte var7 = 64;
        byte var8 = 64;
        int var9 = var0 - var7;
        int var10 = var1 - var8;
        class211.directions[var7][var8] = 99;
        class211.distances[var7][var8] = 0;
        byte var11 = 0;
        int var12 = 0;
        class211.bufferX[var11] = var0;
        int var20 = var11 + 1;
        class211.bufferY[var11] = var1;
        int[][] var13 = var4.flags;

        while (true) {
            label265: while (true) {
                int var14;
                int var15;
                int var16;
                int var17;
                int var18;
                int var19;
                do {
                    do {
                        do {
                            label242: do {
                                if (var20 == var12) {
                                    class18.field56 = var5;
                                    class397.field3691 = var6;
                                    return false;
                                }

                                var5 = class211.bufferX[var12];
                                var6 = class211.bufferY[var12];
                                var12 = var12 + 1 & 4095;
                                var18 = var5 - var9;
                                var19 = var6 - var10;
                                var14 = var5 - var4.xInset;
                                var15 = var6 - var4.yInset;
                                if (var3.hasArrived(var2, var5, var6, var4)) {
                                    class18.field56 = var5;
                                    class397.field3691 = var6;
                                    return true;
                                }

                                var16 = class211.distances[var18][var19] + 1;
                                if (var18 > 0 && class211.directions[var18 - 1][var19] == 0
                                        && (var13[var14 - 1][var15] & 19136782) == 0
                                        && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            class211.bufferX[var20] = var5 - 1;
                                            class211.bufferY[var20] = var6;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18 - 1][var19] = 2;
                                            class211.distances[var18 - 1][var19] = var16;
                                            break;
                                        }

                                        if ((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 < 128 - var2 && class211.directions[var18 + 1][var19] == 0
                                        && (var13[var14 + var2][var15] & 19136899) == 0
                                        && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            class211.bufferX[var20] = var5 + 1;
                                            class211.bufferY[var20] = var6;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18 + 1][var19] = 8;
                                            class211.distances[var18 + 1][var19] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var19 > 0 && class211.directions[var18][var19 - 1] == 0
                                        && (var13[var14][var15 - 1] & 19136782) == 0
                                        && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            class211.bufferX[var20] = var5;
                                            class211.bufferY[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18][var19 - 1] = 1;
                                            class211.distances[var18][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var19 < 128 - var2 && class211.directions[var18][var19 + 1] == 0
                                        && (var13[var14][var15 + var2] & 19136824) == 0
                                        && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2 - 1) {
                                            class211.bufferX[var20] = var5;
                                            class211.bufferY[var20] = var6 + 1;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18][var19 + 1] = 4;
                                            class211.distances[var18][var19 + 1] = var16;
                                            break;
                                        }

                                        if ((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 > 0 && var19 > 0 && class211.directions[var18 - 1][var19 - 1] == 0
                                        && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2) {
                                            class211.bufferX[var20] = var5 - 1;
                                            class211.bufferY[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18 - 1][var19 - 1] = 3;
                                            class211.distances[var18 - 1][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0
                                                || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 < 128 - var2 && var19 > 0 && class211.directions[var18 + 1][var19 - 1] == 0
                                        && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                                    var17 = 1;

                                    while (true) {
                                        if (var17 >= var2) {
                                            class211.bufferX[var20] = var5 + 1;
                                            class211.bufferY[var20] = var6 - 1;
                                            var20 = var20 + 1 & 4095;
                                            class211.directions[var18 + 1][var19 - 1] = 9;
                                            class211.distances[var18 + 1][var19 - 1] = var16;
                                            break;
                                        }

                                        if ((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0
                                                || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                            break;
                                        }

                                        ++var17;
                                    }
                                }

                                if (var18 > 0 && var19 < 128 - var2 && class211.directions[var18 - 1][var19 + 1] == 0
                                        && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                                    for (var17 = 1; var17 < var2; ++var17) {
                                        if ((var13[var14 - 1][var17 + var15] & 19136830) != 0
                                                || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                            continue label242;
                                        }
                                    }

                                    class211.bufferX[var20] = var5 - 1;
                                    class211.bufferY[var20] = var6 + 1;
                                    var20 = var20 + 1 & 4095;
                                    class211.directions[var18 - 1][var19 + 1] = 6;
                                    class211.distances[var18 - 1][var19 + 1] = var16;
                                }
                            } while (var18 >= 128 - var2);
                        } while (var19 >= 128 - var2);
                    } while (class211.directions[var18 + 1][var19 + 1] != 0);
                } while ((var13[var14 + var2][var15 + var2] & 19136992) != 0);

                for (var17 = 1; var17 < var2; ++var17) {
                    if ((var13[var14 + var17][var15 + var2] & 19137016) != 0
                            || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                        continue label265;
                    }
                }

                class211.bufferX[var20] = var5 + 1;
                class211.bufferY[var20] = var6 + 1;
                var20 = var20 + 1 & 4095;
                class211.directions[var18 + 1][var19 + 1] = 12;
                class211.distances[var18 + 1][var19 + 1] = var16;
            }
        }
    }

    public static String intToString(int var0, boolean var1) {
        if (var1 && var0 >= 0) {
            int var3 = var0;
            String var2;
            if (var1 && var0 >= 0) {
                int var4 = 2;

                for (int var5 = var0 / 10; var5 != 0; ++var4) {
                    var5 /= 10;
                }

                char[] var6 = new char[var4];
                var6[0] = '+';

                for (int var7 = var4 - 1; var7 > 0; --var7) {
                    int var8 = var3;
                    var3 /= 10;
                    int var9 = var8 - var3 * 10;
                    if (var9 >= 10) {
                        var6[var7] = (char) (var9 + 87);
                    } else {
                        var6[var7] = (char) (var9 + 48);
                    }
                }

                var2 = new String(var6);
            } else {
                var2 = Integer.toString(var0, 10);
            }

            return var2;
        } else {
            return Integer.toString(var0);
        }
    }

    static final boolean method994(byte[] var0, int var1, int var2) {
        boolean var3 = true;
        Buffer var4 = new Buffer(var0);
        int var5 = -1;

        label57: while (true) {
            int var6 = var4.method2529();
            if (var6 == 0) {
                return var3;
            }

            var5 += var6;
            int var7 = 0;
            boolean var8 = false;

            while (true) {
                int var9;
                while (!var8) {
                    var9 = var4.readUShortSmart();
                    if (var9 == 0) {
                        continue label57;
                    }

                    var7 += var9 - 1;
                    int var10 = var7 & 63;
                    int var11 = var7 >> 6 & 63;
                    int var12 = var4.readUnsignedByte() >> 2;
                    int var13 = var11 + var1;
                    int var14 = var10 + var2;
                    if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                        ObjectComposition var15 = class144.getObjectDefinition(var5);
                        if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1
                                || var15.boolean2) {
                            if (!var15.needsModelFiles()) {
                                ++Client.field425;
                                var3 = false;
                            }

                            var8 = true;
                        }
                    }
                }

                var9 = var4.readUShortSmart();
                if (var9 == 0) {
                    break;
                }

                var4.readUnsignedByte();
            }
        }
    }
}
