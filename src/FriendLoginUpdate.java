public class FriendLoginUpdate extends Link {

    public int field3722 = (int) (class96.clockNow() / 1000L);

    public Username friendUsername;

    public short worldId;

    FriendLoginUpdate(Username var1, int var2) {
        this.friendUsername = var1;
        this.worldId = (short) var2;
    }
}
