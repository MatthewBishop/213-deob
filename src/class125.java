public class class125 {

    static int cameraYaw;

    boolean field1231;

    boolean field1216;

    class123 field1220;

    class123 field1236;

    class120[] field1219;

    boolean field1217;

    float field1221;

    float field1229;

    float field1223;

    float field1224;

    float field1237;

    float field1226;

    float field1227;

    float field1228;

    float field1225;

    float field1230;

    boolean field1232 = true;

    int field1222 = 0;

    float[] field1233;

    int field1234;

    int field1235;

    float field1215;

    float field1218;

    int method743(Buffer var1, int var2) {
        int var3 = var1.readUnsignedShort();
        class160.method904(var1.readUnsignedByte());
        this.field1220 = LoginScreenAnimation.method552(var1.readUnsignedByte());
        this.field1236 = LoginScreenAnimation.method552(var1.readUnsignedByte());
        this.field1231 = var1.readUnsignedByte() != 0;
        this.field1219 = new class120[var3];
        class120 var4 = null;

        for (int var5 = 0; var5 < var3; ++var5) {
            class120 var6 = new class120();
            var6.method717(var1, var2);
            this.field1219[var5] = var6;
            if (var4 != null) {
                var4.field1177 = var6;
            }

            var4 = var6;
        }

        return var3;
    }

    void method750() {
        this.field1234 = this.field1219[0].field1175;
        this.field1235 = this.field1219[this.method748() - 1].field1175;
        this.field1233 = new float[this.method749() + 1];

        for (int var1 = this.method745(); var1 <= this.method751(); ++var1) {
            this.field1233[var1 - this.method745()] = GrandExchangeEvent.method1923(this, (float) var1);
        }

        this.field1219 = null;
        this.field1215 = GrandExchangeEvent.method1923(this, (float) (this.method745() - 1));
        this.field1218 = GrandExchangeEvent.method1923(this, (float) (this.method751() + 1));
    }

    public float method744(int var1) {
        if (var1 < this.method745()) {
            return this.field1215;
        } else {
            return var1 > this.method751() ? this.field1218 : this.field1233[var1 - this.method745()];
        }
    }

    int method745() {
        return this.field1234;
    }

    int method751() {
        return this.field1235;
    }

    int method749() {
        return this.method751() - this.method745();
    }

    int method746(float var1) {
        if (this.field1222 < 0 || (float) this.field1219[this.field1222].field1175 > var1
                || this.field1219[this.field1222].field1177 != null
                        && (float) this.field1219[this.field1222].field1177.field1175 <= var1) {
            if (var1 >= (float) this.method745() && var1 <= (float) this.method751()) {
                int var2 = this.method748();
                int var3 = this.field1222;
                if (var2 > 0) {
                    int var4 = 0;
                    int var5 = var2 - 1;

                    do {
                        int var6 = var4 + var5 >> 1;
                        if (var1 < (float) this.field1219[var6].field1175) {
                            if (var1 > (float) this.field1219[var6 - 1].field1175) {
                                var3 = var6 - 1;
                                break;
                            }

                            var5 = var6 - 1;
                        } else {
                            if (var1 <= (float) this.field1219[var6].field1175) {
                                var3 = var6;
                                break;
                            }

                            if (var1 < (float) this.field1219[var6 + 1].field1175) {
                                var3 = var6;
                                break;
                            }

                            var4 = var6 + 1;
                        }
                    } while (var4 <= var5);
                }

                if (var3 != this.field1222) {
                    this.field1222 = var3;
                    this.field1232 = true;
                }

                return this.field1222;
            } else {
                return -1;
            }
        } else {
            return this.field1222;
        }
    }

    class120 method747(float var1) {
        int var2 = this.method746(var1);
        return var2 >= 0 && var2 < this.field1219.length ? this.field1219[var2] : null;
    }

    int method748() {
        return this.field1219 == null ? 0 : this.field1219.length;
    }

    public static DbRowType getDbRowType(int var0) {
        DbRowType var1 = (DbRowType) DbRowType.DBRowType_cache.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = DbRowType.field4040.takeFile(38, var0);
            var1 = new DbRowType();
            if (var2 != null) {
                var1.method2449(new Buffer(var2));
            }

            var1.method2450();
            DbRowType.DBRowType_cache.put(var1, (long) var0);
            return var1;
        }
    }
}
