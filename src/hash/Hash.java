//Collision handling
// Separate Chaining - Add nested data in has. 1 key will refer to multiple key/values.
// Linear probing - add element to next empty slot


package hash;

import java.util.ArrayList;
import java.util.Arrays;

public class Hash {
    private ArrayList<ArrayList> hashDB = new ArrayList<ArrayList>(10);

    public Hash() {
        for (int i = 0; i < 10; i++) {
            hashDB.add(new ArrayList<>());
        }
    }


    private void get(String key) {

    }

    private void set(String key, String value) {
        int hash = hash(key);

        String[] valuePair = new String[]{key, value};
        hashDB.get(hash).add(valuePair);
    }

    private int hash(String key) {
        return 1;
    }

    public static void main(String[] args) {
        Hash hash = new Hash();

        hash.set("Kavita", "17911");
        hash.set("Jyoti", "17917");
        hash.get("Kavita");
    }

}

//[[[Kavita,17911],[Kavita,17911]],[Kavita,17911]]