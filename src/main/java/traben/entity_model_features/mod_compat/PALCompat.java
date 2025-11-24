package traben.entity_model_features.mod_compat;

//#if MC>=12109
import com.zigythebird.playeranim.accessors.IAvatarAnimationState;
import com.zigythebird.playeranim.animation.AvatarAnimManager;
//#else
//$$ import com.zigythebird.playeranim.accessors.IAnimatedPlayer;
//$$ import com.zigythebird.playeranim.animation.PlayerAnimManager;
//#endif
import traben.entity_model_features.models.animation.state.EMFEntityRenderState;

public class PALCompat {
    public static boolean shouldPauseEntityAnim(EMFEntityRenderState entity) {
        //#if MC>=12109
        if (entity instanceof IAvatarAnimationState animationState) {
            AvatarAnimManager manager = animationState.playerAnimLib$getAnimManager();
            return manager != null && manager.isActive();
        }
        //#else
        //$$ if (entity.emfEntity() instanceof IAnimatedPlayer player) {
        //$$     PlayerAnimManager manager = player.playerAnimLib$getAnimManager();
        //$$     return manager != null && manager.isActive();
        //$$ }
        //#endif
        return false;
    }
}