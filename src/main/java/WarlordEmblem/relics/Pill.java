package WarlordEmblem.relics;
 
import WarlordEmblem.WarlordEmblem;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class Pill extends CustomRelic {
   public static final String ID = WarlordEmblem.makeID("Pill");

 
   
   public Pill() { super(WarlordEmblem.makeID("Pill"),new Texture(WarlordEmblem.assetPath("/img/relics/pill.png")) , RelicTier.COMMON, CustomRelic.LandingSound.FLAT); }
 
 
 
   
   public String getUpdatedDescription() { return this.DESCRIPTIONS[0] ; }
 
 

   public void atBattleStart() {
       flash();
       AbstractDungeon.actionManager.addToTop(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, null, new StrengthPower(AbstractDungeon.player, 2)));
       if(!AbstractDungeon.player.hasRelic("Medical Kit")){
           AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(AbstractDungeon.player, null, new DexterityPower(AbstractDungeon.player, -2)));
       }

         }




   
   public boolean canSpawn() { return (Settings.isEndless || AbstractDungeon.floorNum <= 52); }
 
 
 
   
   public CustomRelic makeCopy() { return new Pill(); }
 }