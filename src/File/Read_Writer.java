package File;

import Room.Apartman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Read_Writer
{
    public static List<Apartman> List_toList_Soba(List<String> stringList)
    {
        List<Apartman> apartmen =new ArrayList<Apartman>();
        for (int i=0;i<stringList.size();i++)
        {
            String temp[]=stringList.get(i).split(",");
            int room_n=Integer.parseInt(temp[0]);
            boolean status=Boolean.parseBoolean(temp[2]);
            int size=Integer.parseInt(temp[1]);
            int t_size,krevet_c,krevet_l_c;
            try {
                switch (temp.length) {
                    case 6:
                        t_size = Integer.parseInt(temp[3]);
                        krevet_c = Integer.parseInt(temp[4]);
                        krevet_l_c = Integer.parseInt(temp[5]);
                        apartmen.add(new Apartman(room_n, status, t_size, krevet_c, krevet_l_c));
                        if (size != apartmen.get(i).get_Size()) {
                            apartmen.get(i).Change_Size(size);
                        }
                        break;
                    case 5:
                        krevet_c = Integer.parseInt(temp[3]);
                        krevet_l_c = Integer.parseInt(temp[4]);
                        apartmen.add(new Apartman(room_n, status, krevet_c, krevet_l_c));
                        if (size != apartmen.get(i).get_Size()) {
                            apartmen.get(i).Change_Size(size);
                        }
                        break;
                    case 4:
                        krevet_c = Integer.parseInt(temp[3]);
                        apartmen.add(new Apartman(room_n, status, krevet_c));
                        if (size != apartmen.get(i).get_Size()) {
                            apartmen.get(i).Change_Size(size);
                        }
                        break;
                    default:
                        throw new Exception_Error("Greska pri citanju sobe");
                }
            }
            catch (Exception_Error e)
            {
            }
        }
        return apartmen;
    }

    public static void ListApartman_toFile_Hotel(List<Apartman> apartmanList)
    {

        for (int i=0;i<apartmanList.size();i++)
        {
            try {
                Delete("Hotel.txt");

                String str="";
                for(Apartman x:apartmanList)
                {
                     str+= x.toString_File()+"\n";
                }

                Path path = Paths.get("Hotel.txt");
                Files.write(path,str.getBytes());
            }
            catch (IOException e)
            {
                System.out.println("\nError writing to file\n");
            }
        }
    }

    public static void Delete(String file_path_name)
    {
        File myObj = new File(file_path_name);
        myObj.delete();
    }
    public static void Create(String file_path_name)
    {
        try {
            File myObj = new File(file_path_name);
            myObj.createNewFile();

        }
        catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }


    }
    public static void Write(String file_path_name,String content)
    {
        try
        {
            FileWriter myWriter = new FileWriter(file_path_name);
            myWriter.write(content);
            myWriter.close();
        }
        catch (IOException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public static List<String> Read(String file_path_name)
    {
        List<String> file=new ArrayList<String>();
        try
        {
            file = Files.readAllLines(new File(file_path_name).toPath(), Charset.defaultCharset() );
        }
        catch (IOException e)
        {
            System.out.println("\nError reading File.\n");
            e.printStackTrace();
        }
        return file;
    }
}
