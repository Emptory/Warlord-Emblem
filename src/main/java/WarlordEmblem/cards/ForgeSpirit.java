package WarlordEmblem.cards;

import WarlordEmblem.WarlordEmblem;
import WarlordEmblem.character.Kael;
import WarlordEmblem.orbs.ForgedSpiritOrb;
import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;

public class ForgeSpirit extends CustomCard {
  private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(WarlordEmblem.makeID("ForgeSpirit"));
  public static final String ID = WarlordEmblem.makeID("ForgeSpirit");
  public static final String NAME = cardStrings.NAME;
  public static final String IMG = WarlordEmblem.assetPath("/img/cards/Kael/kral_fire_element.png");
  private static final int COST = 1;
  public static final String DESCRIPTION = cardStrings.DESCRIPTION;
  public static final CardType TYPE = CardType.SKILL;
  private static final CardColor COLOR = AbstractCard.CardColor.COLORLESS;
  private static final CardRarity RARITY = CardRarity.RARE;
  private static final CardTarget TARGET = CardTarget.SELF;
  public static final String EXTENDED_DESCRIPTION[] = cardStrings.EXTENDED_DESCRIPTION;




  public ForgeSpirit() {
    super(ID, NAME, IMG, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
    this.exhaust = true;
    this.isEthereal = true;
}
  

  
  public void use(AbstractPlayer paramAbstractPlayer, AbstractMonster paramAbstractMonster) {
    AbstractDungeon.actionManager.addToBottom(new VFXAction(new BorderFlashEffect(Color.RED)));
    AbstractDungeon.actionManager.addToBottom(new ChannelAction(new ForgedSpiritOrb()));
  }

  @Override
  public void triggerOnEndOfPlayerTurn() {
    if (Kael.ForgeSpirit_ColdDown >0)
      Kael.ForgeSpirit_ColdDown  -= 1;
    super.triggerOnEndOfPlayerTurn();
  }


  @Override
  public AbstractCard makeCopy() { return new ForgeSpirit(); }

  @Override
  public boolean canUpgrade() { return false; }


  @Override
  public void upgrade() {}
}
