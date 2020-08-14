package enator18.ultratnt;



import enator18.ultratnt.client.entity.PrimedTNTBaseRender;
import enator18.ultratnt.client.entity.TNTYeeterRender;
import enator18.ultratnt.client.entity.TestEntityRender;
import enator18.ultratnt.item.ModSpawnEggItem;
import enator18.ultratnt.util.RegistryHandler;
import net.minecraft.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UltraTNT.MODID)
@Mod.EventBusSubscriber(modid = UltraTNT.MODID, bus = Bus.MOD)
public class UltraTNT
{
	//private static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "ultratnt";
	
	
	public UltraTNT()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		RegistryHandler.init();
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent e)
	{
		
	}
	
	private void doClientStuff(final FMLClientSetupEvent e)
	{
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.TEST_ENTITY.get(), TestEntityRender::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.TNT_YEETER.get(), TNTYeeterRender::new);
		RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.PRIMED_TNT_BASE.get(), PrimedTNTBaseRender::new);
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> e)
	{
		ModSpawnEggItem.initUnaddedEggs();
	}
}