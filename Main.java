import java.util.ArrayList;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creating array list's for girls and boys
        ArrayList<PopularName> boys=new ArrayList<>();
        ArrayList<PopularName> girls=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        //initializing file name
        String fileName=null;
        try {
            //asking the user a file name
            System.out.println("Enter a file name");
             fileName = input.nextLine();

        }//controlling  any exception
        catch(InputMismatchException e)
       {
        System.out.println("file name must be String");
    }

        //creating file object with the user's entered file name
        File nFile=new File(fileName);
        try {
            //reading the file's info
            Scanner fileReader = new Scanner(nFile);
            //while the file end
            while(fileReader.hasNextLine()){
                //split to all infos according to the"," in each line
                String[] arr=fileReader.nextLine().split(",");
                //controlling if the line has not 5 information
                if(arr.length<5){
                    continue;
                }
                //parsing the string rank value to int we know that first element
                //in the line is rank
                int rank=Integer.parseInt(arr[0]);
                //declare to array's second element to male name
                //we know that second element is male name
                String maleName=arr[1];
                //parsing the string male number value to int we know that third element
                //in the line is male name number
                int maleNumber=Integer.parseInt(arr[2]);
                //adding to boys array list according to infos  above
                boys.add(new PopularName(rank,maleName,maleNumber));
                //declare to array's forth element to female name
                //we know that forth element is female name
                String femaleName=arr[3];
                //parsing the string female number value to int we know that fifth element
                //in the line is female name number
                int femaleNumber=Integer.parseInt(arr[4]);
                //adding to object girls array list according to infos above
                girls.add(new PopularName(femaleName,femaleNumber,rank));
            }
            //close to read file
            fileReader.close();
            //if this file not found exception thrown
        }
        catch(FileNotFoundException e){
            System.out.println(e);
            //and exit the system with write 0
            System.exit(0);
        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println("file is uploaded");
        //using bubble sort algorithm order the names as alphabetic for boys

        for(int i=0;i<boys.size()-1;i++){
           for(int j=0;j<boys.size()-1;j++){
               //compare the index's with near here
               //if the first name minus second name bigger than 0
               //swap these names
               if(boys.get(j).getMaleName().compareTo(boys.get(j+1).getMaleName())>0){
                   //swapping the names
                   PopularName temp=boys.get(j);
                   boys.set(j,boys.get(j+1));
                   boys.set(j+1,temp);
               }
           }
        }
        //using bubble sort algorithm order the names as alphabetic for girls

        for(int i=0;i<girls.size()-1;i++){
            for(int j=0;j<girls.size()-1;j++){
                //compare the index's with near here
                //if the first name minus second name bigger than 0
                //swap these names
                if(girls.get(j).getFemaleName().compareTo(girls.get(j+1).getFemaleName())>0){
                    //swapping the names
                    PopularName temp=girls.get(j);
                    girls.set(j,girls.get(j+1));
                    girls.set(j+1,temp);

                }
            }
        }
        //calculating total girls name in the array list
        int totalGirls=0;
        for(PopularName girls1:girls) {
            totalGirls += girls1.getFemaleNumber();
        }
        //calculating total boys name in the array list

        int totalBoys=0;
            for(PopularName boys1:boys){
                totalBoys+=boys1.getMaleNumber();
            }

    while(true){
        //asking the user want to search name
        System.out.println("Do you want to search for a name and see its statistics (y/n)?");
        //taking the name from user
        String answer=input.nextLine();
        //if the user enters y this scope runs
        if(answer.equalsIgnoreCase("y")) {
            //this boolean controls the user entered male or female
           boolean b=false;

           while(!b) {
               //this boolean checks the name is found or not
               boolean isFound=false;
               System.out.println("enter a gender");
               String gender = input.nextLine();
                //this scope runs when the user enters female
               if (gender.equalsIgnoreCase("female")) {
                   //asking user to name which is want to look
                   System.out.println("enter a name");
                   String name = input.nextLine();
                   //this if statement controls the names length
                   //because a name has to be two letters
                   //controlling the names letter
                   if (name.length() < 2 || !name.matches("[a-zA-Z]+")) {
                       System.out.println("Invalid name. It must be at least 2 letters and only contain letters.");
                       continue;
                   }
                   //searching the given name is included among the array list
                   for (int i = 0; i < girls.size(); i++) {
                       if (girls.get(i).getFemaleName().equalsIgnoreCase(name)) {
                           //if the name exist
                           System.out.println(name + ":");
                           //index's the name in the array list
                           System.out.println("index is sorted list:" + i);
                           //rank in the popularity that name
                           System.out.println("rank in popularity:" + girls.get(i).getRank());
                           //how many babies has that name
                           System.out.println("number of babies:" + girls.get(i).getFemaleNumber());
                           //and percentage among the girls name
                           System.out.println("percentage of babies:" +
                                   (girls.get(i).getFemaleNumber() * 100.0) / totalGirls + "%");
                           //because of name found boolean declared with true
                           isFound=true;
                           break;
                       }
                   }
                   //if the name not found this scope runs
                   if(!isFound){
                       System.out.println("this name is not included most popular 1000 name");
                   }
                   //this means that user enter just male or female
                   b = true;
               }
               //if the user enters male this scope runs
               else if (gender.equalsIgnoreCase("male")) {
                   //asking the name to user
                       System.out.println("enter a name");
                       String name = input.nextLine();
                   //this if statement controls the names length
                   //because a name has to be two letters
                   //controlling the names letter
                   if (name.length() < 2 || !name.matches("[a-zA-Z]+")) {
                       System.out.println("Invalid name. It must be at least 2 letters and only contain letters.");
                       continue;
                   }
                   //checking the name exist in boys array list
                       for (int i = 0; i < boys.size(); i++) {
                           if (boys.get(i).getMaleName().equalsIgnoreCase(name)) {
                               //if the name exist
                               System.out.println(name + ":");
                               //index's the name in the array list
                               System.out.println("index is sorted list:" + i);
                               //rank in popularity
                               System.out.println("rank in popularity:" + boys.get(i).getRank());
                               //how many babies has that name
                               System.out.println("number of babies:" + boys.get(i).getMaleNumber());
                               //percentage of male babies have that name
                               System.out.println("percentage of babies:" +
                                       (boys.get(i).getMaleNumber() * 100.0) / totalBoys + "%");
                               //because of that name is found boolean be true
                               isFound = true;
                               break;
                           }

                       }
                       //if the name does not exist this scope runs
                       if (!isFound) {
                           System.out.println("this name is not included most popular 1000 name");
                       }

                   b=true;
               }
               //if the user enter the other than male or female this scope runs
               else{
                   System.out.println("please just enter male or female");


               }
           }

            }
        //if the user do not want to search a name this scope runs
        else if(answer.equalsIgnoreCase("n")){
            break;
        }
        //if the user enter other name y or n this scope runs
        else{
            System.out.println("please enter just y or n");

        }
    }
    }
}
