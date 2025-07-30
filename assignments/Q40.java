package assignments;

import java.util.*;

class CD implements Comparable<CD> {
 String title;
 String singer;

 CD(String title, String singer) {
     this.title = title;
     this.singer = singer;
 }
 public int compareTo(CD other) {
     return this.singer.compareToIgnoreCase(other.singer);  // ascending order
 }

 public String toString() {
     return "Title: " + title + ", Singer: " + singer;
 }
}

public class Q40{
 public static void main(String[] args) {
     List<CD> cdList = new ArrayList<>();

     // Adding CD objects
     cdList.add(new CD("Love Forever", "Adele"));
     cdList.add(new CD("Sky High", "Coldplay"));
     cdList.add(new CD("Harmony", "Bruno Mars"));
     cdList.add(new CD("Echoes", "Ed Sheeran"));

     // Sort the list using Comparable
     Collections.sort(cdList);

     // Display the sorted CDs
     System.out.println("CDs sorted by singer name:");
     for (CD cd : cdList) {
         System.out.println(cd);
     }
 }
}

//CDs sorted by singer name:
//Title: Love Forever, Singer: Adele
//Title: Harmony, Singer: Bruno Mars
//Title: Sky High, Singer: Coldplay
//Title: Echoes, Singer: Ed Sheeran

