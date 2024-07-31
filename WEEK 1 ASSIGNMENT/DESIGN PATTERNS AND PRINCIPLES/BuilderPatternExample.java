 class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        // Methods to set each attribute
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage + ", GPU=" + GPU + "]";
    }
}

public class TestBuilderPattern {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern
        Computer gamingPC = new Computer.Builder()
                                .setCPU("Intel i9")
                                .setRAM("32GB")
                                .setStorage("1TB SSD")
                                .setGPU("NVIDIA RTX 3080")
                                .build();

        Computer officePC = new Computer.Builder()
                                .setCPU("Intel i5")
                                .setRAM("16GB")
                                .setStorage("512GB SSD")
                                .setGPU("Integrated Graphics")
                                .build();

        // Printing the configurations
        System.out.println("Gaming PC Configuration: " + gamingPC);
        System.out.println("Office PC Configuration: " + officePC);
    }
}

