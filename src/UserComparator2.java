import java.util.Comparator;

public class UserComparator2 implements Comparator {

    final boolean reversed;

    public UserComparator2(boolean var1) {
        this.reversed = var1;
    }

    int compare_bridged(User var1, User var2) {
        return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername())
                : var2.getUsername().compareToTyped(var1.getUsername());
    }

    public int compare(Object var1, Object var2) {
        return this.compare_bridged((User) var1, (User) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
