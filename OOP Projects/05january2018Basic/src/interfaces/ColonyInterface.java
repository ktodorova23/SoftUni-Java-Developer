package interfaces;

import models.colonists.Colonist;

import java.util.List;

public interface ColonyInterface {
    void addColonist(Colonist colonist);
    void removeColonist(String familyId, String memberId);
    void removeFamily(String id);
    List<Colonist> getColonistsByFamilyId(String familyId);
    void grow(int years);
    int getPotential();
    String getCapacity();

}
