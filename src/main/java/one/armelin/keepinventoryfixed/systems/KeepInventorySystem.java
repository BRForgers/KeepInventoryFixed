package one.armelin.keepinventoryfixed.systems;

import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.ComponentType;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.dependency.Dependency;
import com.hypixel.hytale.component.dependency.Order;
import com.hypixel.hytale.component.dependency.SystemDependency;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.RefChangeSystem;
import com.hypixel.hytale.server.core.asset.type.gameplay.DeathConfig;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entity.damage.DeathComponent;
import com.hypixel.hytale.server.core.modules.entity.damage.DeathSystems;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import java.util.Set;
import javax.annotation.Nonnull;

public class KeepInventorySystem extends RefChangeSystem<EntityStore, DeathComponent> {
    public KeepInventorySystem() {
    }

    @Override
    @Nonnull
    public ComponentType<EntityStore, DeathComponent> componentType() {
        return DeathComponent.getComponentType();
    }

    @Override
    @Nonnull
    public Query<EntityStore> getQuery() {
        return Player.getComponentType();
    }

    @Override
    @Nonnull
    public Set<Dependency<EntityStore>> getDependencies() {
        return Set.of(
                new SystemDependency<>(Order.AFTER, DeathSystems.PlayerDropItemsConfig.class),
                new SystemDependency<>(Order.BEFORE, DeathSystems.DropPlayerDeathItems.class)
        );
    }

    @Override
    public void onComponentAdded(@Nonnull Ref<EntityStore> ref, @Nonnull DeathComponent component,
                                 @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        component.setItemsLossMode(DeathConfig.ItemsLossMode.NONE);
    }

    @Override
    public void onComponentSet(@Nonnull Ref<EntityStore> ref, DeathComponent oldComponent,
                               @Nonnull DeathComponent newComponent, @Nonnull Store<EntityStore> store,
                               @Nonnull CommandBuffer<EntityStore> commandBuffer) {
    }

    @Override
    public void onComponentRemoved(@Nonnull Ref<EntityStore> ref, @Nonnull DeathComponent component,
                                   @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
    }
}