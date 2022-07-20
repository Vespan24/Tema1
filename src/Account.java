
public class Account {
    public int accountNo;
    public int amount;
    public String nationalID;
    public Account() {
    }
    public void deposit(int amount){
        this.amount=this.amount+amount;
        System.out.println("Money added! You have " + this.amount);
    }
    public void withdraw(int amount) throws NotEnoughMoneyException{
        if(this.amount < amount){
            throw new NotEnoughMoneyException("Transaction denied!-You don't have enough money on your account. You only have " + this.amount + " in your account.");
        }
        else{
            this.amount=this.amount-amount;
            System.out.println("Transaction approved! Now you have " + this.amount +" left.");
        }
    }
    public void linkToNationalID(String nationalID) throws InvalidNationalIdException{
        class Cnp{
            String nationalID;
            int sex;
            int year;
            int month;
            int day;
            int county;
            int seqNumber;
            int controlDigit;
            public Cnp(String nationalID) {
                this.nationalID = nationalID;
            }
            public void setSex(String nationalID) {
                this.sex = Character.getNumericValue(nationalID.charAt(0));
            }
            public void setYear(String nationalID) {
                this.year = Character.getNumericValue(nationalID.charAt(1))*10 +Character.getNumericValue(nationalID.charAt(2));
            }
            public void setMonth(String nationalID) {
                this.month = Character.getNumericValue(nationalID.charAt(3))*10 + Character.getNumericValue(nationalID.charAt(4));
            }
            public void setDay(String nationalID) {
                this.day = Character.getNumericValue(nationalID.charAt(5))*10 + Character.getNumericValue(nationalID.charAt(6));
            }
            public void setCounty(String nationalID) {
                this.county = Character.getNumericValue(nationalID.charAt(7))*10 + Character.getNumericValue(nationalID.charAt(8));
            }
            public void setSeqNumber(String nationalID){
                this.seqNumber = Character.getNumericValue(nationalID.charAt(9))*100 + Character.getNumericValue(nationalID.charAt(10))*10 + Character.getNumericValue(nationalID.charAt(11));
            }
            public void setControlDigit(String nationalID) {
                this.controlDigit = Character.getNumericValue(nationalID.charAt(12));
            }
        }
        if(nationalID.length() != 13){
            throw new InvalidNationalIdException("Your national ID has " + nationalID.length() + " characters. It should have 13. Try again.");
        }
        if(!nationalID.matches("[0-9]+")){
            throw new InvalidNationalIdException("Your national ID contains other characters than digits. Try again.");
        }
        Cnp cnp= new Cnp(nationalID);
        cnp.setSex(nationalID);
        cnp.setYear(nationalID);
        cnp.setMonth(nationalID);
        cnp.setDay(nationalID);
        cnp.setCounty(nationalID);
        cnp.setSeqNumber(nationalID);
        cnp.setControlDigit(nationalID);
        if(cnp.sex == 3 || cnp.sex == 4 || cnp.sex == 7 || cnp.sex == 8){
            throw new InvalidNationalIdException("This person doesn't exist." + cnp.sex);
        }
        if(cnp.month > 12 || cnp.month<1 || cnp.day > 31 || cnp.day < 1){
            throw new InvalidNationalIdException("Invalid birthday: " + cnp.day + "." + cnp.month);
        }
        if(((cnp.month == 4 || cnp.month == 6 || cnp.month == 9 || cnp.month == 11) && cnp.day > 30) || (cnp.month == 2 && cnp.day > 29)){
            throw new InvalidNationalIdException("This day doesn't exist in the month." + cnp.day + "." + cnp.month);
        }
        if(cnp.county > 52 || cnp.county == 47 || cnp.county == 48)
        {
            throw new InvalidNationalIdException("Invalid county. " + cnp.county);
        }
        //testare cifra de control din cnp
        this.nationalID = nationalID;
        System.out.println("NationalID linked successfully! " + this.nationalID);
    }
}
