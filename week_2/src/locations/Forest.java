package locations;

import core.Armor;
import core.Player;
import mobs.Vampire;

public class Forest extends Armor.BattleLoc {
    public Forest(Player player) {
        super(player, "Forest", new Vampire());
    }
}
