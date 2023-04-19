public class RawPcmStream extends PcmStream {

    int field239;

    int field238;

    int field245;

    int field240;

    int field241;

    int field242;

    int field243;

    int numLoops;

    int start;

    int end;

    boolean field247;

    int field248;

    int field244;

    int field237;

    int field251;

    RawPcmStream(RawSound var1, int var2, int var3, int var4) {
        super.sound = var1;
        this.start = var1.start;
        this.end = var1.end;
        this.field247 = var1.field176;
        this.field238 = var2;
        this.field245 = var3;
        this.field240 = var4;
        this.field239 = 0;
        this.method258();
    }

    RawPcmStream(RawSound var1, int var2, int var3) {
        super.sound = var1;
        this.start = var1.start;
        this.end = var1.end;
        this.field247 = var1.field176;
        this.field238 = var2;
        this.field245 = var3;
        this.field240 = 8192;
        this.field239 = 0;
        this.method258();
    }

    void method258() {
        this.field241 = this.field245;
        this.field242 = method297(this.field245, this.field240);
        this.field243 = method255(this.field245, this.field240);
    }

    protected PcmStream firstSubStream() {
        return null;
    }

    protected PcmStream nextSubStream() {
        return null;
    }

    protected int vmethod5648() {
        return this.field245 == 0 && this.field248 == 0 ? 0 : 1;
    }

    public synchronized void fill(int[] var1, int var2, int var3) {
        if (this.field245 == 0 && this.field248 == 0) {
            this.skip(var3);
        } else {
            RawSound var4 = (RawSound) super.sound;
            int var5 = this.start << 8;
            int var6 = this.end << 8;
            int var7 = var4.samples.length << 8;
            int var8 = var6 - var5;
            if (var8 <= 0) {
                this.numLoops = 0;
            }

            int var9 = var2;
            var3 += var2;
            if (this.field239 < 0) {
                if (this.field238 <= 0) {
                    this.method265();
                    this.remove();
                    return;
                }

                this.field239 = 0;
            }

            if (this.field239 >= var7) {
                if (this.field238 >= 0) {
                    this.method265();
                    this.remove();
                    return;
                }

                this.field239 = var7 - 1;
            }

            if (this.numLoops < 0) {
                if (this.field247) {
                    if (this.field238 < 0) {
                        var9 = this.method275(var1, var2, var5, var3, var4.samples[this.start]);
                        if (this.field239 >= var5) {
                            return;
                        }

                        this.field239 = var5 + var5 - 1 - this.field239;
                        this.field238 = -this.field238;
                    }

                    while (true) {
                        var9 = this.method274(var1, var9, var6, var3, var4.samples[this.end - 1]);
                        if (this.field239 < var6) {
                            return;
                        }

                        this.field239 = var6 + var6 - 1 - this.field239;
                        this.field238 = -this.field238;
                        var9 = this.method275(var1, var9, var5, var3, var4.samples[this.start]);
                        if (this.field239 >= var5) {
                            return;
                        }

                        this.field239 = var5 + var5 - 1 - this.field239;
                        this.field238 = -this.field238;
                    }
                } else if (this.field238 < 0) {
                    while (true) {
                        var9 = this.method275(var1, var9, var5, var3, var4.samples[this.end - 1]);
                        if (this.field239 >= var5) {
                            return;
                        }

                        this.field239 = var6 - 1 - (var6 - 1 - this.field239) % var8;
                    }
                } else {
                    while (true) {
                        var9 = this.method274(var1, var9, var6, var3, var4.samples[this.start]);
                        if (this.field239 < var6) {
                            return;
                        }

                        this.field239 = var5 + (this.field239 - var5) % var8;
                    }
                }
            } else {
                if (this.numLoops > 0) {
                    if (this.field247) {
                        label132: {
                            if (this.field238 < 0) {
                                var9 = this.method275(var1, var2, var5, var3, var4.samples[this.start]);
                                if (this.field239 >= var5) {
                                    return;
                                }

                                this.field239 = var5 + var5 - 1 - this.field239;
                                this.field238 = -this.field238;
                                if (--this.numLoops == 0) {
                                    break label132;
                                }
                            }

                            do {
                                var9 = this.method274(var1, var9, var6, var3, var4.samples[this.end - 1]);
                                if (this.field239 < var6) {
                                    return;
                                }

                                this.field239 = var6 + var6 - 1 - this.field239;
                                this.field238 = -this.field238;
                                if (--this.numLoops == 0) {
                                    break;
                                }

                                var9 = this.method275(var1, var9, var5, var3, var4.samples[this.start]);
                                if (this.field239 >= var5) {
                                    return;
                                }

                                this.field239 = var5 + var5 - 1 - this.field239;
                                this.field238 = -this.field238;
                            } while (--this.numLoops != 0);
                        }
                    } else {
                        int var10;
                        if (this.field238 < 0) {
                            while (true) {
                                var9 = this.method275(var1, var9, var5, var3, var4.samples[this.end - 1]);
                                if (this.field239 >= var5) {
                                    return;
                                }

                                var10 = (var6 - 1 - this.field239) / var8;
                                if (var10 >= this.numLoops) {
                                    this.field239 += var8 * this.numLoops;
                                    this.numLoops = 0;
                                    break;
                                }

                                this.field239 += var8 * var10;
                                this.numLoops -= var10;
                            }
                        } else {
                            while (true) {
                                var9 = this.method274(var1, var9, var6, var3, var4.samples[this.start]);
                                if (this.field239 < var6) {
                                    return;
                                }

                                var10 = (this.field239 - var5) / var8;
                                if (var10 >= this.numLoops) {
                                    this.field239 -= var8 * this.numLoops;
                                    this.numLoops = 0;
                                    break;
                                }

                                this.field239 -= var8 * var10;
                                this.numLoops -= var10;
                            }
                        }
                    }
                }

                if (this.field238 < 0) {
                    this.method275(var1, var9, 0, var3, 0);
                    if (this.field239 < 0) {
                        this.field239 = -1;
                        this.method265();
                        this.remove();
                    }
                } else {
                    this.method274(var1, var9, var7, var3, 0);
                    if (this.field239 >= var7) {
                        this.field239 = var7;
                        this.method265();
                        this.remove();
                    }
                }

            }
        }
    }

    public synchronized void setNumLoops(int var1) {
        this.numLoops = var1;
    }

    public synchronized void skip(int var1) {
        if (this.field248 > 0) {
            if (var1 >= this.field248) {
                if (this.field245 == Integer.MIN_VALUE) {
                    this.field245 = 0;
                    this.field243 = 0;
                    this.field242 = 0;
                    this.field241 = 0;
                    this.remove();
                    var1 = this.field248;
                }

                this.field248 = 0;
                this.method258();
            } else {
                this.field241 += this.field244 * var1;
                this.field242 += this.field237 * var1;
                this.field243 += this.field251 * var1;
                this.field248 -= var1;
            }
        }

        RawSound var2 = (RawSound) super.sound;
        int var3 = this.start << 8;
        int var4 = this.end << 8;
        int var5 = var2.samples.length << 8;
        int var6 = var4 - var3;
        if (var6 <= 0) {
            this.numLoops = 0;
        }

        if (this.field239 < 0) {
            if (this.field238 <= 0) {
                this.method265();
                this.remove();
                return;
            }

            this.field239 = 0;
        }

        if (this.field239 >= var5) {
            if (this.field238 >= 0) {
                this.method265();
                this.remove();
                return;
            }

            this.field239 = var5 - 1;
        }

        this.field239 += this.field238 * var1;
        if (this.numLoops < 0) {
            if (!this.field247) {
                if (this.field238 < 0) {
                    if (this.field239 >= var3) {
                        return;
                    }

                    this.field239 = var4 - 1 - (var4 - 1 - this.field239) % var6;
                } else {
                    if (this.field239 < var4) {
                        return;
                    }

                    this.field239 = var3 + (this.field239 - var3) % var6;
                }

            } else {
                if (this.field238 < 0) {
                    if (this.field239 >= var3) {
                        return;
                    }

                    this.field239 = var3 + var3 - 1 - this.field239;
                    this.field238 = -this.field238;
                }

                while (this.field239 >= var4) {
                    this.field239 = var4 + var4 - 1 - this.field239;
                    this.field238 = -this.field238;
                    if (this.field239 >= var3) {
                        return;
                    }

                    this.field239 = var3 + var3 - 1 - this.field239;
                    this.field238 = -this.field238;
                }

            }
        } else {
            if (this.numLoops > 0) {
                if (this.field247) {
                    label121: {
                        if (this.field238 < 0) {
                            if (this.field239 >= var3) {
                                return;
                            }

                            this.field239 = var3 + var3 - 1 - this.field239;
                            this.field238 = -this.field238;
                            if (--this.numLoops == 0) {
                                break label121;
                            }
                        }

                        do {
                            if (this.field239 < var4) {
                                return;
                            }

                            this.field239 = var4 + var4 - 1 - this.field239;
                            this.field238 = -this.field238;
                            if (--this.numLoops == 0) {
                                break;
                            }

                            if (this.field239 >= var3) {
                                return;
                            }

                            this.field239 = var3 + var3 - 1 - this.field239;
                            this.field238 = -this.field238;
                        } while (--this.numLoops != 0);
                    }
                } else {
                    label153: {
                        int var7;
                        if (this.field238 < 0) {
                            if (this.field239 >= var3) {
                                return;
                            }

                            var7 = (var4 - 1 - this.field239) / var6;
                            if (var7 >= this.numLoops) {
                                this.field239 += var6 * this.numLoops;
                                this.numLoops = 0;
                                break label153;
                            }

                            this.field239 += var6 * var7;
                            this.numLoops -= var7;
                        } else {
                            if (this.field239 < var4) {
                                return;
                            }

                            var7 = (this.field239 - var3) / var6;
                            if (var7 >= this.numLoops) {
                                this.field239 -= var6 * this.numLoops;
                                this.numLoops = 0;
                                break label153;
                            }

                            this.field239 -= var6 * var7;
                            this.numLoops -= var7;
                        }

                        return;
                    }
                }
            }

            if (this.field238 < 0) {
                if (this.field239 < 0) {
                    this.field239 = -1;
                    this.method265();
                    this.remove();
                }
            } else if (this.field239 >= var5) {
                this.field239 = var5;
                this.method265();
                this.remove();
            }

        }
    }

    public synchronized void method295(int var1) {
        this.method261(var1 << 6, this.method285());
    }

    synchronized void method260(int var1) {
        this.method261(var1, this.method285());
    }

    synchronized void method261(int var1, int var2) {
        this.field245 = var1;
        this.field240 = var2;
        this.field248 = 0;
        this.method258();
    }

    public synchronized int method262() {
        return this.field245 == Integer.MIN_VALUE ? 0 : this.field245;
    }

    public synchronized int method285() {
        return this.field240 < 0 ? -1 : this.field240;
    }

    public synchronized void method263(int var1) {
        int var2 = ((RawSound) super.sound).samples.length << 8;
        if (var1 < -1) {
            var1 = -1;
        }

        if (var1 > var2) {
            var1 = var2;
        }

        this.field239 = var1;
    }

    public synchronized void method264() {
        this.field238 = (this.field238 ^ this.field238 >> 31) + (this.field238 >>> 31);
        this.field238 = -this.field238;
    }

    void method265() {
        if (this.field248 != 0) {
            if (this.field245 == Integer.MIN_VALUE) {
                this.field245 = 0;
            }

            this.field248 = 0;
            this.method258();
        }

    }

    public synchronized void method298(int var1, int var2) {
        this.method267(var1, var2, this.method285());
    }

    public synchronized void method267(int var1, int var2, int var3) {
        if (var1 == 0) {
            this.method261(var2, var3);
        } else {
            int var4 = method297(var2, var3);
            int var5 = method255(var2, var3);
            if (var4 == this.field242 && var5 == this.field243) {
                this.field248 = 0;
            } else {
                int var6 = var2 - this.field241;
                if (this.field241 - var2 > var6) {
                    var6 = this.field241 - var2;
                }

                if (var4 - this.field242 > var6) {
                    var6 = var4 - this.field242;
                }

                if (this.field242 - var4 > var6) {
                    var6 = this.field242 - var4;
                }

                if (var5 - this.field243 > var6) {
                    var6 = var5 - this.field243;
                }

                if (this.field243 - var5 > var6) {
                    var6 = this.field243 - var5;
                }

                if (var1 > var6) {
                    var1 = var6;
                }

                this.field248 = var1;
                this.field245 = var2;
                this.field240 = var3;
                this.field244 = (var2 - this.field241) / var1;
                this.field237 = (var4 - this.field242) / var1;
                this.field251 = (var5 - this.field243) / var1;
            }
        }
    }

    public synchronized void method268(int var1) {
        if (var1 == 0) {
            this.method260(0);
            this.remove();
        } else if (this.field242 == 0 && this.field243 == 0) {
            this.field248 = 0;
            this.field245 = 0;
            this.field241 = 0;
            this.remove();
        } else {
            int var2 = -this.field241;
            if (this.field241 > var2) {
                var2 = this.field241;
            }

            if (-this.field242 > var2) {
                var2 = -this.field242;
            }

            if (this.field242 > var2) {
                var2 = this.field242;
            }

            if (-this.field243 > var2) {
                var2 = -this.field243;
            }

            if (this.field243 > var2) {
                var2 = this.field243;
            }

            if (var1 > var2) {
                var1 = var2;
            }

            this.field248 = var1;
            this.field245 = Integer.MIN_VALUE;
            this.field244 = -this.field241 / var1;
            this.field237 = -this.field242 / var1;
            this.field251 = -this.field243 / var1;
        }
    }

    public synchronized void method269(int var1) {
        if (this.field238 < 0) {
            this.field238 = -var1;
        } else {
            this.field238 = var1;
        }

    }

    public synchronized int method270() {
        return this.field238 < 0 ? -this.field238 : this.field238;
    }

    public boolean method296() {
        return this.field239 < 0 || this.field239 >= ((RawSound) super.sound).samples.length << 8;
    }

    public boolean method299() {
        return this.field248 != 0;
    }

    int method274(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.field248 > 0) {
                int var6 = var2 + this.field248;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.field248 += var2;
                if (this.field238 == 256 && (this.field239 & 255) == 0) {
                    if (PcmPlayer.PcmPlayer_stereo) {
                        var2 = method292(0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                                this.field243, this.field237, this.field251, 0, var6, var3, this);
                    } else {
                        var2 = method290(((RawSound) super.sound).samples, var1, this.field239, var2, this.field241,
                                this.field244, 0, var6, var3, this);
                    }
                } else if (PcmPlayer.PcmPlayer_stereo) {
                    var2 = method300(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                            this.field243, this.field237, this.field251, 0, var6, var3, this, this.field238, var5);
                } else {
                    var2 = method266(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field241,
                            this.field244, 0, var6, var3, this, this.field238, var5);
                }

                this.field248 -= var2;
                if (this.field248 != 0) {
                    return var2;
                }

                if (!this.method276()) {
                    continue;
                }

                return var4;
            }

            if (this.field238 == 256 && (this.field239 & 255) == 0) {
                if (PcmPlayer.PcmPlayer_stereo) {
                    return method278(0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                            this.field243, 0, var4, var3, this);
                }

                return method277(((RawSound) super.sound).samples, var1, this.field239, var2, this.field241, 0, var4,
                        var3, this);
            }

            if (PcmPlayer.PcmPlayer_stereo) {
                return method281(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                        this.field243, 0, var4, var3, this, this.field238, var5);
            }

            return method280(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field241, 0, var4,
                    var3, this, this.field238, var5);
        }
    }

    int method275(int[] var1, int var2, int var3, int var4, int var5) {
        while (true) {
            if (this.field248 > 0) {
                int var6 = var2 + this.field248;
                if (var6 > var4) {
                    var6 = var4;
                }

                this.field248 += var2;
                if (this.field238 == -256 && (this.field239 & 255) == 0) {
                    if (PcmPlayer.PcmPlayer_stereo) {
                        var2 = method293(0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                                this.field243, this.field237, this.field251, 0, var6, var3, this);
                    } else {
                        var2 = method284(((RawSound) super.sound).samples, var1, this.field239, var2, this.field241,
                                this.field244, 0, var6, var3, this);
                    }
                } else if (PcmPlayer.PcmPlayer_stereo) {
                    var2 = method288(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                            this.field243, this.field237, this.field251, 0, var6, var3, this, this.field238, var5);
                } else {
                    var2 = method287(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field241,
                            this.field244, 0, var6, var3, this, this.field238, var5);
                }

                this.field248 -= var2;
                if (this.field248 != 0) {
                    return var2;
                }

                if (!this.method276()) {
                    continue;
                }

                return var4;
            }

            if (this.field238 == -256 && (this.field239 & 255) == 0) {
                if (PcmPlayer.PcmPlayer_stereo) {
                    return method289(0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                            this.field243, 0, var4, var3, this);
                }

                return method279(((RawSound) super.sound).samples, var1, this.field239, var2, this.field241, 0, var4,
                        var3, this);
            }

            if (PcmPlayer.PcmPlayer_stereo) {
                return method283(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field242,
                        this.field243, 0, var4, var3, this, this.field238, var5);
            }

            return method282(0, 0, ((RawSound) super.sound).samples, var1, this.field239, var2, this.field241, 0, var4,
                    var3, this, this.field238, var5);
        }
    }

    boolean method276() {
        int var1 = this.field245;
        int var2;
        int var3;
        if (var1 == Integer.MIN_VALUE) {
            var3 = 0;
            var2 = 0;
            var1 = 0;
        } else {
            var2 = method297(var1, this.field240);
            var3 = method255(var1, this.field240);
        }

        if (var1 == this.field241 && var2 == this.field242 && var3 == this.field243) {
            if (this.field245 == Integer.MIN_VALUE) {
                this.field245 = 0;
                this.field243 = 0;
                this.field242 = 0;
                this.field241 = 0;
                this.remove();
                return true;
            } else {
                this.method258();
                return false;
            }
        } else {
            if (this.field241 < var1) {
                this.field244 = 1;
                this.field248 = var1 - this.field241;
            } else if (this.field241 > var1) {
                this.field244 = -1;
                this.field248 = this.field241 - var1;
            } else {
                this.field244 = 0;
            }

            if (this.field242 < var2) {
                this.field237 = 1;
                if (this.field248 == 0 || this.field248 > var2 - this.field242) {
                    this.field248 = var2 - this.field242;
                }
            } else if (this.field242 > var2) {
                this.field237 = -1;
                if (this.field248 == 0 || this.field248 > this.field242 - var2) {
                    this.field248 = this.field242 - var2;
                }
            } else {
                this.field237 = 0;
            }

            if (this.field243 < var3) {
                this.field251 = 1;
                if (this.field248 == 0 || this.field248 > var3 - this.field243) {
                    this.field248 = var3 - this.field243;
                }
            } else if (this.field243 > var3) {
                this.field251 = -1;
                if (this.field248 == 0 || this.field248 > this.field243 - var3) {
                    this.field248 = this.field243 - var3;
                }
            } else {
                this.field251 = 0;
            }

            return false;
        }
    }

    int vmethod1019() {
        int var1 = this.field241 * 3 >> 6;
        var1 = (var1 ^ var1 >> 31) + (var1 >>> 31);
        if (this.numLoops == 0) {
            var1 -= var1 * this.field239 / (((RawSound) super.sound).samples.length << 8);
        } else if (this.numLoops >= 0) {
            var1 -= var1 * this.start / ((RawSound) super.sound).samples.length;
        }

        return var1 > 255 ? 255 : var1;
    }

    static int method297(int var0, int var1) {
        return var1 < 0 ? var0 : (int) ((double) var0 * Math.sqrt((double) (16384 - var1) * 1.220703125E-4D) + 0.5D);
    }

    static int method255(int var0, int var1) {
        return var1 < 0 ? -var0 : (int) ((double) var0 * Math.sqrt((double) var1 * 1.220703125E-4D) + 0.5D);
    }

    public static RawPcmStream createRawPcmStream(RawSound var0, int var1, int var2) {
        return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0,
                (int) ((long) var0.sampleRate * 256L * (long) var1 / (long) (PcmPlayer.field201 * 100)), var2 << 6)
                : null;
    }

    public static RawPcmStream method294(RawSound var0, int var1, int var2, int var3) {
        return var0.samples != null && var0.samples.length != 0 ? new RawPcmStream(var0, var1, var2, var3) : null;
    }

    static int method277(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
            RawPcmStream var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        if ((var5 = var3 + var7 - var2) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2++] * var4) {
            var10001 = var3++;
        }

        var8.field239 = var2 << 8;
        return var3;
    }

    static int method278(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8,
            int var9, RawPcmStream var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        if ((var7 = var4 + var9 - var3) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.field239 = var3 << 8;
        return var4 >> 1;
    }

    static int method279(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7,
            RawPcmStream var8) {
        var2 >>= 8;
        var7 >>= 8;
        var4 <<= 2;
        if ((var5 = var3 + var2 - (var7 - 1)) > var6) {
            var5 = var6;
        }

        int var10001;
        for (var5 -= 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var10001 = var3++;
        }

        for (var5 += 3; var3 < var5; var1[var10001] += var0[var2--] * var4) {
            var10001 = var3++;
        }

        var8.field239 = var2 << 8;
        return var3;
    }

    static int method289(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8,
            int var9, RawPcmStream var10) {
        var3 >>= 8;
        var9 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        if ((var7 = var3 + var4 - (var9 - 1)) > var8) {
            var7 = var8;
        }

        var4 <<= 1;
        var7 <<= 1;

        int var10001;
        byte var11;
        for (var7 -= 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
            var2[var10001] += var11 * var6;
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        for (var7 += 6; var4 < var7; var2[var10001] += var11 * var6) {
            var11 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var11 * var5;
            var10001 = var4++;
        }

        var10.field239 = var3 << 8;
        return var4 >> 1;
    }

    static int method280(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, RawPcmStream var10, int var11, int var12) {
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 257) / var11) > var8) {
            var7 = var8;
        }

        byte var13;
        int var10001;
        while (var5 < var7) {
            var1 = var4 >> 8;
            var13 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1 + 1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4) - 1) / var11) > var8) {
            var7 = var8;
        }

        for (var1 = var12; var5 < var7; var4 += var11) {
            var13 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var1 - var13) * (var4 & 255)) * var6 >> 6;
        }

        var10.field239 = var4;
        return var5;
    }

    static int method281(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, RawPcmStream var11, int var12, int var13) {
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        byte var14;
        int var10001;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var0 = (var14 << 8) + (var4 & 255) * (var2[var1 + 1] - var14);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var0 = (var14 << 8) + (var1 - var14) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.field239 = var4;
        return var5 >> 1;
    }

    static int method282(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, RawPcmStream var10, int var11, int var12) {
        if (var11 == 0 || (var7 = var5 + (var11 + (var9 + 256 - var4)) / var11) > var8) {
            var7 = var8;
        }

        int var10001;
        while (var5 < var7) {
            var1 = var4 >> 8;
            byte var13 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var13 << 8) + (var2[var1] - var13) * (var4 & 255)) * var6 >> 6;
            var4 += var11;
        }

        if (var11 == 0 || (var7 = var5 + (var11 + (var9 - var4)) / var11) > var8) {
            var7 = var8;
        }

        var0 = var12;

        for (var1 = var11; var5 < var7; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
        }

        var10.field239 = var4;
        return var5;
    }

    static int method283(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, RawPcmStream var11, int var12, int var13) {
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var5 <<= 1;

        int var10001;
        for (var8 <<= 1; var5 < var8; var4 += var12) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var0 = (var2[var1] - var14) * (var4 & 255) + (var14 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        if (var12 == 0 || (var8 = (var5 >> 1) + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var8 <<= 1;

        for (var1 = var13; var5 < var8; var4 += var12) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
        }

        var11.field239 = var4;
        return var5 >> 1;
    }

    static int method290(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8,
            RawPcmStream var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        if ((var6 = var3 + var8 - var2) > var7) {
            var6 = var7;
        }

        var9.field242 += var9.field237 * (var6 - var3);
        var9.field243 += var9.field251 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2++] * var4;
        }

        var9.field241 = var4 >> 2;
        var9.field239 = var2 << 8;
        return var3;
    }

    static int method292(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, int var11, RawPcmStream var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        if ((var9 = var11 + var4 - var3) > var10) {
            var9 = var10;
        }

        var12.field241 += var12.field244 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3++];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.field242 = var5 >> 2;
        var12.field243 = var6 >> 2;
        var12.field239 = var3 << 8;
        return var4 >> 1;
    }

    static int method284(byte[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8,
            RawPcmStream var9) {
        var2 >>= 8;
        var8 >>= 8;
        var4 <<= 2;
        var5 <<= 2;
        if ((var6 = var3 + var2 - (var8 - 1)) > var7) {
            var6 = var7;
        }

        var9.field242 += var9.field237 * (var6 - var3);
        var9.field243 += var9.field251 * (var6 - var3);

        int var10001;
        for (var6 -= 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
            var4 += var5;
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        for (var6 += 3; var3 < var6; var4 += var5) {
            var10001 = var3++;
            var1[var10001] += var0[var2--] * var4;
        }

        var9.field241 = var4 >> 2;
        var9.field239 = var2 << 8;
        return var3;
    }

    static int method293(int var0, byte[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, int var11, RawPcmStream var12) {
        var3 >>= 8;
        var11 >>= 8;
        var5 <<= 2;
        var6 <<= 2;
        var7 <<= 2;
        var8 <<= 2;
        if ((var9 = var3 + var4 - (var11 - 1)) > var10) {
            var9 = var10;
        }

        var12.field241 += var12.field244 * (var9 - var4);
        var4 <<= 1;
        var9 <<= 1;

        byte var13;
        int var10001;
        for (var9 -= 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
            var6 += var8;
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        for (var9 += 6; var4 < var9; var6 += var8) {
            var13 = var1[var3--];
            var10001 = var4++;
            var2[var10001] += var13 * var5;
            var5 += var7;
            var10001 = var4++;
            var2[var10001] += var13 * var6;
        }

        var12.field242 = var5 >> 2;
        var12.field243 = var6 >> 2;
        var12.field239 = var3 << 8;
        return var4 >> 1;
    }

    static int method266(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, RawPcmStream var11, int var12, int var13) {
        var11.field242 -= var11.field237 * var5;
        var11.field243 -= var11.field251 * var5;
        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 257) / var12) > var9) {
            var8 = var9;
        }

        byte var14;
        int var10001;
        while (var5 < var8) {
            var1 = var4 >> 8;
            var14 = var2[var1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1 + 1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12 - 1) / var12) > var9) {
            var8 = var9;
        }

        for (var1 = var13; var5 < var8; var4 += var12) {
            var14 = var2[var4 >> 8];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var1 - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.field242 += var11.field237 * var5;
        var11.field243 += var11.field251 * var5;
        var11.field241 = var6;
        var11.field239 = var4;
        return var5;
    }

    static int method300(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
        var13.field241 -= var5 * var13.field244;
        if (var14 == 0 || (var10 = var5 + (var12 - var4 + var14 - 257) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        byte var16;
        int var10001;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            var16 = var2[var1];
            var0 = (var16 << 8) + (var4 & 255) * (var2[var1 + 1] - var16);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14 - 1) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var16 = var2[var4 >> 8];
            var0 = (var16 << 8) + (var1 - var16) * (var4 & 255);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.field241 += var13.field244 * var5;
        var13.field242 = var6;
        var13.field243 = var7;
        var13.field239 = var4;
        return var5;
    }

    static int method287(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, RawPcmStream var11, int var12, int var13) {
        var11.field242 -= var11.field237 * var5;
        var11.field243 -= var11.field251 * var5;
        if (var12 == 0 || (var8 = var5 + (var10 + 256 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        int var10001;
        while (var5 < var8) {
            var1 = var4 >> 8;
            byte var14 = var2[var1 - 1];
            var10001 = var5++;
            var3[var10001] += ((var14 << 8) + (var2[var1] - var14) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
            var4 += var12;
        }

        if (var12 == 0 || (var8 = var5 + (var10 - var4 + var12) / var12) > var9) {
            var8 = var9;
        }

        var0 = var13;

        for (var1 = var12; var5 < var8; var4 += var1) {
            var10001 = var5++;
            var3[var10001] += ((var0 << 8) + (var2[var4 >> 8] - var0) * (var4 & 255)) * var6 >> 6;
            var6 += var7;
        }

        var11.field242 += var11.field237 * var5;
        var11.field243 += var11.field251 * var5;
        var11.field241 = var6;
        var11.field239 = var4;
        return var5;
    }

    static int method288(int var0, int var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7, int var8,
            int var9, int var10, int var11, int var12, RawPcmStream var13, int var14, int var15) {
        var13.field241 -= var5 * var13.field244;
        if (var14 == 0 || (var10 = var5 + (var12 + 256 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var5 <<= 1;

        int var10001;
        for (var10 <<= 1; var5 < var10; var4 += var14) {
            var1 = var4 >> 8;
            byte var16 = var2[var1 - 1];
            var0 = (var2[var1] - var16) * (var4 & 255) + (var16 << 8);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        if (var14 == 0 || (var10 = (var5 >> 1) + (var12 - var4 + var14) / var14) > var11) {
            var10 = var11;
        }

        var10 <<= 1;

        for (var1 = var15; var5 < var10; var4 += var14) {
            var0 = (var1 << 8) + (var4 & 255) * (var2[var4 >> 8] - var1);
            var10001 = var5++;
            var3[var10001] += var0 * var6 >> 6;
            var6 += var8;
            var10001 = var5++;
            var3[var10001] += var0 * var7 >> 6;
            var7 += var9;
        }

        var5 >>= 1;
        var13.field241 += var13.field244 * var5;
        var13.field242 = var6;
        var13.field243 = var7;
        var13.field239 = var4;
        return var5;
    }
}
