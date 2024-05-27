package com.xiaoyue.celestial_enchantments.content.table;

import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.register.CEItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;

public class CelestialTableBlock extends BaseEntityBlock {
   protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
   public static final List<BlockPos> BOOKSHELF_OFFSETS = BlockPos.betweenClosedStream(-2, 0, -2, 2, 1, 2).filter((p_207914_) -> Math.abs(p_207914_.getX()) == 2 || Math.abs(p_207914_.getZ()) == 2).map(BlockPos::immutable).toList();

   public CelestialTableBlock(BlockBehaviour.Properties prop) {
      super(prop);
   }

   public static boolean isValidBookShelf(Level level, BlockPos self, BlockPos offset) {
      return level.getBlockState(self.offset(offset)).getEnchantPowerBonus(level, self.offset(offset)) != 0 &&
              level.getBlockState(self.offset(offset.getX() / 2, offset.getY(), offset.getZ() / 2))
                      .is(BlockTags.ENCHANTMENT_POWER_TRANSMITTER);
   }

   @Override
   public void appendHoverText(ItemStack stack, @Nullable BlockGetter level, List<Component> list, TooltipFlag flag) {
      list.add(CELang.TABLE_DESC_0.get().withStyle(ChatFormatting.GRAY));
      list.add(CELang.TABLE_DESC_1.get().withStyle(ChatFormatting.RED));
      list.add(CELang.TABLE_DESC_CA.get().withStyle(ChatFormatting.AQUA));
      super.appendHoverText(stack, level, list, flag);
   }

   public boolean useShapeForLightOcclusion(BlockState pState) {
      return true;
   }

   public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
      return SHAPE;
   }

   /**
    * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
    */
   public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
      super.animateTick(pState, pLevel, pPos, pRandom);

      for (BlockPos blockpos : BOOKSHELF_OFFSETS) {
         if (pRandom.nextInt(16) == 0 && isValidBookShelf(pLevel, pPos, blockpos)) {
            pLevel.addParticle(ParticleTypes.ENCHANT,
                    (double) pPos.getX() + 0.5D,
                    (double) pPos.getY() + 2.0D,
                    (double) pPos.getZ() + 0.5D,
                    (double) ((float) blockpos.getX() + pRandom.nextFloat()) - 0.5D,
                    (double) ((float) blockpos.getY() - pRandom.nextFloat() - 1.0F),
                    (double) ((float) blockpos.getZ() + pRandom.nextFloat()) - 0.5D);
         }
      }

   }

   public RenderShape getRenderShape(BlockState pState) {
      return RenderShape.MODEL;
   }

   public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
      return new CelestialTableBlockEntity(CEItems.BE_TABLE.get(), pPos, pState);
   }

   @Nullable
   public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {//TODO
      return pLevel.isClientSide ? createTickerHelper(pBlockEntityType, CEItems.BE_TABLE.get(), CelestialTableBlockEntity::bookAnimationTick) : null;
   }

   public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
      if (pLevel.isClientSide) {
         return InteractionResult.SUCCESS;
      } else {
         pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
         return InteractionResult.CONSUME;
      }
   }

   @Nullable
   public MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos) {
      if (pLevel.getBlockEntity(pPos) instanceof CelestialTableBlockEntity ct) {
         Component name = ct.getDisplayName();
         return new SimpleMenuProvider((wid, inv, player) ->
                 new CelestialTableMenu(CEItems.MT_TABLE.get(), wid, inv, ContainerLevelAccess.create(pLevel, pPos)), name);
      } else {
         return null;
      }
   }

   /**
    * Called by BlockItem after this block has been placed.
    */
   public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack) {
      if (pStack.hasCustomHoverName()) {
         if (pLevel.getBlockEntity(pPos) instanceof CelestialTableBlockEntity ct) {
            ct.setCustomName(pStack.getHoverName());
         }
      }

   }

   public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
      return false;
   }
}
