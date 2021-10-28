package Hotel;

import Room.Apartman;

import java.util.ArrayList;
import java.util.List;

public class Hotel
{
    private List<Apartman> rooms;
    private int admin_key;

    public Hotel(List<Apartman> roomList)
    {
        rooms=new ArrayList<>(roomList);
        admin_key=29;
    }
    //Getter
    public List<Apartman> getRooms()
    {
        return rooms;
    }

    public void set_Room(int index)
    {
        rooms.remove(index);
    }
    public void set_Room(int index,Apartman x)
    {
        rooms.set(index,x);
    }
    public int get_Admin_Key()
    {
        return admin_key;
    }

    public Integer Get_index_by_ID(int Room_Number)
    {
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).get_ID()==Room_Number)
            {
                return i;
            }
        }
        return -1;
    }
    public List<Integer> Get_index_by_Floor(int Floor)
    {
        List<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<rooms.size();i++)
        {
            if((rooms.get(i).get_ID()/100)==Floor)
                temp.add(i);
        }
        return temp;
    }
    public List<Integer> Get_index_by_RoomSize(int size_in_m2)
    {
        List<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).get_Size()>=size_in_m2-3 && rooms.get(i).get_Size()<=size_in_m2+3)
                temp.add(i);
        }
        return temp;
    }
    public List<Integer> Get_index_by_RoomSize(String Base_to_Premium_Plus)
    {
        List<Integer>temp=new ArrayList<Integer>();
        switch (Base_to_Premium_Plus.toLowerCase())
        {
            case "base":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Size()>25 && rooms.get(i).get_Size()<50)
                        temp.add(i);
                }
                return temp;
            case "base_plus":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Size()>50 && rooms.get(i).get_Size()<75)
                        temp.add(i);
                }
                return temp;
            case "premium":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Size()>75 && rooms.get(i).get_Size()<100)
                        temp.add(i);
                }
                return temp;
            case "premium_plus":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Size()>100 && rooms.get(i).get_Size()<150)
                        temp.add(i);
                }
                return temp;
            default:
                return null;
        }
    }
    public List<Integer> Get_index_by_Terrace_Size(int size_in_m2)
    {
        List<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).get_ID()==size_in_m2)
                temp.add(i);
        }
        return temp;
    }
    public List<Integer> Get_index_by_Terrace_Size(String Not_to_Small_to_ExtraLarge)
    {
        List<Integer>temp=new ArrayList<Integer>();
        switch (Not_to_Small_to_ExtraLarge)
        {
            case "no":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Terace()==0)
                        temp.add(i);
                }
                return temp;
            case "small":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Terace()<10)
                        temp.add(i);
                }
                return temp;
            case "medium":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Terace()>10 && rooms.get(i).get_Terace()<15)
                        temp.add(i);
                }
                return temp;
            case "large":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Terace()>15 && rooms.get(i).get_Size()<25)
                        temp.add(i);
                }
                return temp;
            case "extra large":
                for(int i=0;i<rooms.size();i++)
                {
                    if(rooms.get(i).get_Terace()>25)
                        temp.add(i);
                }
                return temp;
            default:
                return null;
        }
    }
    public List<Integer> Get_index_by_Bed_Count(int Bed_Count)
    {
        List<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).get_Bed_Count()==Bed_Count)
                temp.add(i);
        }
        return temp;
    }
    public List<Integer> Get_index_by_Luxury_Bed_Count(int L_Bed_Count)
    {
        List<Integer>temp=new ArrayList<Integer>();
        for(int i=0;i<rooms.size();i++)
        {
            if(rooms.get(i).get_ID()==L_Bed_Count)
                temp.add(i);
        }
        return temp;
    }
}
