package com.hyperdash.firmaciv.common.entity;

import com.hyperdash.firmaciv.Firmaciv;
import com.hyperdash.firmaciv.common.entity.vehiclehelper.*;
import net.dries007.tfc.util.Helpers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

public final class FirmacivEntities {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Firmaciv.MOD_ID);

    public static final Map<BoatVariant, RegistryObject<EntityType<CanoeEntity>>> CANOES =
            Helpers.mapOfKeys(BoatVariant.class, variant -> ENTITY_TYPES.register("dugout_canoe/" + variant.getName(),
                    () -> EntityType.Builder.of(CanoeEntity::new, MobCategory.MISC).sized(1.125F, 0.625F)
                            .build(new ResourceLocation(Firmaciv.MOD_ID,
                                    "dugout_canoe/" + variant.getName()).toString())));

    public static final Map<BoatVariant, RegistryObject<EntityType<RowboatEntity>>> ROWBOATS =
            Helpers.mapOfKeys(BoatVariant.class, variant -> ENTITY_TYPES.register("rowboat/" + variant.getName(),
                    () -> EntityType.Builder.of(RowboatEntity::new, MobCategory.MISC).sized(1.875F, 0.625F)
                            .build(new ResourceLocation(Firmaciv.MOD_ID, "rowboat/" + variant.getName()).toString())));

    /*
    public static final Map<Wood, RegistryObject<EntityType<TFCBoat>>> BOATS = Helpers.mapOfKeys(Wood .class, (wood) -> {
        return ENTITY_TYPES.register("boat/" + wood.name(), EntityType.Builder.of((type, level) -> {
            return new TFCBoat(type, level, (Supplier) TFCEntities.CHEST_BOATS.get(wood), (Supplier) TFCItems.BOATS.get(wood));
        }, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10));
    });*/

    public static final RegistryObject<EntityType<KayakEntity>> KAYAK_ENTITY = ENTITY_TYPES.register("kayak",
            () -> EntityType.Builder.of(KayakEntity::new, MobCategory.MISC).sized(0.79F, 0.625F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "kayak").toString()));

    public static final RegistryObject<EntityType<EmptyCompartmentEntity>> EMPTY_COMPARTMENT_ENTITY = ENTITY_TYPES.register(
            "compartment_empty",
            () -> EntityType.Builder.of(EmptyCompartmentEntity::new, MobCategory.MISC).sized(0.8F, 0.8F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "compartment_empty").toString()));

    public static final RegistryObject<EntityType<ChestCompartmentEntity>> CHEST_COMPARTMENT_ENTITY = ENTITY_TYPES.register(
            "compartment_chest",
            () -> EntityType.Builder.of(ChestCompartmentEntity::new, MobCategory.MISC).sized(0.8F, 0.8F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "compartment_chest").toString()));

    public static final RegistryObject<EntityType<WorkbenchCompartmentEntity>> WORKBENCH_COMPARTMENT_ENTITY = ENTITY_TYPES.register(
            "compartment_workbench",
            () -> EntityType.Builder.of(WorkbenchCompartmentEntity::new, MobCategory.MISC).sized(0.8F, 0.8F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "compartment_workbench").toString()));

    public static final RegistryObject<EntityType<VehiclePartEntity>> VEHICLE_PART_ENTITY = ENTITY_TYPES.register(
            "vehicle_part",
            () -> EntityType.Builder.of(VehiclePartEntity::new, MobCategory.MISC).sized(0.1F, 0.1F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "vehicle_part").toString()));

    public static final RegistryObject<EntityType<VehicleCleatEntity>> VEHICLE_CLEAT_ENTITY = ENTITY_TYPES.register(
            "vehicle_cleat",
            () -> EntityType.Builder.of(VehicleCleatEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .build(new ResourceLocation(Firmaciv.MOD_ID, "vehicle_cleat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }


}