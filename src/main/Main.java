package main;

import File.Exception_Error;
import File.Read_Writer;
import Hotel.Hotel;
import Room.Apartman;

import java.util.*;

public class Main {
    public static void printline(String s)
    {
        System.out.println(s);
    }

    public static void main(String[] args)
    {
        //Deklaracija glavnog tipa i citanje iz fajla
        Hotel main=new Hotel(Read_Writer.List_toList_Soba(Read_Writer.Read("Hotel.txt")));

        //Deklaracija skenera za citanje inputa
        Scanner s=new Scanner(System.in);
        String input;

        String language="";
        lang_loop:while(language.toLowerCase().compareTo("en")!=0 && language.toLowerCase().compareTo("sr")!=0)
        {
            printline("Da li zelite interface na Engleskom ili na Srpskom?\nDo you want the interface in English or Serbian?\nUneti(en/sr)\n");
            language = s.nextLine();
        }


        m_loop:do {
            switch (language) {
                case "sr":
                    printline("Postovani, Dobro dosli u hotel Pinosava,\nUkoliko zelite da iznajmite sobu unesite DA , ukoliko zelite da vidite slobodne sobe unesite Filter, ukoliko zelite da izdjete iz aplikacije unesite EXIT");
                    break;
                case "en":
                    printline("Hello and welcome to hotel Pinosava \nIf you wish to rent a room enter YES, in case you want to check available rooms enter Filter, and in case you want to leave enter EXIT");
                    break ;
            }

            input=s.nextLine();

            if(input.toLowerCase().compareTo("exit")==0)
            {
                break;
            }
            else if (input.toLowerCase().compareTo("filter")==0)
            {
                switch (language) {
                    case "sr":
                        printline("1-Da li imate neke specifikacije apartmana koji zelite, \nili zelite da vam \n2-Prikazemo sve slobodne apartmane\n(1/2)");
                        break;
                    case "en":
                        printline("1-If you have certain requirements for your apartmen, \nor if you\n2-Just want to see all available apartmens\n(1/2)");
                        break ;
                }
                input=s.nextLine();
                m_switch:switch (input.toLowerCase())
                {
                    case "1":
                        List<Integer> selected_index=new ArrayList<Integer>();
                        switch (language) {
                            case "sr":
                                printline("Unesite parametre koje biste zeleli da postavite (Velicina_Apartmana/Terasa/Ukupno_Kreveta/Broj_Velikih_Kreveta)\nUneti sve parametre odjednon\n");
                                break ;
                            case "en":
                                printline("Enter the requirements that you want to set(Size_of_the_Apartment/Terace/Total_Beds/Big_Beds)\nEnter all the requirements in one line\n");
                                break ;
                        }
                        input=s.nextLine();
                        if(input.toLowerCase().contains("velicina_apartmana") || input.toLowerCase().contains("size_of_the_apartment"))
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Unesite velicinu apartmana koju zelite\nVelicinu mozete uneti u m2\nili mozete uneti neki od nasih paketa (Base/Base_Plus/Premium/Premium_Plus)");
                                    break;
                                case "en":
                                    printline("Enter the size that will be searched\nYou can enter the size either in m2\nor you can use our premade size 'templates' (Base/Base_Plus/Premium/Premium_Plus)");
                                    break;
                            }

                            String input_help=s.nextLine();
                            try
                            {
                                int converted_int=Integer.parseInt(input_help);
                                selected_index.addAll(main.Get_index_by_RoomSize(converted_int));
                            }
                            catch (NumberFormatException e)
                            {
                                boolean succes1=false;
                                while (!succes1)
                                try {
                                    selected_index.addAll(main.Get_index_by_RoomSize(input_help));
                                    succes1=true;
                                }
                                catch (NullPointerException e1)
                                {
                                    printline("Error in input. (When entering premade sizes the _ is important!)\n");
                                    input_help=s.nextLine();
                                }
                            }
                        }
                        if(input.toLowerCase().contains("terasa") || input.toLowerCase().contains("terace"))
                        {
                            switch (language) {
                                case "sr":
                                    printline("Unesite terase koju zelite\nVelicinu mozete uneti u m2\nili mozete uneti neki od nasih standardnih velicina (None/Small/Medium/Large/Extra_Large)");
                                    break;
                                case "en":
                                    printline("Enter the size of the terace that will be searched\nYou can enter the size either in m2\nor you can use our premade size 'templates' (None/Small/Medium/Large/Extra_Large) Watch out for _! \n");
                                    break ;

                            }
                            String input_help=s.nextLine();
                            try
                            {
                                int converted_int=Integer.parseInt(input_help);
                                selected_index.addAll(main.Get_index_by_Terrace_Size(converted_int));
                            }
                            catch (NumberFormatException e)
                            {
                                selected_index.addAll(main.Get_index_by_Terrace_Size(input_help));
                            }
                        }
                        if(input.toLowerCase().contains("ukupno_kreveta") || input.toLowerCase().contains("total_beds"))
                        {
                            switch (language) {
                                case "sr":
                                    printline("Koliko kreveta zelite u vasem apartmanu?\n");
                                    break ;
                                case "en":
                                    printline("How many beds do you want in your apartment?\n");
                                    break ;
                            }
                            String input_help=s.nextLine();
                            boolean success=false;
                            while (!success) {
                                try {
                                    int converted_int = Integer.parseInt(input_help);
                                    success=true;
                                    selected_index.addAll(main.Get_index_by_Bed_Count(converted_int));

                                } catch (NumberFormatException e) {
                                    switch (language) {
                                        case "sr":
                                            printline("Niste tacno uneli broj krveta, molim vas pokusajte ponovo\n");
                                            break;
                                        case "en":
                                            printline("Error in input, please try again\n");
                                            break;
                                    }
                                }
                            }
                        }
                        if(input.toLowerCase().contains("broj_velikih_kreveta") ||input.toLowerCase().contains("big_beds"))
                        {
                            switch (language) {
                                case "sr":
                                    printline("Koliko Luxury kreveta zelite u vasem apartmanu\n");
                                    break;
                                case "en":
                                    printline("How many Luxury beds do you want?");
                            }
                            String input_help=s.nextLine();
                            boolean success=false;
                            while (!success) {
                                try {
                                    int converted_int = Integer.parseInt(input_help);
                                    success=true;
                                    selected_index.addAll(main.Get_index_by_Bed_Count(converted_int));

                                } catch (NumberFormatException e)
                                {
                                    switch (language) {
                                        case "sr":
                                            printline("Niste tacno uneli broj luxury krveta, molim vas pokusajte ponovo\n");
                                            break;
                                        case "en":
                                            printline("Eror in input, please try again\n");
                                    }
                                }
                            }
                        }
                        Set<Integer> selected_i=new HashSet<Integer>(selected_index);
                        for(int i=0;i<main.getRooms().size();i++)
                        {
                            for(Integer y:selected_i)
                            {
                                if(i==y && !main.getRooms().get(i).get_Availability())
                                {
                                    printline(main.getRooms().get(i).toString());
                                }
                            }
                        }
                        break m_switch;
                    case "2":
                        for (Apartman x:main.getRooms())
                        {
                            if(!x.get_Availability()) {
                                printline(x.toString());
                            }
                        }
                        break m_switch;
                    case "exit":
                        break m_loop;
                }
            }
            else if(input.toLowerCase().compareTo("da")==0 || input.toLowerCase().compareTo("yes")==0)
            {
                switch (language) {
                    case "sr":
                        printline("Koji apartman zelite da iznajmite?\n");
                        break ;
                    case "en":
                        printline("Which apartment number are you interested in?\n");
                }
                boolean success=false;
                while (!success) {
                    try {
                        input=s.nextLine();

                        if(input.toLowerCase().contains("exit"))
                        {
                            break ;
                        }

                        int room_id = Integer.parseInt(input);
                        if(main.getRooms().get(main.Get_index_by_ID(room_id)).get_Availability()==false)//Provera raspolozivosti
                        {
                            switch (language) {
                                case "sr":
                                    printline("Da li ste sigurni da zelite da iznajmite (da/ne)\n");
                                    break;
                                case "en":
                                    printline("Are you sure that you want that apartment (Yes/No)\n");
                            }

                            //Confirmation
                            input=s.nextLine();
                            if(input.toLowerCase().compareTo("da")==0 ||input.toLowerCase().compareTo("yes")==0)
                            {
                                //Promena raspolozivosti
                                main.getRooms().get(main.Get_index_by_ID(room_id)).set_Availability(true);
                                //Cuvanje u fajl
                                Read_Writer.ListApartman_toFile_Hotel(main.getRooms());
                                switch (language) {
                                    case "sr":
                                        printline("Uspesno ste iznajmili sobu za narednu nedelju, po ceni od " + main.getRooms().get(main.Get_index_by_ID(room_id)).get_Price() + " dinara!");
                                        break ;
                                    case "en":
                                        printline("You have successfully rented the room for the upcoming 7 days, at the end of the week you will have to play " + (main.getRooms().get(main.Get_index_by_ID(room_id)).get_Price()/120) + " euros!");
                                        break ;
                                }
                                success = true;
                            }
                            else if(input.toLowerCase().compareTo("ne")==0 || input.toLowerCase().compareTo("no")==0)
                            {
                                success=false;
                                break;
                            }
                            else if(input.toLowerCase().compareTo("exit")==0)
                            {
                                break m_loop;
                            }
                            else
                            {
                                success=false;
                                switch (language) {
                                    case "sr":
                                        printline("\nMozete uneti samo da ili ne (Nije case-sensitive)\n");
                                        break;
                                    case "en":
                                        printline("\nYou can only enter yes or no (not case-sensitive)\n");
                                        break ;
                                }
                            }
                        }
                        else if(main.getRooms().get(main.Get_index_by_ID(room_id)).get_Availability()==true)
                        {
                            switch (language) {
                                case "sr":
                                    printline("\nTaj apartman je zauzet\n");
                                    break;
                                case "en":
                                    printline("\nThat apartment is busy\n");
                                    break ;
                            }
                            success=false;
                        }
                        else
                        {
                            switch (language) {
                                case "sr":
                                    printline("\nApartman sa tim brojem nepostoji\n");
                                    break;
                                case "en":
                                    printline("\nThat apartment doesn't exist\n");
                                    break;
                            }
                            success=false;
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        switch (language) {
                            case "sr":
                                printline("Niste tacno uneli broj sobe, molim vas pokusajte ponovo\n");
                                break;
                            case "en":
                                printline("Error in inputing the room number, please try again\n");
                                break;
                        }
                    }
                }
            }
            else if(input.toLowerCase().compareTo(String.valueOf(main.get_Admin_Key()))==0)
            {
                switch (language)
                {
                    case "sr":
                        printline("\n1-Da li zelite da dodate novi apartman\n ili da \n2-Izmenite stanje nekog od postojecih\n ili da\n3-Izbrisete postojeci apartman? \n(1/2/3)\n");
                        break ;
                    case "en":
                        printline("\n1-Do you want to add a new apartmen\n or do you\n2-Want to change properties of an existing one\nor do you\n3-Want to delete an existing apartment? \n(1/2/3)\n");
                        break ;
                }
                input=s.nextLine();
                adding_switch:switch (input.toLowerCase())
                {
                    case "1":
                        int room_n=0,room_size=0,terace_size=0,bed_c=0,l_bed_c=0;
                        boolean taken=false;

                        boolean succes=false;
                        //Unos broja apartmana
                        succes=false;
                        while (!succes)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Unesite broj apartmana:( x )");
                                    break ;
                                case "en":
                                    printline("Enter apartment number:( x )");
                                    break ;
                            }
                            try {
                                room_n = s.nextInt();
                                succes=true;
                            }
                            catch (InputMismatchException e) {
                                succes=false;
                                switch (language)
                                {
                                    case "sr":
                                        printline("Greska u unosu, mora biti ceo broj");
                                        break ;
                                    case "en":
                                        printline("Error in input MUST BE rounded number");
                                        break ;
                                }
                                break adding_switch;
                            }

                        }
                        //Unos velicine apartmana
                        succes=false;
                        while (!succes)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Unesite velicinu apartmana:( x )");
                                    break ;
                                case "en":
                                    printline("Enter apartment size:( x )");
                                    break ;
                            }
                            try {
                                room_size = s.nextInt();
                                succes=true;
                            }
                            catch (InputMismatchException e) {
                                succes=false;
                                switch (language)
                                {
                                    case "sr":
                                        printline("Greska u unosu, mora biti ceo broj");
                                        break ;
                                    case "en":
                                        printline("Error in input MUST BE rounded number");
                                        break ;
                                }
                                break adding_switch;
                            }

                        }
                        //Unos da li je zauzeta ili ne
                        succes=false;
                        while (!succes)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Da li je apartman zauzeta:(true/false)");
                                    break ;
                                case "en":
                                    printline("Enter apartment availability:(true/false)");
                                    break ;
                            }
                            try {
                                taken = s.nextBoolean();
                                succes=true;
                            }
                            catch (InputMismatchException e) {
                                succes=false;
                                switch (language)
                                {
                                    case "sr":
                                        printline("Greska u unosu, mora biti TRUE ili FALSE");
                                        break ;
                                    case "en":
                                        printline("Error in input MUST BE TRUE OR FALSE");
                                        break ;
                                }
                                break adding_switch;
                            }

                        }
                        //Unos broja kreveta
                        succes=false;
                        while (!succes)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Unesite ukupan broj kreveta:( x )");
                                    break ;
                                case "en":
                                    printline("Enter total count of beds:( x )");
                                    break ;
                            }
                            try {
                                bed_c = s.nextInt();
                                succes=true;
                            }
                            catch (InputMismatchException e) {
                                succes=false;
                                switch (language)
                                {
                                    case "sr":
                                        printline("Greska u unosu, mora biti ceo broj");
                                        break ;
                                    case "en":
                                        printline("Error in input MUST BE rounded number");
                                        break ;
                                }
                                break adding_switch;
                            }

                        }

                        //Unos broja luxury kreveta
                        succes=false;
                        while (!succes)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Unesite broj luksuznih kreveta:( x/0 )");
                                    break ;
                                case "en":
                                    printline("Enter count of luxury beds:( x/0 )");
                                    break ;
                            }
                            try {
                                l_bed_c = s.nextInt();
                                succes=true;
                            }
                            catch (InputMismatchException e) {
                                succes=false;
                                switch (language)
                                {
                                    case "sr":
                                        printline("Greska u unosu, mora biti ceo broj");
                                        break ;
                                    case "en":
                                        printline("Error in input MUST BE rounded number");
                                        break ;
                                }
                                break adding_switch;

                            }

                        }


                        //Unos velicine terase
                        succes=false;
                        while (!succes) {
                            switch (language) {
                                case "sr":
                                    printline("Unesite velicinu terase :( x/0 )");
                                    break;
                                case "en":
                                    printline("Enter terace size:( x/0 )");
                                    break;
                            }
                            try {
                                terace_size = s.nextInt();
                                succes = true;
                            } catch (InputMismatchException e) {
                                succes = false;
                                switch (language) {
                                    case "sr":
                                        printline("Greska u unosu, mora biti ceo broj");
                                        break;
                                    case "en":
                                        printline("Error in input MUST BE rounded number");
                                        break;
                                }
                                break adding_switch;

                            }

                        }


                        //Finalna provera i unosenje u bazu i fajl
                        try
                        {


                            if((room_n<=0 || main.Get_index_by_ID(room_n)==-1) || room_size<25 || terace_size<0||bed_c<0||bed_c<l_bed_c)
                            {
                                throw new Exception_Error("Podatci nisu ispravno uneseni");
                            }
                            Apartman temp=new Apartman(room_n,taken,terace_size,bed_c,l_bed_c);
                            temp.Change_Size(room_size);
                            main.getRooms().add(temp);
                            printline("Uspesno je dodata soba!");
                            Read_Writer.ListApartman_toFile_Hotel(main.getRooms());
                        }
                        catch (Exception_Error e)
                        {
                            printline(e.getMessage());
                            break adding_switch;
                        }

                        break adding_switch;
                    case "2":
                        switch (language)
                        {
                            case "sr":
                                printline("Unesite broj apartmana koji zelite da izmenite: (x)");
                                break;
                            case "en":
                                printline("Enter the apartment number of the apartment you want to change : (x)");
                                break;
                        }
                        int room_n_2=0;
                        try {
                            room_n_2=s.nextInt();
                        }
                        catch (InputMismatchException e)
                        {
                            printline("Error in input");
                            break adding_switch;
                        }
                        Apartman t;
                        if(room_n_2!=0)
                        {
                            try {
                                t = main.getRooms().get(main.Get_index_by_ID(room_n_2));
                                printline("Podatci te sobe su " + t.toString());


                                switch (language) {
                                    case "sr":
                                        printline("Unesite podatke koje zelite da promenite (Zauzeta/Velicina_Apartmana/Terasa/Ukupno_Kreveta/Broj_Velikih_Kreveta)\nUneti sve parametre odjednon\n");
                                        break;
                                    case "en":
                                        printline("Enter the data that you want to change(Availability/Size_of_the_Apartment/Terace/Total_Beds/Big_Beds)\nEnter all the requirements in one line\n");
                                        break;
                                }


                                input = s.nextLine();
                                input = s.nextLine();


                                if (input.toLowerCase().contains("zauzeta") || input.toLowerCase().contains("availability")) {
                                    switch (language) {
                                        case "sr":
                                            printline("Da li je apartman zauzet? : (true/false)");
                                            break;
                                        case "en":
                                            printline("Is the apartment busy? : (true/false)");
                                            break;
                                    }


                                    try {
                                        boolean input_help = s.nextBoolean();
                                        t.set_Availability(input_help);
                                    } catch (NumberFormatException e) {
                                        printline("Error in input");
                                        break adding_switch;
                                    }
                                }
                                if(input.toLowerCase().contains("velicina_apartmana") || input.toLowerCase().contains("size_of_the_apartment"))
                                {
                                    switch (language)
                                    {
                                        case "sr":
                                            printline("Unesite novu velicinu apartmana u  m2 : (x)");
                                            break;
                                        case "en":
                                            printline("Enter the size in m2: (x)");
                                            break;
                                    }

                                    String input_help=s.nextLine();
                                    try
                                    {
                                        int converted_int=Integer.parseInt(input_help);
                                        t.Change_Size(converted_int);
                                    }
                                    catch (NumberFormatException e)
                                    {
                                        printline("Error in input");
                                        break adding_switch;
                                    }
                                }
                                if(input.toLowerCase().contains("terasa") || input.toLowerCase().contains("terace"))
                                {
                                    switch (language) {
                                        case "sr":
                                            printline("Unesite velicinu terase u m2 :( x/0 )");
                                            break;
                                        case "en":
                                            printline("Enter the size of the terace in m2 : ( x/0 )");
                                            break ;

                                    }
                                    String input_help=s.nextLine();
                                    try
                                    {
                                        int converted_int=Integer.parseInt(input_help);
                                        t.set_Terace(converted_int);
                                    }
                                    catch (NumberFormatException e)
                                    {
                                        printline("Error in input");
                                        break adding_switch;
                                    }
                                }
                                if(input.toLowerCase().contains("ukupno_kreveta") || input.toLowerCase().contains("total_beds"))
                                {
                                    switch (language) {
                                        case "sr":
                                            printline("Koliko kreveta ima u apartmanu??\n");
                                            break ;
                                        case "en":
                                            printline("How many beds are there in the apartment?\n");
                                            break ;
                                    }
                                    String input_help=s.nextLine();
                                    boolean success=false;
                                    while (!success) {
                                        try {
                                            int converted_int = Integer.parseInt(input_help);
                                            success=true;
                                            t.set_Bed_C(converted_int);

                                        } catch (NumberFormatException e) {
                                            switch (language) {
                                                case "sr":
                                                    printline("Niste tacno uneli broj krveta, molim vas pokusajte ponovo\n");
                                                    break;
                                                case "en":
                                                    printline("Error in input, please try again\n");
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if(input.toLowerCase().contains("broj_velikih_kreveta") ||input.toLowerCase().contains("big_beds"))
                                {
                                    switch (language) {
                                        case "sr":
                                            printline("Koliko Luxury kreveta postoji u apartmanu\n");
                                            break;
                                        case "en":
                                            printline("How many Luxury beds are there?");
                                    }
                                    String input_help=s.nextLine();
                                    boolean success=false;
                                    while (!success) {
                                        try {
                                            int converted_int = Integer.parseInt(input_help);
                                            if(t.get_Bed_Count()<converted_int)
                                            {
                                                t.set_L_Bed_C(converted_int);
                                                success=true;
                                            }
                                            else
                                            {
                                                switch (language) {
                                                    case "sr":
                                                        printline("Nemoze biti vise luxuznih kreveta nego sto ih ima ukupno\n");
                                                        break;
                                                    case "en":
                                                        printline("There can't be more luxury beds than total beds?");
                                                        succes=false;
                                                }
                                            }

                                        } catch (NumberFormatException e)
                                        {
                                            switch (language) {
                                                case "sr":
                                                    printline("Niste tacno uneli broj luxury krveta, molim vas pokusajte ponovo\n");
                                                    break;
                                                case "en":
                                                    printline("Eror in input, please try again\n");
                                            }
                                        }
                                    }
                                }
                                try
                                {


                                    if( t.get_ID()<=0 ||  t.get_Size()<25 || t.get_Terace()<0||t.get_Bed_Count()<0||t.get_Bed_Count()<t.get_Large_Bed_Count())
                                    {
                                        throw new Exception_Error("Podatci nisu ispravno uneseni");
                                    }
                                    main.set_Room(main.Get_index_by_ID(t.get_ID()),t);
                                    printline("Uspesno je promenjen apartman!");
                                    Read_Writer.ListApartman_toFile_Hotel(main.getRooms());
                                }
                                catch (Exception_Error e)
                                {
                                    printline(e.getMessage());
                                    break adding_switch;
                                }
                            }
                            catch (IndexOutOfBoundsException e)
                            {
                                switch (language)
                                {
                                    case "sr":
                                        printline("Ta soba nepostoji");
                                        break;
                                    case "en":
                                        printline("That room doesn't exist");
                                        break;
                                }
                                break adding_switch;
                            }
                        }


                        break adding_switch;
                    case "3":
                        switch (language)
                        {
                            case "sr":
                                printline("Unesite broj apartmana koji zelite da izbrisete: (x)");
                                break;
                            case "en":
                                printline("Enter the apartment number of the apartment you want to delete : (x)");
                                break;
                        }
                        int input_h=s.nextInt();
                        try
                        {
                            main.set_Room(main.Get_index_by_ID(input_h));
                            Read_Writer.ListApartman_toFile_Hotel(main.getRooms());
                            switch (language)
                            {
                                case "sr":
                                    printline("Uspesno je izbrisan apartman br"+input_h);
                                    break;
                                case "en":
                                    printline("Successfully deleted apartment n"+input_h);
                                    break;
                            }
                        }
                        catch (IndexOutOfBoundsException e)
                        {
                            switch (language)
                            {
                                case "sr":
                                    printline("Taj apartman nepostoji");
                                    break;
                                case "en":
                                    printline("That apartment doesn't exist");
                                    break;
                            }
                        }
                        break adding_switch;
                }
            }
        }
        while (true);
        switch (language) {
            case "sr":
                printline("\n\nHvala vam na vasoj poseti Hotelu Pinosava\nNadamo se da ste uzivali!\n");
                break;
            case "en":
                printline("\n\nThank you for visiting Hotel Pinosava\nWe hope you have enjoyed your stay\n");
                break;
        }
    }





}
