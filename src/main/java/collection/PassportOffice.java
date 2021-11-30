package collection;

import java.util.Map;
import java.util.HashMap;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return false;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
