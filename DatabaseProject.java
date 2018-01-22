
import java.sql.*;
import java.util.Scanner;

public class DatabaseProject {  
    public static void main(String[] args) {     
        try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:PORT/DBNAME",
                    "USERNAME",
                    "PASSWORD");
                
            //http://docs.oracle.com/javadb/10.3.3.0/devguide/rdevconceptssur.html
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                  ResultSet.CONCUR_UPDATABLE);     
            Scanner userIn = new Scanner(System.in);
            )
        {
            int options = 1;
            boolean loop = true;
            //user interface loop
            while(loop){
                //display menu
                System.out.println();   
                System.out.println("Select an option: ");   
                System.out.println("1)List all album titles ");   
                System.out.println("2)Get album data "); //enter album title at case 2
                System.out.println("3)Insert a new album ");   
                System.out.println("4)Insert a new studio");
                System.out.println("5)Remove an album ");   
                System.out.println("6)Exit ");                  
                options = userIn.nextInt();
                
                switch(options){
                    case 1: {
                        ResultSet rset = stmt.executeQuery("select albumTitle from album");
                        System.out.println();
                        System.out.println("Albums\n-----------");
                        
                        while(rset.next()){
                            System.out.println(rset.getString("albumTitle"));
                        }
                    }
                    break;
                    case 2: {
                        userIn.nextLine();   
                        String album;
                        System.out.print("Enter an album Name: ");
                        album = userIn.nextLine();
                        ResultSet rset = stmt.executeQuery("select * from album where albumTitle='" + album + "'");                        
                        try{
                            if(!rset.isBeforeFirst()){
                                System.out.println("No album with that name!");
                            }else{
                                rset.next();
                                System.out.println(
                                    "Album: "     + rset.getString(1) + " | " + 
                                    "Group: "     + rset.getString(2) + " | " + 
                                    "Studio: "    + rset.getString(3) + " | " + 
                                    "Released: "  + rset.getString(4) + " | " + 
                                    "Length: "    + rset.getString(5) + " | " + 
                                    "No. Songs: " + rset.getString(6)               
                                    );
                            }
                        }
                        catch(SQLException e){
                            e.printStackTrace();
                        }
                    }        
                    break;
                    case 3: {
                        userIn.nextLine();
                        System.out.print("Enter new album name: ");
                        String albumN = userIn.nextLine();

                        System.out.print("Enter group name: ");
                        String groupN = userIn.nextLine();

                        System.out.print("Enter studio name: ");
                        String studioN = userIn.nextLine();

                        System.out.print("Enter date recorded: ");
                        String recorded = userIn.nextLine();

                        System.out.print("Enter length: ");
                        String length = userIn.nextLine();

                        System.out.print("Enter number of tracks: ");
                        String number = userIn.next();

                        System.out.println("Is this information correct: y or n: ");
                        String answer = userIn.next();
                        
                        if(answer.equalsIgnoreCase("n"))
                            break;

                        try{
                            stmt.executeUpdate("insert into album values('" +
                                          albumN   + "'," +
                                    "'" + groupN   + "'," +
                                    "'" + studioN  + "'," +
                                    "'" + recorded + "'," +
                                    "'" + length   + "'," +
                                    "'" + number   + "')");
                            System.out.println("Album " + albumN + " added!");
                        }
                        catch(SQLException e){
                            e.printStackTrace();
                        }
                    }        
                    break;

                    //do case 4 and 5, thanks    
                    case 4: {
                        userIn.nextLine();
                        System.out.print("Enter studio's name: ");
                        String studioN = userIn.nextLine();
                        
                        System.out.print("Enter studio's address: ");
                        String studioA = userIn.nextLine();
                        
                        System.out.print("Enter studio's owner: ");
                        String studioO = userIn.nextLine();
                        
                        System.out.print("Enter studio's phone number: ");
                        String studioP = userIn.nextLine();
                        
                        System.out.print("Is this information correct: y or n: ");
                        String answer = userIn.next();
                        
                        userIn.nextLine();
                        System.out.print("Enter an album to change its studio: ");
                        String album = userIn.nextLine();
                        
                        ResultSet result= stmt.executeQuery("select * from album where albumTitle='" + album + "'");
                                
                        if(answer.equalsIgnoreCase("n"))
                            break;

                        try{
                            stmt.executeUpdate("insert into recordingStudio values('" +
                                          studioN   + "'," +
                                    "'" + studioA   + "'," +
                                    "'" + studioO  + "'," +
                                    "'" + studioP + "')");
                        }
                         catch(SQLException e){
                            e.printStackTrace();
                        }
                        
                        if(!result.isBeforeFirst()){
                                System.out.println("No album with that name!");
                            }
                        else{
                            try{
                                stmt.executeUpdate("update album set studioName = '"+ studioN + "where albumTitle = '" + album + "'");
                                System.out.println("Hello there from else");
                                System.out.println("Album " + album + " recording studio changed to " + studioN);
                                System.out.println("Studio " + studioN + " added!");
                            }catch(SQLException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                    case 5: {
                        userIn.nextLine();
                        String album;
                        System.out.print("Enter an album Name: ");
                        album = userIn.nextLine();
                        ResultSet rset = stmt.executeQuery("select * from album where albumTitle='" + album + "'");
                        
                        try{
                            if(!rset.isBeforeFirst()){
                                System.out.println("No album with that name!");
                            }
                            else{   
                                stmt.executeUpdate("delete from album where albumTitle='" + album + "'");
                                System.out.println("Album "+ album + " deleted successfully.");
                            }
                        }
                         catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                    break;
                    case 6: loop = false;//
                    break;

                    default: 
                        break;  
                }
            }//ui loop            
        }catch(SQLException ex){
            ex.printStackTrace();
        }        
        System.out.println("Goodbye!");
    }//end main
}
