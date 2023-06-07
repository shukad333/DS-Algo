package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest1 {

    static List<Emp> emps = new ArrayList<>();

    static {
        emps.add(new Emp("1","shu"));
        emps.add(new Emp("2","Litchi"));
    }


    public static void main(String[] args) {

        Integer[] empIds = { 1, 2, 3 };

      


    }

    public Emp findById(String id) {
        for(Emp e : emps) {
            if(e.id == id)
                return e;
        }

        return null;
    }

}

class Emp {
    String id ;
    String name;
    public Emp(String id,String name)  {
        this.id = id;
        this.name = name;
    }
}