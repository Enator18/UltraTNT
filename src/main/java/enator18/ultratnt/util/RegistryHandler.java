package enator18.ultratnt.util;

import enator18.ultratnt.UltraTNT;
import enator18.ultratnt.block.TestBlock;
import enator18.ultratnt.block.TestBlockItem;
import enator18.ultratnt.entity.PrimedTNTBaseEntity;
import enator18.ultratnt.entity.TNTYeeterEntity;
import enator18.ultratnt.entity.TestEntity;
import enator18.ultratnt.item.ModSpawnEggItem;
import enator18.ultratnt.item.TestItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, UltraTNT.MODID);
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, UltraTNT.MODID);
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES, UltraTNT.MODID);
	

	public static void init()
	{
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	//Items
	public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test_item", TestItem::new);
	
	
	//Blocks
	public static final RegistryObject<Block> TEST_BLOCK = BLOCKS.register("test_block", TestBlock::new);
	
	
	//Block Items
	public static final RegistryObject<Item> TEST_BLOCK_ITEM = ITEMS.register("test_block", () -> new TestBlockItem(TEST_BLOCK.get()));
	
	
	//Entities
	public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = ENTITY_TYPES.register("test_entity", () -> EntityType.Builder.<TestEntity>create(TestEntity::new, EntityClassification.CREATURE).size(1, 1.8F).build(new ResourceLocation(UltraTNT.MODID, "test_entity").toString()));
	
	public static final RegistryObject<EntityType<TNTYeeterEntity>> TNT_YEETER = ENTITY_TYPES.register("tnt_yeeter", () -> EntityType.Builder.<TNTYeeterEntity>create(TNTYeeterEntity::new, EntityClassification.MONSTER).size(0.75F, 2.1F).build(new ResourceLocation(UltraTNT.MODID, "tnt_yeeter").toString()));
	
	public static final RegistryObject<EntityType<PrimedTNTBaseEntity>> PRIMED_TNT_BASE = ENTITY_TYPES.register("primed_tnt_base", () -> EntityType.Builder.<PrimedTNTBaseEntity>create(PrimedTNTBaseEntity::new, EntityClassification.CREATURE).size(0.98f, 0.98f).build(new ResourceLocation(UltraTNT.MODID, "primed_tnt_base").toString()));
	
	
	//Spawn Eggs
	public static final RegistryObject<ModSpawnEggItem> TEST_ENTITY_EGG = ITEMS.register("test_entity_spawn_egg", () -> new ModSpawnEggItem(TEST_ENTITY, 0xFFFFFF, 0xFFFFFF, new Item.Properties().group(ItemGroup.MISC)));
	
	public static final RegistryObject<ModSpawnEggItem> TNT_YEETER_EGG = ITEMS.register("tnt_yeeter_spawn_egg", () -> new ModSpawnEggItem(TNT_YEETER, 0xA0A0A0, 0x707070, new Item.Properties().group(ItemGroup.MISC)));
}
