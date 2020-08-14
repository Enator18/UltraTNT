package enator18.ultratnt.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RangedAttackGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TNTYeeterEntity extends MonsterEntity implements IRangedAttackMob
{
	private static final DataParameter<Integer> ARM_ROTATION = EntityDataManager.createKey(TNTYeeterEntity.class, DataSerializers.VARINT);
	
	private int armRotation = 0;
	
	public TNTYeeterEntity(EntityType<? extends MonsterEntity> entityTypeIn, World worldIn)
	{
		super(entityTypeIn, worldIn);
	}
	
	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 5.0F));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.0D, 40, 20));

		this.targetSelector.addGoal(0, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	@Override
	protected void registerAttributes()
	{
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
		this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(30);
	}

	@Override
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor)
	{
		armRotation+=10;
		TNTEntity tnt = new TNTEntity(this.world, this.getPosX(), this.getPosY() + 2, this.getPosZ(), this);
		tnt.setFuse(40);
		Vec3d velocity = target.getPositionVec().subtract(this.getPositionVec());
		tnt.setVelocity(velocity.x / 25, 0.75, velocity.z / 25);
		this.world.addEntity(tnt);
	}

	@Override
	public void writeAdditional(CompoundNBT compound)
	{
		super.writeAdditional(compound);
		compound.putShort("ArmRotation", (short)this.getArmRotation());
	}

	@Override
	protected void registerData()
	{
		super.registerData();
		this.dataManager.register(ARM_ROTATION, 0);
	}

	@Override
	public void readAdditional(CompoundNBT compound)
	{
		super.readAdditional(compound);
		this.setArmRotation(compound.getShort("ArmRotation"));
	}
	
	public int getArmRotationDataManager()
	{
		return this.dataManager.get(ARM_ROTATION);
	}
	
	public int getArmRotation()
	{
		return this.armRotation;
	}
	
	public void setArmRotation(int rotationIn)
	{
		this.dataManager.set(ARM_ROTATION, rotationIn);
		this.armRotation = rotationIn;
	}
	
	public void notifyDataManagerChange(DataParameter<?> key)
	{
	      if (ARM_ROTATION.equals(key))
	      {
	         this.armRotation = this.getArmRotationDataManager();
	      }
	}
	
}
