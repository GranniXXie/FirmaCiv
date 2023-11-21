package com.hyperdash.firmaciv.mixins;

import com.hyperdash.firmaciv.common.entity.boatpart.EmptyCompartmentEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PlayerRideableJumping;
import net.minecraft.world.entity.RiderShieldingMount;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Camel.class)
public class CamelMixin extends AbstractHorse implements PlayerRideableJumping, RiderShieldingMount, Saddleable {

    protected CamelMixin(EntityType<? extends AbstractHorse> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"))
    public void injectEjectEntity(Player pPlayer, InteractionHand pHand,
                                  CallbackInfoReturnable<InteractionResult> cir) {
        if (!this.level()
                .isClientSide() && this.isPassenger() && this.getVehicle() instanceof EmptyCompartmentEntity emptyCompartmentEntity && pPlayer.isSecondaryUseActive()) {
            this.stopRiding();
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Shadow
    public double getRiderShieldingHeight() {
        return 0;
    }
}
