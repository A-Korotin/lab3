public class Tonnel {
    private final String name;

    private TonnelAngle angle = TonnelAngle.flat;

    public TonnelAngle checkAngle() {
        return angle;
    }

    public String becomeSteep() {
        angle = TonnelAngle.steep;
        return name + " стал слишком крутым";
    }

    {
        name = "Тоннель";
    }

    @Override
    public String toString() {
        return "Большой и страшный " + name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Tonnel tonnel = (Tonnel) other;

        return name.equals(tonnel.name) && angle == tonnel.angle;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result += angle.getId();
        return result;
    }
}

enum TonnelAngle {
    steep(1), flat(2);

    private int id;

    TonnelAngle(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
