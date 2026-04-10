package de.chloedev.noinvcharacter.mixin;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public abstract class MixinInventoryScreen extends AbstractRecipeBookScreen<InventoryMenu> {
  private MixinInventoryScreen(InventoryMenu menu, RecipeBookComponent<?> recipeBookComponent, Inventory inventory, Component title) {
    super(menu, recipeBookComponent, inventory, title);
  }

  @Inject(method = "extractEntityInInventoryFollowsMouse", at = @At("HEAD"), cancellable = true)
  private static void drawEntity(GuiGraphicsExtractor graphics, int x0, int y0, int x1, int y1, int size, float offsetY, float mouseX, float mouseY, LivingEntity entity, CallbackInfo ci) {
    ci.cancel();
  }
}
