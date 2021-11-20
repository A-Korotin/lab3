import java.util.ArrayList;

// Интерфейс для действий, совершаемых астроновтом самим над собой
public interface SelfAction {
    String preform(Astronaut astronaut);
}

class TieSkeins implements SelfAction {
    public String preform(Astronaut astronaut) {
        StringBuilder msg = new StringBuilder();
        ArrayList<Interactive> skeins = new ArrayList<>();
        for(Interactive skein: astronaut.equipment) {
            if (skein instanceof NylonCordSkein) {
                msg.append(astronaut.act(new TieSkein(), skein)).append(". ");
                skeins.add(skein);
            }

        }
        Rope rope = new Rope("длинная веревка");
        if (skeins.size() != 0)
            astronaut.equipment.add(rope);

        astronaut.equipment.removeAll(skeins);

        return skeins.size() != 0 ? (msg.append("Получилась ").append(rope.getName())).toString() :
                "У " + astronaut.name + " мотков не оказалось, веревки не будет...";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие связать мотки";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}
