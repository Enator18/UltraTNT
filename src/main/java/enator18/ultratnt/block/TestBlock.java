package enator18.ultratnt.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class TestBlock extends Block
{
	public TestBlock()
	{
		super(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE).harvestLevel(0).harvestTool(ToolType.PICKAXE));
	}

	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit)
	{
		if (player.getHeldItem(handIn).getItem() == Items.FLINT_AND_STEEL)
		{
			if (!worldIn.isRemote)
			{
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4, Mode.DESTROY);
			}
			worldIn.destroyBlock(pos, false);
			return ActionResultType.SUCCESS;
		}
		
		return ActionResultType.FAIL;
	}
	
	
}
