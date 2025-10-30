public class Search extends Thread{
    /* defining attributes */
    private int[] array; // array of values to search
    private int startingIndex; // starting index
    private int endingIndex; // ending index
    private int occurencesNumber; // number of occurences
    private int numberSearch;

    /* constructor method */
    public Search(int[] array, int startingIndex, int endingIndex, int numberSearch){
        this.array = array;
        this.startingIndex = startingIndex;
        this.endingIndex = endingIndex;
        this.numberSearch = numberSearch;
        this.occurencesNumber = 0;
    }

    /* running function to count occurences */
    @Override
    public void run(){
        for(int i=this.startingIndex;i<this.endingIndex;i++){
            if(this.array[i]==this.numberSearch)
                this.occurencesNumber++;
        }
    }

    /* function to return the result of the occurences */
    public int getOccurencesNumber(){
        return this.occurencesNumber;
    }
}
