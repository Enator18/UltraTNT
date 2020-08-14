package enator18.ultratnt.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.world.World;

public class PrimedTNTBaseEntity extends Entity
{
	public PrimedTNTBaseEntity(EntityType<? extends PrimedTNTBaseEntity> entityTypeIn, World worldIn)
	{
		super(entityTypeIn, worldIn);
	}

	@Override
	protected void registerData()
	{
		
	}

	@Override
	protected void readAdditional(CompoundNBT compound)
	{
		
	}

	@Override
	protected void writeAdditional(CompoundNBT compound)
	{
		
	}

	@Override
	public IPacket<?> createSpawnPacket()
	{
		return new SSpawnObjectPacket(this);
	}

	public int getFuse()
	{
		return 60;
	}
	
}
