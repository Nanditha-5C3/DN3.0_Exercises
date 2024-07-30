package CommandPatternExample;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command Classes
class TurnLampOnCommand implements Command {
    private Lamp lamp;

    public TurnLampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOn();
    }
}

class TurnLampOffCommand implements Command {
    private Lamp lamp;

    public TurnLampOffCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOff();
    }
}

// Receiver Class
class Lamp {
    public void turnOn() {
        System.out.println("Lamp is ON");
    }

    public void turnOff() {
        System.out.println("Lamp is OFF");
    }
}

// Invoker Class
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Test the Command Pattern
public class CommandPatternExample {
    public static void main(String[] args) {
        Lamp lamp = new Lamp();
        Command turnLampOn = new TurnLampOnCommand(lamp);
        Command turnLampOff = new TurnLampOffCommand(lamp);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnLampOn);
        remote.pressButton();

        remote.setCommand(turnLampOff);
        remote.pressButton();
    }
}
