package com.hyperdash.firmaciv.events;

import com.hyperdash.firmaciv.Firmaciv;
import com.hyperdash.firmaciv.entity.FirmacivBoatRenderer.FirmacivBoatRenderer;
import com.hyperdash.firmaciv.entity.FirmacivEntities;
import com.hyperdash.firmaciv.entity.custom.entitymodel.CanoeEntityModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Firmaciv.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RenderEvents {

    private RenderEvents(){}

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(CanoeEntityModel.LAYER_LOCATION, CanoeEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(FirmacivEntities.CANOE_ENTITY.get(), FirmacivBoatRenderer::new);
    }
}
