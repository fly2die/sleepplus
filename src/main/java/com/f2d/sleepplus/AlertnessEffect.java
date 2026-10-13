package com.f2d.sleepplus;

import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class AlertnessEffect extends MobEffect {

    private static final Identifier SPEED_MODIFIER_ID =
            Identifier.fromNamespaceAndPath(SleepPlus.MOD_ID, "alertness_speed");

    public AlertnessEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xffd54f);
        addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                SPEED_MODIFIER_ID,
                0.1,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
    }
}