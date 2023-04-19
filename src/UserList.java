import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public abstract class UserList {

    final int capacity;

    int size = 0;

    User[] array;

    HashMap usernamesMap;

    HashMap previousUsernamesMap;

    Comparator comparator = null;

    UserList(int var1) {
        this.capacity = var1;
        this.array = this.newTypedArray(var1);
        this.usernamesMap = new HashMap(var1 / 8);
        this.previousUsernamesMap = new HashMap(var1 / 8);
    }

    abstract User newInstance();

    abstract User[] newTypedArray(int var1);

    public void clear() {
        this.size = 0;
        Arrays.fill(this.array, (Object) null);
        this.usernamesMap.clear();
        this.previousUsernamesMap.clear();
    }

    public int getSize() {
        return this.size;
    }

    public boolean isFull() {
        return this.capacity == this.size;
    }

    public boolean contains(Username var1) {
        if (!var1.hasCleanName()) {
            return false;
        } else {
            return this.usernamesMap.containsKey(var1) ? true : this.previousUsernamesMap.containsKey(var1);
        }
    }

    public User getByUsername(Username var1) {
        User var2 = this.getByCurrentUsername(var1);
        return var2 != null ? var2 : this.getByPreviousUsername(var1);
    }

    User getByCurrentUsername(Username var1) {
        return !var1.hasCleanName() ? null : (User) this.usernamesMap.get(var1);
    }

    User getByPreviousUsername(Username var1) {
        return !var1.hasCleanName() ? null : (User) this.previousUsernamesMap.get(var1);
    }

    public final boolean removeByUsername(Username var1) {
        User var2 = this.getByCurrentUsername(var1);
        if (var2 == null) {
            return false;
        } else {
            this.remove(var2);
            return true;
        }
    }

    final void remove(User var1) {
        int var2 = this.indexOf(var1);
        if (var2 != -1) {
            this.arrayRemove(var2);
            this.mapRemove(var1);
        }
    }

    User addLastNoPreviousUsername(Username var1) {
        return this.addLast(var1, (Username) null);
    }

    User addLast(Username var1, Username var2) {
        if (this.getByCurrentUsername(var1) != null) {
            throw new IllegalStateException();
        } else {
            User var3 = this.newInstance();
            var3.set(var1, var2);
            this.arrayAddLast(var3);
            this.mapPut(var3);
            return var3;
        }
    }

    public final User get(int var1) {
        if (var1 >= 0 && var1 < this.size) {
            return this.array[var1];
        } else {
            throw new ArrayIndexOutOfBoundsException(var1);
        }
    }

    public final void sort() {
        if (this.comparator == null) {
            Arrays.sort(this.array, 0, this.size);
        } else {
            Arrays.sort(this.array, 0, this.size, this.comparator);
        }

    }

    final void changeName(User var1, Username var2, Username var3) {
        this.mapRemove(var1);
        var1.set(var2, var3);
        this.mapPut(var1);
    }

    final int indexOf(User var1) {
        for (int var2 = 0; var2 < this.size; ++var2) {
            if (this.array[var2] == var1) {
                return var2;
            }
        }

        return -1;
    }

    final void mapRemove(User var1) {
        if (this.usernamesMap.remove(var1.username) == null) {
            throw new IllegalStateException();
        } else {
            if (var1.previousUsername != null) {
                this.previousUsernamesMap.remove(var1.previousUsername);
            }

        }
    }

    final void arrayAddLast(User var1) {
        this.array[++this.size - 1] = var1;
    }

    final void mapPut(User var1) {
        this.usernamesMap.put(var1.username, var1);
        if (var1.previousUsername != null) {
            User var2 = (User) this.previousUsernamesMap.put(var1.previousUsername, var1);
            if (var2 != null && var2 != var1) {
                var2.previousUsername = null;
            }
        }

    }

    final void arrayRemove(int var1) {
        --this.size;
        if (var1 < this.size) {
            System.arraycopy(this.array, var1 + 1, this.array, var1, this.size - var1);
        }

    }

    public final void removeComparator() {
        this.comparator = null;
    }

    public final void addComparator(Comparator var1) {
        if (this.comparator == null) {
            this.comparator = var1;
        } else if (this.comparator instanceof AbstractUserComparator) {
            ((AbstractUserComparator) this.comparator).addComparator(var1);
        }

    }
}
