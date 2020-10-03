package minecraft.smg.world.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import minecraft.smg.world.SmgWorldModElements;

import java.util.Map;

@SmgWorldModElements.ModElement.Tag
public class DesertOldHouseOnStructureInstanceGeneratedProcedure extends SmgWorldModElements.ModElement {
	public DesertOldHouseOnStructureInstanceGeneratedProcedure(SmgWorldModElements instance) {
		super(instance, 22);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure DesertOldHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure DesertOldHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure DesertOldHouseOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure DesertOldHouseOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"data merge block ~ ~1 ~ {LootTable:\"gems\"}");
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager().handleCommand(new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO,
					(ServerWorld) world, 4, "", new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
					"setblock ~ ~ ~ stone");
		}
		if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
			world.getWorld().getServer().getCommandManager()
					.handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"setblock ~1 ~1 ~ stone");
		}
	}
}
