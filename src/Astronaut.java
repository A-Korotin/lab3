import java.util.ArrayList;

public abstract class Astronaut {
    protected String name;
    protected ArrayList<Interactive> equipment = new ArrayList<>();

    public String act(Action action, Interactive interactive) {
        return action.preform(this, interactive);
    }

    public String act(SpecialAction action, Astronaut subject) {
        return action.preform(this, subject);
    }

    public String act(SelfAction action) {
        return action.preform(this);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Astronaut astronaut = (Astronaut) other;

        if (equipment.size() != astronaut.equipment.size())
            return false;

        int counter = 0;
        for(Interactive i: equipment) {
            if(astronaut.equipment.contains(i))
                ++counter;
        }
        return name.equals(astronaut.name) && counter == equipment.size();
    }

    @Override
    public String toString() {
        return "Астронавт " + name;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();

        for(Interactive i: equipment)
            result *= i.hashCode() * 127;

        return result;
    }
}

class Znayka extends Astronaut {
    {
        name = "Знайка";
    }

    public Znayka() {
        equipment.add(new NylonCordSkein("моток"));
        equipment.add(new NylonCordSkein("моточек поменьше"));
        equipment.add(new NylonCordSkein("самый маленький моток"));
    }

}

class Steklyashkin extends Astronaut {
    {
        name = "Стекляшкин";
    }

    public Steklyashkin() {
        equipment.add(new Belt("пояс"));
    }

}

class Companion extends Astronaut {

    public Companion(String name){
        // this.name = Objects.requireNotNullElse(name, "NoName");

        if (name == null)
            this.name = "NoName";
        else
            this.name = name;
    }

}
