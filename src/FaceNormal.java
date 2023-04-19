public class FaceNormal {

    int x;

    int y;

    int z;

    public static int method1294(int var0) {
        long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
        int var1 = (int) (var2 >>> 0 & 127L);
        return var1;
    }

    static World worldListStart() {
        World.World_listCount = 0;
        return Interpreter.getNextWorldListWorld();
    }

    public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
        long var5 = (long) ((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14)
                | ((long) var4 & 4294967295L) << 17;
        if (var3) {
            var5 |= 65536L;
        }

        return var5;
    }

    static int Messages_getLastChatID(int var0) {
        Message var1 = (Message) Messages.Messages_hashTable.get((long) var0);
        if (var1 == null) {
            return -1;
        } else {
            return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message) var1.previousDual).count;
        }
    }
}
