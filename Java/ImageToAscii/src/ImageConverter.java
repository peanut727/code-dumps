import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageConverter {

    private BufferedImage image;
    private PrintWriter pw;
    private FileWriter fw;

    private String[] asciiCode = new String[] {

            "0",
            "O",
            "1",
            "!",
            "|",

    };

    public ImageConverter() {

        initialize();

    }


    private void initialize(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Name of text file: ");
        String txtfile = sc.nextLine();

        try {
            FileDialog dialog = new FileDialog((Frame) null, "Select File To Open");
            dialog.setMode(FileDialog.LOAD);
            dialog.setVisible(true);
            String imagepath = dialog.getDirectory() + dialog.getFile();
            dialog.dispose();
            System.out.print(imagepath + " chosen.");

            pw = new PrintWriter(fw = new FileWriter((txtfile + ".txt"), true));
            image = ImageIO.read(new File(imagepath));

        } catch (IOException el) {

            el.printStackTrace();
        }

    }
    private int getAspectRatioValue(Scanner scanner, String dimension) {
        System.out.println("ASPECT RATIO");
        System.out.println(dimension + ": ");
        return scanner.nextInt();
    }

    private void processImage(int ratioWidth, int ratioHeight) {
        float codeRange = 255.0f / (float) asciiCode.length;

        for (int row = 0; row < image.getHeight(); row += ratioHeight) {
            for (int col = 0; col < image.getWidth(); col += ratioWidth) {
                double totGrayscaleVal = 0;
                int pixInBlock = 0;
                for (int r = row; r < row + ratioHeight && r < image.getHeight(); r++) {
                    for (int c = col; c < col + ratioWidth && c < image.getWidth(); c++) {
                        Color color = new Color(image.getRGB(c, r));
                        double grayScaleVal = color.getRed() * 0.21 + color.getGreen() * 0.72 + color.getBlue() * 0.07;
                        totGrayscaleVal += grayScaleVal;
                        pixInBlock++;
                    }
                }
                double avgGScale = totGrayscaleVal / pixInBlock;
                int index = (int) (avgGScale / codeRange);
                printASCIICharacter(index, ratioWidth);
            }
            pw.println();
        }
    }

    private void printASCIICharacter(int index, int repeat) {
        String asciiChar = asciiCode[index];
        for (int i = 0; i < repeat; i++) {
            try {
                pw.print(asciiChar);
                pw.flush();
                fw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(asciiChar + " ");
        }
    }

    private void closeResources() {
        try {
            if (fw != null) {
                fw.close();
            }
            if (pw != null) {
                pw.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        int ratioWidth = getAspectRatioValue(scan, "WIDTH");
        int ratioHeight = getAspectRatioValue(scan, "HEIGHT");
        processImage(ratioWidth,ratioHeight);
        closeResources();
    }

}
