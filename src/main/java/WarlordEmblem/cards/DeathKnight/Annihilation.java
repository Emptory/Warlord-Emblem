package WarlordEmblem.cards.DeathKnight;

import WarlordEmblem.WarlordEmblem;
import WarlordEmblem.patches.CardColorEnum;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.VerticalImpactEffect;

/**
 * 该技能不受力量加成<br>
 * 鲜血系技能
 * 
 * @author 王凯迪
 *
 */
public class Annihilation extends AbstractDKCard {
    public static final String ID = WarlordEmblem.makeID("Annihilation");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String IMG = WarlordEmblem.assetPath("/img/cards/DeathKnight/annihilation.png");
    private static final int COST = 1;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;
    public static final CardType TYPE = CardType.ATTACK;
    private static final CardColor COLOR = CardColorEnum.DeathKnight_LIME;
    private static final CardRarity RARITY = CardRarity.RARE;
    private static final CardTarget TARGET = CardTarget.ENEMY;

    private static final int UPGRADE_BONUS = 1;

    public Annihilation() {
        super(ID, NAME, IMG, COST, DESCRIPTION,TYPE, COLOR,RARITY,TARGET);
        this.baseDamage = 0;
        this.magicNumber = 2;
        this.baseMagicNumber = magicNumber;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int block = p.currentBlock;
        AbstractDungeon.actionManager.addToBottom(new VFXAction(new BorderFlashEffect(Color.SKY)));
        if (!hasBloodRealm())
            AbstractDungeon.actionManager.addToBottom(new DamageAction(p,
                    new DamageInfo(p, block, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        else
            AbstractDungeon.actionManager
                    .addToBottom(new DamageAction(p, new DamageInfo(p, block / 2, this.damageTypeForTurn),
                            AbstractGameAction.AttackEffect.SLASH_DIAGONAL));

        if (m != null) {
            AbstractDungeon.actionManager.addToBottom(
                    new VFXAction(new VerticalImpactEffect(m.hb.cX + m.hb.width / 4.0F, m.hb.cY - m.hb.height / 4.0F)));
        }
        AbstractDungeon.actionManager
                .addToBottom(new DamageAction(m, new DamageInfo(p, block * this.magicNumber, this.damageTypeForTurn),
                        AbstractGameAction.AttackEffect.SLASH_HEAVY));
    }

    public void upgrade() {
        if (!this.upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_BONUS);
        }
    }

    public AbstractCard makeCopy() {
        return new Annihilation();
    }

}