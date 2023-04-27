package be.intecbrussel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) {


        Path path = Paths.get("resources//Secret_Folder//Secret_Message.txt");

        try {

            // Create Directory
            Files.createDirectories(path.getParent());

            // Create File
            if(Files.notExists(path)){
                Files.createFile(path);
                System.out.println("File created");}

            // Create Buffered writer
            FileWriter fileWriter = new FileWriter("resources//Secret_Folder//Secret_Message.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("The wolf is in the pig pen. I repeat: the wolf is in the pig pen.");
            bufferedWriter.close();
            
            // Upload image from URL
            BufferedImage image = ImageIO.read(new URL("https://worldstories.org.uk/content/book/262/__picture_9352.jpg"));
            ImageIO.write(image, "jpg", new File("resources//Secret_Folder//secretpicture.jpg"));


        } catch (IOException e) {
            System.out.println("An error seems to have occured");
        }


    }
}
