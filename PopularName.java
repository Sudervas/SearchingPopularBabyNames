import java.util.ArrayList;
public class PopularName {
    //instance variables
private int rank,maleNumber,femaleNumber;
private String maleName,femaleName;
//constructor for male objects and instance variables
public PopularName(int rank,String maleName,int maleNumber){
    this.maleName=maleName;
    this.maleNumber=maleNumber;
    this.rank=rank;
}
//constructor for female objects and instance variables
    public PopularName(String femaleName,int femaleNumber,int rank){
        this.femaleName=femaleName;
        this.femaleNumber=femaleNumber;
        this.rank=rank;
}
//accessor for rank
    public int getRank() {
        return rank;
    }
    //mutator for rank
    public void setRank(int rank) {
        this.rank = rank;
    }
    //accessor for male number
    public int getMaleNumber() {
        return maleNumber;
    }
    //mutator for male number
    public void setMaleNumber(int maleNumber) {
        this.maleNumber = maleNumber;
    }
    //accessor for female number
    public int getFemaleNumber() {
        return femaleNumber;
    }
    //mutator for female number
    public void setFemaleNumber(int femaleNumber) {
        this.femaleNumber = femaleNumber;
    }
    //accessor for male name
    public String getMaleName() {
        return maleName;
    }
    //mutator for male name
    public void setMaleName(String maleName) {
        this.maleName = maleName;
    }
    //accessor for female name
    public String getFemaleName() {
        return femaleName;
    }
    //mutator for female name
    public void setFemaleName(String femaleName) {
        this.femaleName = femaleName;
    }

    public String toString(){
    return" male name"+ maleName+"number "+maleNumber+" female name"+femaleName+" number"+femaleNumber ;
    }
}
