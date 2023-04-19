public class World {

    public static FriendSystem friendSystem;

    static int World_count = 0;

    static int World_listCount = 0;

    static int[] World_sortOption2 = new int[] { 1, 1, 1, 1 };

    static int[] World_sortOption1 = new int[] { 0, 1, 2, 3 };

    static IndexedSprite[] worldSelectStars;

    int id;

    int properties;

    int population;

    String host;

    String activity;

    int location;

    int index;

    boolean isMembersOnly() {
        return (1 & this.properties) != 0;
    }

    boolean isDeadman() {
        return (65536 & this.properties) != 0;
    }

    boolean method408() {
        return (2 & this.properties) != 0;
    }

    boolean isPvp() {
        return (4 & this.properties) != 0;
    }

    boolean method402() {
        return (8 & this.properties) != 0;
    }

    boolean method407() {
        return (536870912 & this.properties) != 0;
    }

    boolean isBeta() {
        return (33554432 & this.properties) != 0;
    }

    boolean method404() {
        return (1073741824 & this.properties) != 0;
    }

    boolean method405() {
        return (256 & this.properties) != 0;
    }

    boolean method406() {
        return (134217728 & this.properties) != 0;
    }

    public static void method409(AbstractArchive var0) {
        FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var0;
    }

    static int Messages_getHistorySize(int var0) {
        ChatChannel var1 = (ChatChannel) Messages.Messages_channels.get(var0);
        return var1 == null ? 0 : var1.size();
    }
}
