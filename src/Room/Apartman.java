package Room;

import Room.Additions.Additions;

public class Apartman implements Osnovni_Apartman
{
    private int velicina;
    private int r_number;
    private boolean zauzeta;
    private Additions dodatci;

    public Apartman(int room_number, boolean taken, int terasa_size, int bed_count, int big_bed_count)
    {
        r_number=room_number;
        velicina=size;
        zauzeta=taken;
        dodatci=new Additions(terasa_size,bed_count,big_bed_count);
    }
    public Apartman(int room_number, boolean taken, int bed_count, int big_bed_count)
    {
        r_number=room_number;
        velicina=size;
        zauzeta=taken;
        dodatci=new Additions(bed_count,big_bed_count);
    }
    public Apartman(int room_number, boolean taken, int bed_count)
    {
        r_number=room_number;
        velicina=size;
        zauzeta=taken;
        dodatci=new Additions(bed_count);
    }


    public void Change_Size(int actual_size)
    {
        velicina=actual_size;
    }

    public int room_Price()
    {
        if(velicina<25)
        {
            return 0;
        }
        else if(velicina<50)
        {
            return base_price;
        }
        else if(velicina<75)
        {
            return 1500;
        }
        else if(velicina<100)
        {
            return 2500;
        }
        else if(velicina<150)
        {
            return 5000;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public int get_Price() {
        return room_Price()+dodatci.get_Price();
    }

    @Override
    public String toString() {
        if (get_Terace()==0 && get_Large_Bed_Count()!=0)
        {
            return ("Apartman "+ r_number+" koji se nalazi na spratu "+r_number/100+" ima "+get_Size()+"m2,  i ima "+get_Bed_Count()+"kreveta od kojih su "+get_Large_Bed_Count()+" veliki kreveti.");
        }
        else if(get_Terace()==0)
        {
            return ("Apartman "+ r_number+" koji se nalazi na spratu "+r_number/100+" ima "+get_Size()+"m2,  i ima "+get_Bed_Count()+"kreveta.");
        }
        else if (get_Terace()!=0 && get_Large_Bed_Count()!=0)
        {
            return ("Apartman "+ r_number+" koji se nalazi na spratu "+r_number/100+" ima "+get_Size()+"m2, Terasu od "+get_Terace()+"m2 i ima "+get_Bed_Count()+"kreveta od kojih su "+get_Large_Bed_Count()+" veliki kreveti.");
        }
        else
        {
            return ("Apartman "+ r_number+" koji se nalazi na spratu "+r_number/100+" ima "+get_Size()+"m2, Terasu od "+get_Terace()+"m2 i ima "+get_Bed_Count()+"kreveta.");
        }
    }

    public String toString_File()
    {
        if (get_Terace()==0 && get_Large_Bed_Count()!=0)
        {
            return String.valueOf(r_number)+","+ String.valueOf(get_Size()) +","+ String.valueOf(get_Availability())+ ","+String.valueOf(get_Bed_Count())+","+String.valueOf(get_Large_Bed_Count());
        }
        else if(get_Terace()==0)
        {
            return String.valueOf(r_number)+","+String.valueOf(get_Size())+","+ String.valueOf(get_Availability())+ ","+String.valueOf(get_Bed_Count());
        }
        else if (get_Terace()!=0 && get_Large_Bed_Count()!=0)
        {
            return String.valueOf(r_number)+","+String.valueOf(get_Size())+","+ String.valueOf(get_Availability())+ ","+String.valueOf(get_Terace())+","+String.valueOf(get_Bed_Count())+","+String.valueOf(get_Large_Bed_Count());
        }
        else
        {
            return String.valueOf(r_number)+","+String.valueOf(get_Size())+","+ String.valueOf(get_Availability())+ ","+String.valueOf(get_Terace())+","+String.valueOf(get_Bed_Count()+","+0);
        }
    }


    //Getters and setters
    public void set_Terace(int size)
    {
        dodatci.set_T_Size(size);
    }
    public void set_Bed_C(int count)
    {
        dodatci.set_Bed_C(count);
    }
    public void set_L_Bed_C(int count)
    {
        dodatci.set_L_Bed_C(count);
    }

    public int get_Size()
    {
        return velicina;
    }
    public int get_ID()
    {
        return r_number;
    }
    public int get_Velicina()
    {
        return velicina;
    }
    public boolean get_Availability()
    {
        return zauzeta;
    }
    public void set_Availability(boolean setter)
    {
        zauzeta=setter;
    }
    public int get_Terace()
    {
        return dodatci.get_T_Size();
    }
    public int get_Bed_Count()
    {
        return dodatci.get_Bed_C();
    }
    public int get_Large_Bed_Count()
    {
       return dodatci.get_L_Bed_C();
    }
}