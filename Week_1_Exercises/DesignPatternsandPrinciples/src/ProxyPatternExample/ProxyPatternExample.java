package ProxyPatternExample;

interface ImageInterface {
    void display();
}

class ActualImage implements ImageInterface {
    private String filePath;

    public ActualImage(String filePath) {
        this.filePath = filePath;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filePath);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filePath);
    }
}

class ImageProxy implements ImageInterface {
    private ActualImage actualImage;
    private String filePath;

    public ImageProxy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void display() {
        if (actualImage == null) {
            actualImage = new ActualImage(filePath);
        }
        actualImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        ImageInterface image1 = new ImageProxy("C:\\Users\\HP\\Downloads\\image1.jpg");
        ImageInterface image2 = new ImageProxy("C:\\Users\\HP\\Downloads\\image2.jpg");

        image1.display();
        image1.display();

        image2.display();
    }
}
