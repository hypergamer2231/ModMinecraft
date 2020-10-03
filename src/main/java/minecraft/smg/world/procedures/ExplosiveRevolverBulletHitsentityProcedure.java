package minecraft.smg.world.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.entity.Entity;

import minecraft.smg.world.SmgWorldModElements;

import java.util.Map;

@SmgWorldModElements.ModElement.Tag
public class ExplosiveRevolverBulletHitsentityProcedure extends SmgWorldModElements.ModElement {
	public ExplosiveRevolverBulletHitsentityProcedure(SmgWorldModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ExplosiveRevolverBulletHitsentity!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ExplosiveRevolverBulletHitsentity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 2,
					Explosion.Mode.BREAK);
		}
	}
}
