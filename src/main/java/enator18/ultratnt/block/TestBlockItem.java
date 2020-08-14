package enator18.ultratnt.block;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class TestBlockItem extends BlockItem
{
	public TestBlockItem(Block block)
	{
		super(block, new Item.Properties().group(ItemGroup.REDSTONE));
	}
}
