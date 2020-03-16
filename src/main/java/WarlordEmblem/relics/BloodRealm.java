package WarlordEmblem.relics;

import WarlordEmblem.WarlordEmblem;
import WarlordEmblem.patches.CharacterSelectScreenPatches;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class BloodRealm extends CustomRelic {

    public static final String ID = WarlordEmblem.makeID("BloodRealm");;
    private static Texture texture = new Texture(WarlordEmblem.assetPath("img/relics/blood_realm.png")) ;

    public BloodRealm() {
        super(ID, texture, RelicTier.RARE, AbstractRelic.LandingSound.MAGICAL);
    }

    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new BloodRealm();
    }
}
