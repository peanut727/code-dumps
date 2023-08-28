import java.awt.*;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;
import javax.imageio.ImageIO;


 public class MainPanel {
  
   private BufferedImage image;
   private PrintWriter pw;
   private FileWriter fw;

   /*private String[] asciiCode = new String[] {"$","@","B","%","8","&",
                  "W","M","#","*","o","a","h","k","b","d","p","q","w",
                  "-", "=", "+", "[", "]", "{", "}", "|", ";", ":", "'", "\"",
                  "<", ">", ",", ".", "/", "?", "0", "1", "2", "3", "4", "5",
                  "6", "7", "8", "9","l","n","c","e","f","g","i","j","r","s"
  };*/

  /*private String[] asciiCode = new String[] {
    " ", ".", "-", "~", ":", "+", "*", "=", "#", "%", "&", "8", "O", "o", "0", "@",
};*/
    private String[] asciiCode = new String[] {
     "0","O","1","!","|"
};

   public MainPanel(){

    Scanner sc = new Scanner(System.in);

    System.out.print("Name of text file: ");
    String txtfile = sc.nextLine();
   

    try {
         
         // Image Picker
         FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
         dialog.setMode(FileDialog.LOAD);
         dialog.setVisible(true);
         String selectedImagePath = dialog.getDirectory() + dialog.getFile();
         dialog.dispose();
         System.out.println(selectedImagePath + " chosen.");

         pw = new PrintWriter(fw = new FileWriter((txtfile + ".txt"), true));
         image = ImageIO.read(new File(selectedImagePath));
         //image = ImageIO.read(MainPanel.class.getResource(selectedImagePath));

    }catch (IOException el){

      el.printStackTrace();

    }
   }

    public void start() {

      Scanner scan = new Scanner(System.in);

      float codeRange = 255.0f / (float)asciiCode.length;


      System.out.println("ASPECT RATIO");
      System.out.println("WIDTH: ");
      int ratioWidth = scan.nextInt();
      System.out.println("HEIGHT: ");
      int ratioHeight = scan.nextInt();
    
      // default values
      //int ratioWidth = 1;
      //int ratioHeight = 2;

      for (int row = 0; row < image.getHeight(); row += ratioHeight) {
        for (int col = 0; col < image.getWidth(); col += ratioWidth) {

          // RGB
          double totgrayscaleval = 0;
          int pixInBlock = 0;

          for (int r = row; r < row + ratioHeight && r < image.getHeight(); r++) {
            for (int c = col; c < col + ratioWidth && c < image.getWidth(); c++) {
                Color color = new Color(image.getRGB(c, r));
                double grayScaleVal = color.getRed() * 0.21 + color.getGreen() * 0.72 + color.getBlue() * 0.07;
                totgrayscaleval += grayScaleVal;
                pixInBlock++;
            }
        }
         double avggscale = totgrayscaleval / pixInBlock;

      
          int index = (int) (avggscale / codeRange);

          for (int i = 0; i < ratioWidth; i++) {
          try {
              pw.print(asciiCode[index]);
              pw.flush();
              fw.flush();
          }catch (IOException e){
            e.printStackTrace();
          }

          System.out.print(asciiCode[index]+" ");
        }
      }

        System.out.print("\n");
        try{
          pw.println("");
          pw.flush();
          fw.flush();
        }catch (IOException e){
          e.printStackTrace();
        }
       
      }
    }

    public static void main(String[] args) {
      MainPanel mainPanel = new MainPanel();
      mainPanel.start();
  }
}

