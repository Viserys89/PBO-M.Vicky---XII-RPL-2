import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contact extends ContactBook{
    Contact(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);
    }

    public static void main (String[] args){
        Application startPoint = new Application("", "", "");
        try {
            FileInputStream fileInput = new FileInputStream("Contact.ser");
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            contactList = (ArrayList<ContactBook>) objectInput.readObject();
            objectInput.close();
            fileInput.close();
        } catch (IOException | ClassNotFoundException e) {}
        startPoint.application();
    }
    public void contact(){
        if(contactList.size() > 0){
            for(int i = 0; i < contactList.size(); i++){
                email = contactList.get(i).email;
                name = contactList.get(i).name;
                phoneNumber = contactList.get(i).phoneNumber;
                System.out.println(String.format("%s", i + 1));
                System.out.println(String.format("Email :  %s", email));
                System.out.println(String.format("Name : %s", name));
                System.out.println(String.format("Phone Number : %s ", phoneNumber));
                System.out.println(String.format("====================================="));
            }
        }
        else {
            System.out.println("No Contact");
        }
    }
}


class Application extends Contact{
    Scanner Choose = new Scanner(System.in);
        Application(String email, String name, String phoneNumber) {
            super(name, email, phoneNumber);
        }
    
    public void application(){
        Contact contact = new Contact("", "", "");
        
        System.out.println("");
        System.out.println("1. Add Contact");
        System.out.println("2. Show Contact");
        System.out.println("3. Delete Contact");
        System.out.println("4. Close");
        int choose = Choose.nextInt();
        System.out.println("");

        switch(choose) {
            case 1:
                contact.add();
                application();
                break;
            case 2:
                contact.contact();
                application();
                break;
            case 3:
                contact.contact();
                contact.delete();
                application();
                break;
            case 4:
                Choose.close();
                contactInput.close();
                contact.save();
                break;

            default:
                break;
        }
    }
}

class ContactBook implements Serializable{
    public static ArrayList<ContactBook> contactList = new ArrayList<>();
    String email;
    String name;
    String phoneNumber;
    transient Scanner contactInput = new Scanner(System.in);
    ContactBook(String email, String name, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public void save(){
        try {
            FileOutputStream fileOutput = new FileOutputStream("Contact.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(contactList);
            objectOutput.close();
            fileOutput.close();
            System.out.println("Contact saved :) ");
        } catch (IOException e) {
            System.out.println("Something went wrong :( ");
        }
    }
    public void add(){
            System.out.println("Enter your email : ");
            String emailin = contactInput.nextLine();
            System.out.println("Enter your name : ");
            String namein = contactInput.nextLine();
            System.out.println("Enter your phone number : ");
            String phoneNumberin = contactInput.nextLine();
            contactList.add(new ContactBook(emailin, namein, phoneNumberin));
    }
    public void delete(){
        if(contactList.size() > 0){
            System.out.println("Choose contact you want to delete? choose the number");
            int delete = contactInput.nextInt() -1;
            if(delete >= contactList.size()){
                System.out.println("Not Valid");
                delete();
            }
            else {
                contactList.remove(delete);

                System.out.println("");
                System.out.println("Contact Deleted");
            }
        }
        else{
            System.out.println("No contact listed");
        }
    }
}