package enator18.ultratnt.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;

public class TestItem extends Item
{
	public TestItem()
	{
		super(new Item.Properties().group(ItemGroup.REDSTONE));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		if (!worldIn.isRemote)
		{
		worldIn.createExplosion(playerIn, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), 6, Mode.DESTROY);
		}
		
		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
	}
	
	
}
