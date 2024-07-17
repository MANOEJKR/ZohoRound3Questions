public class Display extends BookingManagement {
    
    public static void display()
    {
        for(Passenger value : confirmberthList)
        {
            System.out.println(value.name + " " +value.age+" "+value.BirthPreference);
             
        }
         
    }
}
