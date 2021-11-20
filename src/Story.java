import java.util.ArrayList;

public class Story {
    public static void main(String[] args) {
        Znayka znayka = new Znayka();
        Steklyashkin steklyashkin = new Steklyashkin();

        ArrayList<Companion> companions = new ArrayList<>();
        companions.add(new Companion("Кубик"));
        companions.add(new Companion("Звёздочкин"));
        companions.add(new Companion("Тюбик"));

        Tonnel tonnel = new Tonnel("тоннель");
        Ice ice = new Ice("лёд");
        IceSteps iceSteps = new IceSteps("ледяные ступеньки");

        MessageHandler.logMessage(tonnel.becomeSteep());
        MessageHandler.logMessage(znayka.act(new CheckAngle(), tonnel));

        for(Companion c: companions) {
            MessageHandler.logMessage(znayka.act(new OrderToCutStairs(), c));
            MessageHandler.logMessage(c.act(new CutStairs(), ice));
        }

        MessageHandler.logMessage(znayka.act(new TieSkeins()));
        MessageHandler.logMessage(znayka.act(new AttachEquipment(), steklyashkin));

        MessageHandler.logMessage(znayka.act(new OrderToDescend(), steklyashkin));
        MessageHandler.logMessage(steklyashkin.act(new ExecuteOrderToDescent(), znayka));

        for(Companion c: companions)
            MessageHandler.logMessage(c.act(new Stand(), iceSteps));

        Interactive rope = znayka.equipment.get(0);

        for(Companion c: companions) {
            c.equipment.add(rope);
            MessageHandler.logMessage(c.act(new LowerRope(), rope));
            MessageHandler.logMessage(c.act(new SuperviseRope(), rope));
        }

        MessageHandler.getAllMessages();

    }
}
