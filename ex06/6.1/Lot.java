import java.util.ArrayList;

public class Lot{
    private int lotnum;
    private String description;             
    private int highest;                //=========
    private ArrayList<Bid> bids; 

    public Lot(int num, String des){
        lotnum = num;
        description = des;
        highest = 0;                    //=========
        bids = new ArrayList<Bid>();   
     
    }

    public void bidFor(String nameBid, int price ){ 
        bids.add( new Bid(nameBid, price) );   
    }

    public String getDescription(){
        return description;
    }

    public int getHighestBid(){
        for(Bid b : bids){
            if(b.getValue() >  highest)
                 highest = b.getValue();
        }
        return highest;
    }

    public int getIdNum(){
        return lotnum;
    }

    public String toString(){
        String s = " ";
        if(bids.isEmpty()){
            s = getIdNum() + getDescription() +"        <NO bid>";
        }
        else{
            for(Bid b: bids){
                if(b.getValue() == getHighestBid())
                    s = getIdNum() + getDescription() +"Bid " + getHighestBid() + "by" + b.getBidderName();
            }
        }
    return s;
    }

}