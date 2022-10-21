import javax.swing.*;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Main extends FileReader {


    Path membersFile = Paths.get("src/MembersFile.txt");

    public static void main(String[] args) {
        Main bestGymEver = new Main();
        bestGymEver.mainProgram();

    }

    public void mainProgram() {
        List<Member> listOfMembers = saveMembers(membersFile);
        while (true) {
            String userInput = userInput();
            controlIfMember(userInput, listOfMembers);
        }

    }


    public String userInput() {

        String userInput = JOptionPane.showInputDialog(null, "Please enter the name \"First + Last name\" or Social security number with 10 numbers \"XXXXXXXXXX\"");
        if (userInput == null) {
            JOptionPane.showMessageDialog(null, "Exiting program");
            System.exit(0);
        }

        while (userInput.isBlank()) {
            JOptionPane.showMessageDialog(null, "No input read, please enter a valid input");
            userInput = JOptionPane.showInputDialog(null, "Please enter the name \"First + Last name\" or Social security number with 10 numbers \"XXXXXXXXXX\"");
            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Exiting program");
                System.exit(0);
            }
        }

        return userInput;
    }

    public boolean controlIfActiveSubscription(String lastPaymentString) {
        LocalDate lastPaymentDate = LocalDate.parse(lastPaymentString);
        LocalDate currentDate = LocalDate.now();

        return lastPaymentDate.isAfter(currentDate.minusYears(1)) || lastPaymentDate.isEqual(currentDate.minusYears(1));
    }

    public void controlIfMember(String userInput, List<Member> listOfMembers) {
        boolean membershipStatus;

        for (Member member : listOfMembers) {
            if (userInput.equalsIgnoreCase(member.getName()) || userInput.equals(member.getSocialSecurityNumber())) {
                String lastPayment = member.getLastPayment();
                membershipStatus = controlIfActiveSubscription(lastPayment);
                if (membershipStatus) {
                    registerDataForPersonalTrainer(personalTrainerDataPath, member);
                    JOptionPane.showMessageDialog(null, member.getName() + " has an active subscription. Last payment was: " + member.getLastPayment());
                    return;
                }
                else{
                    JOptionPane.showMessageDialog(null, member.getName() + " does not have an active subscription. Last payment was: " + member.getLastPayment());
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Could not find a member with the name or Social security number of: \"" + userInput + "\"");
    }

}