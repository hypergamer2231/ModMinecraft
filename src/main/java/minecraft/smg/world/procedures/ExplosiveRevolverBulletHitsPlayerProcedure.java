package minecraft.smg.world.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;

import minecraft.smg.world.SmgWorldModElements;

import java.util.Map;

@SmgWorldModElements.ModElement.Tag
public class ExplosiveRevolverBulletHitsPlayerProcedure extends SmgWorldModElements.ModElement {
	public ExplosiveRevolverBulletHitsPlayerProcedure(SmgWorldModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ExplosiveRevolverBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ExplosiveRevolverBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ExplosiveRevolverBulletHitsPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ExplosiveRevolverBulletHitsPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 2, Explosion.Mode.BREAK);
		}
	}
}
