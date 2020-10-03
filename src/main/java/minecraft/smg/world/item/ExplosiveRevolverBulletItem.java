
package minecraft.smg.world.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import minecraft.smg.world.SmgWorldModElements;

@SmgWorldModElements.ModElement.Tag
public class ExplosiveRevolverBulletItem extends SmgWorldModElements.ModElement {
	@ObjectHolder("smg_world:explosive_revolver_bullet")
	public static final Item block = null;
	public ExplosiveRevolverBulletItem(SmgWorldModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(64));
			setRegistryName("explosive_revolver_bullet");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
