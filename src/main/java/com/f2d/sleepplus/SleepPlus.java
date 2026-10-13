package com.f2d.sleepplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.util.EventResult;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SleepPlus implements ModInitializer {
	public static final String MOD_ID = "sleepplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Set<UUID> wokeUpInMorning = new HashSet<>();
	private static final int SLEEP_RADIUS = 8;
	private static final int GLOW_DURATION = 60;

	@Override
	public void onInitialize() {
		ModEffects.register();

		EntitySleepEvents.ALLOW_NEARBY_MONSTERS.register((player, sleepingPos, vanillaResult) -> {
			if (!vanillaResult && player instanceof ServerPlayer serverPlayer) {
				highlightNearbyMonsters(serverPlayer);
			}
			return EventResult.PASS;
		});

		EntitySleepEvents.ALLOW_RESETTING_TIME.register(player -> {
			wokeUpInMorning.add(player.getUUID());
			return true;
		});

		EntitySleepEvents.STOP_SLEEPING.register((entity, sleepingPos) -> {
			if (entity instanceof ServerPlayer player
					&& wokeUpInMorning.remove(player.getUUID())) {
				applyAlertness(player);
			}
		});
	}

	private static void highlightNearbyMonsters(ServerPlayer player) {
		player.level().getEntitiesOfClass(
				Monster.class,
				player.getBoundingBox().inflate(SLEEP_RADIUS),
				Entity::isAlive
		).forEach(monster -> monster.addEffect(new MobEffectInstance(
				MobEffects.GLOWING,
				GLOW_DURATION,
				0,
				false,
				false,
				false
		)));
	}

	private static void applyAlertness(ServerPlayer player) {
		player.addEffect(new MobEffectInstance(
				ModEffects.ALERTNESS,
				6000,
				0,
				false,
				false,
				true
		));
	}
}