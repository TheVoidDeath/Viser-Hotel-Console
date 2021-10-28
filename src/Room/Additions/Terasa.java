package Room.Additions;

public class Terasa extends Terasa_Metode
{
    private int size;

    public Terasa(int _size_)
    {
        size=_size_;
    }
    @Override
    public String get_Size(int size_in_m2)
    {
        if(size_in_m2<=0)
        {
            return "none";
        }
        if(size_in_m2<10)
        {
            return "small";
        }
        else if(size_in_m2<15)
        {
            return "medium";
        }
        else if (size_in_m2<25)
        {
            return "large";
        }
        else if(size_in_m2>=25)
        {
            return "extra_large";
        }
        else
        {
            return "error";
        }
    }

    public int get_Size()
    {
        return size;
    }
    public void set_size(int size_)
    {
        size = size_;
    }

    @Override
    public int get_price()
    {
        if(get_Size(size).compareTo("none")==0)
        {
            return 0;
        }
        if(get_Size(size).compareTo("small")==0)
        {
            return 250;
        }
        else if(get_Size(size).compareTo("medium")==0)
        {
            return 350;
        }
        else if (get_Size(size).compareTo("large")==0)
        {
            return 650;
        }
        else if(get_Size(size).compareTo("extra_large")==0)
        {
            return 1500;
        }
        else
        {
            return 0;
        }
    }
}
