import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReader extends FileWriter{


    

    public List<Member> saveMembers (Path membersFile){
        List<Member> membersListFromFile = new ArrayList<>();
        String socialSecurityNumber;
        String name = null;
        String lastPayment = null;
        try (Scanner readTextFile = new Scanner(membersFile)) {
            while (readTextFile.hasNext()) {
                socialSecurityNumber = readTextFile.next().replace(",", "").trim();
                if (readTextFile.hasNext()) {
                    name = readTextFile.nextLine();
                    name = name.substring(1);
                    if (readTextFile.hasNext()) {
                        lastPayment = readTextFile.nextLine();
                    }
                }
                membersListFromFile.add(new Member(socialSecurityNumber, name, lastPayment));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Something went wrong, please contact the system administrator.");
            e.printStackTrace();
            System.exit(0);
        }

        return membersListFromFile;
    }

}
