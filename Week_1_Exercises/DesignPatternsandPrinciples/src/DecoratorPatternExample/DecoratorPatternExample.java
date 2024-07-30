package DecoratorPatternExample;

interface MessageNotifier {
    void send(String message);
}

class BasicEmailNotifier implements MessageNotifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements MessageNotifier {
    protected MessageNotifier decoratedNotifier;

    public NotifierDecorator(MessageNotifier notifier) {
        this.decoratedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        decoratedNotifier.send(message);
    }
}

class SMSDecorator extends NotifierDecorator {
    public SMSDecorator(MessageNotifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackDecorator extends NotifierDecorator {
    public SlackDecorator(MessageNotifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack message: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        MessageNotifier basicEmailNotifier = new BasicEmailNotifier();
        MessageNotifier smsDecorator = new SMSDecorator(basicEmailNotifier);
        MessageNotifier slackDecorator = new SlackDecorator(smsDecorator);

        slackDecorator.send("Hello, World!");
    }
}
