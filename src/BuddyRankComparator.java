public class BuddyRankComparator extends AbstractUserComparator {

    final boolean reversed;

    public BuddyRankComparator(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (var2.rank != var1.rank) {
            return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
        } else {
            return this.compareUser(var1, var2);
        }
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }

    static long method710(int var0, int var1, int var2) {
        return (long) (var2 << 16 | var0 << 8 | var1);
    }

    public static void method709(AbstractArchive var0, AbstractArchive var1) {
        SpotAnimationDefinition.SpotAnimationDefinition_archive = var0;
        SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var1;
    }

    static int method707(int var0) {
        Message var1 = (Message) Messages.Messages_hashTable.get((long) var0);
        if (var1 == null) {
            return -1;
        } else {
            return var1.nextDual == Messages.Messages_queue.sentinel ? -1 : ((Message) var1.nextDual).count;
        }
    }

    public static String method711(String var0) {
        int var1 = var0.length();
        char[] var2 = new char[var1];
        byte var3 = 2;

        for (int var4 = 0; var4 < var1; ++var4) {
            char var5 = var0.charAt(var4);
            if (var3 == 0) {
                var5 = Character.toLowerCase(var5);
            } else if (var3 == 2 || Character.isUpperCase(var5)) {
                var5 = WorldMapSectionType.method1507(var5);
            }

            if (Character.isLetter(var5)) {
                var3 = 0;
            } else if (var5 != '.' && var5 != '?' && var5 != '!') {
                if (Character.isSpaceChar(var5)) {
                    if (var3 != 2) {
                        var3 = 1;
                    }
                } else {
                    var3 = 1;
                }
            } else {
                var3 = 2;
            }

            var2[var4] = var5;
        }

        return new String(var2);
    }

    public static int method712(int var0) {
        if (var0 > 0) {
            return 1;
        } else {
            return var0 < 0 ? -1 : 0;
        }
    }
}
