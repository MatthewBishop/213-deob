public class class385 {

    int field3652;

    int field3654;

    int field3653;

    int field3651;

    public String toString() {
        boolean var1 = true;
        int var2 = 10 - Integer.toString(this.field3652).length();
        int var3 = 10 - Integer.toString(this.field3653).length();
        int var4 = 10 - Integer.toString(this.field3654).length();
        String var5 = "          ".substring(10 - var2);
        String var6 = "          ".substring(10 - var3);
        String var7 = "          ".substring(10 - var4);
        return "    Size: " + this.field3652 + var5 + "Created: " + this.field3654 + var7 + "Total used: "
                + this.field3653 + var6 + "Max-In-Use: " + this.field3651;
    }
}
