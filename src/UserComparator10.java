public class UserComparator10 extends AbstractUserComparator {

    static PlatformInfo platformInfo;

    final boolean reversed;

    public UserComparator10(boolean var1) {
        this.reversed = var1;
    }

    int compareBuddy(Buddy var1, Buddy var2) {
        if (Client.worldId == var1.world && var2.world == Client.worldId) {
            return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
        } else {
            return this.compareUser(var1, var2);
        }
    }

    public int compare(Object var1, Object var2) {
        return this.compareBuddy((Buddy) var1, (Buddy) var2);
    }
}
