public class Member {

    String socialSecurityNumber;
    String name;
    String lastPayment;



    public Member(String socialSecurityNumber, String name, String lastPayment){
            this.socialSecurityNumber = socialSecurityNumber;
            this.name = name;
            this.lastPayment = lastPayment;
        }


    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastPayment() {
        return lastPayment;
    }

    public void setLastPayment(String lastPayment) {
        this.lastPayment = lastPayment;
    }

}
