package com.xiaoyue.celestial_enchantments.content.table;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.xiaoyue.celestial_enchantments.CelestialEnchantments;
import net.minecraft.client.model.BookModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CelestialTableRenderer implements BlockEntityRenderer<CelestialTableBlockEntity> {
	/**
	 * The texture for the book above the enchantment table.
	 */
	public static final ResourceLocation BOOK_LOCATION = CelestialEnchantments.loc("textures/entity/celestial_table_book.png");
	private final BookModel bookModel;

	public CelestialTableRenderer(BlockEntityRendererProvider.Context pContext) {
		this.bookModel = new BookModel(pContext.bakeLayer(ModelLayers.BOOK));
	}

	public void render(CelestialTableBlockEntity be, float pTick, PoseStack pose, MultiBufferSource buffer, int light, int overlay) {
		pose.pushPose();
		pose.translate(0.5F, 0.75F, 0.5F);
		float f = (float) be.time + pTick;
		pose.translate(0.0F, 0.1F + Mth.sin(f * 0.1F) * 0.01F, 0.0F);

		float f1;
		for (f1 = be.rot - be.oRot; f1 >= (float) Math.PI; f1 -= ((float) Math.PI * 2F)) {
		}

		while (f1 < -(float) Math.PI) {
			f1 += ((float) Math.PI * 2F);
		}

		float f2 = be.oRot + f1 * pTick;
		pose.mulPose(Axis.YP.rotation(-f2));
		pose.mulPose(Axis.ZP.rotationDegrees(80.0F));
		float f3 = Mth.lerp(pTick, be.oFlip, be.flip);
		float f4 = Mth.frac(f3 + 0.25F) * 1.6F - 0.3F;
		float f5 = Mth.frac(f3 + 0.75F) * 1.6F - 0.3F;
		float f6 = Mth.lerp(pTick, be.oOpen, be.open);
		this.bookModel.setupAnim(f, Mth.clamp(f4, 0.0F, 1.0F), Mth.clamp(f5, 0.0F, 1.0F), f6);
		VertexConsumer vc = buffer.getBuffer(RenderType.entitySolid(BOOK_LOCATION));
		this.bookModel.render(pose, vc, light, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
		pose.popPose();
	}
}