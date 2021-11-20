// Интерфейс для действий, совершаемых одним астроноватом над другим
public interface SpecialAction {
    String preform(Astronaut object, Astronaut subject);
}

class OrderToCutStairs implements SpecialAction {

    public String preform(Astronaut object, Astronaut subject) {
        return object.name + " приказал " + subject.name + " вырубить ступеньки";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Приказ вырубить ступени";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class AttachEquipment implements SpecialAction {
    public String preform(Astronaut object, Astronaut subject) {
        return object.name + " прикрепил " + object.equipment.get(0).getName() + " к " +
                subject.equipment.get(0).getName() + " " + subject.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие прикрепления";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class OrderToDescend implements SpecialAction {

    public String preform(Astronaut object, Astronaut subject) {
        return object.name + " велел " + subject.name + " осторожно спускаться вниз";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Приказ к спуску";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class ExecuteOrderToDescent implements SpecialAction {

    public String preform(Astronaut object, Astronaut subject) {
        return object.name + " осторожно спускается вниз по приказу " + subject.name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие осторожно спускаться";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}
