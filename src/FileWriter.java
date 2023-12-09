import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

public class FileWriter {
    private String path;

    public FileWriter(String path) {
            this.path = path + ".txt";
    }

    public void write(User user) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(this.path, true))){
            objectOutputStream.writeUTF(user.getParam());
            objectOutputStream.writeUTF("\n");
        }
        catch (IOException e){
            System.out.println("не удалось записать файл" + path);;
        }
    }

}

