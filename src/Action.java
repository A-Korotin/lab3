// Интерфейс для действий, совершаемых астронавтом над предметом

public interface Action {
    String preform(Astronaut astronaut, Interactive interactive);
}

class CheckAngle implements Action {

    public String preform(Astronaut astronaut, Interactive interactive) {
        Tonnel tonnel = (Tonnel) interactive;
        return tonnel.angle == TonnelAngle.steep ? astronaut.name + " побоялся продолжить спуск" :
                                                   astronaut.name + " продолжил спуск";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие проверить наклон тоннеля";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class CutStairs implements Action {

    public String preform(Astronaut astronaut, Interactive interactive) {
        return astronaut.name + " вырубает ступеньки в " + interactive.getName();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие вырубить ступени";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}


class TieSkein implements Action {

    public String preform(Astronaut astronaut, Interactive interactive) {
        return astronaut.name + " связывает " + interactive.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие связать мотки между собой";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class Stand implements Action {
    public String preform(Astronaut astronaut, Interactive interactive) {
        return astronaut.name + " стоит на " + interactive.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие стоять";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class LowerRope implements Action {
    public String preform(Astronaut astronaut, Interactive interactive) {
        return astronaut.name + " постепенно опускает " + interactive.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие постепенно опускать верёвку";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}

class SuperviseRope implements Action {
    public String preform(Astronaut astronaut, Interactive interactive) {
        return astronaut.name + " внимательно следит, чтобы " + interactive.getName() + " не выскользнула из ручонок";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Действие внимательно следить за верёвкой";
    }

    @Override
    public int hashCode() {
        return this.getClass().getSimpleName().hashCode() * 127;
    }
}
