import java.util.HashMap;
import java.util.Map;

public class SequenceDefinition extends DualNode {

    static boolean field1814 = false;

    static AbstractArchive SequenceDefinition_archive;

    static AbstractArchive SequenceDefinition_animationsArchive;

    static AbstractArchive SequenceDefinition_skeletonsArchive;

    public static EvictingDualNodeHashTable SequenceDefinition_cached = new EvictingDualNodeHashTable(64);

    public static EvictingDualNodeHashTable SequenceDefinition_cachedFrames = new EvictingDualNodeHashTable(100);

    public static EvictingDualNodeHashTable SequenceDefinition_cachedModel = new EvictingDualNodeHashTable(100);

    public int SequenceDefinition_cachedModelId = -1;

    public Map animMayaFrameSounds;

    int animMayaStart = 0;

    int animMayaEnd = 0;

    public int[] frameIds;

    int[] chatFrameIds;

    public int[] frameLengths;

    public int[] soundEffects;

    public int frameCount = -1;

    int[] mergedBoneGroups;

    boolean[] animMayaMasks;

    public boolean stretches = false;

    public int forcedPriority = 5;

    public int shield = -1;

    public int weapon = -1;

    public int iterations = 99;

    public boolean field1823 = false;

    public int precedenceAnimating = -1;

    public int priority = -1;

    public int replyMode = 2;

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
        int var3;
        int var4;
        if (var2 == 1) {
            var3 = var1.readUnsignedShort();
            this.frameLengths = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameLengths[var4] = var1.readUnsignedShort();
            }

            this.frameIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.frameIds[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 2) {
            this.frameCount = var1.readUnsignedShort();
        } else if (var2 == 3) {
            var3 = var1.readUnsignedByte();
            this.mergedBoneGroups = new int[var3 + 1];

            for (var4 = 0; var4 < var3; ++var4) {
                this.mergedBoneGroups[var4] = var1.readUnsignedByte();
            }

            this.mergedBoneGroups[var3] = 9999999;
        } else if (var2 == 4) {
            this.stretches = true;
        } else if (var2 == 5) {
            this.forcedPriority = var1.readUnsignedByte();
        } else if (var2 == 6) {
            this.shield = var1.readUnsignedShort();
        } else if (var2 == 7) {
            this.weapon = var1.readUnsignedShort();
        } else if (var2 == 8) {
            this.iterations = var1.readUnsignedByte();
            this.field1823 = true;
        } else if (var2 == 9) {
            this.precedenceAnimating = var1.readUnsignedByte();
        } else if (var2 == 10) {
            this.priority = var1.readUnsignedByte();
        } else if (var2 == 11) {
            this.replyMode = var1.readUnsignedByte();
        } else if (var2 == 12) {
            var3 = var1.readUnsignedByte();
            this.chatFrameIds = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.chatFrameIds[var4] = var1.readUnsignedShort();
            }

