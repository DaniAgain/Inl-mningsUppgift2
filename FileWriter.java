import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;

public class FileWriter {

    final String personalTrainerDataPath = "src/dataForPersonalTrainer.txt";
    public void registerDataForPersonalTrainer(String activitylog, Member member) {

        try (PrintWriter writer = new PrintWriter(
                new FileOutputStream(activitylog, true)))
        {
            writer.append(member.getName()).append(" went to the gym, date: ").append(String.valueOf(LocalDate.now())).append("\n");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }

    }

}
