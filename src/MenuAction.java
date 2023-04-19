public class MenuAction {

    static class473 HitSplatDefinition_cached;

    int param0;

    int param1;

    int opcode;

    int identifier;

    int itemId;

    String action;

    String target;

    static void method439(int var0, byte[] var1, ArchiveDisk var2) {
        ArchiveDiskAction var3 = new ArchiveDiskAction();
        var3.type = 0;
        var3.key = (long) var0;
        var3.data = var1;
        var3.archiveDisk = var2;
        NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
        synchronized (ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
            ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
        }

        class124.method741();
    }

    public static void method438(AbstractArchive var0, AbstractArchive var1) {
        NPCComposition.NpcDefinition_archive = var0;
        NPCComposition.field1559 = var1;
    }

    public static void method441(AbstractArchive var0) {
        VarbitComposition.VarbitDefinition_archive = var0;
    }

    public static boolean isAlphaNumeric(char var0) {
        return var0 >= '0' && var0 <= '9' || var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
    }

    public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
        SceneTilePaint.insertMenuItem(var0, var1, var2, var3, var4, var5, -1, false);
    }
}
