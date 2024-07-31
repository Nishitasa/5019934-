public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Creating an email notifier
        Notifier emailNotifier = new EmailNotifier();

        // Adding SMS notification functionality
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

        // Adding Slack notification functionality on top of email and SMS
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Sending a message using all notifiers
        slackNotifier.send("Hello, this is a test message!");
    }
}

interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email with message: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// Concrete Decorator for SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS with message: " + message);
    }
}

// Concrete Decorator for Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack message: " + message);
    }
}
