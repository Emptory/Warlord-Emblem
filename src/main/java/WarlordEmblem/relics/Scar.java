package WarlordEmblem.relics;
 
import WarlordEmblem.WarlordEmblem;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.status.Dazed;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Scar extends CustomRelic {
   public static final String ID = WarlordEmblem.makeID("Scar");

 
   
   public Scar() { super(WarlordEmblem.makeID("Scar"),new Texture(WarlordEmblem.assetPath("/img/relics/scar.png")) , RelicTier.BOSS, CustomRelic.LandingSound.FLAT); }
 
 
 
   
   public String getUpdatedDescription() { return this.DESCRIPTIONS[0] ; }

    public void onEquip() { AbstractDungeon.player.energy.energyMaster++; }
    public void onUnequip() { AbstractDungeon.player.energy.energyMaster--; }

   public void atTurnStart() {
       flash();
       AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
       AbstractDungeon.actionManager.addToBottom(new LoseHPAction(AbstractDungeon.player,AbstractDungeon.player,AbstractDungeon.cardRandomRng.random(1,2)));
            
         }




   
   public boolean canSpawn() { return (Settings.isEndless || AbstractDungeon.floorNum <= 52); }
 
 
 
   
   public CustomRelic makeCopy() { return new Scar(); }
 }