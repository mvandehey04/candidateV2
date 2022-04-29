import java.util.ArrayList;
public class ElectionTesterV8 {
    // arrayList version of election tester v1
    public static void main(String args[]){
        // arrayList containing 5 candidate object w/ their name & # of votes
        ArrayList<Candidate> candidates = new ArrayList<Candidate>();

        // 5 candidate objects
        candidates.add(new Candidate("Taylor Swift", 1313));
        candidates.add(new Candidate("Kesha", 894));
        candidates.add(new Candidate("Olivia Rodrigo", 867));
        candidates.add(new Candidate("Britney Spears", 921));
        candidates.add(new Candidate("Marina", 1254));

        // raw election data
        printCandidates(candidates);

        //election results
        printTable(candidates);

        // replace name
        changeCandidate(candidates, "Olivia Rodrigo", "Katy Perry");

        // replace votes
        changeVotes(candidates, "Kesha", 1243);

        // replace votes and candidate
        changeCandAndVot(candidates, "Taylor Swift", "Ariana Grande", 1348);

        // insert candidate at position
        insertNewCandidate(candidates, 2, "Phoebe Bridgers", 799);

        // insert candidate by name
        insertByName(candidates, "Britney Spears", "Victoria Justice", 1215);

        // delete at position
        deleteAtPos(candidates, 1);

        // delete by name
        deleteByName(candidates, "Ariana Grande");
    }
    // print candidtate names & votes
    public static void printCandidates(ArrayList<Candidate> itemList){
        System.out.println("Raw Election Data:" + "\n");
        for(Candidate c : itemList){
            if(c != null){
                System.out.println(c.toString());
            }
        }
    }

    // counts the total votes for all the candidates
    public static int returnTotVotes(ArrayList<Candidate> itemList){
        int totVotes = 0;
        for(Candidate c : itemList){
            if(c != null){
                totVotes += c.getVotes();
            }
        }
        return totVotes;
    }

    // creates a table w/ columns for the candidate name, votes, % of tot votes
    // print a statement showing the total number of votes for the election
    public static void printTable(ArrayList<Candidate> itemList){
        double percentVote = 0.0;

        System.out.println("\n" + "Election Results:");
        System.out.printf("%26s %23s", "Votes", "% of Total");
        System.out.printf("\n %1s %17s %18s \n", "Candidate", "Received", "Votes");
        System.out.println("=======================================================");

        // table of data
        for(Candidate c : itemList){
            if(c != null){
                percentVote = (c.getVotes() / (double)(returnTotVotes(itemList)) * 100);
                System.out.printf("%-20s %-20d %-1.2f \n", c.getName(), c.getVotes(), percentVote);
            }
        }

        // print total number of votes
        System.out.println("\n" + "The total number of votes is: " + returnTotVotes(itemList) + "\n");
    }

     // find candidate by name and change the name
     public static void changeCandidate(ArrayList<Candidate> itemList, String find, String replace){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(find)){
                itemList.set(i, new Candidate(replace, itemList.get(i).getVotes()));
            }
        }
        
        System.out.println("\n" + "<<Changing " + find + " to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find by name and change the number of votes
    public static void changeVotes(ArrayList<Candidate> itemList, String find, int replace){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(find)){
                itemList.set(i, new Candidate(find, replace));
            }
        }

        System.out.println("\n" + "<<Changing " + find + " votes to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find candidate by name and replace both the name and number of votes 
    public static void changeCandAndVot(ArrayList<Candidate> itemList, String name, String newName, int votes){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(name)){
                itemList.set(i, new Candidate(newName, votes));
            }
        }

        System.out.println("\n" + "<<Changing " + name + " to " + newName + " and votes to " + votes + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }

     // insert new candidate into position
     public static void insertNewCandidate(ArrayList<Candidate> itemList, int position, String name, int votes){
        for(int i = 0; i < itemList.size(); i++){
            if(i == position){
                itemList.add(position, new Candidate(name, votes));
            }
        }

        System.out.println("\n" + "<<At position " + position + ", add " + name + ", " + votes + " votes>>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }

    // find candidate by name and insert a new candidate before 
    public static void insertByName(ArrayList<Candidate> itemList, String find, String newName, int votes){
        int location = 0;

        // find location of item you want to insert before
        for(int index = 0; index < itemList.size(); index++)
            if(itemList.get(index).getName().equals(find))
                location = index;

        // insert item into ArrayList
        itemList.add(location, new Candidate(newName, votes));

        System.out.println("\n" + "<<Before " + find + ", add " + newName + ", " + votes + " votes>>" + "\n");

         // raw election data
         printCandidates(itemList);

         //election results
         printTable(itemList);

    }    

    // delete candidate by position
    public static void deleteAtPos(ArrayList<Candidate> itemList, int location){
        if ((location > 0) && (location < itemList.size())){
            for(int i = 0; i < itemList.size(); i++){
                if(i == location){
                    itemList.remove(itemList.get(i));
                }
            }
        }

        System.out.println("\n" + "<<Delete posistion " + location + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find candidate by name and delete candidate
    public static void deleteByName(ArrayList<Candidate> itemList, String name){
        for(int i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getName().equals(name)){
                itemList.remove(itemList.get(i));
            }
        }

        System.out.println("\n" + "<<Delete " + name + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }
}
