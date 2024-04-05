package com.xiaoyue.celestial_enchantments.content.enchantments.shield;

import com.xiaoyue.celestial_core.data.CCDamageTypes;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.content.generic.ShieldEnch;
import com.xiaoyue.celestial_enchantments.data.EnchData;
import com.xiaoyue.celestial_enchantments.data.EnchLevel;
import dev.xkmc.l2library.capability.conditionals.*;
import dev.xkmc.l2library.init.events.GeneralEventHandler;
import dev.xkmc.l2serial.serialization.SerialClass;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;

public class ConstraintsShield extends ShieldEnch
		implements TokenProvider<ConstraintsShield.Token, ConstraintsShield>, Context {

	public static final TokenKey<Token> KEY = TokenKey.of(CelestialEnchantments.loc("constraints_shield"));

	public ConstraintsShield() {
		super(Rarity.RARE, EnchData.treasure(3, SHIELD));
	}

	@Override
	public Token getData(ConstraintsShield context) {
		return new Token();
	}

	@Override
	public TokenKey<Token> getKey() {
		return KEY;
	}

	@Override
	public void onShieldBlock(ShieldBlockEvent event, LivingEntity attacker, LivingEntity entity, int level) {
		if (entity instanceof Player player) {
			var data = ConditionalData.HOLDER.get(player).getOrCreateData(this, this);
			if (data.cec < 4) {
				data.cec++;
			} else {
				data.cec = 0;
				float dmg = event.getBlockedDamage() * level * 0.5f;
				GeneralEventHandler.schedule(() -> attacker.hurt(CCDamageTypes.magic(entity), dmg));
			}
		}
	}

	@SerialClass
	public static class Token extends ConditionalToken {

		@SerialClass.SerialField
		public int cec;

	}

}
