public class ElectionTesterV7 
{
    public static void main(String args[]){
        // array containing 5 candidate object w/ their name & # of votes
        Candidate[] candidates = new Candidate[5];

        // 5 candidate objects
        candidates[0] = new Candidate("Taylor Swift", 1313);
        candidates[1] = new Candidate("Kesha", 894);
        candidates[2] = new Candidate("Olivia Rodrigo", 867);
        candidates[3] = new Candidate("Britney Spears", 921);
        candidates[4] = new Candidate("Marina", 1254);

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
    public static void printCandidates(Candidate[] itemList){
        System.out.println("Raw Election Data:" + "\n");
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i] != null){
                System.out.println(itemList[i].toString());
            }
        }
    }

    // count the total of the votes for all the candidates
    public static int returnTotVotes(Candidate[] itemList){
        int totVotes = 0;
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i] != null){
                totVotes += itemList[i].getVotes();
            }
        }
        return totVotes;
    }

    // create a table w/ columns for the candidate name, votes, % of tot votes
    public static void printTable(Candidate[] itemList){
        double percentVote = 0.0;

        System.out.println("\n" + "Election Results:");
        System.out.printf("%26s %23s", "Votes", "% of Total");
        System.out.printf("\n %1s %17s %18s \n", "Candidate", "Received", "Votes");
        System.out.println("=======================================================");

        // table of data
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i] != null){
                percentVote = (itemList[i].getVotes() / (double)(returnTotVotes(itemList)) * 100);
                System.out.printf("%-20s %-20d %-1.2f \n", itemList[i].getName(), itemList[i].getVotes(), percentVote);
            }
        }

        // print total number of votes
        System.out.println("\n" + "The total number of votes is: " + returnTotVotes(itemList) + "\n");

    }

    // find candidate by name and change the name
    public static void changeCandidate(Candidate[] itemList, String find, String replace){
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(find)){
                itemList[i] = new Candidate(replace, itemList[i].getVotes());
            }
        }
        System.out.println("\n" + "<<Changing " + find + " to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find by name and change the number of votes
    public static void changeVotes(Candidate[] itemList, String find, int replace){
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(find)){
                itemList[i] = new Candidate(find, replace);
            }
        }
        System.out.println("\n" + "<<Changing " + find + " votes to " + replace + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

    // find candidate by name and replace both the name and number of votes 
    public static void changeCandAndVot(Candidate[] itemList, String name, String newName, int votes){

        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(name)){
                itemList[i] = new Candidate(newName, votes);
            }
            
        }

        System.out.println("\n" + "<<Changing " + name + " to " + newName + " and votes to " + votes + ">>" + "\n"); 
        
        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }

    // insert new candidate into position
    public static void insertNewCandidate(Candidate[] itemList, int position, String name, int votes){
        for(int i = (itemList.length - 1); i > position; i--){
            itemList[i] = itemList[(i - 1)];
        }
        itemList[position] = new Candidate(name, votes);

        System.out.println("\n" + "<<At position " + position + ", add " + name + ", " + votes + " votes>>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);
    }

    // find candidate by name and insert a new candidate before 
    public static void insertByName(Candidate[] itemList, String name, String newName, int votes){
        int location = 0;

        // find location of candidate you want to insert before
        for(int i = 0; i < itemList.length; i++){
            if(itemList[i].getName().equals(name)){
                location = i;
            }
        }
        //move candidates down
        for(int i = itemList.length - 1; i > location; i--){
            itemList[i] = itemList[i-1];
        }
        itemList[location] = new Candidate(newName, votes);

        System.out.println("\n" + "<<Before " + name + ", add " + newName + ", " + votes + " votes>>" + "\n");

         // raw election data
         printCandidates(itemList);

         //election results
         printTable(itemList);

    } 
    
    // delete candidate by position
    public static void deleteAtPos(Candidate[] itemList, int location){
        if ((location > 0) && (location < itemList.length)){
            for(int i = location; i < itemList.length -1; i++){
                itemList[i] = itemList[i + 1];
            }

            itemList[itemList.length-1] = null;
        }

        System.out.println("\n" + "<<Delete posistion " + location + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }


    // find candidate by name and delete candidate
    public static void deleteByName(Candidate [] itemList, String name){
        int location = 0;
        int i;

        // find location
        for(i = 0; i < itemList.length; i++){
            if((itemList[i] != null) && (itemList[i].getName().equals(name))){
                location = i;
                break;
            }
            else if(itemList[i] == null){
                location = -1;
                break;
            }
        }

        if ((i != itemList.length) && (location >= 0)){ 
            for(i = location; i < itemList.length -1; i++){
                itemList[i] = itemList[i + 1];
            }
            itemList[itemList.length-1] = null;
        }

        System.out.println("\n" + "<<Delete " + name + ">>" + "\n");

        // raw election data
        printCandidates(itemList);

        //election results
        printTable(itemList);

    }

}