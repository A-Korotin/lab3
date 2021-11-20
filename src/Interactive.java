// Интерфейс для субъекта взаимодействия

public interface Interactive {
    String getName();
}

class Tonnel implements Interactive {
    private final String name;

    TonnelAngle angle = TonnelAngle.flat;

    public Tonnel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String becomeSteep() {
        angle = TonnelAngle.steep;
        return "Наклон " + name + " стал силшком крутым";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((Tonnel) other).name) && angle == ((Tonnel) other).angle;
    }

    @Override
    public String toString() {
        return "Большой и страшный " + name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127 * angle.getCode();
    }

}

class Ice implements Interactive {
    private final String name;

    public Ice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((Ice) other).name);
    }

    @Override
    public String toString() {
        return name +". Холодный...";
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127;
    }
}

class Rope implements Interactive {
    private final String name;

    public Rope(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((Rope) other).name);
    }

    @Override
    public String toString() {
        return "Крепкая крутая " + name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127;
    }

}

class Belt implements Interactive {
    private final String name;

    public Belt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((Belt) other).name);
    }

    @Override
    public String toString() {
        return "Кожаный модный " + name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127;
    }
}

class NylonCordSkein implements Interactive {
    private final String name;

    public NylonCordSkein(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((NylonCordSkein) other).name);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127;
    }

}

class IceSteps implements Interactive {
    private final String name;

    public IceSteps(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(((IceSteps) other).name);
    }

    @Override
    public String toString() {
        return "Скользкие мокрые " + name;
    }

    @Override
    public int hashCode() {
        if (name == null)
            return 0;
        return name.hashCode() * 127;
    }

}
