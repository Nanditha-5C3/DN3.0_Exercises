package BuilderPatternExample;

public class Computer {
    private String processor;
    private String memory;
    private String disk;

    private Computer(Builder builder) {
        this.processor = builder.processor;
        this.memory = builder.memory;
        this.disk = builder.disk;
    }

    public static class Builder {
        private String processor;
        private String memory;
        private String disk;

        public Builder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public Builder setMemory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder setDisk(String disk) {
            this.disk = disk;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [Processor=" + processor + ", Memory=" + memory + ", Disk=" + disk + "]";
    }

    public static void main(String[] args) {
        Computer computer = new Computer.Builder()
                .setProcessor("Intel i7")
                .setMemory("16GB")
                .setDisk("512GB SSD")
                .build();

        System.out.println(computer);
    }
}
