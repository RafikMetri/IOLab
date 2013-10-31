import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 10/30/13
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContactList {

    private FileWriter fw = null;
    private PrintWriter pw = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private String fileName;

    public ContactList(String _fileName){
        this.fileName = _fileName;

        try{
            fw = new FileWriter(fileName, true);
        }
        catch(Exception e){
            System.out.println("There was a problem with your file");
        }
    }

    public void readFile(){
        try{
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            String text;
            while((text = br.readLine()) != null)
                System.out.println(text);
        }
        catch(Exception e){
            System.out.println("There was a problem reading your file");
        }
    }

    public void listContactNames(){
        Pattern regex = Pattern.compile("([A-Z]|[a-z])+\\s([A-Z]|[a-z])+", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(getFileText());

        int count = 1;
        while(search.find())
            System.out.printf("%d - %s%n", count++, search.group());
    }



    public String getContact(String name){
        String contact = null;
        Pattern regex = Pattern.compile(name + "\\s\\S+\\s(\\S)+", Pattern.CASE_INSENSITIVE);
        Matcher search = regex.matcher(getFileText());

        System.out.println("Match found: " + search.find() + "\n");

        do{
            try{
            System.out.printf(search.group());
            }
            catch(Exception e){
                System.out.println("A match was not found, please try again.");
            }
        }while(search.find());
        return contact;
    }

    public String getFileText(){
        Scanner read = null;
        String text = null;

        try{
            read = new Scanner(new File(fileName));
            read.useDelimiter("$");
            text = read.next();
            read.close();
        }
        catch(Exception e){
            System.out.println("There was a problem scanning your file");
        }

        return text;
    }

    public void addContact(String name, String email, String number){
        try{
            pw = new PrintWriter(fw);
            pw.println("\n" + name + "\n" + email + "\n" + number);
            pw.close();
        }
        catch(Exception e){
            System.out.println("There was a problem writing your file");
        }
    }
}
