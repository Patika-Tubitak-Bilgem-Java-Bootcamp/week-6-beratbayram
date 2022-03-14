package locations;

import core.Armor;
import core.Player;
import mobs.Snake;

public class Mine extends Armor.BattleLoc {
    public Mine(Player player) {
        super(player, "Mine", new Snake());
    }
}
