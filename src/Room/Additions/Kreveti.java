package Room.Additions;

public class Kreveti extends Kreveti_Metode
{
    private int count;
    private int count_Big;
    public Kreveti(int ukupno_kreveta,int broj_velikih_kreveta)
    {
        count=ukupno_kreveta;
        count_Big=broj_velikih_kreveta;
    }

    @Override
    public int get_Price()
    {
        return (count-count_Big)*100+count_Big*250;
    }

    //getteri i setteri

    public void setCount(int count_)
    {
        count=count_;
    }

    public void setCount_Big(int countBig_)
    {
        count_Big=countBig_;
    }
    public int getCount()
    {
        return count;
    }
    public int getCount_Big()
    {
        return count_Big;
    }
}
