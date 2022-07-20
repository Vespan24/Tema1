public class Main {
    public static void main(String args[]){
        String cnp1="12345678912334";
        String cnp2="1234ui6666666";
        String cnp3="5003104049999";
        String cnp4="6220631019719";
        String cnp5="6220731019719";
        Account cont=new Account();
        cont.amount=230;
        cont.accountNo=1;

        try{
            cont.linkToNationalID(cnp1);
        }catch (InvalidNationalIdException e){
            System.out.println(e);
        }
        try{
            cont.linkToNationalID(cnp2);
        }catch (InvalidNationalIdException e){
            System.out.println(e);
        }
        try{
            cont.linkToNationalID(cnp3);
        }catch (InvalidNationalIdException e){
            System.out.println(e);
        }
        try{
            cont.linkToNationalID(cnp4);
        }catch (InvalidNationalIdException e){
            System.out.println(e);
        }
        try{
            cont.linkToNationalID(cnp5);
        }catch (InvalidNationalIdException e){
            System.out.println(e);
        }
        try{
            cont.withdraw(234);
        }catch (NotEnoughMoneyException e){
            System.out.println(e);
        }
        try{
            cont.deposit(4);
            cont.withdraw(234);
        }catch (NotEnoughMoneyException e){
            System.out.println(e);
        }
        cont.deposit(90);
    }
}
