import java.util.ArrayList;

public class MessageHandler {
    private static final ArrayList<String> messages = new ArrayList<>();

    public static void logMessage(String message) {
        messages.add(message);
    }

    public static void getAllMessages() {
        for (String m: messages)
            System.out.println(m);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other == null || getClass() != other.getClass();
    }

    @Override
    public String toString() {
        return "Зачем создавать экземпляр этого класса... Зовут ОбработчикСообщений";
    }

    @Override
    public int hashCode() {
        return 123;
    }
}
