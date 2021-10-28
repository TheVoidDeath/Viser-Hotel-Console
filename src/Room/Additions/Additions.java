package Room.Additions;

public class Additions
{
    private Terasa terasa;
    private Kreveti kreveti;
    public Additions(int terasa_size,int bed_count,int big_bed_count)
    {
        terasa=new Terasa(terasa_size);
        kreveti=new Kreveti(bed_count,big_bed_count);
    }
    public Additions(int bed_count,int big_bed_count)
    {
        terasa=new Terasa(0);
        kreveti=new Kreveti(bed_count,big_bed_count);
    }
    public Additions(int bed_count)
    {
        terasa=new Terasa(0);
        kreveti=new Kreveti(bed_count,0);
    }
    public int get_Price()
    {
        return terasa.get_price()+kreveti.get_Price();
    }


    //getters and setters
    public void set_T_Size(int size_t)
    {
        terasa.set_size(size_t);
    }
    public void set_Bed_C(int count)
    {
        kreveti.setCount(count);
    }
    public void set_L_Bed_C(int count_b)
    {
        kreveti.setCount_Big(count_b);
    }
    public int get_T_Size()
    {
        return terasa.get_Size();
    }
    public int get_Bed_C()
    {
        return kreveti.getCount();
    }
    public int get_L_Bed_C()
    {
        return kreveti.getCount_Big();
    }
}
