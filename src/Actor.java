public abstract class Actor extends Renderable {

    boolean isWalking = false;

    int x;

    int y;

    int rotation;

    int field936 = 1;

    int playerCycle;

    int idleSequence = -1;

    int turnLeftSequence = -1;

    int turnRightSequence = -1;

    int walkSequence = -1;

    int walkBackSequence = -1;

    int walkLeftSequence = -1;

    int walkRightSequence = -1;

    int runSequence = -1;

    int runBackSequence = -1;

    int runLeftSequence = -1;

    int runRightSequence = -1;

    int crawlSequence = -1;

    int crawlBackSequence = -1;

    int crawlLeftSequence = -1;

    int crawlRightSequence = -1;

    String overheadText = null;

    boolean isAutoChatting;

    boolean showPublicPlayerChat = false;

    int overheadTextCyclesRemaining = 100;

    int field957 = 0;

    int field1002 = 0;

    byte hitSplatCount = 0;

    int[] hitSplatTypes = new int[4];

    int[] hitSplatValues = new int[4];

    int[] hitSplatCycles = new int[4];

    int[] hitSplatTypes2 = new int[4];

    int[] hitSplatValues2 = new int[4];

    IterableNodeDeque healthBars = new IterableNodeDeque();

    int targetIndex = -1;

    boolean false0 = false;

    int movingOrientation = -1;

    int field993 = -1;

    int field970 = -1;

    boolean field938;

    int movementSequence = -1;

    int movementFrame = 0;

    int movementFrameCycle = 0;

    int field975 = 0;

    int sequence = -1;

    int sequenceFrame = 0;

    int sequenceFrameCycle = 0;

    int sequenceDelay = 0;

    int currentSequenceFrameIndex = 0;

    IterableNodeHashTable graphics = new IterableNodeHashTable(4);

    int graphicsCount = 0;

    int field983;

    int field984;

    int field985;

    int field1003;

    int spotAnimation;

    int exactMoveArrive1Cycle;

    int exactMoveDirection;

    int npcCycle = 0;

    int defaultHeight = 200;

    int recolourStartCycle = -1;

    int recolourEndCycle = -1;

    byte recolourHue;

    byte recolourSaturation;

    byte recolourLuminance;

    byte recolourAmount;

    int orientation;

    int field999 = 0;

    int field986 = 32;

    int pathLength = 0;

    int[] pathX = new int[10];

    int[] pathY = new int[10];

    MoveSpeed[] pathTraversed = new MoveSpeed[10];

    int field1005 = 0;

    int field1006 = 0;

    int combatLevelChange = -1;

    boolean isVisible() {
        return false;
    }

    final void method536() {
        this.pathLength = 0;
        this.field1006 = 0;
    }

    final void addHitSplat(int var1, int var2, int var3, int var4, int var5, int var6) {
        boolean var7 = true;
        boolean var8 = true;

        int var9;
        for (var9 = 0; var9 < 4; ++var9) {
            if (this.hitSplatCycles[var9] > var5) {
                var7 = false;
            } else {
                var8 = false;
            }
        }

        var9 = -1;
        int var10 = -1;
        int var11 = 0;
        if (var1 >= 0) {
            HitSplatDefinition var12 = class122.method738(var1);
            var10 = var12.field1678;
            var11 = var12.field1672;
        }

        int var14;
        if (var8) {
            if (var10 == -1) {
                return;
            }

            var9 = 0;
            var14 = 0;
            if (var10 == 0) {
                var14 = this.hitSplatCycles[0];
            } else if (var10 == 1) {
                var14 = this.hitSplatValues[0];
            }

            for (int var13 = 1; var13 < 4; ++var13) {
                if (var10 == 0) {
                    if (this.hitSplatCycles[var13] < var14) {
                        var9 = var13;
                        var14 = this.hitSplatCycles[var13];
                    }
                } else if (var10 == 1 && this.hitSplatValues[var13] < var14) {
                    var9 = var13;
                    var14 = this.hitSplatValues[var13];
                }
            }

            if (var10 == 1 && var14 >= var2) {
                return;
            }
        } else {
            if (var7) {
                this.hitSplatCount = 0;
            }

            for (var14 = 0; var14 < 4; ++var14) {
                byte var15 = this.hitSplatCount;
                this.hitSplatCount = (byte) ((this.hitSplatCount + 1) % 4);
                if (this.hitSplatCycles[var15] <= var5) {
                    var9 = var15;
                    break;
                }
            }
        }

        if (var9 >= 0) {
            this.hitSplatTypes[var9] = var1;
            this.hitSplatValues[var9] = var2;
            this.hitSplatTypes2[var9] = var3;
            this.hitSplatValues2[var9] = var4;
            this.hitSplatCycles[var9] = var5 + var11 + var6;
        }
    }

    final void addHealthBar(int var1, int var2, int var3, int var4, int var5, int var6) {
        HealthBarDefinition var8 = (HealthBarDefinition) HealthBarDefinition.HealthBarDefinition_cached
                .get((long) var1);
        HealthBarDefinition var7;
        if (var8 != null) {
            var7 = var8;
        } else {
            byte[] var9 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
            var8 = new HealthBarDefinition();
            if (var9 != null) {
                var8.decode(new Buffer(var9));
            }

            HealthBarDefinition.HealthBarDefinition_cached.put(var8, (long) var1);
            var7 = var8;
        }

        var8 = var7;
        HealthBar var14 = null;
        HealthBar var10 = null;
        int var11 = var7.int2;
        int var12 = 0;

        HealthBar var13;
        for (var13 = (HealthBar) this.healthBars.last(); var13 != null; var13 = (HealthBar) this.healthBars
                .previous()) {
            ++var12;
            if (var13.definition.field1521 == var8.field1521) {
                var13.put(var2 + var4, var5, var6, var3);
                return;
            }

            if (var13.definition.int1 <= var8.int1) {
                var14 = var13;
            }

            if (var13.definition.int2 > var11) {
                var10 = var13;
                var11 = var13.definition.int2;
            }
        }

        if (var10 != null || var12 < 4) {
            var13 = new HealthBar(var8);
            if (var14 == null) {
                this.healthBars.addLast(var13);
            } else {
                IterableNodeDeque.IterableNodeDeque_addBefore(var13, var14);
            }

            var13.put(var2 + var4, var5, var6, var3);
            if (var12 >= 4) {
                var10.remove();
            }

        }
    }

    final void removeHealthBar(int var1) {
        HealthBarDefinition var3 = (HealthBarDefinition) HealthBarDefinition.HealthBarDefinition_cached
                .get((long) var1);
        HealthBarDefinition var2;
        if (var3 != null) {
            var2 = var3;
        } else {
            byte[] var4 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var1);
            var3 = new HealthBarDefinition();
            if (var4 != null) {
                var3.decode(new Buffer(var4));
            }

            HealthBarDefinition.HealthBarDefinition_cached.put(var3, (long) var1);
            var2 = var3;
        }

        var3 = var2;

        for (HealthBar var5 = (HealthBar) this.healthBars.last(); var5 != null; var5 = (HealthBar) this.healthBars
                .previous()) {
            if (var3 == var5.definition) {
                var5.remove();
                return;
            }
        }

    }

    void updateGraphic(int idx, int graphicID, int graphicHeight, int graphicStartCycle) {
        int startCycle = graphicStartCycle + Client.cycle;
        Graphic graphic = (Graphic) this.graphics.get((long) idx);
        if (graphic != null) {
            graphic.remove();
            --this.graphicsCount;
        }

        if (graphicID != 65535 && graphicID != -1) {
            byte var7 = 0;
            if (graphicStartCycle > 0) {
                var7 = -1;
            }

            this.graphics.put(new Graphic(graphicID, graphicHeight, startCycle, var7), (long) idx);
            ++this.graphicsCount;
        }
    }

    IterableNodeHashTable method532() {
        return this.graphics;
    }

    void method533() {
        IterableNodeHashTableIterator var1 = new IterableNodeHashTableIterator(this.graphics);

        for (Graphic var2 = (Graphic) var1.method2390(); var2 != null; var2 = (Graphic) var1.next()) {
            var2.remove();
        }

        this.graphicsCount = 0;
    }

    Model method530(Model var1) {
        if (this.graphicsCount == 0) {
            return var1;
        } else {
            IterableNodeHashTableIterator var2 = new IterableNodeHashTableIterator(this.graphics);
            int var3 = var1.verticesCount;
            int var4 = var1.indicesCount;
            int var5 = var1.field2153;
            byte var6 = var1.field2152;

            for (Graphic var7 = (Graphic) var2.method2390(); var7 != null; var7 = (Graphic) var2.next()) {
                if (var7.field4169 != -1) {
                    Model var8 = ItemContainer.SpotAnimationDefinition_get(var7.field4170).method1042();
                    if (var8 != null) {
                        var3 += var8.verticesCount;
                        var4 += var8.indicesCount;
                        var5 += var8.field2153;
                    }
                }
            }

            Model var10 = new Model(var3, var4, var5, var6);
            var10.method1342(var1);

            for (Graphic var11 = (Graphic) var2.method2390(); var11 != null; var11 = (Graphic) var2.next()) {
                if (var11.field4169 != -1) {
                    Model var9 = ItemContainer.SpotAnimationDefinition_get(var11.field4170).getModel(var11.field4169);
                    if (var9 != null) {
                        var9.offsetBy(0, -var11.field4172, 0);
                        var10.method1342(var9);
                    }
                }
            }

            return var10;
        }
    }

    void method527() {
        this.field938 = false;
        this.movingOrientation = -1;
        this.field993 = -1;
        this.field970 = -1;
    }

    static Message Messages_getByChannelAndID(int var0, int var1) {
        ChatChannel var2 = (ChatChannel) Messages.Messages_channels.get(var0);
        return var2.getMessage(var1);
    }

    public static void method538(int var0, AbstractArchive var1, int var2, int var3, int var4, boolean var5) {
        class297.musicPlayerStatus = 1;
        class297.musicTrackArchive = var1;
        class379.musicTrackGroupId = var2;
        VarpDefinition.musicTrackFileId = var3;
        class100.musicTrackVolume = var4;
        class120.musicTrackBoolean = var5;
        class162.pcmSampleLength = var0;
    }

    public static int method539(CharSequence var0) {
        int var1 = var0.length();
        int var2 = 0;

        for (int var3 = 0; var3 < var1; ++var3) {
            var2 = (var2 << 5) - var2 + var0.charAt(var3);
        }

        return var2;
    }

    static final int method537(int var0, int var1) {
        int var2 = var1 * 57 + var0;
        var2 ^= var2 << 13;
        int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
        return var3 >> 19 & 255;
    }
}
