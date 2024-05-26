package com.xiaoyue.celestial_enchantments.content.table;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import com.xiaoyue.celestial_enchantments.data.CELang;
import com.xiaoyue.celestial_enchantments.register.CEItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.EnchantmentNames;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class CelestialTableScreen extends AbstractContainerScreen<CelestialTableMenu> {
   /**
    * The ResourceLocation containing the Enchantment GUI texture location
    */
   private static final ResourceLocation ENCHANTING_TABLE_LOCATION = CelestialEnchantments.loc("textures/gui/celestial_table.png");
   /**
    * The ResourceLocation containing the texture for the Book rendered above the enchantment table
    */
   private static final ResourceLocation ENCHANTING_BOOK_LOCATION = CelestialEnchantments.loc("textures/entity/celestial_table_book.png");
   /**
    * A Random instance for use with the enchantment gui
    */
   private final RandomSource random = RandomSource.create();
   private BookModel bookModel;
   public int time;
   public float flip;
   public float oFlip;
   public float flipT;
   public float flipA;
   public float open;
   public float oOpen;
   private ItemStack last = ItemStack.EMPTY;

   public CelestialTableScreen(CelestialTableMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
      super(pMenu, pPlayerInventory, pTitle);
   }

   protected void init() {
      super.init();
      bookModel = new BookModel(minecraft.getEntityModels().bakeLayer(ModelLayers.BOOK));
   }

   public void containerTick() {
      super.containerTick();
      tickBook();
   }

   public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
      int i = (width - imageWidth) / 2;
      int j = (height - imageHeight) / 2;

      for (int k = 0; k < 3; ++k) {
         double d0 = pMouseX - (double) (i + 60);
         double d1 = pMouseY - (double) (j + 14 + 19 * k);
         if (d0 >= 0.0D && d1 >= 0.0D && d0 < 108.0D && d1 < 19.0D && menu.clickMenuButton(minecraft.player, k)) {
            minecraft.gameMode.handleInventoryButtonClick(menu.containerId, k);
            return true;
         }
      }

      return super.mouseClicked(pMouseX, pMouseY, pButton);
   }

   protected void renderBg(GuiGraphics g, float pTick, int mx, int my) {
      int i = (width - imageWidth) / 2;
      int j = (height - imageHeight) / 2;
      g.blit(ENCHANTING_TABLE_LOCATION, i, j, 0, 0, imageWidth, imageHeight);
      renderBook(g, i, j, pTick);
      EnchantmentNames.getInstance().initSeed(menu.getEnchantmentSeed());
      int k = menu.getGoldCount();

      for (int l = 0; l < 3; ++l) {
         int i1 = i + 60;
         int j1 = i1 + 20;
         int k1 = menu.costs[l] * (l + 1);
         if (k1 == 0) {
            g.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
         } else {
            String s = "" + k1;
            int l1 = 86 - font.width(s);
            FormattedText formattedtext = EnchantmentNames.getInstance().getRandomName(font, l1);
            int i2 = 6839882;
            if (((k < l + 1 || minecraft.player.experienceLevel < k1) && !minecraft.player.getAbilities().instabuild) || menu.enchantClue[l] == -1) {
               g.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 185, 108, 19);
               g.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 239, 16, 16);
               g.drawWordWrap(font, formattedtext, j1, j + 16 + 19 * l, l1, (i2 & 16711422) >> 1);
               i2 = 4226832;
            } else {
               int j2 = mx - (i + 60);
               int k2 = my - (j + 14 + 19 * l);
               if (j2 >= 0 && k2 >= 0 && j2 < 108 && k2 < 19) {
                  g.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 204, 108, 19);
                  i2 = 16777088;
               } else {
                  g.blit(ENCHANTING_TABLE_LOCATION, i1, j + 14 + 19 * l, 0, 166, 108, 19);
               }

               g.blit(ENCHANTING_TABLE_LOCATION, i1 + 1, j + 15 + 19 * l, 16 * l, 223, 16, 16);
               g.drawWordWrap(font, formattedtext, j1, j + 16 + 19 * l, l1, i2);
               i2 = 8453920;
            }

            g.drawString(font, s, j1 + 86 - font.width(s), j + 16 + 19 * l + 7, i2);
         }
      }

   }

   private void renderBook(GuiGraphics g, int pX, int pY, float pTick) {
      float f = Mth.lerp(pTick, oOpen, open);
      float f1 = Mth.lerp(pTick, oFlip, flip);
      Lighting.setupForEntityInInventory();
      g.pose().pushPose();
      g.pose().translate((float) pX + 33.0F, (float) pY + 31.0F, 100.0F);
      float f2 = 40.0F;
      g.pose().scale(-40.0F, 40.0F, 40.0F);
      g.pose().mulPose(Axis.XP.rotationDegrees(25.0F));
      g.pose().translate((1.0F - f) * 0.2F, (1.0F - f) * 0.1F, (1.0F - f) * 0.25F);
      float f3 = -(1.0F - f) * 90.0F - 90.0F;
      g.pose().mulPose(Axis.YP.rotationDegrees(f3));
      g.pose().mulPose(Axis.XP.rotationDegrees(180.0F));
      float f4 = Mth.clamp(Mth.frac(f1 + 0.25F) * 1.6F - 0.3F, 0.0F, 1.0F);
      float f5 = Mth.clamp(Mth.frac(f1 + 0.75F) * 1.6F - 0.3F, 0.0F, 1.0F);
      bookModel.setupAnim(0.0F, f4, f5, f);
      VertexConsumer vertexconsumer = g.bufferSource().getBuffer(bookModel.renderType(ENCHANTING_BOOK_LOCATION));
      bookModel.renderToBuffer(g.pose(), vertexconsumer, 15728880, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      g.flush();
      g.pose().popPose();
      Lighting.setupFor3DItems();
   }

   public void render(GuiGraphics g, int mx, int my, float pTick) {
      pTick = minecraft.getFrameTime();
      renderBackground(g);
      super.render(g, mx, my, pTick);
      renderTooltip(g, mx, my);
      boolean flag = minecraft.player.getAbilities().instabuild;
      int fuelRank = menu.getGoldCount();

      for (int slot = 0; slot < 3; ++slot) {
         int k = menu.costs[slot];
         Enchantment e = Enchantment.byId(menu.enchantClue[slot]);
         int clue = menu.levelClue[slot];
         if (isHovering(60, 14 + 19 * slot, 108, 17, mx, my) && k > 0) {
            List<Component> list = Lists.newArrayList();
            list.add((Component.translatable("container.enchant.clue", e == null ? "" : e.getFullname(clue))).withStyle(ChatFormatting.WHITE));
            if (e == null) {
               list.add(Component.literal(""));
               list.add(Component.translatable("forge.container.enchant.limitedEnchantability").withStyle(ChatFormatting.RED));
            } else if (!flag) {
               list.add(CommonComponents.EMPTY);
               if (minecraft.player.experienceLevel < k) {
                  list.add(Component.translatable("container.enchant.level.requirement", menu.costs[slot]).withStyle(ChatFormatting.RED));
               } else {
                  MutableComponent itemCost = CELang.ITEM_COST.get(CEItems.FUELS[slot].asStack().getHoverName().copy());
                  list.add(itemCost.withStyle(fuelRank > slot ? ChatFormatting.GRAY : ChatFormatting.RED));
                  MutableComponent lvCost = Component.translatable("container.enchant.level.many", (slot + 1) * 10);
                  list.add(lvCost.withStyle(ChatFormatting.GRAY));
               }
            }
            g.renderComponentTooltip(font, list, mx, my);
            break;
         }
      }
   }

   public void tickBook() {
      ItemStack itemstack = menu.getSlot(0).getItem();
      if (!ItemStack.matches(itemstack, last)) {
         last = itemstack;

         do {
            flipT += (float) (random.nextInt(4) - random.nextInt(4));
         } while (flip <= flipT + 1.0F && flip >= flipT - 1.0F);
      }

      ++time;
      oFlip = flip;
      oOpen = open;
      boolean flag = false;

      for (int i = 0; i < 3; ++i) {
         if (menu.costs[i] != 0) {
            flag = true;
         }
      }

      if (flag) {
         open += 0.2F;
      } else {
         open -= 0.2F;
      }

      open = Mth.clamp(open, 0.0F, 1.0F);
      float f1 = (flipT - flip) * 0.4F;
      float f = 0.2F;
      f1 = Mth.clamp(f1, -0.2F, 0.2F);
      flipA += (f1 - flipA) * 0.9F;
      flip += flipA;
   }

}
