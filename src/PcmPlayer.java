public class PcmPlayer {

    public static int field201;

    public static boolean PcmPlayer_stereo;

    public static class50 pcmPlayerProvider;

    static Archive field211;

    protected int[] samples;

    PcmStream stream;

    int field197 = 32;

    long timeMs = class96.clockNow();

    int capacity;

    int field200;

    int field193;

    long field202 = 0L;

    int field203 = 0;

    int field192 = 0;

    int field205 = 0;

    long field204 = 0L;

    boolean field207 = true;

    int field209 = 0;

    PcmStream[] field199 = new PcmStream[8];

    PcmStream[] field210 = new PcmStream[8];

    protected void init() throws Exception {
    }

    protected void open(int var1) throws Exception {
    }

    protected int position() throws Exception {
        return this.capacity;
    }

    protected void write() throws Exception {
    }

    protected void close() {
    }

    protected void discard() throws Exception {
    }

    public final synchronized void setStream(PcmStream var1) {
        this.stream = var1;
    }

    public final synchronized void run() {
        if (this.samples != null) {
            long var1 = class96.clockNow();

            try {
                if (0L != this.field202) {
                    if (var1 < this.field202) {
                        return;
                    }

                    this.open(this.capacity);
                    this.field202 = 0L;
                    this.field207 = true;
                }

                int var3 = this.position();
                if (this.field205 - var3 > this.field203) {
                    this.field203 = this.field205 - var3;
                }

                int var4 = this.field193 + this.field200;
                if (var4 + 256 > 16384) {
                    var4 = 16128;
                }

                if (var4 + 256 > this.capacity) {
                    this.capacity += 1024;
                    if (this.capacity > 16384) {
                        this.capacity = 16384;
                    }

                    this.close();
                    this.open(this.capacity);
                    var3 = 0;
                    this.field207 = true;
                    if (var4 + 256 > this.capacity) {
                        var4 = this.capacity - 256;
                        this.field193 = var4 - this.field200;
                    }
                }

                while (var3 < var4) {
                    this.fill(this.samples, 256);
                    this.write();
                    var3 += 256;
                }

                if (var1 > this.field204) {
                    if (!this.field207) {
                        if (this.field203 == 0 && this.field192 == 0) {
                            this.close();
                            this.field202 = var1 + 2000L;
                            return;
                        }

                        this.field193 = Math.min(this.field192, this.field203);
                        this.field192 = this.field203;
                    } else {
                        this.field207 = false;
                    }

                    this.field203 = 0;
                    this.field204 = var1 + 2000L;
                }

                this.field205 = var3;
            } catch (Exception var7) {
                this.close();
                this.field202 = var1 + 2000L;
            }

            try {
                if (var1 > 500000L + this.timeMs) {
                    var1 = this.timeMs;
                }

                while (var1 > 5000L + this.timeMs) {
                    this.skip(256);
                    this.timeMs += (long) (256000 / field201);
                }
            } catch (Exception var6) {
                this.timeMs = var1;
            }

        }
    }

    public final void method228() {
        this.field207 = true;
    }

    public final synchronized void tryDiscard() {
        this.field207 = true;

        try {
            this.discard();
        } catch (Exception var2) {
            this.close();
            this.field202 = class96.clockNow() + 2000L;
        }

    }

    public final synchronized void shutdown() {
        if (class354.soundSystem != null) {
            boolean var1 = true;

            for (int var2 = 0; var2 < 2; ++var2) {
                if (this == class354.soundSystem.players[var2]) {
                    class354.soundSystem.players[var2] = null;
                }

                if (class354.soundSystem.players[var2] != null) {
                    var1 = false;
                }
            }

            if (var1) {
                SoundSystem.soundSystemExecutor.shutdownNow();
                SoundSystem.soundSystemExecutor = null;
                class354.soundSystem = null;
            }
        }

        this.close();
        this.samples = null;
    }

    final void skip(int var1) {
        this.field209 -= var1;
        if (this.field209 < 0) {
            this.field209 = 0;
        }

        if (this.stream != null) {
            this.stream.skip(var1);
        }

    }

    final void fill(int[] var1, int var2) {
        int var3 = var2;
        if (PcmPlayer_stereo) {
            var3 = var2 << 1;
        }

        class384.clearIntArray(var1, 0, var3);
        this.field209 -= var2;
        if (this.stream != null && this.field209 <= 0) {
            this.field209 += field201 >> 4;
            class207.PcmStream_disable(this.stream);
            this.method235(this.stream, this.stream.vmethod1019());
            int var4 = 0;
            int var5 = 255;

            int var6;
            PcmStream var10;
            label105: for (var6 = 7; var5 != 0; --var6) {
                int var7;
                int var8;
                if (var6 < 0) {
                    var7 = var6 & 3;
                    var8 = -(var6 >> 2);
                } else {
                    var7 = var6;
                    var8 = 0;
                }

                for (int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
                    if ((var9 & 1) != 0) {
                        var5 &= ~(1 << var7);
                        var10 = null;
                        PcmStream var11 = this.field199[var7];

                        label99: while (true) {
                            while (true) {
                                if (var11 == null) {
                                    break label99;
                                }

                                AbstractSound var12 = var11.sound;
                                if (var12 != null && var12.position > var8) {
                                    var5 |= 1 << var7;
                                    var10 = var11;
                                    var11 = var11.after;
                                } else {
                                    var11.active = true;
                                    int var13 = var11.vmethod5648();
                                    var4 += var13;
                                    if (var12 != null) {
                                        var12.position += var13;
                                    }

                                    if (var4 >= this.field197) {
                                        break label105;
                                    }

                                    PcmStream var14 = var11.firstSubStream();
                                    if (var14 != null) {
                                        for (int var15 = var11.field255; var14 != null; var14 = var11.nextSubStream()) {
                                            this.method235(var14, var15 * var14.vmethod1019() >> 8);
                                        }
                                    }

                                    PcmStream var16 = var11.after;
                                    var11.after = null;
                                    if (var10 == null) {
                                        this.field199[var7] = var16;
                                    } else {
                                        var10.after = var16;
                                    }

                                    if (var16 == null) {
                                        this.field210[var7] = var10;
                                    }

                                    var11 = var16;
                                }
                            }
                        }
                    }

                    var7 += 4;
                    ++var8;
                }
            }

            for (var6 = 0; var6 < 8; ++var6) {
                PcmStream var17 = this.field199[var6];
                PcmStream[] var18 = this.field199;
                this.field210[var6] = null;

                for (var18[var6] = null; var17 != null; var17 = var10) {
                    var10 = var17.after;
                    var17.after = null;
                }
            }
        }

        if (this.field209 < 0) {
            this.field209 = 0;
        }

        if (this.stream != null) {
            this.stream.fill(var1, 0, var2);
        }

        this.timeMs = class96.clockNow();
    }

    final void method235(PcmStream var1, int var2) {
        int var3 = var2 >> 5;
        PcmStream var4 = this.field210[var3];
        if (var4 == null) {
            this.field199[var3] = var1;
        } else {
            var4.after = var1;
        }

        this.field210[var3] = var1;
        var1.field255 = var2;
    }

    static int method240(int var0, int var1, int var2) {
        if ((Tiles.Tiles_renderFlags[var0][var1][var2] & 8) != 0) {
            return 0;
        } else {
            return var0 > 0 && (Tiles.Tiles_renderFlags[1][var1][var2] & 2) != 0 ? var0 - 1 : var0;
        }
    }
}
