public class Bid{
    private String biddername;
    private int value;

    public Bid(String bidname, int price){
        biddername = bidname;
        value = price;
    }

    public String getBidderName(){
        return biddername;
    }

    public int getValue(){
        return value;
    }
}