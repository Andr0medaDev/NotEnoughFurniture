package top.andro.not_enough_furniture.entity;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CouchSeatRenderer extends EntityRenderer<CouchSeatEntity> {
    public CouchSeatRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(CouchSeatEntity seatEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(CouchSeatEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}
