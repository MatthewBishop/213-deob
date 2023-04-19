import java.util.Arrays;

public class class207 implements class29 {

    char[] field1861 = new char[128];

    int[] field1864 = new int[128];

    public int[] field1856 = new int[128];

    public int pressedKeysCount = 0;

    int[] field1859 = new int[128];

    int field1860 = 0;

    int field1857 = 0;

    int field1869 = 0;

    int field1862 = 0;

    boolean[] field1863 = new boolean[112];

    boolean[] field1858 = new boolean[112];

    boolean[] field1865 = new boolean[112];

    public char field1866;

    public int field1867;

    public boolean vmethod3949(int var1) {
        this.method1149(var1);
        this.field1863[var1] = true;
        this.field1858[var1] = true;
        this.field1865[var1] = false;
        this.field1856[++this.pressedKeysCount - 1] = var1;
        return true;
    }

    public boolean vmethod3989(int var1) {
        this.field1863[var1] = false;
        this.field1858[var1] = false;
        this.field1865[var1] = true;
        this.field1859[++this.field1860 - 1] = var1;
        return true;
    }

    public boolean vmethod3951(char var1) {
        int var2 = this.field1869 + 1 & 127;
        if (var2 != this.field1857) {
            this.field1864[this.field1869] = -1;
            this.field1861[this.field1869] = var1;
            this.field1869 = var2;
        }

        return false;
    }

    public boolean vmethod3953(boolean var1) {
        return false;
    }

    void method1149(int var1) {
        int var2 = this.field1869 + 1 & 127;
        if (var2 != this.field1857) {
            this.field1864[this.field1869] = var1;
            this.field1861[this.field1869] = 0;
            this.field1869 = var2;
        }

    }

    public void method1151() {
        this.field1857 = this.field1862;
        this.field1862 = this.field1869;
        this.pressedKeysCount = 0;
        this.field1860 = 0;
        Arrays.fill(this.field1858, false);
        Arrays.fill(this.field1865, false);
    }

    public final boolean method1154() {
        if (this.field1862 == this.field1857) {
            return false;
        } else {
            this.field1867 = this.field1864[this.field1857];
            this.field1866 = this.field1861[this.field1857];
            this.field1857 = this.field1857 + 1 & 127;
            return true;
        }
    }

    public boolean method1153(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1858[var1] : false;
    }

    public boolean getKeyPressed(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1863[var1] : false;
    }

    public boolean method1159(int var1) {
        return var1 >= 0 && var1 < 112 ? this.field1865[var1] : false;
    }

    public int[] method1155() {
        int[] var1 = new int[this.pressedKeysCount];

        for (int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
            var1[var2] = this.field1856[var2];
        }

        return var1;
    }

    public int[] method1152() {
        int[] var1 = new int[this.field1860];

        for (int var2 = 0; var2 < this.field1860; ++var2) {
            var1[var2] = this.field1859[var2];
        }

        return var1;
    }

