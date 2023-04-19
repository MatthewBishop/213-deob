public class UserComparator5 extends AbstractUserComparator {

    static FriendsChat friendsChat;

    final boolean reversed;

    public UserComparator5(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (var1.world != 0) {
            if (var2.world == 0) {
                return this.reversed ? -1 : 1;
            }
        } else if (var2.world != 0) {
            return this.reversed ? 1 : -1;
        }

        return this.compareUser(var1, var2);
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }

    static void addGameMessage(int var0, String var1, String var2) {
        class136.addChatMessage(var0, var1, var2, (String) null);
    }

    static void method696(Archive var0, String var1) {
        ArchiveLoader var2 = new ArchiveLoader(var0, var1);
        Client.archiveLoaders.add(var2);
        Client.field397 += var2.groupCount;
    }
}