            for (var4 = 0; var4 < var3; ++var4) {
                this.chatFrameIds[var4] += var1.readUnsignedShort() << 16;
            }
        } else if (var2 == 13) {
            var3 = var1.readUnsignedByte();
            this.soundEffects = new int[var3];

            for (var4 = 0; var4 < var3; ++var4) {
                this.soundEffects[var4] = var1.readMedium();
            }
        } else if (var2 == 14) {
            this.SequenceDefinition_cachedModelId = var1.readInt();
        } else if (var2 == 15) {
            var3 = var1.readUnsignedShort();
            this.animMayaFrameSounds = new HashMap();

            for (var4 = 0; var4 < var3; ++var4) {
                int var5 = var1.readUnsignedShort();
                int var6 = var1.readMedium();
                this.animMayaFrameSounds.put(var5, var6);
            }
        } else if (var2 == 16) {
            this.animMayaStart = var1.readUnsignedShort();
            this.animMayaEnd = var1.readUnsignedShort();
        } else if (var2 == 17) {
            this.animMayaMasks = new boolean[256];

            for (var3 = 0; var3 < this.animMayaMasks.length; ++var3) {
                this.animMayaMasks[var3] = false;
            }

            var3 = var1.readUnsignedByte();

            for (var4 = 0; var4 < var3; ++var4) {
                this.animMayaMasks[var1.readUnsignedByte()] = true;
            }
        }

    }

    void postDecode() {
        if (this.precedenceAnimating == -1) {
            if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
                this.precedenceAnimating = 0;
            } else {
                this.precedenceAnimating = 2;
            }
        }

        if (this.priority == -1) {
            if (this.mergedBoneGroups == null && this.animMayaMasks == null) {
                this.priority = 0;
            } else {
                this.priority = 2;
            }
        }

    }

    public Model transformActorModel(Model var1, int var2) {
        Model var4;
        if (!this.isCachedModelIdSet()) {
            var2 = this.frameIds[var2];
            Frames var5 = WorldMapID.getFrames(var2 >> 16);
            var2 &= 65535;
            if (var5 == null) {
                return var1.toSharedSequenceModel(true);
            } else {
                var4 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
                var4.animate(var5, var2);
                return var4;
            }
        } else {
            class133 var3 = TileItem.method626(this.SequenceDefinition_cachedModelId);
            if (var3 == null) {
                return var1.toSharedSequenceModel(true);
            } else {
                var4 = var1.toSharedSequenceModel(!var3.method770());
                var4.method1317(var3, var2);
                return var4;
            }
        }
    }

    Model transformObjectModel(Model var1, int var2, int var3) {
        Model var5;
        if (!this.isCachedModelIdSet()) {
            var2 = this.frameIds[var2];
            Frames var6 = WorldMapID.getFrames(var2 >> 16);
            var2 &= 65535;
            if (var6 == null) {
                return var1.toSharedSequenceModel(true);
            } else {
                var5 = var1.toSharedSequenceModel(!var6.hasAlphaTransform(var2));
                var3 &= 3;
                if (var3 == 1) {
                    var5.rotateY270Ccw();
                } else if (var3 == 2) {
                    var5.rotateY180();
                } else if (var3 == 3) {
                    var5.rotateY90Ccw();
                }

                var5.animate(var6, var2);
                if (var3 == 1) {
                    var5.rotateY90Ccw();
                } else if (var3 == 2) {
                    var5.rotateY180();
                } else if (var3 == 3) {
                    var5.rotateY270Ccw();
                }

                return var5;
            }
        } else {
            class133 var4 = TileItem.method626(this.SequenceDefinition_cachedModelId);
            if (var4 == null) {
                return var1.toSharedSequenceModel(true);
            } else {
                var5 = var1.toSharedSequenceModel(!var4.method770());
                var3 &= 3;
                if (var3 == 1) {
                    var5.rotateY270Ccw();
                } else if (var3 == 2) {
                    var5.rotateY180();
                } else if (var3 == 3) {
                    var5.rotateY90Ccw();
                }

                var5.method1317(var4, var2);
                if (var3 == 1) {
                    var5.rotateY90Ccw();
                } else if (var3 == 2) {
                    var5.rotateY180();
                } else if (var3 == 3) {
                    var5.rotateY270Ccw();
                }

                return var5;
            }
        }
    }

    Model method1130(Model var1, int var2) {
        Model var4;
        if (!this.isCachedModelIdSet()) {
            var2 = this.frameIds[var2];
            Frames var5 = WorldMapID.getFrames(var2 >> 16);
            var2 &= 65535;
            if (var5 == null) {
                return var1.method1312(true);
            } else {
                var4 = var1.method1312(!var5.hasAlphaTransform(var2));
                var4.animate(var5, var2);
                return var4;
            }
        } else {
            class133 var3 = TileItem.method626(this.SequenceDefinition_cachedModelId);
            if (var3 == null) {
                return var1.method1312(true);
            } else {
                var4 = var1.method1312(!var3.method770());
                var4.method1317(var3, var2);
                return var4;
            }
        }
    }

    public Model applyTransformations(Model var1, int var2, SequenceDefinition var3, int var4) {
        if (field1814 && !this.isCachedModelIdSet() && !var3.isCachedModelIdSet()) {
            return this.method1126(var1, var2, var3, var4);
        } else {
            Model var5 = var1.toSharedSequenceModel(false);
            boolean var6 = false;
            Frames var7 = null;
            Skeleton var8 = null;
            class133 var9;
            if (this.isCachedModelIdSet()) {
                var9 = this.method1131();
                if (var9 == null) {
                    return var5;
                }

                if (var3.isCachedModelIdSet() && this.animMayaMasks == null) {
                    var5.method1317(var9, var2);
                    return var5;
                }

                var8 = var9.field1280;
                var5.method1336(var8, var9, var2, this.animMayaMasks, false, !var3.isCachedModelIdSet());
            } else {
                var2 = this.frameIds[var2];
                var7 = WorldMapID.getFrames(var2 >> 16);
                var2 &= 65535;
                if (var7 == null) {
                    return var3.transformActorModel(var1, var4);
                }

                if (!var3.isCachedModelIdSet() && (this.mergedBoneGroups == null || var4 == -1)) {
                    var5.animate(var7, var2);
                    return var5;
                }

                if (this.mergedBoneGroups == null || var4 == -1) {
                    var5.animate(var7, var2);
                    return var5;
                }

                var6 = var3.isCachedModelIdSet();
                if (!var6) {
                    var5.method1322(var7, var2, this.mergedBoneGroups, false);
                }
            }

            if (var3.isCachedModelIdSet()) {
                var9 = var3.method1131();
                if (var9 == null) {
                    return var5;
                }

                if (var8 == null) {
                    var8 = var9.field1280;
                }

                var5.method1336(var8, var9, var4, this.animMayaMasks, true, true);
            } else {
                var4 = var3.frameIds[var4];
                Frames var10 = WorldMapID.getFrames(var4 >> 16);
                var4 &= 65535;
                if (var10 == null) {
                    return this.transformActorModel(var1, var2);
                }

                var5.method1322(var10, var4, this.mergedBoneGroups, true);
            }

            if (var6 && var7 != null) {
                var5.method1322(var7, var2, this.mergedBoneGroups, false);
            }

            var5.resetBounds();
            return var5;
        }
    }

    Model method1126(Model var1, int var2, SequenceDefinition var3, int var4) {
        var2 = this.frameIds[var2];
        Frames var5 = WorldMapID.getFrames(var2 >> 16);
        var2 &= 65535;
        if (var5 == null) {
            return var3.transformActorModel(var1, var4);
        } else {
            var4 = var3.frameIds[var4];
            Frames var6 = WorldMapID.getFrames(var4 >> 16);
            var4 &= 65535;
            Model var7;
            if (var6 == null) {
                var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
                var7.animate(var5, var2);
                return var7;
            } else {
                var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
                var7.animate2(var5, var2, var6, var4, this.mergedBoneGroups);
                return var7;
            }
        }
    }

    public Model transformWidgetModel(Model var1, int var2) {
        if (!this.isCachedModelIdSet()) {
            int var3 = this.frameIds[var2];
            Frames var4 = WorldMapID.getFrames(var3 >> 16);
            var3 &= 65535;
            if (var4 == null) {
                return var1.toSharedSequenceModel(true);
            } else {
                Frames var5 = null;
                int var6 = 0;
                if (this.chatFrameIds != null && var2 < this.chatFrameIds.length) {
                    var6 = this.chatFrameIds[var2];
                    var5 = WorldMapID.getFrames(var6 >> 16);
                    var6 &= 65535;
                }

                Model var7;
                if (var5 != null && var6 != 65535) {
                    var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6));
                    var7.animate(var4, var3);
                    var7.animate(var5, var6);
                    return var7;
                } else {
                    var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3));
                    var7.animate(var4, var3);
                    return var7;
                }
            }
        } else {
            return this.transformActorModel(var1, var2);
        }
    }

    public boolean isCachedModelIdSet() {
        return this.SequenceDefinition_cachedModelId >= 0;
    }

    public int method1128() {
        return this.animMayaEnd - this.animMayaStart;
    }

    class133 method1131() {
        return this.isCachedModelIdSet() ? TileItem.method626(this.SequenceDefinition_cachedModelId) : null;
    }

    static int method1135(byte[] var0, int var1, int var2) {
        int var3 = -1;

        for (int var4 = var1; var4 < var2; ++var4) {
            var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
        }

        var3 = ~var3;
        return var3;
    }

    static final void method1129(int var0, int var1, int var2, boolean var3) {
        if (SoundSystem.loadInterface(var0)) {
            class135.resizeInterface(VerticalAlignment.Widget_interfaceComponents[var0], -1, var1, var2, var3);
        }
    }
}
