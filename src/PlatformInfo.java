public class PlatformInfo extends Node {

    int field3876;

    boolean field3853;

    int field3854;

    int field3855;

    int field3856;

    int field3871;

    int field3858;

    boolean field3863;

    int field3877;

    int field3870;

    int field3852;

    int field3857;

    String field3865;

    String field3866;

    String field3867;

    String field3868;

    int field3864;

    int field3869;

    int field3862;

    int field3859;

    String field3872;

    String field3861;

    int[] field3873 = new int[3];

    int field3875;

    String field3860;

    String field3874;

    PlatformInfo(int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, boolean var8, int var9,
            int var10, int var11, int var12, String var13, String var14, String var15, String var16, int var17,
            int var18, int var19, int var20, String var21, String var22, int[] var23, int var24, String var25,
            String var26) {
        this.field3876 = var1;
        this.field3853 = var2;
        this.field3854 = var3;
        this.field3855 = var4;
        this.field3856 = var5;
        this.field3871 = var6;
        this.field3858 = var7;
        this.field3863 = var8;
        this.field3877 = var9;
        this.field3870 = var10;
        this.field3852 = var11;
        this.field3857 = var12;
        this.field3865 = var13;
        this.field3866 = var14;
        this.field3867 = var15;
        this.field3868 = var16;
        this.field3864 = var17;
        this.field3869 = var18;
        this.field3862 = var19;
        this.field3859 = var20;
        this.field3872 = var21;
        this.field3861 = var22;
        this.field3873 = var23;
        this.field3875 = var24;
        this.field3860 = var25;
        this.field3874 = var26;
    }

    public void write(Buffer var1) {
        var1.writeByte(9);
        var1.writeByte(this.field3876);
        var1.writeByte(this.field3853 ? 1 : 0);
        var1.writeShort(this.field3854);
        var1.writeByte(this.field3855);
        var1.writeByte(this.field3856);
        var1.writeByte(this.field3871);
        var1.writeByte(this.field3858);
        var1.writeByte(this.field3863 ? 1 : 0);
        var1.writeShort(this.field3877);
        var1.writeByte(this.field3870);
        var1.writeMedium(this.field3852);
        var1.writeShort(this.field3857);
        var1.writeStringCp1252NullCircumfixed(this.field3865);
        var1.writeStringCp1252NullCircumfixed(this.field3866);
        var1.writeStringCp1252NullCircumfixed(this.field3867);
        var1.writeStringCp1252NullCircumfixed(this.field3868);
        var1.writeByte(this.field3869);
        var1.writeShort(this.field3864);
        var1.writeStringCp1252NullCircumfixed(this.field3872);
        var1.writeStringCp1252NullCircumfixed(this.field3861);
        var1.writeByte(this.field3862);
        var1.writeByte(this.field3859);

        for (int var2 = 0; var2 < this.field3873.length; ++var2) {
            var1.writeInt(this.field3873[var2]);
        }

        var1.writeInt(this.field3875);
        var1.writeStringCp1252NullCircumfixed(this.field3860);
        var1.writeStringCp1252NullCircumfixed(this.field3874);
    }

    public int size() {
        byte var1 = 39;
        int var2 = var1 + ObjTypeCustomisation.method971(this.field3865);
        var2 += ObjTypeCustomisation.method971(this.field3866);
        var2 += ObjTypeCustomisation.method971(this.field3867);
        var2 += ObjTypeCustomisation.method971(this.field3868);
        var2 += ObjTypeCustomisation.method971(this.field3872);
        var2 += ObjTypeCustomisation.method971(this.field3861);
        var2 += ObjTypeCustomisation.method971(this.field3860);
        var2 += ObjTypeCustomisation.method971(this.field3874);
        return var2;
    }
}
