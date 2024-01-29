package com.crinfarr.cleveland.item;

import org.apache.logging.log4j.Level;

import com.crinfarr.cleveland.Core;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.world.World;
import net.minecraft.tags.BlockTags;

public class Cleveland extends Item {

	public Cleveland(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ActionResult<ItemStack> superResult = super.use(world, player, hand);
		if (world.isClientSide()) {
			return superResult;
		}
		BlockRayTraceResult ray = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.NONE);
		BlockPos rayEndpoint = ray.getBlockPos();
		
		Block usedOnBlock = world.getBlockState(rayEndpoint).getBlock();
		usedOnBlock.getTags().forEach((ResourceLocation reloc) -> {
			Core.LOGGER.log(Level.INFO, reloc.toString());
		});
		Core.LOGGER.log(Level.INFO, (usedOnBlock.is(BlockTags.WOODEN_DOORS)) ? usedOnBlock.toString() + "IS WOODEN DOOR" : usedOnBlock.toString() + "IS NOT WOODEN DOOR");
		
		return superResult;
		
	}

}