    static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6,
            CollisionMap var7) {
        if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0
                || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
            if (var0 < Tiles.Tiles_minPlane) {
                Tiles.Tiles_minPlane = var0;
            }

            ObjectComposition var8 = class144.getObjectDefinition(var3);
            int var9;
            int var10;
            if (var4 != 1 && var4 != 3) {
                var9 = var8.sizeX;
                var10 = var8.sizeY;
            } else {
                var9 = var8.sizeY;
                var10 = var8.sizeX;
            }

            int var11;
            int var12;
            if (var9 + var1 <= 104) {
                var11 = (var9 >> 1) + var1;
                var12 = (var9 + 1 >> 1) + var1;
            } else {
                var11 = var1;
                var12 = var1 + 1;
            }

            int var13;
            int var14;
            if (var10 + var2 <= 104) {
                var13 = (var10 >> 1) + var2;
                var14 = var2 + (var10 + 1 >> 1);
            } else {
                var13 = var2;
                var14 = var2 + 1;
            }

            int[][] var15 = Tiles.Tiles_heights[var0];
            int var16 = var15[var12][var14] + var15[var11][var14] + var15[var11][var13] + var15[var12][var13] >> 2;
            int var17 = (var1 << 7) + (var9 << 6);
            int var18 = (var2 << 7) + (var10 << 6);
            long var19 = FaceNormal.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
            int var21 = var5 + (var4 << 6);
            if (var8.int3 == 1) {
                var21 += 256;
            }

            if (var8.hasSound()) {
                GameEngine.method189(var0, var1, var2, var8, var4);
            }

            Object var22;
            if (var5 == 22) {
                if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
                    if (var8.animationId == -1 && var8.transforms == null) {
                        var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
                    } else {
                        var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3,
                                (Renderable) null);
                    }

                    var6.newFloorDecoration(var0, var1, var2, var16, (Renderable) var22, var19, var21);
                    if (var8.interactType == 1 && var7 != null) {
                        var7.setBlockedByFloorDec(var1, var2);
                    }

                }
            } else {
                int var31;
                if (var5 != 10 && var5 != 11) {
                    if (var5 >= 12) {
                        if (var8.animationId == -1 && var8.transforms == null) {
                            var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
                        } else {
                            var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId,
                                    var8.boolean3, (Renderable) null);
                        }

                        var6.method1288(var0, var1, var2, var16, 1, 1, (Renderable) var22, 0, var19, var21);
                        if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                            class161.field1407[var0][var1][var2] |= 2340;
                        }

                        if (var8.interactType != 0 && var7 != null) {
                            var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                        }

                    } else if (var5 == 0) {
                        if (var8.animationId == -1 && var8.transforms == null) {
                            var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
                        } else {
                            var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3,
                                    (Renderable) null);
                        }

                        var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var22, (Renderable) null,
                                Tiles.field820[var4], 0, var19, var21);
                        if (var4 == 0) {
                            if (var8.clipped) {
                                Tiles.field819[var0][var1][var2] = 50;
                                Tiles.field819[var0][var1][var2 + 1] = 50;
                            }

                            if (var8.modelClipped) {
                                class161.field1407[var0][var1][var2] |= 585;
                            }
                        } else if (var4 == 1) {
                            if (var8.clipped) {
                                Tiles.field819[var0][var1][var2 + 1] = 50;
                                Tiles.field819[var0][var1 + 1][var2 + 1] = 50;
                            }

                            if (var8.modelClipped) {
                                class161.field1407[var0][var1][var2 + 1] |= 1170;
                            }
                        } else if (var4 == 2) {
                            if (var8.clipped) {
                                Tiles.field819[var0][var1 + 1][var2] = 50;
                                Tiles.field819[var0][var1 + 1][var2 + 1] = 50;
                            }

                            if (var8.modelClipped) {
                                class161.field1407[var0][var1 + 1][var2] |= 585;
                            }
                        } else if (var4 == 3) {
                            if (var8.clipped) {
                                Tiles.field819[var0][var1][var2] = 50;
                                Tiles.field819[var0][var1 + 1][var2] = 50;
                            }

                            if (var8.modelClipped) {
                                class161.field1407[var0][var1][var2] |= 1170;
                            }
                        }

                        if (var8.interactType != 0 && var7 != null) {
                            var7.method1163(var1, var2, var5, var4, var8.boolean1);
                        }

                        if (var8.int2 != 16) {
                            var6.method1262(var0, var1, var2, var8.int2);
                        }

                    } else if (var5 == 1) {
                        if (var8.animationId == -1 && var8.transforms == null) {
                            var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
                        } else {
                            var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3,
                                    (Renderable) null);
                        }

                        var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var22, (Renderable) null,
                                Tiles.field829[var4], 0, var19, var21);
                        if (var8.clipped) {
                            if (var4 == 0) {
                                Tiles.field819[var0][var1][var2 + 1] = 50;
                            } else if (var4 == 1) {
                                Tiles.field819[var0][var1 + 1][var2 + 1] = 50;
                            } else if (var4 == 2) {
                                Tiles.field819[var0][var1 + 1][var2] = 50;
                            } else if (var4 == 3) {
                                Tiles.field819[var0][var1][var2] = 50;
                            }
                        }

                        if (var8.interactType != 0 && var7 != null) {
                            var7.method1163(var1, var2, var5, var4, var8.boolean1);
                        }

                    } else {
                        int var28;
                        if (var5 == 2) {
                            var28 = var4 + 1 & 3;
                            Object var23;
                            Object var24;
                            if (var8.animationId == -1 && var8.transforms == null) {
                                var23 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
                                var24 = var8.getEntity(2, var28, var15, var17, var16, var18);
                            } else {
                                var23 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId,
                                        var8.boolean3, (Renderable) null);
                                var24 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId,
                                        var8.boolean3, (Renderable) null);
                            }

                            var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var23, (Renderable) var24,
                                    Tiles.field820[var4], Tiles.field820[var28], var19, var21);
                            if (var8.modelClipped) {
                                if (var4 == 0) {
                                    class161.field1407[var0][var1][var2] |= 585;
                                    class161.field1407[var0][var1][var2 + 1] |= 1170;
                                } else if (var4 == 1) {
                                    class161.field1407[var0][var1][var2 + 1] |= 1170;
                                    class161.field1407[var0][var1 + 1][var2] |= 585;
                                } else if (var4 == 2) {
                                    class161.field1407[var0][var1 + 1][var2] |= 585;
                                    class161.field1407[var0][var1][var2] |= 1170;
                                } else if (var4 == 3) {
                                    class161.field1407[var0][var1][var2] |= 1170;
                                    class161.field1407[var0][var1][var2] |= 585;
                                }
                            }

                            if (var8.interactType != 0 && var7 != null) {
                                var7.method1163(var1, var2, var5, var4, var8.boolean1);
                            }

                            if (var8.int2 != 16) {
                                var6.method1262(var0, var1, var2, var8.int2);
                            }

                        } else if (var5 == 3) {
                            if (var8.animationId == -1 && var8.transforms == null) {
                                var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
                            } else {
                                var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId,
                                        var8.boolean3, (Renderable) null);
                            }

                            var6.newBoundaryObject(var0, var1, var2, var16, (Renderable) var22, (Renderable) null,
                                    Tiles.field829[var4], 0, var19, var21);
                            if (var8.clipped) {
                                if (var4 == 0) {
                                    Tiles.field819[var0][var1][var2 + 1] = 50;
                                } else if (var4 == 1) {
                                    Tiles.field819[var0][var1 + 1][var2 + 1] = 50;
                                } else if (var4 == 2) {
                                    Tiles.field819[var0][var1 + 1][var2] = 50;
                                } else if (var4 == 3) {
                                    Tiles.field819[var0][var1][var2] = 50;
                                }
                            }

                            if (var8.interactType != 0 && var7 != null) {
                                var7.method1163(var1, var2, var5, var4, var8.boolean1);
                            }

                        } else if (var5 == 9) {
                            if (var8.animationId == -1 && var8.transforms == null) {
                                var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
                            } else {
                                var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId,
                                        var8.boolean3, (Renderable) null);
                            }

                            var6.method1288(var0, var1, var2, var16, 1, 1, (Renderable) var22, 0, var19, var21);
                            if (var8.interactType != 0 && var7 != null) {
                                var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                            }

                            if (var8.int2 != 16) {
                                var6.method1262(var0, var1, var2, var8.int2);
                            }

                        } else if (var5 == 4) {
                            if (var8.animationId == -1 && var8.transforms == null) {
                                var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
                            } else {
                                var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId,
                                        var8.boolean3, (Renderable) null);
                            }

                            var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var22, (Renderable) null,
                                    Tiles.field820[var4], 0, 0, 0, var19, var21);
                        } else {
                            Object var25;
                            long var29;
                            if (var5 == 5) {
                                var28 = 16;
                                var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                                if (0L != var29) {
                                    var28 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var29)).int2;
                                }

                                if (var8.animationId == -1 && var8.transforms == null) {
                                    var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
                                } else {
                                    var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId,
                                            var8.boolean3, (Renderable) null);
                                }

                                var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) null,
                                        Tiles.field820[var4], 0, var28 * Tiles.field830[var4],
                                        var28 * Tiles.field827[var4], var19, var21);
                            } else if (var5 == 6) {
                                var28 = 8;
                                var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                                if (0L != var29) {
                                    var28 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var29)).int2
                                            / 2;
                                }

                                if (var8.animationId == -1 && var8.transforms == null) {
                                    var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                                } else {
                                    var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId,
                                            var8.boolean3, (Renderable) null);
                                }

                                var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) null,
                                        256, var4, var28 * Tiles.field832[var4], var28 * Tiles.field833[var4], var19,
                                        var21);
                            } else if (var5 == 7) {
                                var31 = var4 + 2 & 3;
                                if (var8.animationId == -1 && var8.transforms == null) {
                                    var22 = var8.getEntity(4, var31 + 4, var15, var17, var16, var18);
                                } else {
                                    var22 = new DynamicObject(var3, 4, var31 + 4, var0, var1, var2, var8.animationId,
                                            var8.boolean3, (Renderable) null);
                                }

                                var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var22, (Renderable) null,
                                        256, var31, 0, 0, var19, var21);
                            } else if (var5 == 8) {
                                var28 = 8;
                                var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                                if (0L != var29) {
                                    var28 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var29)).int2
                                            / 2;
                                }

                                int var27 = var4 + 2 & 3;
                                Object var26;
                                if (var8.animationId == -1 && var8.transforms == null) {
                                    var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                                    var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
                                } else {
                                    var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId,
                                            var8.boolean3, (Renderable) null);
                                    var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId,
                                            var8.boolean3, (Renderable) null);
                                }

                                var6.newWallDecoration(var0, var1, var2, var16, (Renderable) var25, (Renderable) var26,
                                        256, var4, var28 * Tiles.field832[var4], var28 * Tiles.field833[var4], var19,
                                        var21);
                            }
                        }
                    }
                } else {
                    if (var8.animationId == -1 && var8.transforms == null) {
                        var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
                    } else {
                        var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3,
                                (Renderable) null);
                    }

                    if (var22 != null && var6.method1288(var0, var1, var2, var16, var9, var10, (Renderable) var22,
                            var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
                        var31 = 15;
                        if (var22 instanceof Model) {
                            var31 = ((Model) var22).method1318() / 4;
                            if (var31 > 30) {
                                var31 = 30;
                            }
                        }

                        for (int var32 = 0; var32 <= var9; ++var32) {
                            for (int var33 = 0; var33 <= var10; ++var33) {
                                if (var31 > Tiles.field819[var0][var32 + var1][var33 + var2]) {
                                    Tiles.field819[var0][var32 + var1][var33 + var2] = (byte) var31;
                                }
                            }
                        }
                    }

                    if (var8.interactType != 0 && var7 != null) {
                        var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                    }

                }
            }
        }
    }

    static final void PcmStream_disable(PcmStream var0) {
        var0.active = false;
        if (var0.sound != null) {
            var0.sound.position = 0;
        }

        for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
            PcmStream_disable(var1);
        }

    }

    static final void method1162() {
        int var0 = Players.Players_count;
        int[] var1 = Players.Players_indices;

        for (int var2 = 0; var2 < var0; ++var2) {
            Player var3 = Client.players[var1[var2]];
            if (var3 != null) {
                ReflectionCheck.updateActorSequence(var3, 1);
            }
        }

    }
}
