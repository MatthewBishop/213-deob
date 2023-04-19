public class GameBuild {

    static final GameBuild LIVE = new GameBuild("LIVE", 0);

    static final GameBuild BUILDLIVE = new GameBuild("BUILDLIVE", 3);

    static final GameBuild RC = new GameBuild("RC", 1);

    static final GameBuild WIP = new GameBuild("WIP", 2);

    static Archive archive7;

    public final String name;

    final int buildId;

    GameBuild(String var1, int var2) {
        this.name = var1;
        this.buildId = var2;
    }

    public static DbTableType getDbTableType(int var0) {
        DbTableType var1 = (DbTableType) DbTableType.DBTableType_cache.get((long) var0);
        if (var1 != null) {
            return var1;
        } else {
            byte[] var2 = DbTableType.field4036.takeFile(39, var0);
            var1 = new DbTableType();
            if (var2 != null) {
                var1.method2444(new Buffer(var2));
            }

            var1.method2446();
            DbTableType.DBTableType_cache.put(var1, (long) var0);
            return var1;
        }
    }

    static final int method1847(int var0, int var1, int var2) {
        if (var2 > 179) {
            var1 /= 2;
        }

        if (var2 > 192) {
            var1 /= 2;
        }

        if (var2 > 217) {
            var1 /= 2;
        }

        if (var2 > 243) {
            var1 /= 2;
        }

        int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
        return var3;
    }
}
