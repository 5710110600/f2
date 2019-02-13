public class Tunnel{
    private int slotIn;
    private int slotOut;

    public Tunnel(int s_in, int s_out){
        this.slotIn = s_in;
        this.slotOut = s_out;
    }

    public int walkIn(int slot){
        if(slot == slotIn){
            System.out.println("!!! Bonut !!! out slot " + slotOut); //**********   
            return slotOut;
        }
        
        return slot;
       
    }
}