public enum class86 implements class356 {

    field886(0, -1),

    field880(1, 2),

    field881(2, 3),

    field882(3, 4),

    field883(4, 5),

    field884(5, 6);

    static int field888;

    static int[] field879;

    final int field887;

    final int field885;

    class86(int var3, int var4) {
        this.field887 = var3;
        this.field885 = var4;
    }

    public int rsOrdinal() {
        return this.field885;
    }

    static final void method502(int var0) {
        var0 = Math.min(Math.max(var0, 0), 255);
        if (var0 != class20.clientPreferences.getCurrentMusicVolume()) {
            if (class20.clientPreferences.getCurrentMusicVolume() == 0 && Client.currentTrackGroupId != -1) {
                Message.method355(class399.archive6, Client.currentTrackGroupId, 0, var0, false);
                Client.playingJingle = false;
            } else if (var0 == 0) {
                FloorUnderlayDefinition.method1050();
                Client.playingJingle = false;
            } else {
                class220.method1232(var0);
            }

            class20.clientPreferences.setCurrentMusicVolume(var0);
        }

    }
}
