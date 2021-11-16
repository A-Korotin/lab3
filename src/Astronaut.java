import java.util.ArrayList;

public abstract class Astronaut {
    protected String name;
    protected ArrayList<Interactive> equipment = new ArrayList<>();

    protected String act(Action action, Interactive interactive) {
        return action.preform(this, interactive);
    }

    public Interactive getEquipment(int index) {
        return equipment.get(index);
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
        int result = name == null ? 0 : name.hashCode();

        for(Interactive i: equipment)
            result *= i.hashCode() * 53;

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


    public String tieSkeins() {
        StringBuilder msg = new StringBuilder();
        for(Interactive skein: equipment) {
            msg.append(act(new TieSkein(), skein)).append(". ");
        }
        equipment.clear();
        Rope rope = new Rope("длинная веревка");
        equipment.add(rope);
        return (msg.append("Получилась ").append(rope.getName())).toString();
    }

    public String attachRope(Steklyashkin steklyashkin) {
        return act(new AttachRope(), equipment.get(0)) + " к " + steklyashkin.equipment.get(0).getName();
    }

}

class Steklyashkin extends Astronaut {
    {
        name = "Стекляшкин";
    }

    public Steklyashkin() {
        equipment.add(new Belt("пояс " + name));
    }

}

class Companion extends Astronaut {

    public Companion(String name) {
        this.name = name;
    }

}
