import java.util.ArrayList;

public class MessageHandler {
    public static ArrayList<String> messages = new ArrayList<>();

    public static void logMessage(String msg){
        messages.add(msg);
    }

    public static void getAllMessages() {
        for(String m: messages)
            System.out.println(m);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return !(other == null || getClass() != other.getClass());
    }

    @Override
    public String toString() {
        return "Зачем создавать экземпляр этого класса... Зовут ОбработчикСообщений";
    }

    @Override
    public int hashCode() {
        int result = messages.size() == 0? 0: 1;
        for (String m: messages)
            result *= m.hashCode() * 127;
        return result;
    }
}
