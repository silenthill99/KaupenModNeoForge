package fr.silenthill99.test_mod.custom.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import fr.silenthill99.test_mod.Main;
import fr.silenthill99.test_mod.custom.entities.GeckoEntity;
import fr.silenthill99.test_mod.custom.entities.models.GeckoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GeckoRenderer extends MobRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Main.MODID, "textures/entity/kaupengecko.png");

    public GeckoRenderer(EntityRendererProvider.Context context) {
        super(context, new GeckoModel<>(context.bakeLayer(GeckoModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GeckoEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(@NotNull GeckoEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack,
                       @NotNull MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        if (entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1, 1, 1);
        }
    }
}
