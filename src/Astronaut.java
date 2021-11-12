import java.util.ArrayList;

public abstract class Astronaut {
    protected final ArrayList<Equipment> equipment = new ArrayList<>();
    protected String name;

    public String getName() {
        return name;
    }
    public String cut(Ice surface) {
        return surface.cut(this);
    }

    public Equipment getEquipment(int index) {
        return equipment.get(index);
    }

    public String equip(Equipment equipment) {
        this.equipment.add(equipment);
        return name + " теперь держит в руках " + equipment.getName();
    }

    public String lowerRope() {
        return name + " постепенно опускает веревку";
    }

    public String checkEquipment(Equipment equipment) {
        String statement = name + " тщательно следит за " + equipment.getName() + ". ";
        for (Equipment e: this.equipment)
        {
            if (e.equals(equipment))
                return statement + equipment.getName() + " все еще в руках " + name;
        }
        return  statement + name + " выпустил из рук " + equipment.getName() + ". Болван...";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Astronaut astronaut = (Astronaut) other;

        if (equipment.size() != astronaut.equipment.size())
            return false;

        int counter = 0;
        for(Equipment e: equipment) {
            if(astronaut.equipment.contains(e))
                counter++;
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

        for (Equipment e: equipment)
            result += e.hashCode();

        return result;
    }
}

class Znayka extends Astronaut {
    private final ArrayList<NylonCordSkein> skeins = new ArrayList<>();
    public Znayka() {
        this.skeins.add(new NylonCordSkein("один моток"));
        this.skeins.add(new NylonCordSkein("другой моток"));
        this.skeins.add(new NylonCordSkein("последний моток"));
    }

    public String descent(Tonnel tonnel) {
        return tonnel.checkAngle() == TonnelAngle.flat ? name + " продолжает спуск" :
                name + " побоялся продолжить спуск";
    }

    public String orderToCutTheSteps(Astronaut astronaut, Ice surface) {
        return astronaut.cut(surface) + " по приказу " + name;
    }

    public String orderToDescent(Steklyashkin steklyashkin) {
        return steklyashkin.executeOrderToDescent(this);
    }

    public String bondSkeins()
    {
        this.equipment.add(NylonCordSkein.bond(skeins));

        return name + " связал между собой мотки шнура и получил " + equipment.get(0).getName();
    }

    {
        name = "Знайка";
    }
}

class Steklyashkin extends Astronaut {

    public Steklyashkin()
    {
        name = "Стекляшкин";
        equipment.add(new Belt());
    }

    public String executeOrderToDescent(Astronaut astronaut) {
        return name + " осторожно спускается вниз по приказу " + astronaut.getName();
    }

}

class Companion extends Astronaut {
    public Companion(String name) {
        this.name = name;
    }
}

