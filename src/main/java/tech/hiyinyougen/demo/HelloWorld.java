package tech.hiyinyougen.demo;

import java.util.*;

/**
 * @author yinyg
 * @date 2019/4/22
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<Message> received = new ArrayList<>();
        received.add(new Message(1, "Hello!"));
        received.add(new Message(2, "发工资了吗？"));
        received.add(new Message(2, "发工资了吗2？"));
        received.add(new Message(3, "去哪吃饭3？"));
        received.add(new Message(3, "去哪吃饭？"));
        received.add(new Message(4, "Bye"));
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
        Set<Message> set = new HashSet<>();
        if (received != null && received.size() > 0) {
            for (Message tmp : received) {
                set.add(tmp);
            }
            return new ArrayList<>(set);
        }
        return null;
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public int hashCode() {
        return this.sequence;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException("参数不能为null");
        }
        return this.sequence == ((Message)obj).sequence;
    }
}
