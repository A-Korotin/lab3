import java.util.ArrayList;

public class Story {
    public static void main(String[] args) {
        Tonnel tonnel = new Tonnel();
        Znayka znayka = new Znayka();
        Steklyashkin steklyashkin = new Steklyashkin();
        ArrayList<Astronaut> companions = new ArrayList<>();
        companions.add(new Companion("Кубик"));
        companions.add(new Companion("Тюбик"));
        companions.add(new Companion("Звездочкин"));
        Ice surface = new Ice();

        MessageHandler.logMessage(tonnel.becomeSteep());
        MessageHandler.logMessage(znayka.descent(tonnel));
        for(Astronaut companion: companions)
            MessageHandler.logMessage(znayka.orderToCutTheSteps(companion, surface));

        surface = new IceSteps();

        MessageHandler.logMessage(znayka.bondSkeins());
        MessageHandler.logMessage(znayka.getEquipment(0).attachTo(steklyashkin.getEquipment(0)));
        MessageHandler.logMessage(znayka.orderToDescent(steklyashkin));
        for(Astronaut companion: companions)
            MessageHandler.logMessage(surface.stand(companion));

        Equipment rope = znayka.getEquipment(0);
        for(Astronaut companion: companions)
            MessageHandler.logMessage(companion.equip(rope));

        for (Astronaut companion: companions) {
            MessageHandler.logMessage(companion.lowerRope());
            MessageHandler.logMessage(companion.checkEquipment(rope));
        }

        MessageHandler.getAllMessages();
    }
}