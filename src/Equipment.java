import java.util.ArrayList;

public interface Equipment {
    ArrayList<Equipment> attachedTo = new ArrayList<>();
    String getName();
    String attachTo(Equipment other);
}

class Rope implements Equipment{
    private final ArrayList<NylonCordSkein> skeins = new ArrayList<>();

    private final String name;

    public Rope(ArrayList<NylonCordSkein> skeins) {
        this.skeins.addAll(skeins);
    }


    public String getName() {
        return name;
    }

    public String attachTo(Equipment other) {
        this.attachedTo.add(other);
        return "Конец " + name + " теперь привязан к " + other.getName();
    }

    {
        name = "длинная веревка";
    }

    @Override
    public String toString() {
        return "Крутая красивая " + name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Rope rope = (Rope) other;
        if (skeins.size() != rope.skeins.size())
            return false;

        int counter = 0;
        for(NylonCordSkein s1: skeins) {
            if(rope.skeins.contains(s1))
                counter++;
        }

        return name.equals(rope.name) && counter == skeins.size();
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        for(NylonCordSkein s: skeins)
            result += s.hashCode();
        return result;
    }
}

class Belt implements Equipment {

    private final String name;

    public String attachTo(Equipment other) {
        this.attachedTo.add(other);
        return "конец " + name + " теперь прикреплен к " + other.getName();
    }

    public String getName() {
        return name;
    }

    {
        name = "пояс";
    }

    @Override
    public String toString() {
        return "Красивый кожаный " + name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Belt belt = (Belt) other;
        return name.equals(belt.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode() * 101;
    }
}

class NylonCordSkein implements Equipment {
    private final String name;

    public String attachTo(Equipment other) {
        this.attachedTo.add(other);
        return name + " теперь прикреплен к " + other.getName();
    }

    public NylonCordSkein(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public static Rope bond(ArrayList<NylonCordSkein> skeins) {
        return new Rope(skeins);
    }

    @Override
    public String toString() {
        return "Моточек. Называется " + name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        NylonCordSkein skein = (NylonCordSkein) other;
        return name.equals(skein.name);
    }

    @Override
    public int hashCode() {
        return name == null ? 0 : name.hashCode() * 101;
    }
}