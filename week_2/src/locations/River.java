package locations;

import core.Armor;
import mobs.Bear;
import core.Player;

public class River extends Armor.BattleLoc {
    public River(Player player) {
        super(player, "River", new Bear());
    }
}
