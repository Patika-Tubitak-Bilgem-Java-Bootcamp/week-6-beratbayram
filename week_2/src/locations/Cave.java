package locations;

import core.Armor;
import core.Player;
import mobs.Zombie;

public class Cave extends Armor.BattleLoc {
    public Cave(Player player) {
        super(player, "Cave", new Zombie());
    }
}
