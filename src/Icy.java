import java.util.ArrayList;

public interface Icy {
    String stand(Astronaut astronaut);
    String cut(Astronaut astronaut);
}

class Ice implements Icy {
    protected String name;
    protected ArrayList<Astronaut> standingAstronauts = new ArrayList<>();
    {
        name = "лёд";
    }

    public String stand(Astronaut astronaut) {
        standingAstronauts.add(astronaut);
        return astronaut.getName() + " стоит на " + name;
    }
    public String cut(Astronaut astronaut) {
        return astronaut.getName() + " вырубает ступени в " + name;
    }

    @Override
    public String toString() {
        return "Холодный " + name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Ice ice = (Ice) other;

        if(standingAstronauts.size() != ice.standingAstronauts.size())
            return false;

        int counter = 0;
        for(Astronaut a: standingAstronauts) {
            if(ice.standingAstronauts.contains(a))
                counter++;
        }

        return name.equals(ice.name) && counter == standingAstronauts.size();
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        for(Astronaut a: standingAstronauts)
            result += a.hashCode();
        return result;
    }
}
class IceSteps extends Ice{
    {
        name = "ледяные ступени";
    }

    @Override
    public String toString() {
        return name + ". Скользкие...";
    }

}
