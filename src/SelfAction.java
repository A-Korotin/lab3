// Интерфейс для действий, совершаемых астроновтом самим над собой
public interface SelfAction {
    String preform(Astronaut astronaut);
}

class TieSkeins implements SelfAction {
    public String preform(Astronaut astronaut) {
        StringBuilder msg = new StringBuilder();
        for(Interactive skein: astronaut.equipment) {
            msg.append(astronaut.act(new TieSkein(), skein)).append(". ");
        }
        astronaut.equipment.clear();
        Rope rope = new Rope("длинная веревка");
        astronaut.equipment.add(rope);
        return (msg.append("Получилась ").append(rope.getName())).toString();
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
