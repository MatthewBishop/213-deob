public class IgnoreList extends UserList {

    final LoginType field3706;

    public IgnoreList(LoginType var1) {
        super(400);
        this.field3706 = var1;
    }

    User newInstance() {
        return new Ignored();
    }

    User[] newTypedArray(int var1) {
        return new Ignored[var1];
    }

    public void read(Buffer var1, int var2) {
        while (var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            if (var3 == 4) {
                Username var4 = new Username(var1.readStringCp1252NullTerminated(), this.field3706);
                if (!var4.hasCleanName()) {
                    throw new IllegalStateException();
                }

                boolean var5 = false;
                World.friendSystem.removeIgnore(var4.getName(), var5);
            } else {
                boolean var9 = (var3 & 1) != 0;
                Username var10 = new Username(var1.readStringCp1252NullTerminated(), this.field3706);
                Username var6 = new Username(var1.readStringCp1252NullTerminated(), this.field3706);
                var1.readStringCp1252NullTerminated();
                if (!var10.hasCleanName()) {
                    throw new IllegalStateException();
                }

                Ignored var7 = (Ignored) this.getByCurrentUsername(var10);
                if (var9) {
                    Ignored var8 = (Ignored) this.getByCurrentUsername(var6);
                    if (var8 != null && var8 != var7) {
                        if (var7 != null) {
                            this.remove(var8);
                        } else {
                            var7 = var8;
                        }
                    }
                }

                if (var7 != null) {
                    this.changeName(var7, var10, var6);
                } else if (this.getSize() < 400) {
                    int var11 = this.getSize();
                    var7 = (Ignored) this.addLast(var10, var6);
                    var7.id = var11;
                }
            }
        }

    }
}
